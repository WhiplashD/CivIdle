package com.cividle.bldg;

import com.cividle.core.Building;
import com.cividle.core.PopulationManager;
import com.cividle.core.ResourceManager;

/**
 *
 * @author Tyler
 */
public class Hut extends Building {

    public Hut(String name, int capacity) {
        super(name, capacity);

    }
    public Hut (){
    	super ("Hut", 2 );
    }
    @Override
    public void Buy(ResourceManager rm, PopulationManager pm, int value) {
        rm.PayResources(cost);
        addAmount(value);
        UpdateCost(rm, value);
        pm.addMaxAmount((long) getCapacity());
    }

    @Override
    public void Sell(ResourceManager rm, PopulationManager pm, int value) {
        subtractAmount(value);
        UpdateCost(rm, value);
        rm.RefundResources(cost);
        pm.subtractMaxAmount((long) getCapacity());
    }
}
