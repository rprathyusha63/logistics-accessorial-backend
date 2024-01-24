package org.servicerate.service;

import org.servicerate.domain.ServiceRate;
import org.servicerate.repository.ServiceRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRateService {

    private final ServiceRateRepository serviceRateRepository;

    @Autowired
    public ServiceRateService(ServiceRateRepository serviceRateRepository) {
        this.serviceRateRepository = serviceRateRepository;
    }

    public List<ServiceRate> getAllServiceRates() {
        return serviceRateRepository.findAll();
    }

    public ServiceRate getServiceRateById(Long id) {
        return serviceRateRepository.findById(id).orElse(null);
    }

    public ServiceRate saveServiceRate(ServiceRate serviceRate) {
        return serviceRateRepository.save(serviceRate);
    }

    public Long deleteServiceRate(Long id) {
        if (serviceRateRepository.existsById(id)) {
            serviceRateRepository.deleteById(id);
            return id;
        } else {
            return null;
        }
    }
}
