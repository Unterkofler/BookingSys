package eventside.domain;

import java.time.LocalDate;
import java.util.List;

public class Booking {
    private int bookingNumber;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Room> bookedRooms;

    public Booking(int bookingNumber, Customer customer, LocalDate startDate, LocalDate endDate, List<Room> bookedRooms) {
        this.bookingNumber = bookingNumber;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookedRooms = bookedRooms;
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

    public List<Room> getBookedRooms() {
        return bookedRooms;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingNumber=" + bookingNumber +
                ", customer=" + customer +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", bookedRooms=" + bookedRooms +
                '}';
    }
}
