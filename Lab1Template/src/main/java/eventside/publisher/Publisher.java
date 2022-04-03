package eventside.publisher;

import writeside.event.BookingCanceled;
import writeside.event.Event;

public interface Publisher {
    Boolean roomCreated(Event event);
    Boolean bookingCreated(Event event);
    Boolean publishBookingCanceled(Event event);
    Boolean roomBookingCreated(Event event);
    Boolean roomBookingCanceled(Event event);
}
