package com.example.demo.controller;

import com.example.demo.entity.ManicureService;
import com.example.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    // Добавяне на услуга
    @PostMapping
    public ManicureService createService(@RequestBody ManicureService service) {
        return serviceService.createService(service);
    }

    // Намиране на всички услуги
    @GetMapping
    public List<ManicureService> getAllServices() {
        return serviceService.getAllServices();
    }

    // Намиране на услуга по име
    @GetMapping("/{name}")
    public ManicureService getServiceByName(@PathVariable String name) {
        return serviceService.getServiceByName(name);
    }
}
