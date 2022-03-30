package readside.repository;

import eventside.domain.ValueObjects.BookingId;
import readside.DTO.BookingDTO;

import java.util.HashMap;

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
}
