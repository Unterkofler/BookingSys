package writeside.application.interfaces;

import eventside.domain.Booking;
import eventside.domain.Room;
import eventside.domain.ValueObjects.BookingId;

import java.util.List;


public interface RepositoryWrite {
    void createBooking(Booking booking);
    void cancelBooking(BookingId bookingId) throws Exception;
    Booking getBookingByBookingId(BookingId bookingId) throws Exception;

   // void add(Customer customer);
    void createRooms();
    Room getRoomByRoomNumber(int roomNumber) throws Exception;
    List<Room> roomsByCapacity(int capacity) throws Exception;

    void cancelRoomBooking(Room specificRoom) throws Exception;

}
