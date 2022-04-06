package writeside.application.interfaces;

import writeside.domain.Booking;
import writeside.domain.Room;
import writeside.domain.ValueObjects.BookingId;

import java.util.List;


public interface RepositoryWrite {
    void createRoom(Room room) throws Exception;

    void createBooking(Booking booking) throws Exception;
    void cancelBooking(BookingId bookingId) throws Exception;
    Booking getBookingByBookingId(BookingId bookingId) throws Exception;

    Room getRoomByRoomNumber(int roomNumber) throws Exception;
    List<Room> roomsByCapacity(int capacity) throws Exception;
    void cancelRoomBooking(Room specificRoom) throws Exception;
}

