package org.cc2.application.create_provider;

import org.cc2.domain.ProviderId;
import org.cc2.kernel.ApplicationEvent;

public final class CreateProviderEvent implements ApplicationEvent {
    private final ProviderId providerId;

    public CreateProviderEvent(ProviderId providerId) {
        this.providerId = providerId;
    }
}
