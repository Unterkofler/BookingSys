package at.fhv.lab1reference;

import GUI.GUI;
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Configuration
@ComponentScan("writeside")
@ComponentScan("GUI")
public class WriteSide {

    @Autowired
    private EventPublisher publisher;

    @Autowired
    private StorageWriteImpl storageWrite;

    @Autowired
    private GUI gui;

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.start();
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


            Booking booking1 = new Booking(1,customer1, LocalDate.now(),LocalDate.now().plusDays(2),storageWrite.getRooms());
            storageWrite.createBooking(booking1);

            boolean flag = true;
            while (flag){
                if (storageWrite.getCustomers().size() == 1){
                    System.out.println(gui.getFirstName());
                    flag = false;
                }
            }

        };
    }
}
