package com.natsi.repositories.bd;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import com.natsi.entities.Role;
import com.natsi.entities.User;
import com.natsi.repositories.list.UserRepository;

public class UserRepositoryBD extends RepositoryJpaImpl<User> implements UserRepository<User>{

    private static ClientRepositoryBD clientRepositoryBD;
    private final String SQL_SELECT_BY_LOGIN = "SELECT u FROM User u WHERE u.login = :login";
    private final String SQL_SELECT_BY_ROLE = "SELECT u FROM User u WHERE u.role = :role";
   
    public UserRepositoryBD(ClientRepositoryBD clientRepositoryBD) {
        super(User.class);
        entityClass=User.class;
        this.clientRepositoryBD = clientRepositoryBD;  
    }
    @Override
    public User selectByLogin(String login) {
        TypedQuery<User> query = em.createQuery(SQL_SELECT_BY_LOGIN, entityClass);
        query.setParameter("login", login);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public List<User> selectByRole(Role role) {
        TypedQuery<User> query = em.createQuery(SQL_SELECT_BY_ROLE, entityClass);
        query.setParameter("role", role);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    
   
}
