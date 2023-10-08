package com.iamneo.controller;

import com.iamneo.dto.LoginDto;
import com.iamneo.dto.UserDto;
import com.iamneo.dto.UserResponse;
import com.iamneo.request.UserRequest;
import com.iamneo.response.AppResponse;
import com.iamneo.response.AuthResponse;
import com.iamneo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/add")
    public ResponseEntity<String> saveStudent(@RequestBody UserDto dto) {
        boolean isRegistered = userService.userRegistration(dto);

        return isRegistered ? ResponseEntity.ok("User registered successfully")
                : ResponseEntity.badRequest().body("Something went wrong!");
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<UserResponse> deleteStudent(Long user_id) {
        return new ResponseEntity<UserResponse>(
                new UserResponse(false, "Student Successfully Deleted", userService.deleteStudent(user_id)),
                HttpStatus.OK);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<UserResponse> getStudent(Long user_id) {
        return new ResponseEntity<UserResponse>(
                new UserResponse(false, "Student Fetched Successfully", userService.getStudent(user_id)),
                HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody UserRequest request) {
        System.out.println(userService.authenticateLogin(request));
        return ResponseEntity.ok(userService.authenticateLogin(request));
    }
}
