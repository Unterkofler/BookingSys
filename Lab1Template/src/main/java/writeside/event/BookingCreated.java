package writeside.event;

import writeside.domain.ValueObjects.BookingId;
import writeside.domain.ValueObjects.Customer;

import java.time.LocalDate;

public class BookingCreated extends Event {
    private BookingId bookingId;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private int roomId;

    public BookingCreated(BookingId bookingId, Customer customer, LocalDate startDate, LocalDate endDate, int roomId) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomId = roomId;
    }

    public BookingId getBookingId() {
        return bookingId;
    }

    public void setBookingId(BookingId bookingId) {
        this.bookingId = bookingId;
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

    public int getRoomId() {
        return roomId;
    }
}
