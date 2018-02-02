package swing.gui;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {

    public MyJFrame(String title, int width, int height) {
        super(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new FlowLayout());
        super.setIconImage(new ImageIcon("C:\\Java\\icons\\icon_android.jpg").getImage());
        super.setVisible(true);
    }

    public MyJFrame(String title, int width, int height, Component component) {
        this(title,width, height);
        super.getContentPane().add(component);
    }

    public MyJFrame(String title, int width, int height, LayoutManager layoutManager) {
        super(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(layoutManager);
        super.setIconImage(new ImageIcon("C:\\Java\\icons\\caculator.png").getImage());
    }

}
