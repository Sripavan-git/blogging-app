package com.pavan.blogapp.services.Impl;

import com.pavan.blogapp.exceptions.ResourceNotFoundException;
import com.pavan.blogapp.modals.User;
import com.pavan.blogapp.payloads.UserDTO;
import com.pavan.blogapp.repositories.UserRepository;
import com.pavan.blogapp.services.UserService;
import com.pavan.blogapp.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User savedUser = userRepository.save(dtoToUser(userDTO));
        return userToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id ", userId));
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAbout(userDTO.getAbout());

        User updatedUser = this.userRepository.save(user);
        return this.userToDTO(updatedUser);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id ", userId));
        return this.userToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return this.userRepository.findAll().stream().map(user -> userToDTO(user)).toList();
    }

    @Override
    public void deleteUser(Long userId) {
        User user =  this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id ", userId));
        this.userRepository.delete(user);
    }

    private User dtoToUser(UserDTO userDTO) {
        //User uesr = new User();
        //user.setId(userDTO.getId());
        //user.setName(userDTO.getName());
        //user.setAbout(userDTO.getAbout());
        //user.setEmail(userDTO.getEmail());
        //user.setPassword(userDTO.getPassword());

        return this.modelMapper.map(userDTO, User.class);
    }

    private UserDTO userToDTO(User user ) {
        /*UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAbout(user.getAbout());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());*/

        return this.modelMapper.map(user, UserDTO.class);
    }
}
