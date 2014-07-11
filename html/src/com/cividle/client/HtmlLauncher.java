package com.cividle.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.cividle.CivIdle;

public class HtmlLauncher extends GwtApplication {
    
    @Override
    public GwtApplicationConfiguration getConfig() {
        return new GwtApplicationConfiguration(480, 320);
    }
    
    @Override
    public ApplicationListener getApplicationListener() {
        CivIdle.setTPD(new WebPlatform());
        return new CivIdle();
    }
}
