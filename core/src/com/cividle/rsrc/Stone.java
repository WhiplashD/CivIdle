package com.cividle.rsrc;

import com.cividle.core.Resource;
import com.cividle.core.Tradeable;

/**
 *
 * @author Whiplash
 */
public class Stone extends Resource implements Tradeable {

    public Stone(String name, String container) {
        super(name, container);
    }

    public Stone(String name, String container, float gathermultiplier) {
        super(name, container, gathermultiplier);
    }
    public Stone (){
    	super ("Stone", "StoneStockpile", 1.2f);
    }
}
