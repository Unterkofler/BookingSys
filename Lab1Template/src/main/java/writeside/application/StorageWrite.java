package writeside.application;

import eventside.domain.Booking;
import eventside.domain.Customer;
import eventside.domain.Room;

import java.time.LocalDate;
import java.util.List;


public interface StorageWrite {
    void createBooking(Booking booking);
    void cancelBooking(Booking booking);
    void createRooms();
    void add(Customer customer);
    List<Room> roomsByCapacity(int capacity) throws Exception;
}
