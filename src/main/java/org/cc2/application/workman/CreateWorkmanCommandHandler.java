package org.cc2.application.workman;

import org.cc2.application.provider.CreateProvider;
import org.cc2.application.provider.CreateProviderEvent;
import org.cc2.domain.*;
import org.cc2.kernel.CommandHandler;
import org.cc2.kernel.Event;
import org.cc2.kernel.EventDispatcher;

public class CreateWorkmanCommandHandler implements CommandHandler<CreateWorkman, WorkmanId> {
    private final WorkmanRepository workmanRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateWorkmanCommandHandler(WorkmanRepository workmanRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.workmanRepository = workmanRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public WorkmanId handle(CreateWorkman createWorkman) {
        final WorkmanId workmanId = workmanRepository.nextIdentity();
        Workman workman = new Workman(workmanId, createWorkman.name, createWorkman.skills, createWorkman.location, createWorkman.dailyPrice);
        workmanRepository.add(workman);
        eventEventDispatcher.dispatch(new CreateWorkmanEvent(workmanId));
        return workmanId;
    }
}
