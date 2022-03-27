package writeside.application;


import GUI.RoomService;
import eventside.domain.Booking;
import eventside.domain.Customer;
import eventside.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class BookingServiceImpl implements BookingService {

    @Autowired
    StorageWrite storageWrite;

    @Autowired
    RoomService roomService;


    @Override
    public void createBooking(String firstName, String lastName, int bookingNumber, LocalDate startDate, LocalDate endDate, int capacity) throws Exception {

        // TODO: Gibt es hier Exception?
        Customer customer = new Customer(1, firstName, lastName);
        Room room = roomService.getAvailableRooms(startDate, endDate, capacity).get(0);

        Booking booking = new Booking(1, customer, startDate, endDate, room);


        storageWrite.createBooking(booking);

        // publisher zum Event

    }

    @Override
    public void cancelBooking() {

    }
}
