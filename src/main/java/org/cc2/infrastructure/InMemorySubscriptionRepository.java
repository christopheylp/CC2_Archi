package org.cc2.infrastructure;

import org.cc2.domain.*;
import org.cc2.kernel.exception.NoSuchEntityException;
import org.cc2.kernel.ValueObjectId;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemorySubscriptionRepository implements SubscriptionRepository {
    private final Map<SubscriptionId, Subscription> data = new ConcurrentHashMap<>();
    private final AtomicInteger count = new AtomicInteger(0);

    @Override
    public Map<SubscriptionId, Subscription> findAll() {
        return data;
    }

    @Override
    public ArrayList<Subscription> findByUserId(ValueObjectId userId) {
        ArrayList<Subscription> subscriptions = new ArrayList<>();
        for (Subscription subscription : data.values()) {
            if(subscription.getUserId().equals(userId)){
                subscriptions.add(subscription);
            }
        }
        return subscriptions;
    }

    @Override
    public SubscriptionId nextIdentity() {
        return new SubscriptionId(count.incrementAndGet());
    }

    @Override
    public Subscription findById(SubscriptionId id) throws NoSuchEntityException {
        final Subscription subscription = data.get(id);
        if (subscription == null) {
            assert false;
            throw new RuntimeException("No provider for " + subscription);
        }
        return subscription;
    }

    @Override
    public void add(Subscription entity) {
        data.put(entity.getId(), entity);
    }

    @Override
    public void delete(SubscriptionId id) {
        data.remove(id);
    }
}
