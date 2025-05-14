package com.example.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.entity.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

    @GetMapping(value = "/users/{id}", produces = "application/json")
    public UserDTO getUserById(@PathVariable Long id) {
        log.info("[UserService] user client controller");

        // This is a simple example. Replace with your actual data retrieval logic.
        UserDTO user = new UserDTO();
        user.setId(id);
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        log.info("User request is: " + user.getId());
        return user;
    }
}
