package writeside.domain;

import writeside.domain.ValueObjects.RoomBooking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomNumber;
    private int capacity;
    private List<RoomBooking> roomBookings;

    //TODO: Achim ansehen
    public Room(int roomNumber, int capacity, List<RoomBooking> roomBookings) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.roomBookings = new ArrayList<>();
    }



    public int getRoomNumber() { return roomNumber; }

    public int getCapacity() {
        return capacity;
    }

    public List<RoomBooking> getRoomBookings() {
        return roomBookings;
    }

    public void createRoomBooking(LocalDate startDate, LocalDate endDate) {
        RoomBooking roomBooking = new RoomBooking(startDate, endDate);
        roomBookings.add(roomBooking);
    }
}
