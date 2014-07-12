package com.cividle.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.cividle.CivIdle;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = 1778;
        config.height = 1000;

        CivIdle.setTPD(new DesktopPlatform());
        new LwjglApplication(new CivIdle(), config);
    }
}
