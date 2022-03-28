package eventside.domain.ValueObjects;
import java.util.UUID;

public class BookingId {

    private UUID bookingId;

    public BookingId(UUID uuid) {
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }
}
