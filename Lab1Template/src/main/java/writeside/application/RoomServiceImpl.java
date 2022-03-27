package writeside.application;

import GUI.RoomService;
import eventside.domain.BookingPeriode;
import eventside.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import writeside.repository.StorageWriteImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoomServiceImpl implements RoomService {

    @Autowired
    private StorageWriteImpl storageWrite;

    @Override
    public List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate, int capacity) throws Exception {
        List<Room> rooms = new ArrayList<>();
        List<Room> roomsByCapacity = storageWrite.roomsByCapacity(capacity);

      /*  for (Room room : roomsByCapacity) {

           for (BookingPeriode bp : room.getBookingPeriodes()) {
                // TODO: Check
                if (!(bp.getStartDate().isBefore(startDate) && bp.getEndDate().isAfter(endDate))) {
                    rooms.add(room);
                }
            }
            rooms.add(room);
        } */

        for (Room room : roomsByCapacity) {

            // TODO: Check
            for (int i = 0; i < 5; i++) {

                if (room.getBookingPeriodes() == null) {
                    rooms.add(room);
                } else if ((!(room.getBookingPeriodes().get(i).getStartDate().isBefore(startDate)
                        && room.getBookingPeriodes().get(i).getEndDate().isAfter(endDate)))) {
                    rooms.add(room);
                }
            }
        }


        if (rooms.size() == 0) {
            throw new Exception("No rooms found");
        }

        return rooms;
    }
}
