package readside.repository;

import eventside.domain.Room;
import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.RoomBooking;
import org.springframework.stereotype.Component;
import readside.DTO.BookingDTO;
import readside.DTO.RoomBookingDTO;
import readside.DTO.RoomDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class RepositoryReadImpl implements RepositoryRead{

    private List<BookingDTO> bookingDTOS = new ArrayList<>();
    private List<RoomDTO> roomList = new ArrayList<>();


    @Override
    public void addRoom(RoomDTO roomDTO) {
        roomList.add(roomDTO);
    }

    @Override
    public void addRoomBooking(RoomBooking roomBooking) {
        //hier muss es in die RoomListe eigentlich in das Objekt hinein.
        // aktuell speichern in eigener Liste
        //roomBookings.add(roomBooking);
    }

    //Exeption if(bookingDTO == null)
    public void addBooking(BookingDTO bookingDTO){
        bookingDTOS.add(bookingDTO);
    }

    public void remove(BookingId bookingId) throws Exception {
        try {
            bookingDTOS.remove(bookingId);
        }catch (Exception e){
            throw new Exception("BookingId not found");
        }

    }

    public List<BookingDTO> getBookingsInPeriod(LocalDate startDate, LocalDate endDate){
        List<BookingDTO> allBookings = new ArrayList<>();

        for (BookingDTO bookingDTO : bookingDTOS){
            if(bookingDTO.getStartDate().equals(startDate) && bookingDTO.getEndDate().equals(endDate)){
                allBookings.add(bookingDTO);
            }
        }

        return allBookings;
    }

    @Override
    public void removeRoomBooking(RoomBookingDTO roomBookingDTO) {
        //hier muss es in die RoomListe eigentlich in das Objekt hinein.
        // aktuell speichern in eigener Liste
        //roomBookings.add(roomBookingDTO);
    }
}
