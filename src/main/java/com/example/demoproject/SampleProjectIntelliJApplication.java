package com.example.demoproject;

import com.example.demoproject.Repository.UserRepository;
import com.example.demoproject.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

/**
 * Startup
 */
@SpringBootApplication
public class SampleProjectIntelliJApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleProjectIntelliJApplication.class, args);
    }

}
