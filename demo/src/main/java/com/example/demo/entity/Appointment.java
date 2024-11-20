package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ManicureService service;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(nullable = false)
    private boolean isCancelled = false;

    // Default constructor
    public Appointment() {}

    // Parameterized constructor
    public Appointment(User user, ManicureService service, LocalDateTime appointmentTime, boolean isCancelled) {
        this.user = user;
        this.service = service;
        this.appointmentTime = appointmentTime;
        this.isCancelled = isCancelled;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ManicureService getService() {
        return service;
    }

    public void setService(ManicureService service) {
        this.service = service;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", user=" + user +
                ", service=" + service +
                ", appointmentTime=" + appointmentTime +
                ", isCancelled=" + isCancelled +
                '}';
    }
}
