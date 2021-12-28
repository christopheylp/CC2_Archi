package org.cc2.domain.project;

import java.util.Objects;

public final class Project {
    private final String id;
    private final String name;

    public Project(String id, String name) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
    }

    public static Project of(String id,String name){
        return new Project(id, name);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
