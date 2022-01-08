package org.cc2;


import org.cc2.application.assign_workman_to_project.AssignWorkmanToProjectCommandHandler;
import org.cc2.application.create_project_by_provider.ProviderCreateProjectCommandHandler;
import org.cc2.application.create_provider.CreateProviderCommandHandler;
import org.cc2.application.create_subscription.CreateSubscriptionCommandHandler;
import org.cc2.application.create_workman.CreateWorkmanCommandHandler;
import org.cc2.domain.ProjectRepository;
import org.cc2.domain.ProviderRepository;
import org.cc2.domain.SubscriptionRepository;
import org.cc2.domain.WorkmanRepository;
import org.cc2.infrastructure.*;
import org.cc2.kernel.Event;
import org.cc2.kernel.EventDispatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        return new DefaultEventDispatcher();
    }

    @Bean
    public ProviderRepository providerRepository() {
        return new InMemoryProviderRepository();
    }

    @Bean
    public ProjectRepository projectRepository() {
        return new InMemoryProjectRepository();
    }

    @Bean
    public WorkmanRepository workmanRepository() {
        return new InMemoryWorkmanRepository();
    }

    @Bean
    public SubscriptionRepository subscriptionRepository() {
        return new InMemorySubscriptionRepository();
    }

    @Bean
    public ProviderCreateProjectCommandHandler providerCreateProjectCommandHandler() {
        return new ProviderCreateProjectCommandHandler(projectRepository(), eventEventDispatcher());
    }

    @Bean
    public CreateWorkmanCommandHandler createWorkmanCommandHandler() {
        return new CreateWorkmanCommandHandler(workmanRepository(), eventEventDispatcher());
    }

    @Bean
    public CreateProviderCommandHandler createProviderCommandHandler() {
        return new CreateProviderCommandHandler(providerRepository(), eventEventDispatcher());
    }

    @Bean
    public AssignWorkmanToProjectCommandHandler assignWorkmanToProjectCommandHandler(){
        return new AssignWorkmanToProjectCommandHandler(providerRepository(),workmanRepository(),projectRepository(), subscriptionRepository(), eventEventDispatcher());
    }

    @Bean
    public CreateSubscriptionCommandHandler createSubscriptionCommandHandler(){
        return new CreateSubscriptionCommandHandler(subscriptionRepository(),eventEventDispatcher());
    }
}
