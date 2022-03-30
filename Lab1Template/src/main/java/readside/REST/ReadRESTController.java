package readside.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import readside.repository.Projection;
import writeside.event.Event;

@RestController
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
}
