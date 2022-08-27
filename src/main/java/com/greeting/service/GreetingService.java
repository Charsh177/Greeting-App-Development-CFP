package com.greeting.service;

import com.greeting.entity.User;
import com.greeting.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Autowired(required = false)
    GreetingRepository greetingRepository;

    public String getMessage() {
        return "Hello";
    }

    public String sayHelloByName(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

    public User sayHello(User user) {
        greetingRepository.save(user);
        return user;
    }

    public User postData(User user) {
        greetingRepository.save(user);
        return user;
    }
}
