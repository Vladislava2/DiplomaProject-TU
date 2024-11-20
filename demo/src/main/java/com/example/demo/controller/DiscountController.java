package com.example.demo.controller;

import com.example.demo.entity.Discount;
import com.example.demo.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    // Добавяне на отстъпка
    @PostMapping
    public Discount createDiscount(@RequestBody Discount discount) {
        return discountService.createDiscount(discount);
    }

    // Намиране на отстъпка за потребител
    @GetMapping("/{userId}")
    public Discount getDiscountByUserId(@PathVariable Long userId) {
        return discountService.getDiscountByUserId(userId);
    }
}
