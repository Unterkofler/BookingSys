package writeside.application.interfaces;

import eventside.domain.Booking;
import eventside.domain.Customer;
import eventside.domain.Room;

import java.time.LocalDate;
import java.util.List;


public interface StorageWrite {
    void createBooking(Booking booking);
    void cancelBooking(int bookingNumber) throws Exception;
    void cancelRoomBooking(Room specificRoom) throws Exception;
    Booking getBookingByBookingNumber(int bookingNumber) throws Exception;


    void createRooms();
    List<Room> roomsByCapacity(int capacity) throws Exception;
    Room getRoomByRoomNumber(int roomNumber) throws Exception;



    void add(Customer customer);

}
