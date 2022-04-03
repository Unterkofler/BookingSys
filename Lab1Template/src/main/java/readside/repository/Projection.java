package readside.repository;

import writeside.event.Event;

public interface Projection {
    void createRoom(Event event) throws Exception;

    void createBooking(Event event) throws Exception;
    void cancelBooking(Event event) throws Exception;

    void createRoomBooking(Event event);
    void roomBookingCanceled(Event event);
}
