package writeside.event;

import java.time.LocalDate;

public class RoomBookingCreated extends Event{
    private LocalDate startDate;
    private LocalDate endDate;
    private int roomNumber;

    public RoomBookingCreated() {
    }

    public RoomBookingCreated(LocalDate startDate, LocalDate endDate, int roomNumber) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNumber = roomNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
