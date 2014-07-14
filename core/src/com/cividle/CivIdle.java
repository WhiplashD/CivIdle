package com.cividle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.TimeUtils;
import com.cividle.core.DesktopUI;
import com.cividle.core.Game;
import com.cividle.core.PlatformDependencyResolver;
import com.cividle.core.UI;
import com.cividle.util.Console;
import com.cividle.util.Saver;

public class CivIdle extends ApplicationAdapter {

    private boolean isrunning = true, devmode = false;
    public static Game game;
    private static UI ui;
//    private DesktopUI dui;
    private long lastloop = TimeUtils.nanoTime();
    private final int targetfps = 60;
    private final long targettime = 1000000000 / targetfps;
    private double delta = 0;
    public static PlatformDependencyResolver pdr = null;

    public static void setTPD(PlatformDependencyResolver tpd) {
        pdr = tpd;
    }

    @Override
    public void create() {
        game = new Game();
        ui = new UI(game);
        Saver.Initialize();

// Uncomment these lines to work with the old UI
//        dui = new DesktopUI(game, devmode);
//        dui.setVisible(true);
    }

    @Override
    public void render() {
        long Now = TimeUtils.nanoTime();
        double updateLength = Now - lastloop;
        delta += (updateLength / 1000000000);
        lastloop = Now;

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (delta >= 1) { // Updates that are done periodically, every second.
            game.Update(delta);
            Saver.Update(game);
            delta = 0;
        }

// Uncomment this line to work with old UI
//        dui.UpdateDisplay();
        ui.render();
    }

    @Override
    public void resize(int width, int height) {
        ui.resize(width, height);
    }

    @Override
    public void dispose() {
        ui.dispose();
    }

    /**
     * Restarts the game by creating a new instance of Game.
     *
     */
    public void Restart() {
        Console.println("Game Restarting.");
        game = new Game();
    }
}
