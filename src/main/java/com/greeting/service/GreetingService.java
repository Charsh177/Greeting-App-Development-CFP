package com.greeting.service;

import com.greeting.entity.User;
import com.greeting.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

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

    public User postData(User user) {
        greetingRepository.save(user);
        return user;
    }

    public Optional<User> getMsgById(int id) {
        return greetingRepository.findById(id);
    }

    public List<User> getAllMsg() {
        return greetingRepository.findAll();
    }
}
