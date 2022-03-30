package writeside.application;
import eventside.domain.Booking;
import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.Customer;
import eventside.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import writeside.EventPublisher;
import writeside.application.interfaces.BookingService;
import writeside.application.interfaces.RepositoryWrite;
import writeside.event.BookingCanceled;
import writeside.event.BookingCreated;
import writeside.event.Event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookingServiceImpl implements BookingService {

    @Autowired
    RepositoryWrite storeRepository;

    private EventPublisher eventPublisher = new EventPublisher();


    @Override
    public void createBooking(String firstName, String lastName, BookingId bookingId, LocalDate startDate, LocalDate endDate, int capacity) throws Exception {

        // TODO: Gibt es hier Exception?
        Customer customer = new Customer(firstName, lastName);
        Room room = getAvailableRooms(startDate, endDate, capacity).get(0);
        Booking booking = new Booking(bookingId, customer, startDate, endDate, room);

        room.createRoomBooking(startDate, endDate);
        storeRepository.createBooking(booking);


        Event event = new BookingCreated(booking.getBookingId(),booking.getCustomer(), booking.getStartDate(),booking.getEndDate(), booking.getBookedRoom());
        eventPublisher.bookingCreated(event);
    }

    @Override
    public void cancelBooking(BookingId bookingId) throws Exception {

        // TODO: Gibt es hier Exception?
        Booking booking = storeRepository.getBookingByBookingId(bookingId);

        removeRoomBooking(booking);
        storeRepository.cancelBooking(bookingId);

        Event event = new BookingCanceled(booking.getBookingId());
        System.out.println(event);
        eventPublisher.publishBookingCanceled(event);
    }

    @Override
    public List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate, int capacity) throws Exception {
        List<Room> rooms = new ArrayList<>();
        List<Room> roomsByCapacity = storeRepository.roomsByCapacity(capacity);

        // Todo: Überarbeiten
        for (Room room : roomsByCapacity) {
            int i = 0;


            if (room.getRoomBookings().size() == 0) {
                rooms.add(room);
            } else if ((!(room.getRoomBookings().get(i).getStartDate().isBefore(startDate)
                    && room.getRoomBookings().get(i).getEndDate().isAfter(endDate)))) {
                rooms.add(room);
            }
            i++;
        }


        if (rooms.size() == 0) {
            throw new Exception("No rooms found");
        }

        return rooms;
    }

    @Override
    public void removeRoomBooking(Booking booking) throws Exception {
        Room room = storeRepository.getRoomByRoomNumber(booking.getBookedRoom().getRoomNumber());

        storeRepository.cancelRoomBooking(room);
    }
}
