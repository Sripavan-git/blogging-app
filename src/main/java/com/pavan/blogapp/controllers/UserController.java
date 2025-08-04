package com.pavan.blogapp.controllers;

import com.pavan.blogapp.payloads.UserDTO;
import com.pavan.blogapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = this.userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("userId") Long userId){
        return new ResponseEntity<UserDTO>(userService.getUserById(userId), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("userId") Long userId, @RequestBody UserDTO userDTO){
        return new ResponseEntity<UserDTO>(userService.updateUser(userDTO, userId), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }

}
