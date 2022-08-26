package com.greeting.controller;

import com.greeting.entity.Greeting;
import com.greeting.service.GreetingService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*
    Use Case 1 Greeting Controller for Return JSON Messages using
    HTTP methods via @RequestParam and @PathVariable
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @GetMapping("/param/{name}")
    public Greeting greeting1(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    /*
    Use Case 2 Extend GreetingController to use Service Layer to get
    Simple Greeting message "Hello World"
     */
    @GetMapping("/getMap")
    public String getMessage() {
        return "Hello World";
    }

    @GetMapping("/getPath/{name}")
    public String getPath(@PathVariable String name) {
        return "Hello " + name;
    }

    /*
    Use Case 3 Customized Greeting message with service layers
     */
    @GetMapping("/getByService")
    public String getByService() {
        return GreetingService.getMessage();
    }

    @GetMapping("/hello")
    public String sayPosting(@RequestParam (required = false) String firstName, @RequestParam (required = false) String lastName) {
        if (!(firstName == null || lastName == null)) {
            return GreetingService.sayHelloByName(firstName, lastName);
        }

        if (firstName == null && lastName == null) {
            return "Hello World!";
        } else if (firstName == null) {
            firstName = "";
            return GreetingService.sayHelloByName(firstName, lastName);
        } else {
            lastName = "";
            return GreetingService.sayHelloByName(firstName, lastName);
        }
    }
}