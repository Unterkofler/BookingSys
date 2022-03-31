package at.fhv.lab1reference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import readside.repository.RepositoryRead;

@SpringBootApplication
@Configuration
@ComponentScan("readside")
public class ReadSide {

    @Autowired
    RepositoryRead repositoryRead;

    public static void main(String[] args) {
        SpringApplication.run(ReadSide.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            repositoryRead.getAllBookings();

        };
    }

}
