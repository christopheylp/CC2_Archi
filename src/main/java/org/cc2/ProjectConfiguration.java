package org.cc2;

import org.cc2.application.ProviderCreateProjectCommandHandler;
import org.cc2.application.provider.CreateProviderCommandHandler;
import org.cc2.domain.ProjectRepository;
import org.cc2.domain.ProviderRepository;
import org.cc2.infrastructure.DefaultEventDispatcher;
import org.cc2.infrastructure.InMemoryProjectRepository;
import org.cc2.infrastructure.InMemoryProviderRepository;
import org.cc2.kernel.Event;
import org.cc2.kernel.EventDispatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {
    @Bean
    public ProjectRepository projectRepository() {
        return new InMemoryProjectRepository();
    }

    @Bean
    public ProviderCreateProjectCommandHandler providerCreateProjectCommandHandler() {
        return new ProviderCreateProjectCommandHandler(projectRepository(), eventEventDispatcher());
    }

    public EventDispatcher<Event> eventEventDispatcher() {
        return new DefaultEventDispatcher();
    }

}
