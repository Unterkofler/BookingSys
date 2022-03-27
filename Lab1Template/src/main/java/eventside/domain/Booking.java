package eventside.domain;

import java.time.LocalDate;
import java.util.List;

public class Booking {
    private int bookingNumber;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private Room bookedRoom;



    public Booking(int bookingNumber, Customer customer, LocalDate startDate, LocalDate endDate, Room bookedRoom) {
        this.bookingNumber = bookingNumber;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookedRoom = bookedRoom;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Room getBookedRoom() {
        return bookedRoom;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingNumber=" + bookingNumber +
                ", customer=" + customer +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", bookedRoom=" + bookedRoom +
                '}';
    }
}
