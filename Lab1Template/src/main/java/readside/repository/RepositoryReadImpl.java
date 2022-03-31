package readside.repository;

import eventside.domain.ValueObjects.BookingId;
import org.springframework.stereotype.Component;
import readside.DTO.BookingDTO;

import java.util.HashMap;

@Component
public class RepositoryReadImpl implements RepositoryRead{

    private HashMap<BookingId, BookingDTO> hashMap = new HashMap<>();

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

    public HashMap<BookingId,BookingDTO> getAllBookings(){
        return hashMap;
    }
}
