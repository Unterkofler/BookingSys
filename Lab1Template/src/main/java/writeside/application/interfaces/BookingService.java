package writeside.application.interfaces;

import eventside.domain.Booking;
import eventside.domain.Room;

import java.time.LocalDate;

public interface BookingService {
    void createBooking(String firstName, String lastName, int bookingNumber, LocalDate startDate, LocalDate endDate, int capacity) throws Exception;
    void cancelBooking(int bookingNumber) throws Exception;
}
