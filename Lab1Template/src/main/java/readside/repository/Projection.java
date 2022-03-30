package readside.repository;

import writeside.event.Event;

public interface Projection {
    void createBooking(Event event);
    void cancelBooking(Event event) throws Exception;

    //void addRoom(Event event);
}
