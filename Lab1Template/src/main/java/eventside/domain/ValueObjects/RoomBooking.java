package eventside.domain.ValueObjects;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class RoomBooking {
    private LocalDate startDate;
    private LocalDate endDate;

    public RoomBooking() {
    }

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
