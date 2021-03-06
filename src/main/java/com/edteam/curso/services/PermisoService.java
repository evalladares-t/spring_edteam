package com.edteam.curso.services;

import com.edteam.curso.dao.PermisoDao;
import com.edteam.curso.models.Permiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisoService {

    @Autowired
    PermisoDao permisoDao;

    public List<Permiso> getAll(){
        return permisoDao.getAll();
    }

    public Permiso get(Long id){
        return permisoDao.get(id);
    }

    public Permiso register(Permiso permiso){
        return permisoDao.register(permiso);
    }

    public Permiso update(Permiso permiso){
        return permisoDao.update(permiso);

    }

    public void delete(Long id){
        permisoDao.delete(id);
    }
}
