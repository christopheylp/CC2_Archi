package org.cc2.application.provider;

import org.cc2.domain.ProviderId;
import org.cc2.kernel.ApplicationEvent;

public class CreateProviderEvent implements ApplicationEvent {
    private final ProviderId providerId;

    public CreateProviderEvent(ProviderId providerId) {
        this.providerId = providerId;
    }
}
