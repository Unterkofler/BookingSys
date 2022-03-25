package at.fhv.lab1reference;

import eventside.domain.Booking;
import eventside.domain.Customer;
import eventside.domain.Event;
import eventside.domain.Room;
import writeside.StorageWriteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import writeside.EventPublisher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Configuration
@ComponentScan("writeside")
public class WriteSide {

    @Autowired
    private EventPublisher publisher;

    @Autowired
    private StorageWriteImpl storageWrite;

    public static void main(String[] args) {
        SpringApplication.run(WriteSide.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            Event event = new Event();
            event.setContent("This is the content!");
            event.setCustomer("Customer1");
            event.setTimestamp(System.currentTimeMillis());
            System.out.println("Result: " + publisher.publishEvent(event));

            //Befüllen der Store
            Customer customer1 = new Customer(1,"Achim", "Unterkofler");
            Room room1 = new Room(1,2);
            List<Room> roomList = new ArrayList<>();
            roomList.add(room1);
            
            Booking booking1 = new Booking(1,customer1, LocalDate.now(),LocalDate.now().plusDays(2),roomList);
            storageWrite.createBooking(booking1);

            String achim = "Achim";
            String jan = "Jan";
            String tobi = "Tobi";
            String fabian = "Fabian";
            storageWrite.add(achim);
            storageWrite.add(jan);
            storageWrite.add(tobi);
            storageWrite.add(fabian);
        };
    }
}
