package com.cividle.rsrc;

import com.cividle.core.Resource;
import com.cividle.core.Tradeable;

/**
 *
 * @author Whiplash
 */
public class Food extends Resource implements Tradeable {

    public Food(String name, String container) {
        super(name, container);
    }

    public Food(String name, String container, float gathermultiplier) {
        super(name, container, gathermultiplier);
    }
    public Food (){
    	super ("Food", "Barn", 1.4f);
    }

}
