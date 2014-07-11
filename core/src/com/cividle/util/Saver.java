package com.cividle.util;

import com.cividle.core.Game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

/**
 *
 * @author Whiplash
 */
public class Saver {

    private static long currenttime, oldsavetime, newsavetime;
    private static final int defaultsaveinterval = 350; // In seconds.
    private static final String savefilename = "Civclicker.json";
    private static int saveinterval; // In seconds;

    public static void Initialize() {
        saveinterval = defaultsaveinterval;
    //	saveinterval = 15;
        updateCurrentTime();
        setNewSaveTime();
    }

    /**
     * Resets the save interval to default. Default 60 seconds.
     *
     */
    public static void resetSaveInterval() {
        saveinterval = defaultsaveinterval;
    }

    /**
     * Sets the save interval. Default 5 minutes.
     *
     * @param value what to set the save interval to. Cannot be lower than one
     * minute.
     */
    public static void setSaveInterval(int value) {
        saveinterval = (Math.max(60, value));
    //	saveinterval = 15;
    }

    private static boolean checkSaveTime() {
    //	String tmp = "Current: " + currenttime + " New: " + newsavetime;
    //	System.out.println (tmp);
        return currenttime >= newsavetime;
    }

    private static void setNewSaveTime() {
        newsavetime = ((currenttime / 1000) + saveinterval) * 1000;
    }

    private static void updateCurrentTime() {
        currenttime = System.currentTimeMillis();
    }

    private static void AutoSave(Game game) {
    	
        if (checkSaveTime()) {
            Console.println("Attempting to autosave...", Console.Type.s);
            Save(game);
            oldsavetime = newsavetime;
            setNewSaveTime();
        }
    }

    /**
     * Attempts to save the game to a .sav file.
     *
     * @param game
     */
    public static void Save(Game game) {

        // Used the System.out in Loader so I stayed consistent
        //       Console.println("Attempting to save...", Console.Type.s);
        System.out.println("Attempting to save...");

        // Confirm local storage is available
        if (Gdx.files.isLocalStorageAvailable() == true) {

            System.out.println("Saving Game...");
            //     Console.println("Saving Game...");

            Json save = new Json();
            
            String text = save.toJson(game);

            FileHandle file = Gdx.files.local(savefilename);
            
            file.writeString(text, false);

            System.out.println("Game Saved!");
            
            //      Console.println("Game Saved!");
        } else {
            System.out.println("Cannot access local storage!");
            //     Console.println("Cannot access local storage!");
        }
    }

    public static void Update(Game game) {
        updateCurrentTime();
        AutoSave(game);
    }

}
