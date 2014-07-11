package com.cividle.core;

import com.cividle.util.Console;

/**
 *
 * @author Whiplash
 */
public class InvasionEvent extends Event {

    InvasionType Wolf;

    private InvasionType t;

    /**
     * Creates a new invasion event.
     */
    public InvasionEvent() {
        super(60000);
        Wolf = new InvasionType("Wolves", 1, 1, 10, 0.25f);
    }

    /**
     *
     * @return the invasion events type name.
     */
    public String getName() {
        return t.getName();
    }

    @Override
    public void Create(Game game) {
        StartEvent();
        Console.println("Invasion Event active!" + this.toString());
        t = Wolf;
        game.pm.CatchEvent(this);
    }

    @Override
    public void Dispose() {
        EndEvent();
        t = null;
    }

}
