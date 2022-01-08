package org.cc2.kernel.exception;

import org.cc2.kernel.ValueObjectId;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(ValueObjectId id) {
        return new NoSuchEntityException("No entity found with ID " + id.getValue());
    }
}
