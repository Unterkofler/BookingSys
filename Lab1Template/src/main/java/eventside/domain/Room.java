package eventside.domain;

import java.util.List;

public class Room {
    private int roomNumber;
    private int capacity;
    private List<BookingPeriode> bookingPeriodes;



    public Room(int roomNumber, int capacity, boolean isFree) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
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

    public List<BookingPeriode> getBookingPeriodes() {
        return bookingPeriodes;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", capacity=" + capacity +
                '}';
    }
}
