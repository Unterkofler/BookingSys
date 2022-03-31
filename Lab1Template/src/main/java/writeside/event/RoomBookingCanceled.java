package writeside.event;

import java.time.LocalDate;

public class RoomBookingCanceled extends Event{
    private LocalDate startDate;
    private LocalDate endDate;

    public RoomBookingCanceled() {
    }

    public RoomBookingCanceled(LocalDate startDate, LocalDate endDate) {
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
