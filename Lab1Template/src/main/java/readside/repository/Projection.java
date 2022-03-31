package readside.repository;

import writeside.event.Event;

public interface Projection {
    void createBooking(Event event);
    void cancelBooking(Event event) throws Exception;

    void createRoom(Event event);
    void createRoomBooking(Event event);
    void roomBookingCanceled(Event event);
}
