package readside.DTO;


import java.time.LocalDate;

public class RoomBookingDTO {
    private LocalDate startDate;
    private LocalDate endDate;

    public RoomBookingDTO() {
    }

    public RoomBookingDTO(LocalDate startDate, LocalDate endDate) {
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
