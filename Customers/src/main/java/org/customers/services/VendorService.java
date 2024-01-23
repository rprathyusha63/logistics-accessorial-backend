package org.customers.services;


import org.customers.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.customers.repository.CustomerRepository;
@Service
public class VendorService {
@Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    public VendorService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Vendor> getAllVendors() {
        return customerRepository.findAll();
    }

    public Vendor getVendorById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Vendor saveCustomer(Vendor vendor) {
        return customerRepository.save(vendor);
    }

    public Long deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return id;
        } else {
            return null;
        }
    }

    public List<Vendor> getAllVendorsByWarehouse(long warehouseId) {
        return customerRepository.findVendorsByWarehouseId(warehouseId);
    }
}