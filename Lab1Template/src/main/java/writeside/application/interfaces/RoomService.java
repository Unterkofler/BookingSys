package writeside.application.interfaces;

import eventside.domain.Booking;
import eventside.domain.Room;
import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate, int capacity) throws Exception;
    void removeRoomBooking(Booking booking) throws Exception;
}
