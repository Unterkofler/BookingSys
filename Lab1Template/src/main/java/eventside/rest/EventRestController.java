package eventside.rest;

import eventside.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import writeside.event.Event;

@RestController
public class EventRestController {

    @Autowired
    private EventRepository repository;

    @PostMapping(value = "/event", consumes = "application/json", produces = "application/json")
    public boolean addEvent(@RequestBody Event event) {
        // TODO: process event in readside.repository
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/event/bookingCreated", consumes = "application/json", produces = "application/json")
    public boolean bookingCreated(@RequestBody Event event) {
        // TODO: process event in readside.repository
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/event/bookingCanceled", consumes = "application/json", produces = "application/json")
    public boolean bookingCanceled(@RequestBody Event event) {
        // TODO: process event in readside.repository
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }


}
