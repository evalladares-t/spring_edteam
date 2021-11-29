package com.edteam.curso.controller;

import com.edteam.curso.models.Permiso;
import com.edteam.curso.services.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permiso")
public class PermisoController {

    @Autowired
    PermisoService permisoService;
    //Traer todos los permiso
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Permiso> getAll(){
        return permisoService.getAll();
    }

    //Buscar un permiso
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Permiso get(@PathVariable Long id){
        return permisoService.get(id);
    }

    //Registrar un permiso
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Permiso register(@RequestBody Permiso permiso){
        System.out.println(permiso.getRole());
        //TODO: registrarlo en la bd
        return permisoService.register(permiso);
    }

    //Actualizar un permiso
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    Permiso update(Permiso permiso){
        return permisoService.update(permiso);
    }

    //Eliminar un permiso
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable Long id){
        //TODO: Eliminarlo de la bd
        permisoService.delete(id);
    }
}
