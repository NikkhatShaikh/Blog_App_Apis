package com.example.blogg_api.controller;

import com.example.blogg_api.entity.User;
import com.example.blogg_api.payload.ApiResponse;
import com.example.blogg_api.payload.UserDto;
import com.example.blogg_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/api/users")
public class UserController {

    @Autowired
    private UserService userService;



    // POST= Create User

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){

        // createUser is method , requested from UserDto Class from userService InterFace (Service package)
        // ResponseEntity is predefined Collection Method by Controller
        // Created = is predefined method in ResponseEntity  HttpStatus

        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }


    //PUT= Update User
     @PutMapping("/{userId}")
    public ResponseEntity<UserDto>updateUser(@RequestBody UserDto userDto, @PathVariable ("userId") Integer uid){
      UserDto updatedUser=  this.userService.updateUser(userDto , uid);
        return ResponseEntity.ok(updatedUser);
    }


    //DELETE = Delete User
    @DeleteMapping("/{userId}")
    public  ResponseEntity<ApiResponse>deleteUser(@PathVariable("userId") Integer uid){
        this.deleteUser(uid);
        return new  ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);

    }


    //GET = Get all User
    @GetMapping("/")
  public  ResponseEntity<List<UserDto>>getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
  }

    //GET = Get single User
    @GetMapping("/{userId}")
    public  ResponseEntity<UserDto>getSingleUser(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

}
