package org.cc2.application.workman;

import org.cc2.domain.ProviderId;
import org.cc2.domain.WorkmanId;
import org.cc2.kernel.ApplicationEvent;

public class CreateWorkmanEvent implements ApplicationEvent {
    private final WorkmanId workmanId;

    public CreateWorkmanEvent(WorkmanId workmanId) {
        this.workmanId = workmanId;
    }
}
