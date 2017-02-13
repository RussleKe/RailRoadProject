package com.russlekelly.railroadproject.model.factiories;

/**
 * Created by RuslanKuleshov on 12.02.17.
 */
public interface EntityFactory<T> {
    T createEntity();

    T createEntity(String parameter);
}
