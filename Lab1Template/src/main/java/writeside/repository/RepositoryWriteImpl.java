package writeside.repository;

import writeside.domain.Booking;
import writeside.domain.Room;
import writeside.domain.ValueObjects.BookingId;
import writeside.domain.ValueObjects.RoomBooking;
import org.springframework.stereotype.Component;
import writeside.application.interfaces.RepositoryWrite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class RepositoryWriteImpl implements RepositoryWrite {
    private List<Booking> bookings = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();

    public void createRoom(Room room) throws Exception {
        int oldRoomSize = rooms.size();
        rooms.add(room);

        if(rooms.size() == oldRoomSize){
            throw new Exception("Room can't be created exception");
        }
    }


    @Override
    public void createBooking(Booking booking) throws Exception {
        int oldBookingSize = bookings.size();
        bookings.add(booking);

        if(bookings.size() == oldBookingSize){
            throw new Exception("Booking can't be created exception");
        }
    }


    @Override
    public void cancelBooking(BookingId bookingId) throws Exception {
        Iterator bookingIterator = bookings.iterator();

        while (bookingIterator.hasNext()) {
            Booking booking = (Booking) bookingIterator.next();

            if (booking.getBookingId().getBookingId().compareTo(bookingId.getBookingId()) == 0) {
                bookingIterator.remove();
                return;
            }
        }
        throw new Exception("Booking not found exception");
    }


    @Override
    public Booking getBookingByBookingId(BookingId bookingId) throws Exception {
        for (Booking booking : bookings) {
            if (booking.getBookingId().getBookingId().compareTo(bookingId.getBookingId()) == 0) {
                return booking;
            }
        }
        throw new Exception("Booking not found exception");
    }


    @Override
    public Room getRoomByRoomNumber(int roomNumber) throws Exception {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        throw new Exception("No rooms found exception");
    }


    @Override
    public List<Room> roomsByCapacity(int capacity) throws Exception {
        List<Room> roomsResult = new ArrayList<>();
        for (Room room : rooms) {
            if (capacity == room.getCapacity()) {
                roomsResult.add(room);
            }
        }

        if (roomsResult.size() == 0) {
            throw new Exception("No rooms found exception");
        }

        return roomsResult;
    }


    @Override
    public void cancelRoomBooking(Room specificRoom) throws Exception {
        Iterator<RoomBooking> roomIterator = specificRoom.getRoomBookings().iterator();
        int i = 0;

        while (roomIterator.hasNext()) {
            RoomBooking rooms = (RoomBooking) roomIterator.next();

            if (rooms.getStartDate().equals(specificRoom.getRoomBookings().get(i).getStartDate()) && rooms.getEndDate().equals(specificRoom.getRoomBookings().get(i).getEndDate())) {
                roomIterator.remove();
                return;
            }
            i++;
        }
        throw new Exception("Booking not found exception");
    }
}


