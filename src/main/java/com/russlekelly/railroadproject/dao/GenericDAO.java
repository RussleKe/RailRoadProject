package com.russlekelly.railroadproject.dao;

import java.util.Collection;

/**
 * Generic DAO interface. Used as a base interface for all DAO objects.
 *
 * @author Ruslan Kuleshov.
 */

public interface GenericDAO<T, ID> {

    T getByID(ID id);

    Collection<T> getAll();

    void save(T entity);

    void update(T entity);

    void remove(T entity);
}
