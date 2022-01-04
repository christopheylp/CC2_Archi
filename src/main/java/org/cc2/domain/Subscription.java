package org.cc2.domain;

import org.cc2.kernel.ValueObjectId;

public final class Subscription {
    private final SubscriptionId id;
    private final ValueObjectId userID;
    private final int duration;
    private final float monthlyPrice;

    public Subscription(SubscriptionId id, ValueObjectId userID, int duration, float monthlyPrice) {
        this.id = id;
        this.userID = userID;
        this.duration = duration;
        this.monthlyPrice = monthlyPrice;
    }

    public SubscriptionId getId() {
        return this.id;
    }
}
