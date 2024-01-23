package org.roles.controllers;

import org.roles.entity.Roles;
import org.roles.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Timestamp;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // Get all Roles
    @GetMapping
    public Flux<ResponseEntity<Roles>> getAllRoles() {
        return Flux.fromIterable(roleService.getAllRoles()) // Convert List to Flux
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Get Role by ID
    @GetMapping("/{roleId}")
    public Mono<ResponseEntity<?>> getRole(@PathVariable int roleId) {
        Roles roles = roleService.getRoleById((long) roleId);
        if (roles != null) {
            return Mono.just(ResponseEntity.status(HttpStatus.OK).body(roles));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found with ID " + roleId));
        }
    }

    // Create a Role
    @PostMapping
    public Mono<ResponseEntity<Roles>> createRole(@RequestBody Roles roles) {
//        roles.setCreatedOn(new Timestamp(new Date().getTime()));
//        roles.setModifiedOn(new Timestamp(new Date().getTime()));
        Roles savedRole = roleService.saveRole(roles);
        return Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(savedRole));
    }

    // Update a Role
    @PutMapping("/{id}")
    public Mono<ResponseEntity<?>> updateRole(@PathVariable int id, @RequestBody Roles updatedRole) {
        Roles existingRole = roleService.getRoleById((long) id);
        if (existingRole != null) {
            existingRole.setRoleId(updatedRole.getRoleId());
            existingRole.setRoleName(updatedRole.getRoleName());
            existingRole.setDescription(updatedRole.getDescription());

            Roles updatedRoleEntity = roleService.saveRole(existingRole);

            return Mono.just(ResponseEntity.ok(updatedRoleEntity));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found with ID: " + id));
        }
    }

    // Delete a Role
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteRole(@PathVariable Long id) {
        Long deletedId = roleService.deleteRole(id);

        if (deletedId != null) {
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
                    .body("Role with ID: " + deletedId + " has been deleted."));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Role not found with ID: " + id));
        }
    }
}
