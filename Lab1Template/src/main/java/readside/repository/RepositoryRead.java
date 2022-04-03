package readside.repository;

import writeside.domain.ValueObjects.BookingId;
import readside.DTO.BookingDTO;
import readside.DTO.RoomBookingDTO;
import readside.DTO.RoomDTO;

import java.time.LocalDate;
import java.util.List;

public interface RepositoryRead {
        void createRoom(RoomDTO roomDTO) throws Exception;

        void createBooking(BookingDTO bookingDTO) throws Exception;
        void removeBooking(BookingId bookingId) throws Exception;

        void addDates(RoomBookingDTO roomBookingDTO);
        void removeDates(RoomBookingDTO roomBookingDTO);

        List<BookingDTO> getBookingsInPeriod(LocalDate startDate, LocalDate endDate) throws Exception;
        List<RoomDTO> getFreeRooms(LocalDate startDate, LocalDate endDate, int capacity) throws Exception;
}

