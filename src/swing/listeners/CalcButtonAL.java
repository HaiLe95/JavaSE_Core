package swing.listeners;

import swing.calc.CalcOperation;
import swing.gui.MyJTextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class CalcButtonAL implements ActionListener {

    private MyJTextField num1;
    private MyJTextField num2;
    private MyJTextField res;


    public CalcButtonAL(MyJTextField num1, MyJTextField num2, MyJTextField res) {
        this.num1 = num1;
        this.num2 = num2;
        this.res = res;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(!(e.getSource() instanceof JButton)) {
            return;
        } else {
            JButton button = (JButton)e.getSource();
            try {
                final double numberOne = Double.parseDouble(num1.getText());
                final double numberTwo = Double.parseDouble(num2.getText());
                switch (button.getText()) {
                    case "Сложение":
                        res.setText(String.valueOf(CalcOperation.add(numberOne, numberTwo)));
                        break;
                    case "Вычитание":
                        res.setText(String.valueOf(CalcOperation.divide(numberOne, numberTwo)));
                        break;
                    case "Умножение":
                        res.setText(String.valueOf(CalcOperation.multiply(numberOne, numberTwo)));
                        break;
                    case "Деление":
                        res.setText(String.valueOf(CalcOperation.subtract(numberOne, numberTwo)));
                        break;
                }
            } catch (NumberFormatException exception) {
                res.errorMessage();
            }



        }
    }
}
