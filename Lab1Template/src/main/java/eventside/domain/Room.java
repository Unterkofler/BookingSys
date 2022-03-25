package eventside.domain;

public class Room {
    private int roomNumber;
    private int capacity;
    private boolean isFree = true;

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", capacity=" + capacity +
                ", isFree=" + isFree +
                '}';
    }
}
