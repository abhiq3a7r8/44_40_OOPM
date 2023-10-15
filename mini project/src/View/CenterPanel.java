package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CenterPanel extends JPanel {

    ArrayList<JButton> header_buttons = new ArrayList<>();
    ArrayList<JButton> customer_buttons = new ArrayList<>();

    ArrayList<JButton> delete_buttons = new ArrayList<>();

    public CenterPanel()
    {
        super();
    }

    public void createDisplay(int rows, int cols)
    {
        this.setLayout(new GridLayout(0,cols));
        for (int i = 1; i <= cols; i++)
        {
            JButton b = new JButton();
            b.setBackground(Color.cyan);
            b.setPreferredSize(new Dimension(80,25));
            header_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }




        for (int i = 1; i <= rows * cols; i++)
        {
            JButton b = new JButton();
            b.setBackground(Color.cyan);
            b.setPreferredSize(new Dimension(80,25));
            customer_buttons.add(b);
            this.add(b);
            validate();
            repaint();

        }



    }

    public void updateDisplay(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++)
        {
            setHeaderButtonText(i,headers.get(i));
        }

        for (int player_no = 0; player_no < lines.size(); player_no++)
        {
            for (int player_col_no = 0; player_col_no < headers.size(); player_col_no++)
            {
                int button_no = player_no * headers.size() + player_col_no;

                String button_txt = lines.get(player_no).get(player_col_no);
                setCustomer_buttons(button_no,button_txt);
            }
        }
    }

    public void setHeaderButtonText(int button_no, String button_text) {
        header_buttons.get(button_no).setText(button_text);
    }
    public void setCustomer_buttons(int button_no, String button_text) {
        customer_buttons.get(button_no).setText(button_text);
    }

    public ArrayList<JButton> getHeaderButtons()
    {
        return header_buttons;
    }

    public ArrayList<JButton> getCustomer_buttons()
    {
        return customer_buttons;
    }

}