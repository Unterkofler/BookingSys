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

        if(roomList.size() == oldRoomSize){
            throw new Exception("Room can't be created exception");
        }
    }


    @Override
    public void createBooking(BookingDTO bookingDTO) throws Exception {
        int oldBookingSize = roomList.size();
        bookingList.add(bookingDTO);

        if(bookingList.size() == oldBookingSize){
            throw new Exception("Booking can't be created exception");
        }
    }



    public void removeBooking(BookingId bookingId) throws Exception {
        int oldBookingSize = roomList.size();
        bookingList.remove(bookingId);

        if(bookingList.size() == oldBookingSize){
            throw new Exception("Booking can't be canceled exception");
        }
    }


    @Override
    public void addDates(RoomBookingDTO roomBookingDTO) {
        LocalDate startDate = roomBookingDTO.getStartDate().minusDays(1);
        LocalDate endDate = roomBookingDTO.getEndDate();
        for (RoomDTO roomDTO : roomList) {

            if (roomDTO.getRoomNumber() == roomBookingDTO.getRoomNumber()) {
                while ((startDate = startDate.plusDays(1)).isBefore(endDate.plusDays(1))) {
                    roomDTO.getFreePeriods().add(startDate);
                }
            }
            //Eventuell noch liste sortieren
            //TODO: Exception
        }
    }


    @Override
    public void removeDates(RoomBookingDTO roomBookingDTO) {
        LocalDate startDate = roomBookingDTO.getStartDate().minusDays(1);
        LocalDate endDate = roomBookingDTO.getEndDate();
        for (RoomDTO roomDTO : roomList) {

            if (roomDTO.getRoomNumber() == roomBookingDTO.getRoomNumber()) {
                while ((startDate = startDate.plusDays(1)).isBefore(endDate.plusDays(1))) {
                    roomDTO.getFreePeriods().remove(startDate);
                }
            }
        }
        //TODO: Exception
    }

    //TODO: Methode noch anpassen und Exception hinzufügen
    @Override
    public List<BookingDTO> getBookingsInPeriod(LocalDate startDate, LocalDate endDate) {
        List<BookingDTO> allBookings = new ArrayList<>();

        for (BookingDTO bookingDTO : bookingList) {
            //if (bookingDTO.getStartDate().equals(startDate) && bookingDTO.getEndDate().equals(endDate)) {
            allBookings.add(bookingDTO);
            // }
        }

        return allBookings;
    }

    //TODO: Methode anpassen und Exception hinzufügen
    @Override
    public List<RoomDTO> getFreeRooms(LocalDate startDate, LocalDate endDate, int capacity) {
        List<RoomDTO> freeRooms = new ArrayList<>();

        for(RoomDTO room : roomList){
           freeRooms.add(room);
        }

        return freeRooms;
    }
}
