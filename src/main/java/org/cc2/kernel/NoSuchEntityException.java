package org.cc2.kernel;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(ValueObjectId id) {
        return new NoSuchEntityException("No entity found with ID " + id.getValue());
    }
}
