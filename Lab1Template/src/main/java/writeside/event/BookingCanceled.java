package writeside.event;

import writeside.domain.ValueObjects.BookingId;

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
