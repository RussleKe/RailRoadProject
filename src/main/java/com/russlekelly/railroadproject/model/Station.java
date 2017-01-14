package com.russlekelly.railroadproject.model;

/**
 * Simple JavaBean domain object that represents a Station (for instance, Moscow, etc.)
 *
 * @author Ruslan Kuleshov
 */

public class Station extends NamedEntity {

    private String description;

    public Station() {
    }

    public Station(String name, String description) {
        super(name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.getId() + "," + super.getName() + "," + this.description;
    }
}
