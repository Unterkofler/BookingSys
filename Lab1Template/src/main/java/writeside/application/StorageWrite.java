package writeside.application;

import eventside.domain.Booking;
import eventside.domain.Room;


public interface StorageWrite {
    void createBooking(Booking booking);
    void cancelBooking(Booking booking);
    void createRooms(Room room);
}
