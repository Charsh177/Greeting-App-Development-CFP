package com.greeting.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public static String getMessage() {
        return "Hello";
    }

    public static String sayHelloByName(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

}
