package com.example.racepulse.service.impl;

import com.example.racepulse.models.Role;
import com.example.racepulse.repository.RoleRepository;
import com.example.racepulse.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }

    @Override
    public Role findByName(String name) {
        return this.roleRepository.findByName(name);
    }

    @Override
    public List<Role> removeRole(Long roleId, List<Role> roles) {
        return roles.stream().filter(role -> !role.getId().equals(roleId)).toList();
    }
}
