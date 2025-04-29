package com.amaraldev.workshopmongo.resources;

import com.amaraldev.workshopmongo.domain.User;
import com.amaraldev.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    private ResponseEntity<List<User>> finAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
