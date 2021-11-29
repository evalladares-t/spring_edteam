package com.edteam.curso.dao;

import com.edteam.curso.models.Role;

import java.util.List;

public interface RoleDao {


    List<Role> getAll();
    Role get(Long id);
    Role register(Role role);
    Role update(Role role);
    void delete(Long id);
    
}
