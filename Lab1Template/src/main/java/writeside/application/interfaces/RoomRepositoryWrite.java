package writeside.application.interfaces;

import eventside.domain.Room;
import java.util.List;

public interface RoomRepositoryWrite {
    void createRooms();
    Room getRoomByRoomNumber(int roomNumber) throws Exception;
    List<Room> roomsByCapacity(int capacity) throws Exception;

    void cancelRoomBooking(Room specificRoom) throws Exception;
}
