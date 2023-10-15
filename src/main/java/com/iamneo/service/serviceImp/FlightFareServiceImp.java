package com.iamneo.service.serviceImp;

import com.iamneo.dto.FlightFareDto;
import com.iamneo.dto.UpdateUserDto;
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

    @Override
    public boolean updateUser(String email, UpdateUserDto updateUserDto) {
        Optional<FlightFare> optionalUser = flightFareRepository.findByUserEmail(email);

        if (optionalUser.isPresent()) {
            FlightFare userToUpdate = optionalUser.get();

            // Check if the UpdateUserDto contains new values for the fields.
            String newName = updateUserDto.getUserName();
            String newAge = updateUserDto.getAge();

            // Update the user's information if new values are provided.
            if (newName != null) {
                userToUpdate.setUserName(newName);
            }
//            if (newAge != null && !newAge.isEmpty()) {
                userToUpdate.setUserAge(newAge);
//            }

            // You can add more fields to update as needed.

            // Save the updated user information in the repository.
            flightFareRepository.save(userToUpdate);

            // Return true to indicate a successful update.
            return true;
        }

        // Return false to indicate that the user was not found or the update failed.
        return false;
    }

}
