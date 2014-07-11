package com.cividle.job;

import com.cividle.core.Occupation;

/**
 *
 * @author Whiplash
 */
public class Dead extends Occupation {

    public Dead(String name) {
        super(name);
    }

    public Dead(String name, String building) {
        super(name, building);
    }
    public Dead (){
    	super ("Unburied Dead");
    }

}
