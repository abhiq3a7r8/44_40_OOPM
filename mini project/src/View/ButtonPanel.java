package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonPanel  extends JPanel {
    JButton btn_Customer = new JButton();
    JButton btn_Electronic_Device = new JButton();
    JButton btn_CreateCust = new JButton();
    JButton btn_CreateDev = new JButton();

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
        btn_CreateCust.setBackground(Color.cyan);
        btn_CreateCust.setPreferredSize(new Dimension(140,25));
        btn_CreateCust.setText("Create Customer");
        this.add(btn_CreateCust);
        validate();
        repaint();
        btn_CreateDev.setBackground(Color.cyan);
        btn_CreateDev.setPreferredSize(new Dimension(180,25));
        btn_CreateDev.setText("Create Electronic Device");
        this.add(btn_CreateDev);
        validate();
        repaint();
    }

    public JButton getBtn_Customer() {
        return btn_Customer;
    }

    public JButton getBtn_Electronic_Device() {
        return btn_Electronic_Device;
    }

    public JButton getBtn_CreateCust(){return btn_CreateCust;}
    public JButton getBtn_CreateDev(){return btn_CreateDev;}
}
