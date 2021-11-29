package com.edteam.curso.controller;

import com.edteam.curso.models.Role;
import com.edteam.curso.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {
    
    @Autowired
    RoleService roleService;
    //Traer todos los role
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Role> getAll(){
        return roleService.getAll();
    }

    //Buscar un role
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Role get(@PathVariable Long id){
        return roleService.get(id);
    }

    //Registrar un role
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Role register(@RequestBody Role role){
        //TODO: registrarlo en la bd
        return roleService.register(role);
    }

    //Actualizar un role
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    Role update(Role role){
        return roleService.update(role);
    }

    //Eliminar un role
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable Long id){
        //TODO: Eliminarlo de la bd
        roleService.delete(id);
    }
}
