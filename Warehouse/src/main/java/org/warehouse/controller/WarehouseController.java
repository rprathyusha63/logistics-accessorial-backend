package org.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.warehouse.domain.Warehouse;
import org.warehouse.service.WarehouseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    // Get all Warehouses
    @GetMapping
    public Flux<ResponseEntity<Warehouse>> getAllWarehouses() {
        return Flux.fromIterable(warehouseService.getAllWarehouses()) // Convert List to Flux
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Get Warehouse by ID
    @GetMapping("/{warehouseId}")
    public Mono<ResponseEntity<?>> getWarehouse(@PathVariable int warehouseId) {
        Warehouse warehouse = warehouseService.getWarehouseById((long) warehouseId);
        if (warehouse != null) {
            return Mono.just(ResponseEntity.status(HttpStatus.OK).body(warehouse));
        } else {
            return Mono.just(
                    ResponseEntity.status(HttpStatus.NOT_FOUND).body("Warehouse not found with ID " + warehouseId));
        }
    }

    // Create a Warehouse
    @PostMapping
    public Mono<ResponseEntity<Warehouse>> createWarehouse(@RequestBody Warehouse warehouse) {
        warehouse.setCreatedOn(new Timestamp(new Date().getTime()));
        warehouse.setModifiedOn(new Timestamp(new Date().getTime()));
        Warehouse savedWarehouse = warehouseService.saveWarehouse(warehouse);
        return Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(savedWarehouse));
    }

    // Update a Warehouse
    @PutMapping("/{warehouseId}")
    public Mono<ResponseEntity<?>> updateWarehouse(@PathVariable int warehouseId,
            @RequestBody Warehouse updatedWarehouse) {
        Warehouse existingWarehouse = warehouseService.getWarehouseById((long) warehouseId);
        if (existingWarehouse != null) {
            existingWarehouse.setWarehouseName(updatedWarehouse.getWarehouseName());
            existingWarehouse.setAddress(updatedWarehouse.getAddress());
            existingWarehouse.setWarehouseManager(updatedWarehouse.getWarehouseManager());
            existingWarehouse.setWarehouseContactNumber(updatedWarehouse.getWarehouseContactNumber());
            existingWarehouse.setWarehouseEmail(updatedWarehouse.getWarehouseEmail());
            existingWarehouse.setWarehouseCapacity(updatedWarehouse.getWarehouseCapacity());
            existingWarehouse.setWarehouseType(updatedWarehouse.getWarehouseType());
            existingWarehouse.setWarehouseStatus(updatedWarehouse.getWarehouseStatus());
            existingWarehouse.setWarehouseOperatingHours(updatedWarehouse.getWarehouseOperatingHours());
            existingWarehouse.setModifiedOn(new Timestamp(new Date().getTime()));
            existingWarehouse.setModifiedBy(updatedWarehouse.getModifiedBy());
            existingWarehouse.setNotes(updatedWarehouse.getNotes());

            Warehouse updatedWarehouseEntity = warehouseService.saveWarehouse(existingWarehouse);

            return Mono.just(ResponseEntity.ok(updatedWarehouseEntity));
        } else {
            return Mono.just(
                    ResponseEntity.status(HttpStatus.NOT_FOUND).body("Warehouse not found with ID: " + warehouseId));
        }
    }

    // Delete a Warehouse
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteWarehouse(@PathVariable Long id) {
        Long deletedId = warehouseService.deleteWarehouse(id);

        if (deletedId != null) {
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
                    .body("Warehouse with ID: " + deletedId + " has been deleted."));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Warehouse not found with ID: " + id));
        }
    }
}
