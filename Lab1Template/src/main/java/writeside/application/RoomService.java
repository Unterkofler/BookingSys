package GUI;

import eventside.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate, int capacity) throws Exception;

}
