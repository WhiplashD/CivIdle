package com.cividle.rsrc;

import com.cividle.core.Resource;
import com.cividle.core.Tradeable;

/**
 *
 * @author Whiplash
 */
public class Leather extends Resource implements Tradeable {

    public Leather(String name, String container) {
        super(name, container);
    }

    public Leather(String name, String container, float gathermultiplier) {
        super(name, container, gathermultiplier);
    }
    public Leather (){
    	super ("Leather", "Storage");
    }
}
