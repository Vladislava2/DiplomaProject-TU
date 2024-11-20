package com.example.demo.repository;

import com.example.demo.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByAppointmentTimeBetween(LocalDateTime start, LocalDateTime end);
    List<Appointment> findByUserId(Long userId); // Пример за търсене на часове по потребител
}
