package readside.repository;

import eventside.domain.Room;
import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.RoomBooking;
import readside.DTO.BookingDTO;

import java.util.HashMap;

public interface RepositoryRead {
    void addBooking(BookingDTO bookingDTO);
    void remove(BookingId bookingId) throws Exception;
    void addRoom(Room room);
    void addRoomBooking( RoomBooking roomBooking);
    HashMap<BookingId,BookingDTO> getAllBookings();
    void removeRoomBooking(RoomBooking roomBooking);
}
