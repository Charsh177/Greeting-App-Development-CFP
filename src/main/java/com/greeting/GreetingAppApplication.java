package com.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingAppApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to Messaging App");
        SpringApplication.run(GreetingAppApplication.class, args);
    }

}