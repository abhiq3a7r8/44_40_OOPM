package Controller;

import Model.*;
import View.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.ArrayList;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    Model model;
    View view;

    public Controller(Model m, View v) {
        model = m;
        view = v;
        view.centerInitialSetup(model.getManageElectronicDeviceData().getLinesBeingDisplayed(), model.getManageElectronicDeviceData().getHeaders().size());
        System.out.println(model.getManageElectronicDeviceData().getHeaders().size());
        System.out.println(model.getManageElectronicDeviceData().getLinesBeingDisplayed());
        view.centerUpdate(model.getManageElectronicDeviceData().getLines(model.getManageElectronicDeviceData().getFirstLineToDisplay(), model.getManageElectronicDeviceData().getLastLineToDisplay()), model.getManageElectronicDeviceData().getHeaders());
        view.centerInitialSetup(model.getManageCustomerData().getLinesBeingDisplayed(), model.getManageCustomerData().getHeaders().size());
        view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay())        ,                 model.getManageCustomerData().getHeaders());


        deletelistner(model);
        addButtonClickDevices();
        addButtonClickCustomers();

    }


    private void addButtonClickDevices()
    {

        view.getMf().getIp().getBp().getBtn_Electronic_Device().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Electronic Device Pressed");
                addScrollingDevices();
                view.centerUpdate(model.getManageElectronicDeviceData().getLines(model.getManageElectronicDeviceData().getFirstLineToDisplay(), model.getManageElectronicDeviceData().getLastLineToDisplay()), model.getManageElectronicDeviceData().getHeaders());
            }
        });
    }

    private void addButtonClickCustomers(){
        view.getMf().getIp().getBp().getBtn_Customer().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Customer Pressed");
                addScrollingCustomers();
                view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
            }
        });
    }


    manageCustomer Selected_button_id = new manageCustomer();
    private void deletelistner(Model model1)   {
        ArrayList<JButton> allbuttons = view.getMf().getIp().getCp().getCustomer_buttons();
        JFrame frame = new JFrame("Delete Airport");
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());
        for(JButton allbutton : allbuttons)
            allbutton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    String buttonText = allbutton.getText();
                    System.out.println(buttonText);
                    if(buttonText.contains("delete")) {
                        System.out.println("this is a delete button");
                        String[] seprated = buttonText.split(":");
                        System.out.println("string " + seprated[1]);
                        int button_id = Integer.parseInt(seprated[1]);
                        System.out.println(button_id);
                        String message = "Do you want to delete Button ID: " + button_id + "?";
                        int option = JOptionPane.showOptionDialog(null, message, "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                        if (option == JOptionPane.YES_OPTION) {
                            ArrayList customers = model1.getManageCustomerData().getTable();
                            customers.remove(button_id - 1);
                            ObjectMapper mapper = new ObjectMapper();
                            try {
                                mapper.writeValue(Paths.get("C:\\OOPMISTIC\\44_40_OOPM\\mini project\\src\\Model\\customers.json").toFile(), customers);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            JOptionPane.showMessageDialog(frame, "Customer Deleted: " + button_id);
                        }

                    }
                }
            });

        }




    private void addScrollingDevices()
    {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getManageElectronicDeviceData().getFirstLineToDisplay();
                int current_last_line = model.getManageElectronicDeviceData().getLastLineToDisplay();
                int no_of_players = model.getManageElectronicDeviceData().getTable().size();
                int no_of_display_lines = model.getManageElectronicDeviceData().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getManageElectronicDeviceData().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getManageElectronicDeviceData().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getManageElectronicDeviceData().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_players-1)
                {
                    model.getManageElectronicDeviceData().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_players-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_players - no_of_display_lines)
                    {
                        new_first_line = no_of_players-no_of_display_lines;
                        model.getManageElectronicDeviceData().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getManageElectronicDeviceData().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdate(model.getManageElectronicDeviceData().getLines(model.getManageElectronicDeviceData().getFirstLineToDisplay(), model.getManageElectronicDeviceData().getLastLineToDisplay()), model.getManageElectronicDeviceData().getHeaders());
            }
        });
    }
    private void addScrollingCustomers()
    {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getManageCustomerData().getFirstLineToDisplay();
                int current_last_line = model.getManageCustomerData().getLastLineToDisplay();
                int no_of_players = model.getManageCustomerData().getTable().size();
                int no_of_display_lines = model.getManageCustomerData().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getManageCustomerData().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getManageCustomerData().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getManageCustomerData().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_players-1)
                {
                    model.getManageCustomerData().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_players-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_players - no_of_display_lines)
                    {
                        new_first_line = no_of_players-no_of_display_lines;
                        model.getManageCustomerData().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getManageCustomerData().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
            }
        });
    }
}
