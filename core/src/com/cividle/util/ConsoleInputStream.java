package com.cividle.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JTextField;

/**
 *
 * @author Whiplash
 */
public class ConsoleInputStream extends InputStream {

    byte[] contents;
    int pointer = 0;

//    public ConsoleInputStream(final JTextField text) { // Compile error for HTML5.
//
//        text.addKeyListener(new KeyAdapter() { // Compile error for HTML5.
//            @Override
//            public void keyReleased(KeyEvent e) { // Compile error for HTML5.
//                if (e.getKeyChar() == '\n') {
//                    contents = text.getText().getBytes();
//                    pointer = 0;
//                    text.setText("");
//                }
//                super.keyReleased(e);
//            }
//        });
//    }
    @Override
    public int read() throws IOException {
//        if (pointer >= contents.length) {
//            return -1;
//        }
//        return this.contents[pointer++];
        return -1;
    }

}
