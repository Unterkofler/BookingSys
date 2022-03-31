package eventside.domain;

import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.Customer;

import java.time.LocalDate;

public class Booking {
    private BookingId bookingId;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private int roomId;

    public Booking(BookingId bookingId, Customer customer, LocalDate startDate, LocalDate endDate, int roomId) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomId = roomId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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
