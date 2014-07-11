package com.cividle.core;

import java.util.Random;

/**
 *
 * @author Whiplash
 */
public class InvasionType {

    private final String name;
    private int health, amount;
    private final int damage, poptriggeramount;
    private final float amountmultiplier;

    /**
     * Creates a new Invasion event type.
     * 
     * @param name
     * @param health
     * @param damage
     * @param poptriggeramount
     * @param amountmultiplier
     */
    public InvasionType(String name, int health, int damage, int poptriggeramount, float amountmultiplier) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.poptriggeramount = poptriggeramount;
        this.amountmultiplier = amountmultiplier;
    }

    /**
     *
     * @return the name of the event type.
     */
    public String getName() {
        return name;
    }

    /**
     * Initializes the stats of the invasion event type.
     * 
     * @param game
     */
    public void InitStats(Game game) {
        amount = (new Random().nextInt((int) (game.pm.getPopulationAmount() * amountmultiplier))) + 1;
        health *= amount;
    }
}
