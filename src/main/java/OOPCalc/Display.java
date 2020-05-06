package OOPCalc;

import java.awt.*;
import javax.swing.*;

public class Display extends JPanel {
    private JTextField frontSymbols;
    private JTextField backSymbols;
    private JTextField oper;

    public Display() {
        backSymbols = new JTextField("");
        oper = new JTextField("");
        frontSymbols = new JTextField("");
        setGUI();
    }
    private void setGUI(){
        frontSymbols.setHorizontalAlignment(JTextField.RIGHT);
        Font font =  frontSymbols.getFont();



        backSymbols.setHorizontalAlignment(JTextField.RIGHT);
        backSymbols.setFont(font.deriveFont(Font.PLAIN, 16f));
        backSymbols.setBackground(Color.BLACK);
        backSymbols.setForeground(Color.GREEN);
        backSymbols.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        backSymbols.setSize(300,16);
        backSymbols.setFocusable(false);

        oper.setHorizontalAlignment(JTextField.LEFT);
        oper.setFont(font.deriveFont(Font.PLAIN, 18f));
        oper.setBackground(Color.BLACK);
        oper.setForeground(Color.GREEN);
        oper.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        backSymbols.setSize(300,18);
        oper.setFocusable(false);

        frontSymbols.setFont(font.deriveFont(Font.PLAIN, 20f));
        frontSymbols.setBackground(Color.BLACK);
        frontSymbols.setForeground(Color.GREEN);
        frontSymbols.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        backSymbols.setSize(300,20);
        frontSymbols.setFocusable(false);

        setLayout(new GridLayout(3, 1));
        add(backSymbols);
        add(oper);
        add(frontSymbols);
        setBackground(Color.BLACK);
        setSize(300,60);
    }
    public void setFrontSymbols(String number) {
        this.frontSymbols.setText(number);
    }
    public void setBackSymbols(String number) {
        this.backSymbols.setText(number);
    }
    public void setOper(String oper) {
        this.oper.setText(oper);
    }
}
