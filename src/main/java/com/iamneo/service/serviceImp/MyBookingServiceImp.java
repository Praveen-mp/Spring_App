package com.iamneo.service.serviceImp;


import com.iamneo.model.User;
import com.iamneo.repository.UserRepository;
import com.iamneo.service.MyBookingService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
@Transactional
public class MyBookingServiceImp implements MyBookingService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean validateUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByUserEmail(email);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return bCryptPasswordEncoder.matches(password, user.getPassword());
        }
        System.out.println("failed"+email);
        return false;
    }
}
