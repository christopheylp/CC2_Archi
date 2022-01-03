package org.cc2.infrastructure;

import org.cc2.kernel.Event;
import org.cc2.kernel.EventDispatcher;

public class DefaultEventDispatcher implements EventDispatcher<Event> {
    @Override
    public void dispatch(Event event) {
        System.out.println("Dispatching Event " + event.getClass().getName());
    }
}
