package readside.repository;

import writeside.domain.ValueObjects.BookingId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import readside.DTO.BookingDTO;
import readside.DTO.RoomBookingDTO;
import readside.DTO.RoomDTO;
import writeside.event.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectionImpl implements Projection{
    @Autowired
    RepositoryRead repositoryRead;

    @Override
    public void createRoom(Event event) throws Exception {
        event = (RoomCreated) event;
        List<LocalDate> freePeriods = LocalDate.now().datesUntil(LocalDate.now().plusYears(1)).collect(Collectors.toList());;

        RoomDTO roomDTO = new RoomDTO(((RoomCreated) event).getRoomNumber(),((RoomCreated) event).getCapacity(),freePeriods);
        //Room room = new Room(((RoomCreated) event).getRoomNumber(),((RoomCreated) event).getCapacity(),((RoomCreated) event).getRoomBookings());
        repositoryRead.createRoom(roomDTO);
    }


    @Override
    public void createBooking(Event event) throws Exception {
        event = (BookingCreated) event;
        BookingDTO bookingDTO = new BookingDTO(((BookingCreated) event).getBookingId(),
                ((BookingCreated) event).getCustomer(),((BookingCreated) event).getStartDate(),
                ((BookingCreated) event).getEndDate(),((BookingCreated) event).getRoomId());
        repositoryRead.createBooking(bookingDTO);
    }


    @Override
    public void cancelBooking(Event event) throws Exception {
        event = (BookingCanceled) event;
        BookingId bookingId = ((BookingCanceled) event).getBookingId();
        repositoryRead.removeBooking(bookingId);
    }


    @Override
    public void createRoomBooking(Event event) {
        event = (RoomBookingCreated) event;
        RoomBookingDTO roomBookingDTO = new RoomBookingDTO(((RoomBookingCreated) event).getStartDate(),((RoomBookingCreated) event).getEndDate(), ((RoomBookingCreated) event).getRoomNumber());
        repositoryRead.removeDates(roomBookingDTO);

    }


    @Override
    public void roomBookingCanceled(Event event) {
        event = (RoomBookingCanceled) event;
        RoomBookingDTO roomBookingDTO = new RoomBookingDTO(((RoomBookingCanceled) event).getStartDate(), ((RoomBookingCanceled) event).getEndDate(),((RoomBookingCanceled) event).getRoomNumber());
        repositoryRead.addDates(roomBookingDTO);
    }
}
