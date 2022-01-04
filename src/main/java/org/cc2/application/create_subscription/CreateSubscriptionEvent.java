package org.cc2.application.create_subscription;

import org.cc2.domain.SubscriptionId;
import org.cc2.kernel.ApplicationEvent;

public final class CreateSubscriptionEvent implements ApplicationEvent {
    private final SubscriptionId subscriptionId;

    public CreateSubscriptionEvent(SubscriptionId subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}
