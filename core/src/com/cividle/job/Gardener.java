package com.cividle.job;

import com.cividle.core.Occupation;

/**
 *
 * @author Whiplash
 */
public class Gardener extends Occupation {

    public Gardener(String name, String building) {
        super(name, building);
    }
    
    public Gardener (){
    	super ("Gardener", "Greenhouse");
    }

}
