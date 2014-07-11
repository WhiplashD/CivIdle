package com.cividle.core;

import com.cividle.util.Console;
import java.util.Random;

/**
 *
 * @author Whiplash
 */
public class RandomEventHandler implements Updateable {

    private long newthrowtime, currenttime, throwdelay = 600000, closetime; // All this is in milliseconds.
    private final Random rand;
    private boolean hasevent = false;
    private Event ev;

    public RandomEventHandler() {
        UpdateTime();
        setNewThrowTime();
        rand = new Random();

    }

    private void ThrowEvent(Game game) {
        hasevent = true;
        ev = ChooseEventType(game);
        ev.Create(game);
        setClosetime(ev.getCloseTime());

    }

    public void setClosetime(long l) {
        closetime = currenttime + l;
    }

    private void setNewThrowTime() {
        newthrowtime = currenttime + throwdelay;
    }

    private boolean CheckThrowTime() {
        return currenttime >= newthrowtime;
    }

    private boolean CheckCloseTime() {
        return currenttime >= closetime;
    }

    private boolean CheckChance() {
        return rand.nextInt(1000) >= 990;
    }

    private void UpdateTime() {
        currenttime = System.currentTimeMillis();
    }

    public void EndEvent() {
        Console.println("Closing event." + ev.toString());
        hasevent = false;
        ev.Dispose();
        ev = null;
    }

    private Event ChooseEventType(Game game) {
        switch (rand.nextInt(1)) {
            case 0:
                return new TradeEvent();
            case 1:
                return new InvasionEvent();
            default:
                return null;
        }
    }

    @Override
    public void Update(Game game) {
        UpdateTime();
        if (!hasevent) {
            if (CheckThrowTime() || CheckChance()) {
                ThrowEvent(game);
                setNewThrowTime();
            }
        } else {
            if (CheckCloseTime() || !ev.IsActive()) {
                EndEvent();
            }
        }
    }
}
