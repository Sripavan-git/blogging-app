package com.pavan.blogapp.controllers;

import com.pavan.blogapp.payloads.ApiResponse;
import com.pavan.blogapp.payloads.UserDTO;
import com.pavan.blogapp.services.UserService;
import jakarta.validation.Valid;
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

    // Crate User
    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUser = this.userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Get All Users in Repo
    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    // Get User by Id
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("userId") Long userId){
        return new ResponseEntity<UserDTO>(userService.getUserById(userId), HttpStatus.OK);
    }

    // Update User by Id
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable("userId") Long userId){
        return new ResponseEntity<UserDTO>(userService.updateUser(userDTO, userId), HttpStatus.OK);
    }

    // Delete User By Id
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", false), HttpStatus.OK);
    }

}
