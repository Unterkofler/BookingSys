package writeside.application;

import eventside.domain.Customer;

import java.time.LocalDate;

public interface BookingService {
    void createBooking(String firstName, String lastName, int bookingNumber, LocalDate startDate, LocalDate endDate, int capacity) throws Exception;
    void cancelBooking();
}
