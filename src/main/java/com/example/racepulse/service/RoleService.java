package com.example.racepulse.service;

import com.example.racepulse.models.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll();

    public Role findByName(String name);

    List<Role> removeRole(Long roleId, List<Role> roles);
}
