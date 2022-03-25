package writeside;

import eventside.domain.Booking;
import eventside.domain.Room;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StorageWriteImpl implements StorageImpl{
    private List<String> storage = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();

    public StorageWriteImpl(){}

    public boolean add(String data){
        boolean isadded = this.storage.add(data);
        System.out.println(data);
        return isadded;
    }

    @Override
    public void createBooking(Booking booking) {
        System.out.println(booking.toString());
        bookings.add(booking);
    }

    @Override
    public void cancelBooking(Booking booking) {
        return;
    }

    @Override
    public void createRooms(Room room) {
        rooms.add(room);
    }
}
