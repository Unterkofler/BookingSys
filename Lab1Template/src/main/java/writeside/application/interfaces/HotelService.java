package writeside.application.interfaces;

import eventside.domain.Booking;
import eventside.domain.Room;
import eventside.domain.ValueObjects.BookingId;
import java.time.LocalDate;
import java.util.List;

public interface HotelService {
    void createBooking(String firstName, String lastName, BookingId bookingId, LocalDate startDate, LocalDate endDate, int capacity) throws Exception;
    void cancelBooking(BookingId bookingId) throws Exception;

    List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate, int capacity) throws Exception;
    void removeRoomBooking(Booking booking) throws Exception;

    void createRoom(Room room);
}
