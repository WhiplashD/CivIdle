package com.cividle.util;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 *
 * @author Whiplash
 */
public class ConsoleOutputStream extends OutputStream {

//    private final JTextArea textArea; // Compile error for HTML5.

//    public ConsoleOutputStream(JTextArea textArea) {
//        this.textArea = textArea;
//    }

    @Override
    public void write(int b) throws IOException {
//        textArea.append(String.valueOf((char) b));
//        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
