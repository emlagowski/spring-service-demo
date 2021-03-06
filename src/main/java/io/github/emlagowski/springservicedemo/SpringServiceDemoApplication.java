package io.github.emlagowski.springservicedemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class SpringServiceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringServiceDemoApplication.class, args);
    }

    @RestController
    static final class MyController {

        private final String greetings;

        MyController(@Value("${demo.greetings}") String greetings) {
            this.greetings = greetings;
        }

        @GetMapping("/")
        public String helloWorld() {
            return greetings + " World!\n";
        }

        @GetMapping("/test")
        public String test(@RequestParam(value = "value", defaultValue = "Hiiiii!") String value) {
            return value + " " + DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
        }

    }

}
