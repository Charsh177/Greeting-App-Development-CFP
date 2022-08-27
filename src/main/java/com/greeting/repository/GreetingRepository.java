package com.greeting.repository;

import com.greeting.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<User, Integer> {

}
