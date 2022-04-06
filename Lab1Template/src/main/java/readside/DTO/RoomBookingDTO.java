package readside.DTO;


import java.time.LocalDate;

public class RoomBookingDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    int roomNumber;

    public RoomBookingDTO(LocalDate startDate, LocalDate endDate, int roomNumber) {
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
