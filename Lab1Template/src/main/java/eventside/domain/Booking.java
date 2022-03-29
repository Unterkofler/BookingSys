package eventside.domain;

import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.Customer;

import java.time.LocalDate;

public class Booking {
    private BookingId bookingId;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private Room bookedRoom;

    public Booking(BookingId bookingId, Customer customer, LocalDate startDate, LocalDate endDate, Room bookedRoom) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookedRoom = bookedRoom;
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

    public Room getBookedRoom() {
        return bookedRoom;
    }
}
