package writeside.domain.ValueObjects;
import java.util.UUID;

public class BookingId {
    private UUID bookingId;

    public BookingId(){
    }

    public BookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    @Override
    public String toString() {
        return "BookingId{" +
                "bookingId=" + bookingId +
                '}';
    }
}
