package com.cividle.util;

import com.cividle.CivIdle;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Tyler
 */
public class Console implements Serializable {

    private static int verbositylevel = 0;
    private static boolean islogging = false;
    private static final List<Object> printlist = new ArrayList<>();
//    private static javax.swing.JTextArea consoleout; // Compile error for HTML5.
    private static final File logfile = new File("output.log");

    /**
     * Custom System.out.println wrapper. Defaults to type "u"ser if no output
     * type is supplied. Defaults to verbosity 0 if no level is supplied.
     *
     * @param message object to be passed along.
     */
    public static void println(Object message) {
        println(message, Type.u, 0);
    }

    /**
     * Custom System.out.println wrapper. Defaults to verbosity 0 if no level is
     * supplied.
     *
     * @param message object to be passed along.
     * @param type flag used to determine if the message is sent to the "u"ser
     * or "s"ystem.
     */
    public static void println(Object message, Type type) {
        println(message, type, 0);
    }

    /**
     * Custom System.out.println wrapper. Defaults to type "u"ser if no output
     * type is supplied.
     *
     * @param message object to be passed along.
     * @param vlevel verbosity level.
     */
    public static void println(Object message, int vlevel) {
        println(message, Type.u, vlevel);
    }

    /**
     * Custom System.out.println wrapper.
     *
     * @param message object to be passed along.
     * @param type flag used to determine if the message is sent to the "u"ser
     * or "s"ystem.
     * @param vlevel verbosity level.
     */
    public static void println(Object message, Type type, int vlevel) {
        if (vlevel >= verbositylevel) {
            switch (type) {
                case u:
                    if (islogging) {
//                        WriteLog(Timestamp() + message);
                    }
                    if (printlist.size() >= 28) { // This does scrolly stuff.
                        printlist.remove(0);
                    }
                    printlist.add(CivIdle.pdr.Timestamp() + message);
//                    consoleout.setText("");
                    for (Object s : printlist) {
                        System.out.println(s);
                    }
                    break;
                case s:
                    if (islogging) {
//                        WriteLog(Timestamp() + message);
                    }
                    break;
            }
        }
    }

    private static void WriteLog(Object message) {
//        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(logfile, true)))) { // Compile error for HTML5.
//            out.println(message); // Compile error for HTML5.
//        } catch (IOException ex) {
//            println(ex.getMessage());
//        }
    }

    /**
     * Starts logging system and console output to a file.
     *
     * @param args
     */
    public static void StartLog(String[] args) {
        for (String s : args) {
            switch (s) {
                case "-v0":
                    verbositylevel = 0;
                    break;
                case "-v1":
                    verbositylevel = 1;
                    break;
                case "-v2":
                    verbositylevel = 2;
                    break;
                case "-v3":
                    verbositylevel = 3;
                    break;
            }
            islogging = !islogging;
            String init = "----------" + "LOG START" + CivIdle.pdr.Timestamp() + "----------";
//            WriteLog(init);
        }
    }

//    /**
//     * Sets a JTextArea to be printed to as well as setting System Err and Out
//     * to this JTA.
//     *
//     * @param jta the JTextArea.
//     */
//    public static void setOut(JTextArea jta) {
//        consoleout = jta;
//        PrintStream ps = new PrintStream(new ConsoleOutputStream(consoleout));
//        System.setErr(ps);
//        System.setOut(ps);
//    }
//    private static String Timestamp() {
//        return "[" + sdf.format(new Date()) + "] ";
//        return "null";
//    }
    public enum Type {

        u, // user
        s // system
    }
}
