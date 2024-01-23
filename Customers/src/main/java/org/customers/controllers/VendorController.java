package org.customers.controllers;

import org.customers.entity.Vendor;
import org.customers.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/vendors")
public class VendorController {
    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    // Get all Customers
    @GetMapping
    public Flux<ResponseEntity<Vendor>> getAllVendors() {
        return Flux.fromIterable(vendorService.getAllVendors()) // Convert List to Flux
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/findByWarehouseId/{warehouseId}")
    public Flux<ResponseEntity<Vendor>> getAllVendorsByWarehouseId(@PathVariable long warehouseId) {
        return Flux.fromIterable(vendorService.getAllVendorsByWarehouse(warehouseId)) // Convert List to Flux
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Get Customer by ID
    @GetMapping("/{vendorId}")
    public Mono<ResponseEntity<?>> getVendor(@PathVariable int vendorId) {
        Vendor vendor = vendorService.getVendorById((long) vendorId);
        if (vendor != null) {
            return Mono.just(ResponseEntity.status(HttpStatus.OK).body(vendor));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with ID " + vendorId));
        }
    }

    // Create a Customer
    @PostMapping
    public Mono<ResponseEntity<Vendor>> createVendor(@RequestBody Vendor vendor) {

        Vendor savedVendor = vendorService.saveCustomer(vendor);
        return Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(savedVendor));
    }

    // Update a Customer
    @PutMapping("/{id}")
    public Mono<ResponseEntity<?>> updateVendor(@PathVariable int id, @RequestBody Vendor updatedVendor) {
        Vendor existingVendor = vendorService.getVendorById((long) id);
        if (existingVendor != null) {
            existingVendor.setVendor_id(updatedVendor.getVendor_id());
            existingVendor.setFirstName(updatedVendor.getFirstName());
            existingVendor.setLastName(updatedVendor.getLastName());
            existingVendor.setBusinessName(updatedVendor.getBusinessName());
            existingVendor.setType(updatedVendor.getType());
            existingVendor.setEmail(updatedVendor.getEmail());
            existingVendor.setPhone(updatedVendor.getPhone());
            existingVendor.setAddress(updatedVendor.getAddress());

            existingVendor.setNotes(updatedVendor.getNotes());

            Vendor updatedVendorEntity = vendorService.saveCustomer(existingVendor);

            return Mono.just(ResponseEntity.ok(updatedVendorEntity));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendor not found with ID: " + id));
        }
    }

    // Delete a Customer
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteVendor(@PathVariable Long id) {
        Long deletedId = vendorService.deleteCustomer(id);

        if (deletedId != null) {
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
                    .body("Customer with ID: " + deletedId + " has been deleted."));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer not found with ID: " + id));
        }
    }
}
