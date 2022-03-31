package readside.repository;

import eventside.domain.Room;
import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.RoomBooking;
import org.springframework.stereotype.Component;
import readside.DTO.BookingDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Component
public class RepositoryReadImpl implements RepositoryRead{

    private HashMap<BookingId, BookingDTO> hashMap = new HashMap<>();
    private List<Room> roomList = new ArrayList<>();
    private List<RoomBooking> roomBookings= new ArrayList<>();

    //Exeption if(bookingDTO == null)
    public void addBooking(BookingDTO bookingDTO){
        hashMap.put(bookingDTO.getBookingId(), bookingDTO);
    }

    public void remove(BookingId bookingId) throws Exception {
        try {
            hashMap.remove(bookingId);
        }catch (Exception e){
            throw new Exception("BookingId not found");
        }

    }

    @Override
    public void addRoom(Room room) {
        roomList.add(room);
    }

    @Override
    public void addRoomBooking(RoomBooking roomBooking) {
        //hier muss es in die RoomListe eigentlich in das Objekt hinein.
        // aktuell speichern in eigener Liste
        roomBookings.add(roomBooking);
    }

    public HashMap<BookingId,BookingDTO> getAllBookings(){
        return hashMap;
    }

    @Override
    public void removeRoomBooking(RoomBooking roomBooking) {
        //hier muss es in die RoomListe eigentlich in das Objekt hinein.
        // aktuell speichern in eigener Liste
        roomBookings.add(roomBooking);
    }
}
