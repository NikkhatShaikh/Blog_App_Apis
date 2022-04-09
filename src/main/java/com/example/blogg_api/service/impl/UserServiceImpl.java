package com.example.blogg_api.service.impl;

import com.example.blogg_api.entity.User;
import com.example.blogg_api.exception.ResourceNotFoundException;
import com.example.blogg_api.payload.UserDto;
import com.example.blogg_api.repository.UserRepository;
import com.example.blogg_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private User user;


    @Override
    public UserDto createUser(UserDto userDto) {
        User user =this.dtoToUser(userDto);
        User savedUser=  this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user =this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));

        user.setName(userDto.getName());   // fecth data from userDto
        user.setEmailId(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = this.userRepository.save(user);  // store into userRepository
        UserDto userDto1= this.userToDto(updatedUser);     // return updated user (updated by userId)

        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users =this.userRepository.findAll();   // list all users    findAll()
        List<UserDto> userDtos = users.stream().map(user1 -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
        this.userRepository.delete(user);  // delete by user Id

    }

    private User dtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmailId(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());

        return user;

    }

    private UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmailId());
        userDto.setAbout(user.getAbout());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
