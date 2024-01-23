package org.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.users.domain.User;
import org.users.services.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.sql.Timestamp;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all Users
    @GetMapping
    public Flux<ResponseEntity<User>> getAllUsers() {
        return Flux.fromIterable(userService.getAllUsers()) // Convert List to Flux
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Get User by ID
    @GetMapping("/{userId}")
    public Mono<ResponseEntity<?>> getUser(@PathVariable int userId) {
        User user = userService.getUserById((long) userId);
        if (user != null) {
            return Mono.just(ResponseEntity.status(HttpStatus.OK).body(user));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID " + userId));
        }
    }

    // Create a User
    @PostMapping
    public Mono<ResponseEntity<User>> createUser(@RequestBody User user) {
//        user.setCreatedOn(new Timestamp(new Date().getTime()));
//        user.setModifiedOn(new Timestamp(new Date().getTime()));
        User savedUser = userService.saveUser(user);
        return Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(savedUser));
    }

    // Update a User
    @PutMapping("/{id}")
    public Mono<ResponseEntity<?>> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        User existingUser = userService.getUserById((long) id);
        if (existingUser != null) {
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setRoleId(updatedUser.getRoleId());
//            existingUser.setWarehouseId(updatedUser.getWarehouseId());
//            existingUser.setWarehouseName(updatedUser.getWarehouseName());
            existingUser.setEmail(updatedUser.getEmail());
//            existingUser.setContact(updatedUser.getContact());
//            existingUser.setAddress(updatedUser.getAddress());
            existingUser.setPassword(updatedUser.getPassword());

            User updatedUserEntity = userService.saveUser(existingUser);

            return Mono.just(ResponseEntity.ok(updatedUserEntity));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + id));
        }
    }

    // Delete a User
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteUser(@PathVariable Long id) {
        Long deletedId = userService.deleteUser(id);

        if (deletedId != null) {
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
                    .body("User with ID: " + deletedId + " has been deleted."));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found with ID: " + id));
        }
    }
}