package Controller;

import Model.Model;
import View.View;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
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


        deletelistner();
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

    private void deletelistner()   {
        ArrayList<JButton> allbuttons = view.getMf().getIp().getCp().getCustomer_buttons();
        for(JButton allbutton : allbuttons)
            allbutton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    System.out.println("all clicked");
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
