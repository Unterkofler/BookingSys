package writeside;

import eventside.domain.Booking;
import eventside.domain.Room;


public interface StorageImpl {
    void createBooking(Booking booking);
    void cancelBooking(Booking booking);
    void createRooms(Room room);
}
