package writeside.application;
import writeside.domain.Booking;
import writeside.domain.ValueObjects.BookingId;
import writeside.domain.ValueObjects.Customer;
import writeside.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import writeside.EventPublisher;
import writeside.application.interfaces.HotelService;
import writeside.application.interfaces.RepositoryWrite;
import writeside.domain.ValueObjects.RoomBooking;
import writeside.event.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookingServiceImpl implements HotelService {

    @Autowired
    RepositoryWrite repositoryWrite;

    private EventPublisher eventPublisher = new EventPublisher();

    @Override
    public void createRoom(Room room) throws Exception {

        repositoryWrite.createRoom(room);
        Event event = new RoomCreated(room.getRoomNumber(), room.getCapacity(), room.getRoomBookings());
        eventPublisher.publishRoomCreated(event);
    }


    @Override
    public void createBooking(String firstName, String lastName, BookingId bookingId, LocalDate startDate, LocalDate endDate, int capacity, int roomNumber) throws Exception {
        Customer customer = new Customer(firstName, lastName);

        if(checkIsRoomAvailable(roomNumber, startDate, endDate) == true){
            Booking booking = new Booking(bookingId, customer, startDate, endDate, roomNumber);
            Room room = repositoryWrite.getRoomByRoomNumber(booking.getRoomNumber());

            room.createRoomBooking(startDate, endDate);
            repositoryWrite.createBooking(booking);

            Event bookingCreated = new BookingCreated(booking.getBookingId(), booking.getCustomer(), booking.getStartDate(), booking.getEndDate(), booking.getRoomNumber());
            eventPublisher.bookingCreated(bookingCreated);

            Event roomBookingCreated = new RoomBookingCreated(startDate, endDate, room.getRoomNumber());
            eventPublisher.publishRoomBookingCreated(roomBookingCreated);
        }
    }


    @Override
    public void cancelBooking(BookingId bookingId) throws Exception {
        Booking booking = repositoryWrite.getBookingByBookingId(bookingId);
        Room room = repositoryWrite.getRoomByRoomNumber(booking.getRoomNumber());

        repositoryWrite.cancelRoomBooking(room);
        repositoryWrite.cancelBooking(bookingId);

        Event bookingCanceled = new BookingCanceled(booking.getBookingId());
        eventPublisher.publishBookingCanceled(bookingCanceled);

        Event roomBookingCanceled = new RoomBookingCanceled(booking.getStartDate(), booking.getEndDate(), booking.getRoomNumber());
        eventPublisher.publishRoomBookingCanceled(roomBookingCanceled);
    }

    private boolean checkIsRoomAvailable(int roomNumber, LocalDate startDate, LocalDate endDate) throws Exception {
        Room room = repositoryWrite.getRoomByRoomNumber(roomNumber);

        for(RoomBooking roomBooking : room.getRoomBookings()) {
            if(roomBooking.getStartDate().isBefore(startDate) && roomBooking.getEndDate().isAfter(startDate)) {
                System.out.println("An other Booking is in this Time period");
                return false;
            }
            if(roomBooking.getStartDate().isAfter(startDate) && roomBooking.getEndDate().isBefore(endDate)) {
                System.out.println("An other Booking is in this Time period");
                return false;
            }
            if(roomBooking.getStartDate().isBefore(endDate) && roomBooking.getEndDate().isAfter(endDate)) {
                System.out.println("An other Booking is in this Time period");
                return false;
            }
            if(roomBooking.getStartDate().isBefore(startDate) && roomBooking.getEndDate().isAfter(endDate)) {
                System.out.println("An other Booking is in this Time period");
                return false;
            }
        }
            return true;
    }
}

