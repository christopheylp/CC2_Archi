package org.cc2.application.create_workman;

import org.cc2.domain.WorkmanId;
import org.cc2.kernel.ApplicationEvent;

public final class CreateWorkmanEvent implements ApplicationEvent {
    private final WorkmanId workmanId;

    public CreateWorkmanEvent(WorkmanId workmanId) {
        this.workmanId = workmanId;
    }
}
