package writeside.application;
import eventside.domain.Booking;
import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.Customer;
import eventside.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import writeside.EventPublisher;
import writeside.application.interfaces.HotelService;
import writeside.application.interfaces.RepositoryWrite;
import writeside.event.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class HotelServiceImpl implements HotelService {

    @Autowired
    RepositoryWrite repositoryWrite;

    private EventPublisher eventPublisher = new EventPublisher();


    @Override
    public void createBooking(String firstName, String lastName, BookingId bookingId, LocalDate startDate, LocalDate endDate, int capacity) throws Exception {

        // TODO: Gibt es hier Exception?
        Customer customer = new Customer(firstName, lastName);
        Room room = getAvailableRooms(startDate, endDate, capacity).get(0);
        Booking booking = new Booking(bookingId, customer, startDate, endDate, room.getRoomNumber());

        room.createRoomBooking(startDate, endDate);
        repositoryWrite.createBooking(booking);


        Event event = new BookingCreated(booking.getBookingId(),booking.getCustomer(), booking.getStartDate(),booking.getEndDate(), booking.getRoomId());
        eventPublisher.bookingCreated(event);

        Event event1 = new RoomBookingCreated(startDate, endDate);
        eventPublisher.publishRoomBookingCreated(event1);
    }

    @Override
    public void cancelBooking(BookingId bookingId) throws Exception {

        // TODO: Gibt es hier Exception?
        Booking booking = repositoryWrite.getBookingByBookingId(bookingId);

        removeRoomBooking(booking);
        repositoryWrite.cancelBooking(bookingId);

        Event event = new BookingCanceled(booking.getBookingId());
        System.out.println(event);
        eventPublisher.publishBookingCanceled(event);

        Event event1 = new RoomBookingCanceled(booking.getStartDate(), booking.getEndDate());
        eventPublisher.publishRoomBookingCanceled(event1);
    }

    @Override
    public List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate, int capacity) throws Exception {
        List<Room> rooms = new ArrayList<>();
        List<Room> roomsByCapacity = repositoryWrite.roomsByCapacity(capacity);

        // Todo: Überarbeiten der else if Abfrage
        for (int i = 0; i < roomsByCapacity.size(); i++) {
            Room room = roomsByCapacity.get(i);
            if (room.getRoomBookings().size() == 0) {
                rooms.add(room);
            } else if ((!(room.getRoomBookings().get(i).getStartDate().isBefore(startDate)
                    && room.getRoomBookings().get(i).getEndDate().isAfter(endDate)))) {
                rooms.add(room);
            }
        }

        if (rooms.size() == 0) {
            throw new Exception("No rooms found");
        }

        return rooms;
    }

    @Override
    public void removeRoomBooking(Booking booking) throws Exception {
        Room room = repositoryWrite.getRoomByRoomNumber(booking.getRoomId());

        repositoryWrite.cancelRoomBooking(room);
    }

    @Override
    public void createRoom(Room room) {

        repositoryWrite.createRoom(room);
        Event event = new RoomCreated(room.getRoomNumber(), room.getCapacity(), room.getRoomBookings());
        eventPublisher.publishRoomCreated(event);
    }
}
