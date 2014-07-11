package com.cividle.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cividle.CivIdle;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        CivIdle.setTPD(new DesktopPlatform());
        new LwjglApplication(new CivIdle(), config);
    }
}
