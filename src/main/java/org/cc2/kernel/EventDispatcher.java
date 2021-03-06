package org.cc2.kernel;

public interface EventDispatcher<E extends Event> {
    void dispatch(E event);
}
