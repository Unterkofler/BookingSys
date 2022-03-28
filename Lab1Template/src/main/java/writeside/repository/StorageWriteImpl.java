package writeside.repository;

import eventside.domain.Booking;
import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.Customer;
import org.springframework.stereotype.Component;
import writeside.application.interfaces.BookingRepositoryWrite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class StorageWriteImpl implements BookingRepositoryWrite {
    //private List<Customer> customers = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    @Override
    public void createBooking(Booking booking) {
        //TODO: Exception
        bookings.add(booking);
    }

    @Override
    public void cancelBooking(BookingId bookingId) throws Exception {
        Iterator bookingIterator = bookings.iterator();

        while (bookingIterator.hasNext()) {
            Booking booking = (Booking) bookingIterator.next();

            if (booking.getBookingId() == bookingId) {
                bookingIterator.remove();
                return;
            }
        }
        throw new Exception("Booking not found exception");
    }

    @Override
    public Booking getBookingByBookingId(BookingId bookingId) throws Exception {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                return booking;
            }
        }
        throw new Exception("Booking not found exception");
    }


        /*public void add(Customer customer) {
        boolean isadded = this.customers.add(customer);
    } */
}


