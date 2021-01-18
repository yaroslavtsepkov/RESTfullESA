package com.ssau.restfulesa.repository;

import com.ssau.restfulesa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
