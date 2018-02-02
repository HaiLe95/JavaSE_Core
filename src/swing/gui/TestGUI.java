package swing.gui;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import swing.listeners.CalcButtonAL;
import swing.listeners.CalcTextFieldAL;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TestGUI {

    public static final String INPUT_NUMBER = "Введите число";

    private MyJButton btnAdd;
    private MyJButton btnSubtract;
    private MyJButton btnDivide;
    private MyJButton btnMultiply;

    private JLabel lblNum1;
    private JLabel lblNum2;
    private JLabel lblResult;

    private MyJTextField jtxtfldNum1;
    private MyJTextField jtxtfldNum2;
    private MyJTextField jtxtfldResult;

    private MyJPanel panel1;
    private MyJPanel panel2;
    private MyJPanel panel3;

    private MyJFrame frame;

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new AcrylLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame.setDefaultLookAndFeelDecorated(true);

        TestGUI testGUI = new TestGUI();

        testGUI.createTextFields();
        testGUI.createButtons();
        testGUI.createLabels();
        testGUI.createPanels();
        testGUI.createFrame();


    }

    private void createButtons() {
        btnAdd = new MyJButton("Сложение");
        btnDivide = new MyJButton("Деление");
        btnMultiply = new MyJButton("Умножение");
        btnSubtract = new MyJButton("Вычитание");

        addButtonListeners();
    }

    private void createLabels() {
        lblNum1 = new JLabel("Число 1");
        lblNum2 = new JLabel("Число 2");
        lblResult = new JLabel("Результат");
    }

    public void createTextFields() {
        jtxtfldNum1 = new MyJTextField(INPUT_NUMBER,10);
        jtxtfldNum2 = new MyJTextField(INPUT_NUMBER,10);

        jtxtfldResult = new MyJTextField(15, Color.BLACK);
        jtxtfldResult.setEditable(false);
        jtxtfldResult.setFocusable(false);

        addTextFieldListeners();
    }

    private void createPanels() {
        panel1 = new MyJPanel("panel", 100 ,100);
        panel1.setPreferredSize(new Dimension(200, 50));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel2 = new MyJPanel("panel", 100 ,100);
        panel2.setPreferredSize(new Dimension(200, 50));
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel3 = new MyJPanel("panel", 100 ,100);
        panel3.setPreferredSize(new Dimension(200, 50));
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel1.add(lblNum1);
        panel1.add(jtxtfldNum1);
        panel1.add(lblNum2);
        panel1.add(jtxtfldNum2);

        panel2.add(btnAdd);
        panel2.add(btnSubtract);
        panel2.add(btnMultiply);
        panel2.add(btnDivide);

        panel3.add(lblResult);
        panel3.add(jtxtfldResult);
    }

    private void createFrame() {
        frame = new MyJFrame("Калькулятор", 430, 200, new BorderLayout(2, 2));
//      frame.setMinimumSize(new Dimension(430, 200));
        frame.setResizable(false);
        frame.getContentPane().add(panel1, BorderLayout.NORTH);
        frame.getContentPane().add(panel2, BorderLayout.CENTER);
        frame.getContentPane().add(panel3, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void addButtonListeners() {

        CalcButtonAL bl = new CalcButtonAL(jtxtfldNum1, jtxtfldNum2, jtxtfldResult);

        btnAdd.addActionListener(bl);
        btnDivide.addActionListener(bl);
        btnSubtract.addActionListener(bl);
        btnMultiply.addActionListener(bl);
    }

    private void addTextFieldListeners() {

        jtxtfldNum1.addFocusListener(new CalcTextFieldAL(jtxtfldNum1));
        jtxtfldNum2.addFocusListener(new CalcTextFieldAL(jtxtfldNum2));

    }
}
