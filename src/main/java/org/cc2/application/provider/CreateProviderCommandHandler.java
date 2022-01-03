package org.cc2.application.provider;

import org.cc2.domain.Provider;
import org.cc2.domain.ProviderId;
import org.cc2.domain.ProviderRepository;
import org.cc2.kernel.CommandHandler;
import org.cc2.kernel.Event;
import org.cc2.kernel.EventDispatcher;

public class CreateProviderCommandHandler implements CommandHandler<CreateProvider, ProviderId> {
    private final ProviderRepository providerRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateProviderCommandHandler(ProviderRepository providerRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.providerRepository = providerRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public ProviderId handle(CreateProvider createProvider) {
        final ProviderId providerId = providerRepository.nextIdentity();
        Provider provider = new Provider(providerId, createProvider.name);
        providerRepository.add(provider);
        eventEventDispatcher.dispatch(new CreateProviderEvent(providerId));
        return providerId;
    }
}
