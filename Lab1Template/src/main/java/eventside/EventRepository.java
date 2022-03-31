package eventside;

import eventside.publisher.Publisher;
import eventside.publisher.PublisherToRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import writeside.event.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventRepository {

    private List<Event> events = new ArrayList<>();

    @Autowired
    private PublisherToRead publisher;


    public void processEvent(Event event) {
        events.add(event);

        if(event instanceof BookingCreated){
            publisher.bookingCreated(event);
        } else if(event instanceof BookingCanceled){
            publisher.publishBookingCanceled(event);
        } else if(event instanceof RoomCreated){
            publisher.roomCreated(event);
        } else if(event instanceof RoomBookingCreated){
           publisher.roomBookingCreated(event);
        } else if(event instanceof RoomBookingCanceled){
            publisher.roomBookingCanceled(event);
        }
    }
}
