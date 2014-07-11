package com.cividle.util;

/**
 *
 * @author Whiplash
 */
public class Devmode {

    private static final String delimiter = "\\.";

    public static void ComanndLookup(String command) {
        Console.println("> " + command);
        String[] tmp = command.split(delimiter);
        switch (tmp[0].toLowerCase()) {
            case "rm":
//                civclicker.CivClicker.game.rm.execute(command.toLowerCase());
                break;
            case "bm":
//                civclicker.CivClicker.game.bm.execute(command.toLowerCase());
                break;
            case "pm":
//                civclicker.CivClicker.game.pm.execute(command.toLowerCase());
                break;
            case "game":
//                Console.println(civclicker.CivClicker.game.hashCode());
                break;
            case "clear":
                for (int i = 0; i < 12; i++) {
                    Console.println("");
                }
                break;
            case "help":
                Console.println("devmode commands:");
                Console.println("rm: Access resource manager commands.");
                Console.println("bm: Access building manager commands.");
                Console.println("pm: Access population manager commands.");
                Console.println("game: Displays current games hashcode.");
                Console.println("help: Displays these messages.");
                break;

            default:
                Console.println("Invalid command.");
                Console.println(" @" + Devmode.class.getName());
        }

    }
}
