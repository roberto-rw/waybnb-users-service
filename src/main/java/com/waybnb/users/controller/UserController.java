package com.waybnb.users.controller;

import com.waybnb.users.dto.UserDTO;
import com.waybnb.users.service.IKeycloakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IKeycloakService keycloakService;

    @GetMapping("/test")
    public String test() {
        return "Users!";
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserDTO userDTO) {
        keycloakService.createUser(userDTO);

    }
}
