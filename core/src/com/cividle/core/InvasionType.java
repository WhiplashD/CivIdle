package com.cividle.core;

import java.util.Random;

/**
 *
 * @author Whiplash
 */
public class InvasionType {

//    private final Game game;
    private final String name;
    private int health, amount;
    private final int damage, poptriggeramount;
    private final float amountmultiplier;

    public InvasionType(String name, int health, int damage, int poptriggeramount, float amountmultiplier) {
     //   this.game = game;
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.poptriggeramount = poptriggeramount;
        this.amountmultiplier = amountmultiplier;
    }

    public String getName() {
        return name;
    }

    public void GenStats(Game game) {
        amount = (new Random().nextInt((int) (game.pm.getPopulationAmount() * amountmultiplier))) + 1;
        health *= amount;
    }
}
