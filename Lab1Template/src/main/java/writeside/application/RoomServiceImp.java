package writeside.application;

import GUI.RoomService;
import eventside.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import writeside.repository.StorageWriteImpl;

import java.time.LocalDate;
import java.util.List;

@Component
public class RoomServiceImp implements RoomService {
    @Autowired
    private StorageWriteImpl storageWrite;


    @Override
    public List<Room> getAvalibleRooms(LocalDate startDate, LocalDate endDate,int capacity) {
        List<Room> rooms = storageWrite.getAvalibleRooms(startDate, endDate, capacity);



        return rooms;
    }
}
