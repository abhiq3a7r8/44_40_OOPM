package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonPanel  extends JPanel {
    JButton btn_Customer = new JButton();
    JButton btn_Electronic_Device = new JButton();

    public ButtonPanel(){
        btn_Customer.setBackground(Color.cyan);
        btn_Customer.setPreferredSize(new Dimension(80,25));
        btn_Customer.setText("Customer");
        this.add(btn_Customer);
        validate();
        repaint();
        btn_Electronic_Device.setBackground(Color.cyan);
        btn_Electronic_Device.setPreferredSize(new Dimension(80,25));
        btn_Electronic_Device.setText("Electronic_Device");
        this.add(btn_Electronic_Device);
        validate();
        repaint();
    }

    public JButton getBtn_Customer() {
        return btn_Customer;
    }

    public JButton getBtn_Electronic_Device() {
        return btn_Electronic_Device;
    }
}
