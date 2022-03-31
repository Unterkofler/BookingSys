package at.fhv.lab1reference;

import GUI.GUI;
import eventside.domain.Room;
import eventside.domain.ValueObjects.BookingId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import writeside.application.interfaces.HotelService;

import java.time.LocalDate;
import java.util.UUID;


@SpringBootApplication
@Configuration
@ComponentScan("writeside")
@ComponentScan("GUI")
public class WriteSide {


    @Autowired
    private HotelService hotelService;

    @Autowired
    private GUI gui;






    public static void main(String[] args) {
      GUI gui = new GUI();
      //  gui.start();
        SpringApplicationBuilder builder = new SpringApplicationBuilder(WriteSide.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
        //SpringApplication.run(WriteSide.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            BookingId bookingId1 = new BookingId(UUID.randomUUID());
            BookingId bookingId2 = new BookingId(UUID.randomUUID());


            hotelService.createRoom(new Room(1,2,null));
            hotelService.createRoom(new Room(2,2,null));
            hotelService.createRoom(new Room(3,2,null));
            hotelService.createRoom(new Room(4,2,null));
            hotelService.createRoom(new Room(5,2,null));

            hotelService.createBooking("Achim","Unterkofler", bookingId1,LocalDate.now(),LocalDate.now().plusDays(3), 2);
            hotelService.createBooking("Achim","Unterkofler",bookingId2,LocalDate.now(),LocalDate.now().plusDays(3), 2);
            hotelService.cancelBooking(bookingId1);

            System.out.println("It worked");

            gui.start();
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
