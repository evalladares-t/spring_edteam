package com.edteam.curso.dao.imp;

import com.edteam.curso.dao.PermisoDao;
import com.edteam.curso.models.Permiso;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class PermisoDaoImp implements PermisoDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<Permiso> getAll(){
        String hql = "FROM Permiso";
        return (List<Permiso>) entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    @Override
    public Permiso get(Long id){
        return entityManager.find(Permiso.class,id);
    }

    @Transactional
    @Override
    public Permiso register(Permiso permiso){
        return entityManager.merge(permiso);
    }

    @Transactional
    @Override
    public Permiso update(Permiso permiso){
        return entityManager.merge(permiso);

    }

    @Transactional
    @Override
    public void delete(Long id){
        Permiso permiso = get(id);
        entityManager.remove(permiso);
    }
}
