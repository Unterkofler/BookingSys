package readside.DTO;

import java.time.LocalDate;
import java.util.List;

public class RoomDTO {
    private int roomNumber;
    private int capacity;
    private List<LocalDate> freePeriods;

    public RoomDTO(int roomNumber, int capacity, List<LocalDate> freePeriods) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.freePeriods = freePeriods;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<LocalDate> getFreePeriods() {
        return freePeriods;
    }
}
