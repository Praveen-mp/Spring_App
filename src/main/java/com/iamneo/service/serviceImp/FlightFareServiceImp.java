package com.iamneo.service.serviceImp;

import com.iamneo.dto.FlightFareDto;
import com.iamneo.dto.UserDto;
import com.iamneo.model.FlightFare;
import com.iamneo.model.User;
import com.iamneo.repository.FlightFareRepository;
import com.iamneo.service.FlightFareService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@AllArgsConstructor
public class FlightFareServiceImp implements FlightFareService {
    @Autowired
    private FlightFareRepository flightFareRepository;

    FlightFare flightFare;
    public boolean saveUserFare(FlightFareDto dto) {
        Optional<FlightFare> isUserExists = flightFareRepository.findByUserEmail(dto.getUserEmail());
        if (isUserExists.isEmpty()) {
            System.out.println("Hello");
            var user = FlightFare.builder()
                    .userId(dto.getUserId())
                    .userName(dto.getUserName())
                    .userEmail(dto.getUserEmail())
                    .userAge(dto.getUserAge())
                    .ticketType(dto.getTicketType())
                    .mealsOption(dto.getMealsOption())
                    .wheelChair(dto.getWheelChair())
                    .totalFare(dto.getTotalFare())
                    .build();

            flightFareRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public FlightFare getUserById(Long userId) {
        System.out.println(flightFareRepository.findById(userId));
        return flightFareRepository.findById(userId)
                .orElseThrow();
    }

    @Override
    public FlightFare findByUserEmail(String userEmail) {
        return flightFareRepository.findByUserEmail(userEmail).orElseThrow();
    }

}
