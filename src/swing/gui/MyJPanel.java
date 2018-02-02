package swing.gui;

import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {

    public MyJPanel(String name, int width, int height) {
        super.setSize(width, height);
        super.setName(name);
        super.setBorder(BorderFactory.createEtchedBorder());
    }

    public MyJPanel(String name, int width, int height, Component component) {
        this(name, width, height);
        super.add(component);
    }

    public MyJPanel(String name, int width, int height, LayoutManager layoutManager) {
        this(name, width, height);
        super.setLayout(layoutManager);
    }

    public MyJPanel(String name, int width, int height, Component component, LayoutManager layoutManager) {
        this(name, width, height, component);
        super.setLayout(layoutManager);
    }

}
