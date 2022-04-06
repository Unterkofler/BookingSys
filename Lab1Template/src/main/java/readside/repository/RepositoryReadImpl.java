package readside.repository;

import writeside.domain.ValueObjects.BookingId;
import org.springframework.stereotype.Component;
import readside.DTO.BookingDTO;
import readside.DTO.RoomBookingDTO;
import readside.DTO.RoomDTO;

import java.time.LocalDate;
import java.util.*;

@Component
public class RepositoryReadImpl implements RepositoryRead {

    private List<BookingDTO> bookingList = new ArrayList<>();
    private List<RoomDTO> roomList = new ArrayList<>();


    @Override
    public void createRoom(RoomDTO roomDTO) throws Exception {
        int oldRoomSize = roomList.size();
        roomList.add(roomDTO);

        if (roomList.size() == oldRoomSize) {
            throw new Exception("Room can't be created exception");
        }
    }


    @Override
    public void createBooking(BookingDTO bookingDTO) throws Exception {
        int oldBookingSize = roomList.size();
        bookingList.add(bookingDTO);

        if (bookingList.size() == oldBookingSize) {
            throw new Exception("Booking can't be created exception");
        }
    }


    public void removeBooking(BookingId bookingId) throws Exception {
        int oldBookingSize = roomList.size();
        bookingList.remove(bookingId);

        if (bookingList.size() == oldBookingSize) {
            throw new Exception("Booking can't be canceled exception");
        }
    }


    @Override
    public void addDates(RoomBookingDTO roomBookingDTO) throws Exception {
        LocalDate startDate = roomBookingDTO.getStartDate().minusDays(1);
        LocalDate endDate = roomBookingDTO.getEndDate();

        try {
            for (RoomDTO roomDTO : roomList) {
                if (roomDTO.getRoomNumber() == roomBookingDTO.getRoomNumber()) {
                    while ((startDate = startDate.plusDays(1)).isBefore(endDate.plusDays(1))) {
                        roomDTO.getFreePeriods().add(startDate);
                    }
                }

            }
        } catch (Exception e) {
            throw new Exception("No rooms in roomList");
        }
    }


    @Override
    public void removeDates(RoomBookingDTO roomBookingDTO) throws Exception {
        LocalDate startDate = roomBookingDTO.getStartDate().minusDays(1);
        LocalDate endDate = roomBookingDTO.getEndDate();

        try {
            for (RoomDTO roomDTO : roomList) {
                if (roomDTO.getRoomNumber() == roomBookingDTO.getRoomNumber()) {
                    while ((startDate = startDate.plusDays(1)).isBefore(endDate.plusDays(1))) {
                        roomDTO.getFreePeriods().remove(startDate);
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception("No rooms in roomList");
        }
    }

    @Override
    public List<BookingDTO> getBookingsInPeriod(LocalDate startDate, LocalDate endDate) throws Exception {
        List<BookingDTO> allBookings = new ArrayList<>();

        for (BookingDTO bookingDTO : bookingList) {
            if((bookingDTO.getStartDate().equals(startDate) || (bookingDTO.getStartDate().isAfter(startDate.minusDays(1))))
                    && (bookingDTO.getEndDate().equals(endDate) || (bookingDTO.getEndDate().isBefore(endDate.plusDays(1))))) {

                allBookings.add(bookingDTO);
            }
        }

        if (allBookings.size() == 0) {
            throw new Exception("No Bookings in Period exception");
        }
        return allBookings;
    }

    @Override
    public List<RoomDTO> getFreeRooms(LocalDate startDate, LocalDate endDate, int capacity) throws Exception {
        List<RoomDTO> roomsByCapacity = roomsByCapacity(capacity);
        List<RoomDTO> freeRooms = new ArrayList<>();
        boolean isFree = true;
        LocalDate startDate2 = startDate;

        for (RoomDTO room : roomsByCapacity) {
            while (startDate.isBefore(endDate.plusDays(1)) && isFree == true) {
                if (!room.getFreePeriods().contains(startDate)) {
                    isFree = false;
                }

                startDate = startDate.plusDays(1);
            }
            if (isFree == true) {
                freeRooms.add(room);
            }
            isFree = true;
            startDate = startDate2;
        }

        if (freeRooms.size() == 0) {
            throw new Exception("No free Rooms exception");
        }
        return freeRooms;
    }

    public List<RoomDTO> roomsByCapacity(int capacity) throws Exception {
        List<RoomDTO> roomsResult = new ArrayList<>();
        for (RoomDTO room : roomList) {
            if (capacity == room.getCapacity()) {
                roomsResult.add(room);
            }
        }

        if (roomsResult.size() == 0) {
            throw new Exception("No rooms found exception");
        }

        return roomsResult;
    }
}




