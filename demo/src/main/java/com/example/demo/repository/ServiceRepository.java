package com.example.demo.repository;

import com.example.demo.entity.ManicureService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ManicureService, Long> {
    ManicureService findByName(String name); // Пример за търсене на услуга по име
}
