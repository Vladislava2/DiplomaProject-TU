package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Показване на форма за регистрация (за Web интерфейс)
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());  // Това добавя празен обект User за формата
        return "register";  // Връща HTML страницата register.html
    }

    // Регистрация на нов потребител (обработване на данни от формата)
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        // Възможност за валидация тук
        userService.createUser(user);  // Записва потребителя в базата чрез UserService
        return "redirect:/login";  // След успешна регистрация пренасочваме към логин страницата
    }

    // Други API методи за потребителите (ако са необходими)
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        e.printStackTrace();  // Извеждане на стектрейс за грешката
        return "error";  // Връща страница за грешка
    }
}
