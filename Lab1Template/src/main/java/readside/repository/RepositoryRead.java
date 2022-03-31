package readside.repository;

import eventside.domain.ValueObjects.BookingId;
import readside.DTO.BookingDTO;

import java.util.HashMap;

public interface RepositoryRead {
    void addBooking(BookingDTO bookingDTO);
    void remove(BookingId bookingId) throws Exception;
    HashMap<BookingId,BookingDTO> getAllBookings();
}
