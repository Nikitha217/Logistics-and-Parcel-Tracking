package com.kce.logistics.model;

public class Hub {
    private String id;
    private String name;
    private String location;

    public Hub(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %s", id, name, location);
    }
}
