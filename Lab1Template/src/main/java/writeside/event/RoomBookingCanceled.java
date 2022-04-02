package writeside.event;

import java.time.LocalDate;

public class RoomBookingCanceled extends Event{
    private LocalDate startDate;
    private LocalDate endDate;
    int roomNumber;

    public RoomBookingCanceled() {
    }

    public RoomBookingCanceled(LocalDate startDate, LocalDate endDate, int roomNumber) {
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
