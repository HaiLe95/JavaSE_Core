package swing.gui;

import javax.swing.*;

public class MyJButton extends JButton {

    public MyJButton(String text) {
        super.setText(text);
    }

    public MyJButton(String text, int width, int height) {
        this(text);
        super.setSize(width, height);
    }
}
