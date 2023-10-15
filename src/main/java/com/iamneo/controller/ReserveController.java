package com.iamneo.controller;


import com.iamneo.dto.ReserveDto;
import com.iamneo.dto.UpdateUserDto;
import com.iamneo.dto.UserDto;
import com.iamneo.service.ReserveService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @PostMapping("/add")
    public ResponseEntity<String> saveStudent(@RequestBody ReserveDto reserveDto) {
        boolean isRegistered = reserveService.reserveAdd(reserveDto);

        return isRegistered ? ResponseEntity.ok("Reserved successfully")
                : ResponseEntity.badRequest().body("Something went wrong!");
    }

}
