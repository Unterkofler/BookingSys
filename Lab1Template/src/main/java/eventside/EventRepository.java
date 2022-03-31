package eventside;

import org.springframework.stereotype.Component;
import writeside.event.BookingCanceled;
import writeside.event.BookingCreated;
import writeside.event.Event;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventRepository {

    private List<Event> events = new ArrayList<>();

    public void processEvent(Event event) {
        events.add(event);

       /* switch (event){
            case event instanceof BookingCreated:
                break;
            case event instanceof BookingCanceled:
                break;
        } */

    }
}
