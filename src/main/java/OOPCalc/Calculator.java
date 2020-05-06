package OOPCalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private String a;
    private String b;
    private String oper;
    private Stage stage;

    private Display display;
    private ButtonSet buttonSet;

    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;

    public Calculator() {
        super();
        a = "0";
        b = "";
        oper = "";
        stage = Stage.FIRST;
        setGUI();
    }
    public void actionPerformed(ActionEvent e)  {
        String command = e.getActionCommand();
        System.out.println("Info: command = " + command);
        switch (stage){
            case FIRST: {
                if(command.matches("\\d")){
                    a = command;
                    stage = Stage.SECOND;
                    display.setFrontSymbols(a);
                }
                break;
            }
            case SECOND:{
                System.out.println("INFO: Second stage");
                if(command.matches("\\d")){
                    System.out.println(a);
                    a = a + command;
                    display.setFrontSymbols(a);
                    System.out.println(a);
                }
                if(command.equals(".") && a.matches(".")){
                    a = a + command;
                    display.setFrontSymbols(a);
                    System.out.println(a);
                }

                if(command.equals("+")) {
                    oper = "+";
                    stage = Stage.THIRD;
                }
                if(command.equals("-")) {
                    oper = "-";
                    stage = Stage.THIRD;

                }
                if(command.equals("/")) {
                    oper = "÷";
                    stage = Stage.THIRD;

                }
                if(command.equals("x")) {
                    oper = "x";
                    stage = Stage.THIRD;
                }
                if(stage == Stage.THIRD) {
                    display.setOper(oper);
                    display.setBackSymbols(a);
                    display.setFrontSymbols("0");
                }
                break;
            }
            case THIRD: {
                System.out.println("INFO: Third stage");
                if(command.matches("[0-9]")){
                    b = command;
                    display.setFrontSymbols(b);
                    stage = Stage.FOURTH;
                }
                break;
            }
            case FOURTH: {
                if(command.matches("[0-9]")){
                    b = b + command;
                    display.setFrontSymbols(b);
                }
                if(command.equals(".") && !a.matches("\\.")) {
                    b = b + command;
                    display.setFrontSymbols(b);
                }
                if(command.equals("=")) {
                    display.setBackSymbols("");
                    display.setOper("");
                    a = getResult();
                    b = "";
                    oper = "";
                    System.out.println("INFO: result " + a);
                    display.setFrontSymbols(a);
                    stage = Stage.FIFTH;
                }
                break;
            }
            case FIFTH: {
                if(command.matches("\\d")){
                    System.out.println(a);
                    a = command;
                    display.setFrontSymbols(a);
                    stage = Stage.SECOND;
                }
                if(command.equals("+")) {
                    oper = "+";
                    stage = Stage.THIRD;
                }
                if(command.equals("-")) {
                    oper = "-";
                    stage = Stage.THIRD;

                }
                if(command.equals("/")) {
                    oper = "÷";
                    stage = Stage.THIRD;

                }
                if(command.equals("x")) {
                    oper = "x";
                    stage = Stage.THIRD;
                }
                if(stage == Stage.THIRD) {
                    display.setOper(oper);
                    display.setBackSymbols(a);
                    display.setFrontSymbols("0");
                }
                break;
            }
        }
    }

    private void setGUI(){
        JPanel panel = new JPanel();
        display = new Display();
        panel.add(display);
        buttonSet = new ButtonSet(this);
        panel.add(buttonSet);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);
        add(panel);
        setVisible(true);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getResult() throws NumberFormatException {
        String result = "";
        try {
            switch (oper) {
                case "+":
                    result = Double.toString(Double.parseDouble(a) + Double.parseDouble(b));
                    break;
                case "x":
                    result = Double.toString(Double.parseDouble(a) * Double.parseDouble(b));
                    break;
                case "-":
                    result = Double.toString(Double.parseDouble(a) - Double.parseDouble(b));
                    break;
                case "÷": {
                    if (Double.parseDouble(b) != 0.0) {
                        result = Double.toString(Double.parseDouble(a) / Double.parseDouble(b));
                    } else {
                        JOptionPane.showMessageDialog(null, "ERR: На ноль делить нельзя",
                                "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERR: NumberFormatException" + e,
                    "NumberFormatException", JOptionPane.ERROR_MESSAGE);
        }
        return result;

    }
    public static void main(String[] args) {
        Calculator myCalc = new Calculator();
    }
}

