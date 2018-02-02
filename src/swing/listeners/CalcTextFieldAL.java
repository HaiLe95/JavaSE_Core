package swing.listeners;

import swing.gui.MyJTextField;
import swing.gui.TestGUI;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CalcTextFieldAL implements FocusListener {

    private MyJTextField field;

    public CalcTextFieldAL(MyJTextField field) {
        this.field = field;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(field.getText().equals(TestGUI.INPUT_NUMBER)) {
            field.setText("");
            field.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(field.getText().equals("")) {
            field.setText(TestGUI.INPUT_NUMBER);
            field.setForeground(Color.GRAY);
        }

    }
}
