package writeside.repository;

import eventside.domain.Booking;
import eventside.domain.Room;
import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.RoomBooking;
import org.springframework.stereotype.Component;
import writeside.application.interfaces.RepositoryWrite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Component
public class RepositoryWriteImpl implements RepositoryWrite {
    private List<Booking> bookings = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();

    @Override
    public void createBooking(Booking booking) {
        //TODO: Exception
        bookings.add(booking);

    }

    @Override
    public void cancelBooking(BookingId bookingId) throws Exception {
        Iterator bookingIterator = bookings.iterator();

        while (bookingIterator.hasNext()) {
            Booking booking = (Booking) bookingIterator.next();

            if (booking.getBookingId() == bookingId) {
                bookingIterator.remove();
                return;
            }
        }
        throw new Exception("Booking not found exception");
    }

    @Override
    public Booking getBookingByBookingId(BookingId bookingId) throws Exception {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                return booking;
            }
        }
        throw new Exception("Booking not found exception");
    }

    public void createRoom(Room room) {
        //TODO: Excpetion!
        rooms.add(room);
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

    //TODO: Überarbeiten
    @Override
    public void cancelRoomBooking(Room specificRoom) throws Exception {
        Iterator<RoomBooking> roomIterator = specificRoom.getRoomBookings().iterator();
        int i = 0;

        while (roomIterator.hasNext()) {
            RoomBooking rooms = (RoomBooking) roomIterator.next();

            if (rooms.getStartDate().equals(specificRoom.getRoomBookings().get(0).getStartDate()) && rooms.getEndDate().equals(specificRoom.getRoomBookings().get(0).getEndDate())) {
                roomIterator.remove();
                return;
            }
            i++;
        }

        throw new Exception("Booking not found exception");
    }
}


