package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom queries can be added here
    User findByEmail(String email); // Пример за търсене на потребител по email
}
