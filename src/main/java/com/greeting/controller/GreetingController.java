package com.greeting.controller;

import com.greeting.entity.User;
import com.greeting.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    @Autowired
    GreetingService greetingService;

    @GetMapping("/getmap")
    public String getMessage() {
        return "Hello World";
    }
    @GetMapping("getbyparam")
    public String getByParam(@RequestParam String name) {
        return "Hello " + name;
    }

    @GetMapping("/getpath/{name}")
    public String getPath(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/getbyservice")
    public String getByService() {
        return greetingService.getMessage();
    }

    @GetMapping("/hello")
    public String sayPosting(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        if (!(firstName == null || lastName == null)) {
            return greetingService.sayHelloByName(firstName, lastName);
        }

        if (firstName == null && lastName == null) {
            return "Hello World!";
        }
        else if (firstName == null) {
            firstName = "";
            return greetingService.sayHelloByName(firstName, lastName);
        }
        else {
            lastName = "";
            return greetingService.sayHelloByName(firstName, lastName);
        }
    }
    @PostMapping("/getdata")
    public User getData(@RequestBody User user) {
        User user1 = greetingService.postData(user);
        return user1;
    }
}