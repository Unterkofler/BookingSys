package readside.DTO;

import eventside.domain.Room;
import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.Customer;

import java.time.LocalDate;

public class BookingDTO {
    private BookingId bookingId;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private int roomId;

    public BookingDTO(BookingId bookingId, Customer customer, LocalDate startDate, LocalDate endDate, int roomId) {
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
