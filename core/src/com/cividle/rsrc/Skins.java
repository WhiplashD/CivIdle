package com.cividle.rsrc;

import com.cividle.core.Resource;
import com.cividle.core.Tradeable;

/**
 *
 * @author Whiplash
 */
public class Skins extends Resource implements Tradeable {

    public Skins(String name, String container) {
        super(name, container);
    }

    public Skins(String name, String container, float gathermultiplier) {
        super(name, container, gathermultiplier);
    }
    public Skins (){
    	super ("Animal Skins", "Storage");
    }
}
