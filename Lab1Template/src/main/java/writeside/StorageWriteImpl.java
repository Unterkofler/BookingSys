package writeside;

import eventside.domain.Booking;
import eventside.domain.Customer;
import eventside.domain.Room;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class StorageWriteImpl implements StorageImpl{
    private List<Customer> customers  = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();

    public StorageWriteImpl(){
        for (int i = 0; i < 50; i++) {
            Random random = new Random( 99991 * i + 13);
            rooms.add(i, new Room(i, random.nextInt(5) + 1, random.nextBoolean()));
        }
    }

    public boolean add(Customer customer){
        boolean isadded = this.customers.add(customer);
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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
