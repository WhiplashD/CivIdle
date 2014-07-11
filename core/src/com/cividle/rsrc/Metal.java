package com.cividle.rsrc;

import com.cividle.core.Resource;
import com.cividle.core.Tradeable;

/**
 *
 * @author Whiplash
 */
public class Metal extends Resource implements Tradeable {

    public Metal(String name, String container) {
        super(name, container);
    }

    public Metal(String name, String container, float gathermultiplier) {
        super(name, container, gathermultiplier);
    }
    public Metal (){
    	super ("Metal", "Storage");
    }
}
