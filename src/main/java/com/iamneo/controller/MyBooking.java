package com.iamneo.controller;

import com.iamneo.dto.BookingDto;
import com.iamneo.dto.UserDto;
import com.iamneo.model.FlightFare;
import com.iamneo.model.Reservation;
import com.iamneo.model.User;
import com.iamneo.request.BookingRequest;
import com.iamneo.service.MyBookingService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/book")
public class MyBooking {
    @Autowired
    private MyBookingService myBookingService;

    @PostMapping("/validate")
    public ResponseEntity<String> login(@RequestBody BookingDto bookingDto) {
        String email = bookingDto.getUserEmail();
        String password = bookingDto.getUserPassword();
        if (myBookingService.validateUser(email, password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}
