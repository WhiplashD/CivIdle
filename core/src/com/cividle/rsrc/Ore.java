package com.cividle.rsrc;

import com.cividle.core.Resource;
import com.cividle.core.Tradeable;

/**
 *
 * @author Whiplash
 */
public class Ore extends Resource implements Tradeable {

    public Ore(String name, String container) {
        super(name, container);
    }

    public Ore(String name, String container, float gathermultiplier) {
        super(name, container, gathermultiplier);
    }
    public Ore (){
    	super ("Ore", "Storage");
    }
}
