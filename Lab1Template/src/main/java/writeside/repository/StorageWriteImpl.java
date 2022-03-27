package writeside.repository;

import eventside.domain.Booking;
import eventside.domain.Customer;
import eventside.domain.Room;
import org.springframework.stereotype.Component;
import writeside.application.StorageWrite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class StorageWriteImpl implements StorageWrite {
    private List<Customer> customers = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();

    public StorageWriteImpl() {
        for (int i = 0; i < 50; i++) {
            Random random = new Random(99991 * i + 13);
            rooms.add(i, new Room(i, random.nextInt(5) + 1, true));
        }
    }

    public void createRooms() {
        for (int i = 0; i < 50; i++) {
            Random random = new Random(99991 * i + 13);
            rooms.add(i, new Room(i, random.nextInt(5) + 1, true));
        }
    }

    public void add(Customer customer) {
        boolean isadded = this.customers.add(customer);
    }

    @Override
    public List<Room> roomsByCapacity(int capacity) throws Exception {
        List<Room> roomsResult = new ArrayList<>();
        for (Room room : rooms) {
            if (capacity == room.getCapacity()) {
                roomsResult.add(room);
            }
        }

        if(roomsResult.size() == 0){
            throw new Exception("No rooms found");
        }

        return roomsResult;
    }

    @Override
    public void createBooking(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public void cancelBooking(Booking booking) {
        return;
    }


    public List<Room> getRooms() {
        return rooms;
    }

}

