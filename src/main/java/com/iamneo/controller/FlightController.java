package com.iamneo.controller;


import com.iamneo.dto.FlightDto;
import com.iamneo.model.FlightList;
import com.iamneo.model.User;
import com.iamneo.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class FlightController {
    @Autowired
    private FlightService flightService;
    @GetMapping("/allFlight")
    public List<FlightDto> getAllFlights() {
        return flightService.getAllFlights();
    }
    @GetMapping("/findFlight/{fid}")
    public Optional<FlightList> getById(@PathVariable Long fid){
        System.out.println(fid);
        return Optional.ofNullable(flightService.getById(fid));
    }

    @DeleteMapping("/deleteFlight/{fid}")
    public boolean deleteByUserId(@PathVariable Long fid){
        System.out.println(fid);
        return flightService.deleteFlight(fid);
    }

}
