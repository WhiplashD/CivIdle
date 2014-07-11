package com.cividle.job;

import com.cividle.core.Occupation;

/**
 *
 * @author Whiplash
 */
public class Cleric extends Occupation {

    public Cleric(String name, String building) {
        super(name, building);
    }
    
    public Cleric (){
    	super ("Cleric", "Church");
    }

}
