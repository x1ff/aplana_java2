package OOPCalc;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonSet extends JPanel  {
    public ButtonSet(Calculator calc){
        String buttons = "789/456x123-0.+=";
        Font font =  new JButton().getFont();;
        for(int i = 0; i < buttons.length(); i++) {
            JButton btn = new JButton(buttons.substring(i, i + 1));
            btn.setBackground(Color.BLACK);
            btn.setForeground(Color.GREEN);
            btn.setFont(font.deriveFont(Font.PLAIN, 20f));
            btn.setActionCommand(buttons.substring(i, i + 1));
            btn.addActionListener(calc);
            this.add(btn);
        }
        setLayout(new GridLayout(4, 4));
    }
}
