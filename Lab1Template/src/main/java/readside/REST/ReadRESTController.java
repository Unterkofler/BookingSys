package readside.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import readside.repository.Projection;
import writeside.event.*;

@RestController
public class ReadRESTController {

    @Autowired
    private Projection projection;


    @PostMapping(value = "/event/bookingCreated", consumes = "application/json", produces = "application/json")
    public boolean bookingCreated(@RequestBody BookingCreated event) throws Exception {

        projection.createBooking(event);
        System.out.println("Event received: " + event);
        return true;
    }


    @PostMapping(value = "/event/bookingCanceled", consumes = "application/json", produces = "application/json")
    public boolean bookingCanceled(@RequestBody BookingCanceled event) throws Exception {

        projection.cancelBooking(event);
        System.out.println("Event received: " + event);
        return true;
    }


    @PostMapping(value = "/event/roomCreated", consumes = "application/json", produces = "application/json")
    public boolean roomCreated(@RequestBody RoomCreated event) throws Exception {
        System.out.println(event);
        projection.createRoom(event);
        System.out.println("Event received: " + event);
        return true;
    }


    @PostMapping(value = "/event/roomBookingCreated", consumes = "application/json", produces = "application/json")
    public boolean roomBookingCreated(@RequestBody RoomBookingCreated event) throws Exception {
        projection.createRoomBooking(event);
        System.out.println("Event received: " + event);
        return true;
    }


    @PostMapping(value = "/event/roomBookingCanceled", consumes = "application/json", produces = "application/json")
    public boolean roomBookingCanceled(@RequestBody RoomBookingCanceled event) throws Exception {
        projection.roomBookingCanceled(event);
        System.out.println("Event received: " + event);
        return true;
    }
}
