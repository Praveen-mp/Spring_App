package com.iamneo.service;

import com.iamneo.dto.UserDto;
import com.iamneo.model.User;

public interface StudentService {

	public User saveStudent(UserDto dto);
	
	public boolean deleteStudent(Long user_id);

	public User getStudent(Long user_id);

//   public User findByEmail(String userEmail);
}
