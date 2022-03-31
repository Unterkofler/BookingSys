package eventside.publisher;

import writeside.event.BookingCanceled;
import writeside.event.Event;

public interface Publisher {
    Boolean bookingCreated(Event event);
    Boolean publishBookingCanceled(Event event);
}
