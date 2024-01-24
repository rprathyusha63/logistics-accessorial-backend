package org.servicerate.controller;

import org.servicerate.domain.ServiceRate;
import org.servicerate.service.ServiceRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/service-rates")
public class ServiceRateController {

    private final ServiceRateService serviceRateService;

    @Autowired
    public ServiceRateController(ServiceRateService serviceRateService) {
        this.serviceRateService = serviceRateService;
    }

    // Get all Service Rates
    @GetMapping
    public Flux<ResponseEntity<ServiceRate>> getAllServiceRates() {
        return Flux.fromIterable(serviceRateService.getAllServiceRates())
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Get Service Rate by ID
    @GetMapping("/{serviceRateId}")
    public Mono<ResponseEntity<?>> getServiceRate(@PathVariable Long serviceRateId) {
        ServiceRate serviceRate = serviceRateService.getServiceRateById(serviceRateId);
        if (serviceRate != null) {
            return Mono.just(ResponseEntity.status(HttpStatus.OK).body(serviceRate));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service Rate not found with ID " + serviceRateId));
        }
    }

    // Create a Service Rate
    @PostMapping
    public Mono<ResponseEntity<ServiceRate>> createServiceRate(@RequestBody ServiceRate serviceRate) {
        ServiceRate savedServiceRate = serviceRateService.saveServiceRate(serviceRate);
        return Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(savedServiceRate));
    }

    // Update a Service Rate
    @PutMapping("/{id}")
    public Mono<ResponseEntity<?>> updateServiceRate(@PathVariable Long id, @RequestBody ServiceRate updatedServiceRate) {
        ServiceRate existingServiceRate = serviceRateService.getServiceRateById(id);
        if (existingServiceRate != null) {
            existingServiceRate.setCustomerId(updatedServiceRate.getCustomerId());
            existingServiceRate.setWarehouseId(updatedServiceRate.getWarehouseId());
            existingServiceRate.setServiceId(updatedServiceRate.getServiceId());
            existingServiceRate.setCurrency(updatedServiceRate.getCurrency());
            existingServiceRate.setRate(updatedServiceRate.getRate());
            existingServiceRate.setEffectiveDate(updatedServiceRate.getEffectiveDate());
            existingServiceRate.setExpirationDate(updatedServiceRate.getExpirationDate());
            existingServiceRate.setStatus(updatedServiceRate.getStatus());

            ServiceRate updatedServiceRateEntity = serviceRateService.saveServiceRate(existingServiceRate);

            return Mono.just(ResponseEntity.ok(updatedServiceRateEntity));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service Rate not found with ID: " + id));
        }
    }

    // Delete a Service Rate
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteServiceRate(@PathVariable Long id) {
        Long deletedId = serviceRateService.deleteServiceRate(id);

        if (deletedId != null) {
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
                    .body("Service Rate with ID: " + deletedId + " has been deleted."));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Service Rate not found with ID: " + id));
        }
    }
}
