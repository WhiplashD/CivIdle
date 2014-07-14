package com.cividle.core;

import java.io.Serializable;

/**
 *
 * @author Whiplash
 */
public class Game implements Serializable {

    public ResourceManager rm;
    public PopulationManager pm;
    public BuildingManager bm;
    public RandomEventHandler reh;

    public Game() {
        rm = new ResourceManager();
        pm = new PopulationManager();
        bm = new BuildingManager();
        reh = new RandomEventHandler();
    }
    
    public void Update(Double Delta) {
        rm.Update(this, Delta);
        pm.Update(this, Delta);
        reh.Update(this, Delta);
    }
}
