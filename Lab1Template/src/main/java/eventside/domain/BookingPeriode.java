package eventside.domain;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class BookingPeriode {
    private LocalDate startDate, endDate;

    public BookingPeriode(LocalDate startDate, LocalDate endDate) {
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
