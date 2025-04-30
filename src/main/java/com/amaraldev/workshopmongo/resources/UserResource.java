package com.amaraldev.workshopmongo.resources;

import com.amaraldev.workshopmongo.domain.User;
import com.amaraldev.workshopmongo.dto.UserDTO;
import com.amaraldev.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    private ResponseEntity<List<UserDTO>> finAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(x->new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
