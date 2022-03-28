package writeside.application.interfaces;

import eventside.domain.Booking;
import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.Customer;
import eventside.domain.Room;

import java.util.List;


public interface BookingRepositoryWrite {
    void createBooking(Booking booking);
    void cancelBooking(BookingId bookingId) throws Exception;
    Booking getBookingByBookingId(BookingId bookingId) throws Exception;



   // void add(Customer customer);

}
