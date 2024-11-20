package com.example.demo.service;

import com.example.demo.entity.Discount;
import com.example.demo.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;

    @Autowired
    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    // Добавяне на отстъпка
    public Discount createDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    // Намиране на отстъпка за потребител
    public Discount getDiscountByUserId(Long userId) {
        return discountRepository.findByUserId(userId);
    }

    // Актуализация на отстъпка
    public void updateDiscount(Long id, Discount updatedDiscount) {
        discountRepository.findById(id)
                .ifPresent(discount -> {
                    discount.setUsedAppointments(updatedDiscount.getUsedAppointments());
                    discount.setDiscountPercentage(updatedDiscount.getDiscountPercentage());
                    discountRepository.save(discount);
                });
    }
}
