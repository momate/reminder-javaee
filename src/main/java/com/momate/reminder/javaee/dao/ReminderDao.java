package com.momate.reminder.javaee.dao;

import com.momate.reminder.javaee.model.Reminder;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Singleton
@LocalBean
public class ReminderDao implements CrudRepository<Reminder, Long> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Reminder entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        } else {
            em.persist(entity);
        }

        em.flush();
    }

    public void update(Reminder entity) {
        em.merge(entity);
    }

    @Override
    public void delete(Reminder entity) {
        entity = em.merge(entity);
        em.remove(entity);
    }

    @Override
    public List<Reminder> findAll() {
        return (List) em.createQuery("SELECT r FROM Reminder r")
                .getResultList();

    }

    @Override
    public Optional<Reminder> findById(Long id) {
        try {
            Reminder reminder = (Reminder) em.createQuery("SELECT r FROM Reminder r WHERE r.id=:id")
                    .setParameter("id", id)
                    .getSingleResult();

            return Optional.of(reminder);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public List<Reminder> findByUserId(Long id) {

        return (List) em.createQuery("SELECT r FROM Reminder r WHERE r.user.id = :id")
                .setParameter("id", id)
                .getResultList();

    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

}
