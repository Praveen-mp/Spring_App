package com.iamneo.controller;

import com.iamneo.dto.UserDto;
import com.iamneo.jwt.JwtUtil;
import com.iamneo.model.User;
import com.iamneo.request.UserRequest;
import com.iamneo.response.AuthResponse;
import com.iamneo.response.UserResponse;
import com.iamneo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

//   @Autowired

    @PostMapping("/add")
    public ResponseEntity<String> saveStudent(@RequestBody UserDto dto) {
        boolean isRegistered = userService.userRegistration(dto);

        return isRegistered ? ResponseEntity.ok("User registered successfully")
                : ResponseEntity.badRequest().body("Something went wrong!");
    }


    @DeleteMapping("/delete/{userId}")
    public boolean deleteByUserId(@PathVariable Long userId){
        System.out.println(userId);
        return userService.deleteUser(userId);
    }

    @GetMapping("/find/{userId}")
    public Optional<User> getUserByID(@PathVariable Long userId){
        System.out.println(userId);
        return Optional.ofNullable(userService.getUserById(userId));
    }
    @GetMapping("/findAll")
    public List<UserResponse> getUserAll(){
        return userService.getUser();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody UserRequest request) {
        System.out.println(userService.authenticateLogin(request));

        return ResponseEntity.ok(userService.authenticateLogin(request));
    }
}
