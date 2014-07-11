package com.cividle.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

import com.cividle.core.Game;
// import java.io.FileInputStream;
// import java.io.IOException;
// import java.io.ObjectInputStream;

/**
 *
 * @author Whiplash
 */
public class Loader {

    private static final String savefilename = "Civclicker.json";

    /**
     * Tries to load a previous save from file.
     *
     * @return whether or not a save file was found.
     */
    public static Game LoadGame() {
        
//        try {
//            ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(savefilename)); // Compile error for HTML5.
//            return (Game) OIS.readObject();
//
//        } catch (IOException | ClassNotFoundException e) {
//            Console.println(e.getMessage(), Console.Type.s);
//            return new Game();
//        }
    	
    	// Changed to System.out because UI isn't made so Console doesn't work.
    	System.out.println("Attempting to load file...");
        
        // Confirm local storage is available
        if (Gdx.files.isLocalStorageAvailable() == true){
    		FileHandle file = Gdx.files.local (savefilename);
    		
    		// Check the file was opened and has saved content
    		// Used length because it also tells us if the file wasn't opened
    		// Or something else went wrong. Also it is faster to use on Android than the exists method.
    		if (file.length() <= 0){
    			// No save or something else went wrong
    			
    			System.out.println("No Save...Starting new game");
    			return new Game();
    		}
    		String info = file.readString();
    		Json saved = new Json ();
    		Game newGame = saved.fromJson(Game.class, info);
    		System.out.println("Successfully loaded file.");
    		return newGame;
    	}
        else{
        	// No local storage - meaning they cannot save either
        	// So maybe a graceful exit of program or just
        	// continue without saving.
        	System.out.println("No local storage. May not be able to save");
        	return new Game ();
        }
      
    }

}
