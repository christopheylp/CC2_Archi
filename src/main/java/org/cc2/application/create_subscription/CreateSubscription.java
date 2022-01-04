package org.cc2.application.create_subscription;

import org.cc2.kernel.Command;
import org.cc2.kernel.ValueObjectId;

public final class CreateSubscription implements Command {
    public final ValueObjectId userID;
    public final int duration;
    public final float monthlyPrice;

    public CreateSubscription(ValueObjectId userID, int duration, float monthlyPrice) {
        this.userID = userID;
        this.duration = duration;
        this.monthlyPrice = monthlyPrice;
    }
}
