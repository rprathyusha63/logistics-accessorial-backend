package org.services.service;

import org.services.domain.Services;
import org.services.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService {
    private final ServicesRepository servicesRepository;

    @Autowired
    public ServicesService(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

    public Services getServiceById(Long id) {
        return servicesRepository.findById(id).orElse(null);
    }

    public Services saveService(Services service) {
        return servicesRepository.save(service);
    }

    public Long deleteService(Long id) {
        if (servicesRepository.existsById(id)) {
            servicesRepository.deleteById(id);
            return id;
        } else {
            return null;
        }
    }
}
