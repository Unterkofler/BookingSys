package writeside.event;

import eventside.domain.Booking;
import eventside.domain.ValueObjects.BookingId;

import java.util.UUID;

public class BookingCanceled extends Event {
    private BookingId bookingId;

    public BookingCanceled() {
    }

    public BookingCanceled(BookingId bookingId) {
        this.bookingId = bookingId;
    }

    public BookingId getBookingId() {
        return bookingId;
    }

    public void setBookingId(BookingId bookingId) {
        this.bookingId = bookingId;
    }
}
