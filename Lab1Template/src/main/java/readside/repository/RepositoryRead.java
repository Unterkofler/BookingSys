package readside.repository;

import eventside.domain.Room;
import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.RoomBooking;
import readside.DTO.BookingDTO;
import readside.DTO.RoomBookingDTO;
import readside.DTO.RoomDTO;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface RepositoryRead {
    void addBooking(BookingDTO bookingDTO);
    void remove(BookingId bookingId) throws Exception;
    void addRoom(RoomDTO roomDTO);
    void addRoomBooking( RoomBooking roomBooking);
    List<BookingDTO> getBookingsInPeriod(LocalDate startDate, LocalDate endDate);
    void removeRoomBooking(RoomBookingDTO roomBookingDTO);
}
