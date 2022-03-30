package readside.DTO;

import eventside.domain.ValueObjects.RoomBooking;

import java.util.List;

public class RoomDTO {
    private int roomNumber;
    private int capacity;
    private List<RoomBooking> roomBookings;

    public RoomDTO(int roomNumber, int capacity, List<RoomBooking> roomBookings) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.roomBookings = roomBookings;
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

    public List<RoomBooking> getRoomBookings() {
        return roomBookings;
    }

    public void setRoomBookings(List<RoomBooking> roomBookings) {
        this.roomBookings = roomBookings;
    }
}
