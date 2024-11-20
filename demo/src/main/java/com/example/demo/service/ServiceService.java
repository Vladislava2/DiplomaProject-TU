package com.example.demo.service;

import com.example.demo.entity.ManicureService;
import com.example.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Важно да добавиш това

import java.util.List;

@Service // Анотацията трябва да бъде @Service, а не @ManicureService
public class ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    // Добавяне на услуга
    public ManicureService createService(ManicureService service) {
        return serviceRepository.save(service);
    }

    // Намиране на всички услуги
    public List<ManicureService> getAllServices() {
        return serviceRepository.findAll();
    }

    // Намиране на услуга по име
    public ManicureService getServiceByName(String name) {
        return serviceRepository.findByName(name);
    }
}
