package writeside.application;

import eventside.domain.Booking;
import eventside.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import writeside.application.interfaces.RoomRepositoryWrite;
import writeside.application.interfaces.RoomService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepositoryWrite roomRepository;

    @Override
    public List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate, int capacity) throws Exception {
        List<Room> rooms = new ArrayList<>();
        List<Room> roomsByCapacity = roomRepository.roomsByCapacity(capacity);

        // Todo: Überarbeiten
            for (Room room : roomsByCapacity) {
                int i = 0;


                    if (room.getRoomBookings().size() == 0) {
                        rooms.add(room);
                    } else if ((!(room.getRoomBookings().get(i).getStartDate().isBefore(startDate)
                            && room.getRoomBookings().get(i).getEndDate().isAfter(endDate)))) {
                        rooms.add(room);
                    }
                    i++;
                }


            if (rooms.size() == 0) {
                throw new Exception("No rooms found");
            }

        return rooms;
        }

    @Override
    public void removeRoomBooking(Booking booking) throws Exception {
        Room room = roomRepository.getRoomByRoomNumber(booking.getBookedRoom().getRoomNumber());

        roomRepository.cancelRoomBooking(room);
    }
}

