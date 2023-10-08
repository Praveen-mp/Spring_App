package com.iamneo.service;

import java.util.Optional;

import com.iamneo.jwt.JwtUtil;
import com.iamneo.repository.UserRepository;
import com.iamneo.request.UserRequest;
import com.iamneo.response.AuthResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.iamneo.dto.UserDto;
import com.iamneo.model.User;



@Service
@Transactional
@RequiredArgsConstructor
@AllArgsConstructor
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    private UserService userService;
     @Autowired
    private JwtUtil jwtUtil;
    User user = new User();

    @Override
    public User saveStudent(UserDto dto) {
        BeanUtils.copyProperties(dto, user);
        userRepository.save(user);
        return user;
    }

    @Override
    public boolean deleteStudent(Long user_id) {
        userRepository.deleteById(user_id);
        return false;
    }

    @Override
    public User getStudent(Long user_id) {
        Optional<User> findById = userRepository.findById(user_id);
        BeanUtils.copyProperties(findById, user);
        return user;
    }
   @Override
    public User findByUserEmail(String userEmail){
        Optional<User> findByEmail=userRepository.findByUserEmail(userEmail);
        BeanUtils.copyProperties(findByEmail,user);
        return user;
   }

    public boolean userRegistration(UserDto dto) {
        Optional<User> isUserExists = userRepository.findByUserEmail(dto.getUserEmail());
        if (isUserExists.isEmpty()) {
            System.out.println("Hello");
            var user = User.builder()
                    .userName(dto.getUserName())
                    .userEmail(dto.getUserEmail())
                    .userPassword(passwordEncoder.encode(dto.getUserPassword()))// Set isEnabled to tru
                    .build();

            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public AuthResponse authenticateLogin(UserRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserEmail(), request.getUserPassword()));
        var user = userRepository.findByUserEmail(request.getUserEmail()).orElseThrow();
        var token = jwtUtil.generateToken(user);
        System.out.println(token);
        return AuthResponse.builder()
                .token(token)
                .email(user.getUserEmail())
                .build();
    }
}