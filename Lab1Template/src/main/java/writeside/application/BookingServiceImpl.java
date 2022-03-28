package writeside.application;
import eventside.domain.Booking;
import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.Customer;
import eventside.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import writeside.application.interfaces.BookingService;
import writeside.application.interfaces.RoomService;
import writeside.application.interfaces.BookingRepositoryWrite;
import java.time.LocalDate;

@Component
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepositoryWrite bookingRepository;

    @Autowired
    RoomService roomService;


    @Override
    public void createBooking(String firstName, String lastName, BookingId bookingId, LocalDate startDate, LocalDate endDate, int capacity) throws Exception {

        // TODO: Gibt es hier Exception?
        Customer customer = new Customer(firstName, lastName);
        Room room = roomService.getAvailableRooms(startDate, endDate, capacity).get(0);
        Booking booking = new Booking(bookingId, customer, startDate, endDate, room);

        room.createRoomBooking(startDate, endDate);
        bookingRepository.createBooking(booking);

        // publisher zum Event

    }

    @Override
    public void cancelBooking(BookingId bookingId) throws Exception {

        // TODO: Gibt es hier Exception?
        Booking booking = bookingRepository.getBookingByBookingId(bookingId);

        roomService.removeRoomBooking(booking);
        bookingRepository.cancelBooking(bookingId);

        // publisher zum Event
    }
}
