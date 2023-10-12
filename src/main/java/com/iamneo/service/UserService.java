package com.iamneo.service;

import com.iamneo.dto.UserDto;
import com.iamneo.model.User;
import com.iamneo.request.UserRequest;
import com.iamneo.response.AuthResponse;
import com.iamneo.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User saveUser(UserDto dto);

    public boolean deleteUser(Long user_id);

    public List<UserResponse> getUser();

   public User findByUserEmail(String userEmail);

   public User getUserById(Long userId);
//   public User findByUserId(Long user)

    public AuthResponse authenticateLogin(UserRequest request);

    boolean userRegistration(UserDto userDto);
}