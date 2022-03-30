package readside.repository;

import eventside.domain.ValueObjects.BookingId;
import readside.DTO.BookingDTO;

public interface RepositoryRead {
    void addBooking(BookingDTO bookingDTO);
    void remove(BookingId bookingId) throws Exception;
}
