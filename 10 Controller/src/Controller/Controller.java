package Controller;

import Model.Model;
import View.View;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.Customer;
import Model.Electronic_Device;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Controller {
    Model model;
    View view;

    public Controller(Model m, View v) throws IOException {
        model = m;
        view = v;
        view.centerInitialSetup(model.getManageElectronicDeviceData().getLinesBeingDisplayed(), model.getManageElectronicDeviceData().getHeaders().size());
        view.centerUpdate(model.getManageElectronicDeviceData().getLines(model.getManageElectronicDeviceData().getFirstLineToDisplay(), model.getManageElectronicDeviceData().getLastLineToDisplay()), model.getManageElectronicDeviceData().getHeaders());
        addScrolling();
        addButtonClick();
        addButtonClickCreateCust(m);
        addButtonClickCreateED(m);
    }
    private void addButtonClick()
    {
        view.getMf().getIp().getBp().getBtn_Customer().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Customer Pressed");

                view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
            }
        });

        view.getMf().getIp().getBp().getBtn_Electronic_Device().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Electronic Device Pressed");
                view.centerUpdate(model.getManageElectronicDeviceData().getLines(model.getManageElectronicDeviceData().getFirstLineToDisplay(), model.getManageElectronicDeviceData().getLastLineToDisplay()), model.getManageElectronicDeviceData().getHeaders());
            }
        });
    }
    private void addButtonClickCreateCust(Model m) {
        view.getMf().getIp().getBp().getBtn_CreateCust().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {

                System.out.println("Create Customer Pressed");

                //   Scanner scanner = new Scanner(System.in);

                ObjectMapper mapper = new ObjectMapper();
                ArrayList<Customer> Customer;
                Customer = m.getManageCustomerData().getTable();

                int customer_id = Customer.size() + 1;
                Frame frame = new Frame("Customer Form ");
                frame.setSize(400, 300);

                Label nameLabel = new Label("Customer Name:");
                TextField nameInput = new TextField(20);

                Label phoneLabel = new Label("Phone No.:");
                TextField phoneInput = new TextField(20);

                Label emailLabel = new Label("Email Id:");
                TextField emailInput = new TextField(20);

                Label genderLabel = new Label("Gender:");
                TextField genderInput = new TextField(20);

                Label ewdLabel = new Label("Enter Warranty Duration:");
                TextField ewdInput = new TextField(20);

                Button confirmButton = new Button("Confirm");

                confirmButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String name = nameInput.getText();
                        String phone = phoneInput.getText();
                        String email = emailInput.getText();
                        String gender = genderInput.getText();
                        int ewd = Integer.parseInt(ewdInput.getText());

                        Customer Cust = new Customer(customer_id,gender, name, phone, email, ewd);
                        Customer.add(Cust);
                        try {
                            mapper.writeValue(Paths.get("src/Model/customers.json").toFile(), Customer);
                        } catch (IOException ea) {
                            System.out.println("Error is " + ea);
                        }



                        JOptionPane.showMessageDialog(null, "Customer created and added to the array with id " + Customer.size());


                        frame.dispose();
                    }
                });

                frame.setLayout(new GridLayout(8, 2));
                frame.add(nameLabel);
                frame.add(nameInput);
                frame.add(phoneLabel);
                frame.add(phoneInput);
                frame.add(emailLabel);
                frame.add(emailInput);
                frame.add(genderLabel);
                frame.add(genderInput);
                frame.add(ewdLabel);
                frame.add(ewdInput);
                frame.add(confirmButton);

                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        frame.dispose();
                    }
                });

                frame.setVisible(true);
            }
        });
    }
    private void addButtonClickCreateED(Model m) throws IOException {
        view.getMf().getIp().getBp().getBtn_CreateDev().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {

                System.out.println("Create Electronic Device Pressed");

                //   Scanner scanner = new Scanner(System.in);

                ObjectMapper mapper = new ObjectMapper();
                ArrayList<Electronic_Device> Electronic_Device;
                Electronic_Device = m.getManageElectronicDeviceData().getTable();

                int id =Electronic_Device.size() + 1;
                Frame frame = new Frame("Electonic Device Form");
                frame.setSize(400, 300);

                Label name = new Label("Device Name:");
                TextField nameInput = new TextField(20);

                Label price = new Label("Device Price:");
                TextField priceInput = new TextField(20);

                Label wattage = new Label("Device Wattage:");
                TextField wattageInput = new TextField(20);

                Label usw = new Label("User Set Wattage:");
                TextField uswInput = new TextField(20);

                Button confirmButton = new Button("Confirm");

                confirmButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String name = nameInput.getText();
                        int price = Integer.parseInt(priceInput.getText());
                        int wattage =Integer.parseInt( wattageInput.getText());
                        int usw = Integer.parseInt(uswInput.getText());

                        // Create an Airports object with the input data
                        Electronic_Device dev = new Electronic_Device(id,name,price,wattage,usw);
                        Electronic_Device.add(dev);
                        try {
                            mapper.writeValue(Paths.get("src/Model/Electronic_Device.json").toFile(), Electronic_Device);
                        } catch (IOException ea) {
                            System.out.println("Error is " + ea);
                        }


                        JOptionPane.showMessageDialog(null, "Electronic Device created and added to the array with id " + Electronic_Device.size());

                        frame.dispose();
                    }
                });

                frame.setLayout(new GridLayout(6, 2));
                frame.add(name);
                frame.add(nameInput);
                frame.add(price);
                frame.add(priceInput);
                frame.add(wattage);
                frame.add(wattageInput);
                frame.add(usw);
                frame.add(uswInput);
                frame.add(confirmButton);

                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        frame.dispose();
                    }
                });

                frame.setVisible(true);
            }
        });
    }
    private void addScrolling()
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
}