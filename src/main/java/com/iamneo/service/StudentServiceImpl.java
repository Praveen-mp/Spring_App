package com.iamneo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamneo.dto.UserDto;
import com.iamneo.model.User;
import com.iamneo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	User user = new User();

	@Override
	public User saveStudent(UserDto dto) {
		BeanUtils.copyProperties(dto, user);
		studentRepository.save(user);
		return user;
	}

	@Override
	public boolean deleteStudent(Long user_id) {
		studentRepository.deleteById(user_id);
		return false;
	}

	@Override
	public User getStudent(Long user_id) {
		Optional<User> findById = studentRepository.findById(user_id);
		BeanUtils.copyProperties(findById, user);
		return user;
	}




}
