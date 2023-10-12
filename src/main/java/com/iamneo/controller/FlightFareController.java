package com.iamneo.controller;


import com.iamneo.dto.FlightFareDto;
import com.iamneo.dto.UserDto;
import com.iamneo.model.FlightFare;
import com.iamneo.model.User;
import com.iamneo.service.FlightFareService;
import com.iamneo.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/fare")
public class FlightFareController {

    @Autowired
    FlightFareService flightFareService;

    @PostMapping("/add")
    public ResponseEntity<String> saveStudent(@RequestBody FlightFareDto dto) {
        boolean isSaved = flightFareService.saveUserFare(dto);

        return isSaved ? ResponseEntity.ok("fare calculated successfully")
                : ResponseEntity.badRequest().body("Something went wrong!");
    }
    @GetMapping("/profile/{userEmail}")
    public Optional<FlightFare> getUserByID(@PathVariable String userEmail){
        System.out.println(userEmail);
        return Optional.ofNullable(flightFareService.findByUserEmail(userEmail));
    }
}
