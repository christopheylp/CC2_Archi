package org.cc2;

import org.cc2.application.provider.CreateProviderCommandHandler;
import org.cc2.domain.ProviderRepository;
import org.cc2.infrastructure.DefaultEventDispatcher;
import org.cc2.infrastructure.InMemoryProviderRepository;
import org.cc2.kernel.Event;
import org.cc2.kernel.EventDispatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderConfiguration {

    @Bean
    public ProviderRepository providerRepository() {
        return new InMemoryProviderRepository();
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        return new DefaultEventDispatcher();
    }

    @Bean
    public CreateProviderCommandHandler createProviderCommandHandler() {
        return new CreateProviderCommandHandler(providerRepository(), eventEventDispatcher());
    }
}
