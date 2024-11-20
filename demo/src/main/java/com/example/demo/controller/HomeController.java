package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Това показва, че класът е контролер
@RequestMapping("/")  // Това указва, че всички заявки към коренния път ще се обработват тук
public class HomeController {

    @GetMapping  // Този метод ще се изпълни за заявки към коренния път (/)
    public String home() {
        return "Приложението работи!";
    }
}
