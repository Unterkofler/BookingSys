package writeside.application;
import eventside.domain.Booking;
import eventside.domain.Customer;
import eventside.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import writeside.application.interfaces.BookingService;
import writeside.application.interfaces.RoomService;
import writeside.application.interfaces.StorageWrite;
import java.time.LocalDate;

@Component
public class BookingServiceImpl implements BookingService {

    @Autowired
    StorageWrite storageWrite;

    @Autowired
    RoomService roomService;


    @Override
    public void createBooking(String firstName, String lastName, int bookingNumber, LocalDate startDate, LocalDate endDate, int capacity) throws Exception {

        // TODO: Gibt es hier Exception?
        Customer customer = new Customer(1, firstName, lastName);
        Room room = roomService.getAvailableRooms(startDate, endDate, capacity).get(0);

        Booking booking = new Booking(bookingNumber, customer, startDate, endDate, room);

        room.createRoomBooking(startDate, endDate);
        storageWrite.createBooking(booking);

        // publisher zum Event

    }

    @Override
    public void cancelBooking(int bookingNumber) throws Exception {

        // TODO: Gibt es hier Exception?
        Booking booking = storageWrite.getBookingByBookingNumber(bookingNumber);
        roomService.removeRoomBooking(booking);
        storageWrite.cancelBooking(bookingNumber);

        // publisher zum Event
    }
}
