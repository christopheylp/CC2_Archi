package org.cc2.application.create_subscription;

import org.cc2.application.create_provider.CreateProvider;
import org.cc2.application.create_provider.CreateProviderEvent;
import org.cc2.domain.*;
import org.cc2.kernel.CommandHandler;
import org.cc2.kernel.Event;
import org.cc2.kernel.EventDispatcher;

public final class CreateSubscriptionCommandHandler implements CommandHandler<CreateSubscription, SubscriptionId> {
    private final SubscriptionRepository subscriptionRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateSubscriptionCommandHandler(SubscriptionRepository subscriptionRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.subscriptionRepository = subscriptionRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public SubscriptionId handle(CreateSubscription createSubscription) {
        final SubscriptionId subscriptionId = subscriptionRepository.nextIdentity();
        Subscription subscription = new Subscription(subscriptionId, createSubscription.userID, createSubscription.duration, createSubscription.monthlyPrice);
        subscriptionRepository.add(subscription);
        eventEventDispatcher.dispatch(new CreateSubscriptionEvent(subscriptionId));
        return subscriptionId;
    }
}
