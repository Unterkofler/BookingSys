package writeside.event;

import java.util.UUID;

public class BookingCanceled extends AbstractEvent{
    private UUID bookingId;

    public BookingCanceled() {
    }

    public BookingCanceled(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public UUID getBookingID() {
        return bookingId;
    }

    public void setBookingId(UUID bookingID) {
        this.bookingId = bookingId;
    }
}
