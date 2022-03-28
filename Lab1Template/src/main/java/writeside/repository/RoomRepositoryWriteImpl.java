package writeside.repository;

import eventside.domain.Room;
import eventside.domain.ValueObjects.RoomBooking;
import org.springframework.stereotype.Component;
import writeside.application.interfaces.RoomRepositoryWrite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Component
public class RoomRepositoryWriteImpl implements RoomRepositoryWrite {
    private List<Room> rooms = new ArrayList<>();

    public void createRooms() {
        for (int i = 0; i < 50; i++) {
            Random random = new Random(99991 * i + 13);
            rooms.add(i, new Room(i, random.nextInt(5) + 1,null));
        }
    }

    @Override
    public Room getRoomByRoomNumber(int roomNumber) throws Exception {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }

        throw new Exception("No rooms found exception");
    }

    @Override
    public List<Room> roomsByCapacity(int capacity) throws Exception {
        List<Room> roomsResult = new ArrayList<>();
        for (Room room : rooms) {
            if (capacity == room.getCapacity()) {
                roomsResult.add(room);
            }
        }

        if (roomsResult.size() == 0) {
            throw new Exception("No rooms found exception");
        }

        return roomsResult;
    }

    @Override
    public void cancelRoomBooking(Room specificRoom) throws Exception {
        Iterator<RoomBooking> roomIterator = specificRoom.getRoomBookings().iterator();
        int i = 0;

        while (roomIterator.hasNext()) {
            RoomBooking rooms = (RoomBooking) roomIterator.next();

            if (rooms.getStartDate().equals(specificRoom.getRoomBookings().get(0).getStartDate()) && rooms.getEndDate().equals(specificRoom.getRoomBookings().get(0).getEndDate())) {
                roomIterator.remove();
                return;
            }
            i++;
        }

        throw new Exception("Booking not found exception");
    }
}
