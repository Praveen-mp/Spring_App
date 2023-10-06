package com.iamneo.controller;

import com.iamneo.dto.UserDto;
import com.iamneo.dto.UserResponse;
import com.iamneo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/add")
    public ResponseEntity<UserResponse> saveStudent(@RequestBody UserDto dto) {
        return new ResponseEntity<UserResponse>(
                new UserResponse(false, "Student Successfully Added", studentService.saveStudent(dto)),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<UserResponse> deleteStudent(Long user_id) {
        return new ResponseEntity<UserResponse>(
                new UserResponse(false, "Student Successfully Deleted", studentService.deleteStudent(user_id)),
                HttpStatus.OK);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<UserResponse> getStudent(Long user_id) {
        return new ResponseEntity<UserResponse>(
                new UserResponse(false, "Student Fetched Successfully", studentService.getStudent(user_id)),
                HttpStatus.OK);
    }



}
