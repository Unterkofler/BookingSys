package writeside.domain.ValueObjects;

import java.time.LocalDate;

public class RoomBooking {
    private LocalDate startDate;
    private LocalDate endDate;

    public RoomBooking(LocalDate startDate, LocalDate endDate) {
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
