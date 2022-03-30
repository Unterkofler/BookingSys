package at.fhv.lab1reference;

import eventside.domain.ValueObjects.BookingId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import writeside.EventPublisher;
import writeside.application.interfaces.BookingService;
import writeside.application.interfaces.RepositoryWrite;

import java.time.LocalDate;
import java.util.UUID;


@SpringBootApplication
@Configuration
@ComponentScan("writeside")
public class WriteSide {

    @Autowired
    private EventPublisher publisher;

    @Autowired
    private BookingService bookingService;

    @Autowired
    RepositoryWrite storageWrite;




    public static void main(String[] args) {
     //   GUI gui = new GUI();
     //   gui.start();
        SpringApplication.run(WriteSide.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            /*Event event = new Event();
            event.setContent("This is the content!");
            event.setCustomer("Customer1");
            event.setTimestamp(System.currentTimeMillis());
            System.out.println("Result: " + publisher.publishEvent(event));
            //System.out.println("Result: " + publisher.publishEvent(event)); */

            BookingId bookingId1 = new BookingId(UUID.randomUUID());
            BookingId bookingId2 = new BookingId(UUID.randomUUID());

            storageWrite.createRooms();
            bookingService.createBooking("Achim","Unterkofler", bookingId1,LocalDate.now(),LocalDate.now().plusDays(3), 2);
            bookingService.createBooking("Achim","Unterkofler",bookingId2,LocalDate.now(),LocalDate.now().plusDays(3), 2);
            bookingService.cancelBooking(bookingId1);

            System.out.println("It worked");

            //für GUI
            /*
            boolean flag = true;
            while (flag){
                if (storageWrite.getCustomers().size() == 1){
                    System.out.println(gui.getFirstName());
                    flag = false;
                }
            }

             */

        };
    }
}
