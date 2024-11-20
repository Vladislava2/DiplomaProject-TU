package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private int usedAppointments;

    @Column(nullable = false)
    private double discountPercentage;

    // Default constructor
    public Discount() {}

    // Parameterized constructor
    public Discount(User user, int usedAppointments, double discountPercentage) {
        this.user = user;
        this.usedAppointments = usedAppointments;
        this.discountPercentage = discountPercentage;
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

    public int getUsedAppointments() {
        return usedAppointments;
    }

    public void setUsedAppointments(int usedAppointments) {
        this.usedAppointments = usedAppointments;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", user=" + user +
                ", usedAppointments=" + usedAppointments +
                ", discountPercentage=" + discountPercentage +
                '}';
    }
}
