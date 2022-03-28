package writeside.application;

import eventside.domain.Booking;
import eventside.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import writeside.application.interfaces.RoomRepositoryWrite;
import writeside.application.interfaces.RoomService;
import writeside.repository.StorageWriteImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepositoryWrite roomRepositoryWrite;

    @Override
    public List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate, int capacity) throws Exception {
        List<Room> rooms = new ArrayList<>();
        List<Room> roomsByCapacity = roomRepositoryWrite.roomsByCapacity(capacity);

        rooms.add(roomsByCapacity.get(0));

       /* for (Room room : roomsByCapacity) {

            // Todo: Trubbles
             for (int i = 0; i < 5; i++) {

                if (room.getRoomBookings() == null) {
                    rooms.add(room);
                } else if ((!(room.getRoomBookings().get(i).getStartDate().isBefore(startDate)
                        && room.getRoomBookings().get(i).getEndDate().isAfter(endDate)))) {
                    rooms.add(room);
                }
            } */


        if (rooms.size() == 0) {
            throw new Exception("No rooms found");
        }

        return rooms;
    }

    @Override
    public void removeRoomBooking(Booking booking) throws Exception {
       Room room = roomRepositoryWrite.getRoomByRoomNumber(booking.getBookedRoom().getRoomNumber());

       roomRepositoryWrite.cancelRoomBooking(room);
    }
}
