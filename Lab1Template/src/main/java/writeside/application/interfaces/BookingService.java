package writeside.application.interfaces;

import eventside.domain.ValueObjects.BookingId;
import java.time.LocalDate;

public interface BookingService {
    void createBooking(String firstName, String lastName, BookingId bookingId, LocalDate startDate, LocalDate endDate, int capacity) throws Exception;
    void cancelBooking(BookingId bookingId) throws Exception;
}
