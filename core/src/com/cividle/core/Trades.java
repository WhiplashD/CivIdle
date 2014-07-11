package com.cividle.core;

/**
 *
 * @author Whiplash
 */
public abstract class Trades {

    /**
     * Trades one resource for another.
     *
     * @param rTake the resource being traded away.
     * @param amount the amount of the resource being traded away.
     * @param rGive the resource being traded for.
     * @param ratio the trade ratio.
     */
    public void Trade(Resource rTake, double amount, Resource rGive, float ratio) {
        if (rTake instanceof Tradeable && rGive instanceof Tradeable) {
            if (rTake.getAmount() - amount >= 0) { // If it is above or lands on 0 its fine
                rTake.subtractAmount(amount);
                rGive.addAmount(amount * ratio);
            } else { // Otherwise we use difference to figure out how much to remove
                double difference = Math.abs((rTake.getAmount() - amount));
                rTake.subtractAmount(amount - difference);
                rGive.addAmount((amount - difference) * ratio);
            }
        }
    }
}
