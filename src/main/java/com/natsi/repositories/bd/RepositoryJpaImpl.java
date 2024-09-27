package com.natsi.repositories.bd;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.natsi.repositories.core.RepositoryBD;
import javax.persistence.EntityManager;

public class RepositoryJpaImpl<T> implements RepositoryBD<T> {
    protected EntityManager em;
    protected Class<T> entityClass; 
    EntityManagerFactory emf =Persistence.createEntityManagerFactory("MYSQL");

    public RepositoryJpaImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
        if (em == null) {
            em = emf.createEntityManager(); 
        }
    }

    public RepositoryJpaImpl() {
        if (em == null) {
            em = emf.createEntityManager();
        }
    }

    @Override
    public void insert(T data) {
        em.getTransaction().begin();  
        em.persist(data);
        em.getTransaction().commit();
    }

    @Override
    public List<T> selectAll() {
        return this.em.createQuery("SELECT u FROM " + entityClass.getSimpleName() + " u", entityClass)
                      .getResultList();
    }















    @Override
    public boolean update(T object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    @Override
    public T selectById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    
}
