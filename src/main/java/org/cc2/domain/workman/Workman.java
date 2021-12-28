package org.cc2.domain.workman;

import org.cc2.domain.provider.Provider;

import java.util.Objects;

public final class Workman {
    private final String id;
    private final String name;

    public Workman(String id, String name) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
    }

    public static Workman of(String id, String name){
        return new Workman(id, name);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
