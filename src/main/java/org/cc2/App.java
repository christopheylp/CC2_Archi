package org.cc2;

import org.cc2.application.assign_workman_to_project.AssignWorkmanToProject;
import org.cc2.application.assign_workman_to_project.AssignWorkmanToProjectCommandHandler;
import org.cc2.application.create_project_by_provider.ProviderCreateProject;
import org.cc2.application.create_project_by_provider.ProviderCreateProjectCommandHandler;
import org.cc2.application.create_provider.CreateProvider;
import org.cc2.application.create_provider.CreateProviderCommandHandler;
import org.cc2.application.create_subscription.CreateSubscription;
import org.cc2.application.create_subscription.CreateSubscriptionCommandHandler;
import org.cc2.application.create_workman.CreateWorkman;
import org.cc2.application.create_workman.CreateWorkmanCommandHandler;
import org.cc2.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Date;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);

        CreateProviderCommandHandler providerCommandHandler = applicationContext.getBean(CreateProviderCommandHandler.class);
        CreateProvider createProvider = new CreateProvider("Christophe");
        final ProviderId providerId = providerCommandHandler.handle(createProvider);

        CreateSubscriptionCommandHandler subscriptionCommandHandler = applicationContext.getBean(CreateSubscriptionCommandHandler.class);
        CreateSubscription createSubscription = new CreateSubscription(providerId,10,10);
        final SubscriptionId subscriptionId = subscriptionCommandHandler.handle(createSubscription);

        ProviderCreateProjectCommandHandler providerCreateProjectCommandHandler = applicationContext.getBean(ProviderCreateProjectCommandHandler.class);
        ArrayList<WorkmanSkills> skills = new ArrayList<>();
        skills.add(WorkmanSkills.ELECTRICIAN);
        ProviderCreateProject providerCreateProject = new ProviderCreateProject(providerId,"project1",skills,new Date(),"Paris",new ArrayList<WorkmanId>());
        final ProjectId projectId = providerCreateProjectCommandHandler.handle(providerCreateProject);

        CreateWorkmanCommandHandler workmanCommandHandler = applicationContext.getBean(CreateWorkmanCommandHandler.class);
        CreateWorkman createWorkman = new CreateWorkman("Christophe",skills ,"Paris",60);
        final WorkmanId workmanId = workmanCommandHandler.handle(createWorkman);

        AssignWorkmanToProjectCommandHandler assignWorkmanToProjectCommandHandler = applicationContext.getBean(AssignWorkmanToProjectCommandHandler.class);
        AssignWorkmanToProject assignWorkmanToProject = new AssignWorkmanToProject(providerId,workmanId,projectId);
        final ProjectId assignedProjectId = assignWorkmanToProjectCommandHandler.handle(assignWorkmanToProject);


    }
}
