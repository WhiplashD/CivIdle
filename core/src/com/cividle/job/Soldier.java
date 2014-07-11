package com.cividle.job;

import com.cividle.core.Occupation;

/**
 *
 * @author Whiplash
 */
public class Soldier extends Occupation {

    public Soldier(String name, String building) {
        super(name, building);
    }
    
    public Soldier (){
    	super ("Soldier", "Barracks");
    }

}
