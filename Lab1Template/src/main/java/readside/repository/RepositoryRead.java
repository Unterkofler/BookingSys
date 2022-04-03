package readside.repository;

import eventside.domain.ValueObjects.BookingId;
import readside.DTO.BookingDTO;
import readside.DTO.RoomBookingDTO;
import readside.DTO.RoomDTO;

import java.time.LocalDate;
import java.util.List;

public interface RepositoryRead {
    void addBooking(BookingDTO bookingDTO);
    void remove(BookingId bookingId) throws Exception;
    void addRoom(RoomDTO roomDTO);
    void addDates(RoomBookingDTO roomBookingDTO);
    List<BookingDTO> getBookingsInPeriod(LocalDate startDate, LocalDate endDate);
    void removeDates(RoomBookingDTO roomBookingDTO);
    List<RoomDTO> getFreeRooms(LocalDate startDate, LocalDate endDate, int capacity);
}
