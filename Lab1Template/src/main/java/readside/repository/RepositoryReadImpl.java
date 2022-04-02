package readside.repository;

import eventside.domain.Room;
import eventside.domain.ValueObjects.BookingId;
import eventside.domain.ValueObjects.RoomBooking;
import org.springframework.stereotype.Component;
import readside.DTO.BookingDTO;
import readside.DTO.RoomBookingDTO;
import readside.DTO.RoomDTO;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class RepositoryReadImpl implements RepositoryRead {

    private List<BookingDTO> bookingDTOS = new ArrayList<>();
    private List<RoomDTO> roomList = new ArrayList<>();


    @Override
    public void addRoom(RoomDTO roomDTO) {
        roomList.add(roomDTO);
    }


    @Override
    public void addDates(RoomBookingDTO roomBookingDTO) {
        System.out.println(roomList.get(0).getFreePeriods().size());
        LocalDate startDate = roomBookingDTO.getStartDate().minusDays(1);
        LocalDate endDate = roomBookingDTO.getEndDate();
        for (RoomDTO roomDTO : roomList) {

            if (roomDTO.getRoomNumber() == roomBookingDTO.getRoomNumber()) {
                while ((startDate = startDate.plusDays(1)).isBefore(endDate.plusDays(1))) {
                    roomDTO.getFreePeriods().add(startDate);
                }
            }
            //Eventuell noch liste sortieren
            //roomList.sort(Comparator.comparing(RoomDTO::getFreePeriods));
            System.out.println(roomList.get(0).getFreePeriods().size());
        }
    }

    //Exeption if(bookingDTO == null)
    public void addBooking(BookingDTO bookingDTO) {
        bookingDTOS.add(bookingDTO);
    }

    public void remove(BookingId bookingId) throws Exception {
        try {
            bookingDTOS.remove(bookingId);
        } catch (Exception e) {
            throw new Exception("BookingId not found");
        }

    }

    public List<BookingDTO> getBookingsInPeriod(LocalDate startDate, LocalDate endDate) {
        List<BookingDTO> allBookings = new ArrayList<>();

        for (BookingDTO bookingDTO : bookingDTOS) {
            //if (bookingDTO.getStartDate().equals(startDate) && bookingDTO.getEndDate().equals(endDate)) {
                allBookings.add(bookingDTO);
           // }
        }

        return allBookings;
    }

    @Override
    public void removeDates(RoomBookingDTO roomBookingDTO) {
        //System.out.println(roomList.get(0).getFreePeriods().size());
        LocalDate startDate = roomBookingDTO.getStartDate().minusDays(1);
        LocalDate endDate = roomBookingDTO.getEndDate();
        for (RoomDTO roomDTO : roomList) {

            if (roomDTO.getRoomNumber() == roomBookingDTO.getRoomNumber()) {
                while ((startDate = startDate.plusDays(1)).isBefore(endDate.plusDays(1))) {
                    roomDTO.getFreePeriods().remove(startDate);
                }
            }
        }
        //System.out.println(roomList.get(0).getFreePeriods().size());
    }
}
