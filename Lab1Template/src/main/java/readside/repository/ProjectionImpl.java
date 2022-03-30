package readside.repository;

import eventside.domain.Booking;
import eventside.domain.ValueObjects.BookingId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import readside.DTO.BookingDTO;
import writeside.event.BookingCanceled;
import writeside.event.BookingCreated;
import writeside.event.Event;

@Component
public class ProjectionImpl implements Projection{
    @Autowired
    RepositoryRead repositoryRead;

    @Override
    public void createBooking(Event event) {
        event = (BookingCreated) event;
        BookingDTO bookingDTO = new BookingDTO(((BookingCreated) event).getBookingId(),
                ((BookingCreated) event).getCustomer(),((BookingCreated) event).getStartDate(),
                ((BookingCreated) event).getEndDate(),((BookingCreated) event).getBookedRoom());
        repositoryRead.addBooking(bookingDTO);
    }

    @Override
    public void cancelBooking(Event event) throws Exception {
        event = (BookingCanceled) event;
        BookingId bookingId = ((BookingCanceled) event).getBookingId();
        repositoryRead.remove(bookingId);
    }
}
