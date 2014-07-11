package com.cividle.core;

import com.cividle.util.Console;

/**
 *
 * @author Whiplash
 */
public class TradeEvent extends Event {

    private String name;

    public TradeEvent() {
        super(10000);
    }

    public void CompleteTrade() {
        // Do trade transactions

        EndEvent();
    }

    @Override
    public void Create(Game game) {
        StartEvent();
        Console.println("Trade Event active!" + this.toString());
        game.rm.CatchEvent(this);

    }

    @Override
    public void Dispose() {
        // 	EndEvent();
    }
}
