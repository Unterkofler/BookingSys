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

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<LocalDate> getFreePeriods() {
        return freePeriods;
    }

    public void setFreePeriods(List<LocalDate> freePeriods) {
        this.freePeriods = freePeriods;
    }

}
