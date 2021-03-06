package com.momate.reminder.javaee.dao;

import com.momate.reminder.javaee.model.User;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Singleton
@LocalBean
public class UserDao implements CrudRepository<User, Long> {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void save(User entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        } else {
            em.persist(entity);
        }
        
        em.flush();
        
    }
    
    @Override
    public void delete(User entity) {
        if (existsById(entity.getId())) {
            em.remove(entity);
        }
    }
    
    @Override
    public List<User> findAll() {
        return (List) em.createQuery("SELECT u FROM User u")
                .getResultList();
    }
    
    @Override
    public Optional<User> findById(Long id) {
        try {
            User user = (User) em.createQuery("SELECT u FROM User u WHERE u.id=:id")
                    .setParameter("id", id)
                    .getSingleResult();
            
            return Optional.of(user);
            
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
    
    public Optional<User> findByUsername(String username) {
        try {
            User user = (User) em.createQuery("SELECT u FROM User u WHERE u.username=:username")
                    .setParameter("username", username)
                    .getSingleResult();
            
            return Optional.of(user);
            
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
    
    public Optional<User> findByEmail(String email){
        try {
            User user = (User) em.createQuery("SELECT u FROM User u WHERE u.email=:email")
                    .setParameter("email", email)
                    .getSingleResult();
            
            return Optional.of(user);
            
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
    
    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
        
    }
    
}
