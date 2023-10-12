package com.iamneo.service.serviceImp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.iamneo.jwt.JwtUtil;
import com.iamneo.repository.UserRepository;
import com.iamneo.request.UserRequest;
import com.iamneo.response.AuthResponse;
import com.iamneo.response.UserResponse;
import com.iamneo.role.Role;
import com.iamneo.service.UserService;
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
    public User saveUser(UserDto dto) {
        BeanUtils.copyProperties(dto, user);
        userRepository.save(user);
        return user;
    }

    @Override
    public boolean deleteUser(Long user_id) {
        userRepository.deleteById(user_id);
        return false;
    }



    @Override
    public List<UserResponse> getUser() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .filter(user -> !user.getRole().equals(Role.ADMIN))
                .map(this::mapUserToUserResponse)
                .collect(Collectors.toList());
    }
   @Override
    public User findByUserEmail(String userEmail){
        Optional<User> findByEmail=userRepository.findByUserEmail(userEmail);
        BeanUtils.copyProperties(findByEmail,user);
        return user;
   }
    public User getUserById(Long userId) {
        System.out.println(userRepository.findById(userId));
        return userRepository.findById(userId)
                .orElseThrow();
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
    private com.iamneo.response.UserResponse mapUserToUserResponse(User user) {
        return com.iamneo.response.UserResponse.builder()
                .userId(user.getUserId())
                .userEmail(user.getUserEmail())
                .userPassword(user.getUserPassword())
                .userName(user.getUsername())
                .role(user.getRole())
                .build();
    }
}