package com.momate.reminder.javaee.dao;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T,ID> {
    
    void save(T entity);
    void delete(T entity);
    List<T> findAll();
    Optional<T> findById(ID id);
    boolean existsById(ID id);
   
    
}
