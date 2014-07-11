package com.cividle.core;

/**
 *
 * @author Whiplash
 */
public interface Invokable {

//  Used to split up commands.
    final String delimiter = "\\.";

    /**
     * Parses a string, executes a method matching the string.
     *
     * @param command
     */
    void execute(String command);
}
