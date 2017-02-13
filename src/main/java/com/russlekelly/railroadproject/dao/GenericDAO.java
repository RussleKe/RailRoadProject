package com.russlekelly.railroadproject.dao;


/**
 * Generic DAO interface. Used as a base interface for all DAO objects.
 *
 * @author Ruslan Kuleshov.
 */

public interface GenericDAO<T> {

    T getEntityById(Long id);

    void saveEntity(T entity);

    void updateEntity(T entity);

    void removeEntity(T entity);

}