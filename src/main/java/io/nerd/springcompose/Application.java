package io.nerd.springcompose;

import io.nerd.springcompose.event.Event;
import io.nerd.springcompose.event.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EventRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                var event = new Event(
                        1,
                        "SpringOne+",
                        "it is spring meetup",
                        LocalDate.of(2023, 9, 21),
                        LocalDate.of(2023, 9, 24),
                        LocalDate.now().minusDays(180),
                        LocalDate.now().minusDays(90),
                        "spain,krdpa",
                        "https://github.com/hassanrefaat9"
                );
                repository.save(event);
                log.info("Event created: {}",event.getName());
            }
        };
    }
}
