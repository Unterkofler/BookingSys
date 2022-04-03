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
    public void createBooking(String firstName, String lastName, BookingId bookingId, LocalDate startDate, LocalDate endDate, int capacity) throws Exception {
        Customer customer = new Customer(firstName, lastName);
        Room room = getAvailableRoom(startDate, endDate, capacity);
        Booking booking = new Booking(bookingId, customer, startDate, endDate, room.getRoomNumber());

        room.createRoomBooking(startDate, endDate);
        repositoryWrite.createBooking(booking);

        Event bookingCreated = new BookingCreated(booking.getBookingId(), booking.getCustomer(), booking.getStartDate(), booking.getEndDate(), booking.getRoomNumber());
        eventPublisher.bookingCreated(bookingCreated);

        Event roomBookingCreated = new RoomBookingCreated(startDate, endDate, room.getRoomNumber());
        eventPublisher.publishRoomBookingCreated(roomBookingCreated);
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


    @Override
    public Room getAvailableRoom(LocalDate startDate, LocalDate endDate, int capacity) throws Exception {
        List<Room> roomsByCapacity = repositoryWrite.roomsByCapacity(capacity);

        //TODO: Problem hier
        for (int i = 0; i < roomsByCapacity.size(); i++) {
            Room room = roomsByCapacity.get(i);
            if (room.getRoomBookings().size() == 0) {
                return room;
            } else if ((!(room.getRoomBookings().get(i).getStartDate().isBefore(startDate)
                    && room.getRoomBookings().get(i).getEndDate().isAfter(startDate)))) {
                return room;
            } else if ((!(room.getRoomBookings().get(i).getStartDate().isAfter(startDate)
                    && room.getRoomBookings().get(i).getEndDate().isBefore(startDate)))) {
                return room;
            } else if ((!(room.getRoomBookings().get(i).getEndDate().isBefore(endDate)
                    && room.getRoomBookings().get(i).getStartDate().isAfter(endDate)))) {
                return room;
            } else if ((!(room.getRoomBookings().get(i).getEndDate().isBefore(endDate)
                    && room.getRoomBookings().get(i).getStartDate().isAfter(startDate)))) {
                return room;
            }
        }
            throw new Exception("No suitable room found exception");
    }
}

