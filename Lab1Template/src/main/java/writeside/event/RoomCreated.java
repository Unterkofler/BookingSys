package writeside.event;

import writeside.domain.ValueObjects.RoomBooking;
import java.util.ArrayList;
import java.util.List;

public class RoomCreated extends Event {
    private int roomNumber;
    private int capacity;
    private List<RoomBooking> roomBookings;

    public RoomCreated(int roomNumber, int capacity, List<RoomBooking> roomBookings) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.roomBookings = roomBookings;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }
}
