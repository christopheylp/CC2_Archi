package org.cc2;

import org.cc2.application.provider.CreateProviderCommandHandler;
import org.cc2.application.workman.CreateWorkmanCommandHandler;
import org.cc2.domain.ProviderRepository;
import org.cc2.domain.WorkmanRepository;
import org.cc2.infrastructure.DefaultEventDispatcher;
import org.cc2.infrastructure.InMemoryProviderRepository;
import org.cc2.infrastructure.InMemoryWorkmanRepository;
import org.cc2.kernel.Event;
import org.cc2.kernel.EventDispatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkmanConfiguration {

    @Bean
    public WorkmanRepository workmanRepository() {
        return new InMemoryWorkmanRepository();
    }

    public EventDispatcher<Event> eventEventDispatcher() {
        return new DefaultEventDispatcher();
    }

    @Bean
    public CreateWorkmanCommandHandler createWorkmanCommandHandler() {
        return new CreateWorkmanCommandHandler(workmanRepository(), eventEventDispatcher());
    }
}
