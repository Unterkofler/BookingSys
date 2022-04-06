package writeside.domain;

import writeside.domain.ValueObjects.BookingId;
import writeside.domain.ValueObjects.Customer;

import java.time.LocalDate;

public class Booking {
    private BookingId bookingId;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private int roomNumber;

    public Booking(BookingId bookingId, Customer customer, LocalDate startDate, LocalDate endDate, int roomNumber) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public BookingId getBookingId() {
        return bookingId;
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
}
