package org.roles.services;


import org.roles.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.roles.entity.Roles;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Roles> getAllRoles() {
        return roleRepository.findAll();
    }

    public Roles getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Roles saveRole(Roles roles) {
        return roleRepository.save(roles);
    }

    public Long deleteRole(Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            return id;
        } else {
            return null;
        }
    }
}
