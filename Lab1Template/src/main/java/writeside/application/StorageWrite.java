package writeside.application;

import eventside.domain.Booking;
import eventside.domain.Customer;
import eventside.domain.Room;

import java.time.LocalDate;
import java.util.List;


public interface StorageWrite {
    void createBooking(Booking booking);
    void cancelBooking(Booking booking);
    void createRooms(Room room);
    void add(Customer customer);
    List<Room> getAvalibleRooms(LocalDate startDate, LocalDate endDate, int capacity);
}
