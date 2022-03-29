package eventside;

import org.springframework.stereotype.Component;
import writeside.event.Event;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventRepository {

    private List<Event> events = new ArrayList<>();

    public void processEvent(Event event) {
        events.add(event);
        // TODO: notify subscribed read repositories
    }
}
