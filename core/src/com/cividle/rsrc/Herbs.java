package com.cividle.rsrc;

import com.cividle.core.Resource;
import com.cividle.core.Tradeable;

/**
 *
 * @author Whiplash
 */
public class Herbs extends Resource implements Tradeable {

    public Herbs(String name, String container) {
        super(name, container);
    }

    public Herbs(String name, String container, float gathermultiplier) {
        super(name, container, gathermultiplier);
    }
    public Herbs (){
    	super ("Herbs", "Storage");
    }
}
