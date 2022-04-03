package eventside.domain.ValueObjects;
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

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "BookingId{" +
                "bookingId=" + bookingId +
                '}';
    }

    /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingId bookingId = (BookingId) o;

        return bookingId == this.bookingId;
    } */

}
