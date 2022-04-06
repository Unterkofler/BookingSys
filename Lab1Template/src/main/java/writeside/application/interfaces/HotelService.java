package writeside.application.interfaces;

import writeside.domain.Room;
import writeside.domain.ValueObjects.BookingId;
import java.time.LocalDate;

public interface HotelService {
    void createRoom(Room room) throws Exception;

    void createBooking(String firstName, String lastName, BookingId bookingId, LocalDate startDate, LocalDate endDate, int capacity, int roomNumber) throws Exception;
    void cancelBooking(BookingId bookingId) throws Exception;
}

