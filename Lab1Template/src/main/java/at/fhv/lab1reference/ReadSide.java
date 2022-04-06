package at.fhv.lab1reference;

import ReadGUI.ReadGUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import readside.repository.RepositoryRead;

@SpringBootApplication
@Configuration
@ComponentScan({"readside","ReadGUI"})
public class ReadSide {

    @Autowired
    RepositoryRead repositoryRead;

    @Autowired
    ReadGUI readGUI;


    public static void main(String[] args) {
        ReadGUI readGUI = new ReadGUI();
        SpringApplicationBuilder builder = new SpringApplicationBuilder(ReadSide.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            readGUI.start();
        };
    }

}
