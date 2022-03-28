package writeside.application.interfaces;

import eventside.domain.Booking;
import eventside.domain.ValueObjects.BookingId;




public interface BookingRepositoryWrite {
    void createBooking(Booking booking);
    void cancelBooking(BookingId bookingId) throws Exception;
    Booking getBookingByBookingId(BookingId bookingId) throws Exception;

   // void add(Customer customer);

}
