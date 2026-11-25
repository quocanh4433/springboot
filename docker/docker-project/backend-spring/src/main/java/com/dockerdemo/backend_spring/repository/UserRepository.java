package com.dockerdemo.backend_spring.repository;

import com.dockerdemo.backend_spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}