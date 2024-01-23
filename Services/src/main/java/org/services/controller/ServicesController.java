package org.services.controller;

import org.services.domain.Services;
import org.services.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/services")
public class ServicesController {
    private final ServicesService servicesService;

    @Autowired
    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    // Get all Services
    @GetMapping
    public Flux<ResponseEntity<Services>> getAllServices() {
        return Flux.fromIterable(servicesService.getAllServices()) // Convert List to Flux
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Get Service by ID
    @GetMapping("/{serviceId}")
    public Mono<ResponseEntity<?>> getService(@PathVariable int serviceId) {
        Services service = servicesService.getServiceById((long) serviceId);
        if (service != null) {
            return Mono.just(ResponseEntity.status(HttpStatus.OK).body(service));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not found with ID " + serviceId));
        }
    }

    // Create a Service
    @PostMapping
    public Mono<ResponseEntity<Services>> createService(@RequestBody Services service) {
        service.setCreatedOn(new Timestamp(new Date().getTime()));
        service.setModifiedOn(new Timestamp(new Date().getTime()));
        Services savedService = servicesService.saveService(service);
        return Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(savedService));
    }

    // Update a Service
    @PutMapping("/{id}")
    public Mono<ResponseEntity<?>> updateService(@PathVariable Long id, @RequestBody Services updatedService) {
        Services existingService = servicesService.getServiceById(id);
        if (existingService != null) {
            existingService.setServiceDisplayName(updatedService.getServiceDisplayName());
            existingService.setServiceDescription(updatedService.getServiceDescription());
            existingService.setServiceType(updatedService.getServiceType());
            existingService.setModifiedOn(new Timestamp(new Date().getTime()));
            existingService.setModifiedBy(updatedService.getModifiedBy());


            Services updatedServiceEntity = servicesService.saveService(existingService);

            return Mono.just(ResponseEntity.ok(updatedServiceEntity));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not found with ID: " + id));
        }
    }

    // Delete a Service
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteService(@PathVariable Long id) {
        Long deletedId = servicesService.deleteService(id);

        if (deletedId != null) {
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
                    .body("Service with ID: " + deletedId + " has been deleted."));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Service not found with ID: " + id));
        }
    }
}
