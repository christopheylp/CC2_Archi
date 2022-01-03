package org.cc2;

import org.cc2.application.provider.CreateProvider;
import org.cc2.application.provider.CreateProviderCommandHandler;
import org.cc2.application.workman.CreateWorkman;
import org.cc2.application.workman.CreateWorkmanCommandHandler;
import org.cc2.domain.ProviderId;
import org.cc2.domain.WorkmanId;
import org.cc2.domain.WorkmanSkills;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;

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

        CreateWorkmanCommandHandler workmanCommandHandler = applicationContext.getBean(CreateWorkmanCommandHandler.class);
        ArrayList<WorkmanSkills> skills = new ArrayList<WorkmanSkills>();
        skills.add(WorkmanSkills.ELECTRICIAN);
        CreateWorkman createWorkman = new CreateWorkman("Christophe",skills ,"Paris",60);
        final WorkmanId workmanId = workmanCommandHandler.handle(createWorkman);

    }
}
