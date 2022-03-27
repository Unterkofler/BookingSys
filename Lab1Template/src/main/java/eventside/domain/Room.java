package eventside.domain;

public class Room {
    private int roomNumber;
    private int capacity;
    private boolean isFree;

    public Room(int roomNumber, int capacity, boolean isFree) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.isFree = isFree;
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
