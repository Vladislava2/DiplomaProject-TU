package com.example.demo.service;

import com.example.demo.entity.Appointment;
import com.example.demo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Създаване на нов час
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Намиране на всички часове
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Намиране на часове в конкретен период
    public List<Appointment> getAppointmentsByTimeRange(LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByAppointmentTimeBetween(start, end);
    }

    // Отмяна на час
    public void cancelAppointment(Long id) {
        appointmentRepository.findById(id)
                .ifPresent(appointment -> {
                    appointment.setCancelled(true);
                    appointmentRepository.save(appointment);
                });
    }
}
