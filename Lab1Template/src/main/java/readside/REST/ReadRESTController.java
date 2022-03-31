package readside.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import readside.repository.Projection;
import writeside.event.Event;

@RestController
@RequestMapping(value = "/event/", method = RequestMethod.GET)
public class ReadRESTController {

    @Autowired
    private Projection projection;

    @PostMapping(value = "/event/bookingCreated", consumes = "application/json", produces = "application/json")
    public boolean bookingCreated(@RequestBody Event event) {

        projection.createBooking(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/event/bookingCanceled", consumes = "application/json", produces = "application/json")
    public boolean bookingCanceled(@RequestBody Event event) throws Exception {

        projection.cancelBooking(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/event/roomCreated", consumes = "application/json", produces = "application/json")
    public boolean roomCreated(@RequestBody Event event) {

        projection.createRoom(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/event/roomBookingCreated", consumes = "application/json", produces = "application/json")
    public boolean roomBookingCreated(@RequestBody Event event) {
        projection.createRoomBooking(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/event/roomBookingCanceled", consumes = "application/json", produces = "application/json")
    public boolean roomBookingCanceled(@RequestBody Event event) {
        projection.roomBookingCanceled(event);
        System.out.println("Event received: " + event);
        return true;
    }
}
