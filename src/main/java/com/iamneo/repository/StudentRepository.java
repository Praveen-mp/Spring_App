package com.iamneo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iamneo.model.User;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<User, Long> {
//      User findByEmail(String userEmail);
//    Optional<User> findOneByEmailAndPassword(String email, String password)
}
