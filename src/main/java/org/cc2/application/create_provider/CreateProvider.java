package org.cc2.application.create_provider;

import org.cc2.kernel.Command;

import java.util.Objects;

public final class CreateProvider implements Command {
    public final String name;

    public CreateProvider(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public static CreateProvider of(String name){
        return new CreateProvider(name);
    }
}
