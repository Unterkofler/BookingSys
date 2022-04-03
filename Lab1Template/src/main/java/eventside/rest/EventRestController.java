package eventside.rest;

import eventside.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import writeside.event.*;

@RestController
public class EventRestController {

    @Autowired
    private EventRepository repository;


    @PostMapping(value = "/event", consumes = "application/json", produces = "application/json")
    public boolean addEvent(@RequestBody Event event) {
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }


    @PostMapping(value = "/event/roomCreated", consumes = "application/json", produces = "application/json")
    public boolean roomCreated(@RequestBody RoomCreated event) {
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }


    @PostMapping(value = "/event/bookingCreated", consumes = "application/json", produces = "application/json")
    public boolean bookingCreated(@RequestBody BookingCreated event) {
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }


    @PostMapping(value = "/event/bookingCanceled", consumes = "application/json", produces = "application/json")
    public boolean bookingCanceled(@RequestBody BookingCanceled event) {
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }


    @PostMapping(value = "/event/roomBookingCreated", consumes = "application/json", produces = "application/json")
    public boolean roomBookingCreated(@RequestBody RoomBookingCreated event) {
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }


    @PostMapping(value = "/event/roomBookingCanceled", consumes = "application/json", produces = "application/json")
    public boolean roomBookingCanceled(@RequestBody RoomBookingCanceled event) {
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }
}
