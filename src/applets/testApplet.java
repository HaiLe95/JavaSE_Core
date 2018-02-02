package applets;

import javax.swing.*;
import java.awt.*;

public class testApplet extends JApplet {

    JPanel jPanel = new JPanel();
    JLabel jLabel = new JLabel();

    @Override
    public void init() {
        super.init();
        jPanel.setLayout(new FlowLayout());
        jPanel.add(jLabel);
        String s  = getParameter("labelText");
        jLabel.setText(s);
        getContentPane().add(jPanel);
    }
}
