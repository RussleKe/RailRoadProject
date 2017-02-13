package com.russlekelly.railroadproject.model;


/**
 * Base class that extends {@link BaseEntity} adding property 'name'.
 * Used as a base class for all objects that need this property.
 *
 * @author Ruslan Kuleshov
 */

public class NamedEntity extends BaseEntity {
    private String name;

    public NamedEntity() {
    }

    public NamedEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NamedEntity{" +
                "Id: " + super.getId() +
                "Name: " + name;
    }
}
