package com.aero.TafDatastoreService.Controller;

import com.aero.TafDatastoreService.Models.Users;

import com.aero.TafDatastoreService.Services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    //CRUD Methods for users MS
    private final UserServiceImpl userServiceImpl;

    @GetMapping("/user/{id}")
    public Users getUserDetails(@PathVariable("id")Long id){
        return userServiceImpl.getUserDetails(id);
    }

    @PostMapping("/user")
    public Users addUser(@RequestBody Users users){
        return userServiceImpl.addUser(users);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable("id")Long id,@RequestBody Users users){

        return new ResponseEntity<>(userServiceImpl.updateUser(id,users), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id")Long id){

        userServiceImpl.deleteUser(id);
    }

    @ExceptionHandler
    public ResponseEntity<?> respondWithError(Exception e){
        return new ResponseEntity<>("Exception Occurred. More Info :"
                + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
