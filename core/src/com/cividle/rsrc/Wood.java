package com.cividle.rsrc;

import com.cividle.core.Resource;
import com.cividle.core.Tradeable;

/**
 *
 * @author Whiplash
 */
public class Wood extends Resource implements Tradeable {

    public Wood(String name, String container) {
        super(name, container);
    }

    public Wood(String name, String container, float gathermultiplier) {
        super(name, container, gathermultiplier);
    }
    public Wood (){
    	super ("Wood", "LumberYard", 1.2f);
    }
}
