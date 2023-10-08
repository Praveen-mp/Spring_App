package com.iamneo.service;

import com.iamneo.dto.LoginDto;
import com.iamneo.dto.UserDto;
import com.iamneo.model.User;
import com.iamneo.request.UserRequest;
import com.iamneo.response.AppResponse;
import com.iamneo.response.AuthResponse;

public interface UserService {

    public User saveStudent(UserDto dto);

    public boolean deleteStudent(Long user_id);

    public User getStudent(Long user_id);

   public User findByUserEmail(String userEmail);

    public AuthResponse authenticateLogin(UserRequest request);

    boolean userRegistration(UserDto userDto);
}