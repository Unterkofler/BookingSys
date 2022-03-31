package readside.repository;

import eventside.domain.Booking;
import eventside.domain.Room;
import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.RoomBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import readside.DTO.BookingDTO;
import writeside.event.*;

import java.beans.JavaBean;

@Component
public class ProjectionImpl implements Projection{
    @Autowired
    RepositoryRead repositoryRead;

    @Override
    public void createBooking(Event event) {
        event = (BookingCreated) event;
        BookingDTO bookingDTO = new BookingDTO(((BookingCreated) event).getBookingId(),
                ((BookingCreated) event).getCustomer(),((BookingCreated) event).getStartDate(),
                ((BookingCreated) event).getEndDate(),((BookingCreated) event).getRoomId());
        repositoryRead.addBooking(bookingDTO);
    }

    @Override
    public void cancelBooking(Event event) throws Exception {
        event = (BookingCanceled) event;
        BookingId bookingId = ((BookingCanceled) event).getBookingId();
        repositoryRead.remove(bookingId);
    }

    @Override
    public void createRoom(Event event) {
        event = (RoomCreated) event;
        Room room = new Room(((RoomCreated) event).getRoomNumber(),((RoomCreated) event).getCapacity(),((RoomCreated) event).getRoomBookings());
        repositoryRead.addRoom(room);
    }

    @Override
    public void createRoomBooking(Event event) {
        event = (RoomBookingCreated) event;
        RoomBooking roomBooking = new RoomBooking(((RoomBookingCreated) event).getStartDate(),((RoomBookingCreated) event).getEndDate());
        repositoryRead.addRoomBooking(roomBooking);
    }

    @Override
    public void roomBookingCanceled(Event event) {
        event = (RoomBookingCanceled) event;
        RoomBooking roomBooking = new RoomBooking(((RoomBookingCanceled) event).getStartDate(), ((RoomBookingCanceled) event).getEndDate());
        repositoryRead.removeRoomBooking(roomBooking);
    }
}
