package com.edteam.curso.dao.imp;

import com.edteam.curso.dao.RoleDao;
import com.edteam.curso.models.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImp implements RoleDao{
    
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<Role> getAll(){
        String hql = "FROM Role as u ";
        return (List<Role>) entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    @Override
    public Role get(Long id){
        return entityManager.find(Role.class,id);
    }

    @Transactional
    @Override
    public Role register(Role role){
        return entityManager.merge(role);
    }

    @Transactional
    @Override
    public Role update(Role role){
        return entityManager.merge(role);

    }

    @Transactional
    @Override
    public void delete(Long id){
        Role role = get(id);
        entityManager.remove(role);
    }
}
