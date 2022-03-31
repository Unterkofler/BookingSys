package writeside.event;

import java.time.LocalDate;

public class RoomBookingCreated extends Event{
    private LocalDate startDate;
    private LocalDate endDate;

    public RoomBookingCreated() {
    }

    public RoomBookingCreated(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }


}
