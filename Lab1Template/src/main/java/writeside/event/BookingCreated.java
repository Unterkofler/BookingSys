package writeside.event;

import eventside.domain.Event;
import eventside.domain.Room;
import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.Customer;

import java.time.LocalDate;

public class BookingCreated extends AbstractEvent {
    private BookingId bookingId;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private Room bookedRoom;

    public BookingCreated(BookingId bookingId, Customer customer, LocalDate startDate, LocalDate endDate, Room bookedRoom) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookedRoom = bookedRoom;
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Room getBookedRoom() {
        return bookedRoom;
    }

    public void setBookedRoom(Room bookedRoom) {
        this.bookedRoom = bookedRoom;
    }
}
