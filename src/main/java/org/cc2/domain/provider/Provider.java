package org.cc2.domain.provider;

import org.cc2.domain.project.Project;

import java.util.Objects;

public final class Provider {
    private final String id;
    private final String name;

    public Provider(String id, String name) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
    }

    public static Provider of(String id, String name){
        return new Provider(id, name);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
