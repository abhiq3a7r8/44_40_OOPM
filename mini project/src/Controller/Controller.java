package Controller;

import Model.*;
import View.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.event.*;
import java.nio.file.Paths;
import java.util.ArrayList;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
//import java.util.ArrayList;

public class Controller {
    Model model;

    View view;

    Customer cust1;

    Electronic_Device dev1;

    public Controller(Model m, View v) {
        model = m;
        view = v;
        view.centerInitialSetup(model.getManageElectronicDeviceData().getLinesBeingDisplayed(), model.getManageElectronicDeviceData().getHeaders().size());
        view.centerUpdate(model.getManageElectronicDeviceData().getLines(model.getManageElectronicDeviceData().getFirstLineToDisplay(), model.getManageElectronicDeviceData().getLastLineToDisplay()), model.getManageElectronicDeviceData().getHeaders());
        view.centerInitialSetup(model.getManageCustomerData().getLinesBeingDisplayed(), model.getManageCustomerData().getHeaders().size());
        view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()),model.getManageCustomerData().getHeaders());



        insertListener(model);

        addButtonClickDevices();
        addButtonClickCustomers();


    }


    // Declare a variable to store the mouse listener for the "Electronic Device" button
    private MouseAdapter electronicDeviceListener = null;

    // Modify the addButtonClickDevices() method
    private void addButtonClickDevices() {
        // Check if a previous listener exists and remove it
        if (electronicDeviceListener != null) {
            view.getMf().getIp().getBp().getBtn_Electronic_Device().removeMouseListener(electronicDeviceListener);
        }

        // Create a new mouse listener for the "Electronic Device" button
        electronicDeviceListener = new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Electronic Device Pressed");
                deletelistner2(model);
                editlistner2(dev1);
                addScrollingDevices();
                view.centerUpdate(model.getManageElectronicDeviceData().getLines(model.getManageElectronicDeviceData().getFirstLineToDisplay(), model.getManageElectronicDeviceData().getLastLineToDisplay()), model.getManageElectronicDeviceData().getHeaders());
            }
        };

        // Add the new mouse listener to the "Electronic Device" button
        view.getMf().getIp().getBp().getBtn_Electronic_Device().addMouseListener(electronicDeviceListener);
    }


    private MouseAdapter customerListener = null;

    private void addButtonClickCustomers() {
        if (customerListener != null) {
            view.getMf().getIp().getBp().getBtn_Customer().removeMouseListener(customerListener);
        }

        customerListener = new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Customer Pressed");
                deletelistner(model);
                editlistner(cust1);
                addScrollingCustomers();
                view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
            }
        };

        view.getMf().getIp().getBp().getBtn_Customer().addMouseListener(customerListener);
    }

    private void insertListener(Model c1) {
        view.getMf().getIp().getBp().getBtn_CreateCust().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Insert Customer Pressed");

                ObjectMapper mapper = new ObjectMapper();
                ArrayList<Customer> customers1;
                customers1 = c1.getManageCustomerData().getTable();

                // Create a new JFrame for the customer input form
                JFrame customerForm = new JFrame("Customer Form");
                customerForm.setSize(400, 300);
                customerForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Create input fields
                JLabel nameLabel = new JLabel("Name:");
                JTextField nameField = new JTextField(20);

                JLabel phoneLabel = new JLabel("Phone:");
                JTextField phoneField = new JTextField(20);

                JLabel emailLabel = new JLabel("Email:");
                JTextField emailField = new JTextField(20);

                JLabel genderLabel = new JLabel("Gender:");
                JTextField genderField = new JTextField(20);

                // Create a button to submit the form
                JButton submitButton = new JButton("Submit");

                // Create a panel to hold the form components
                JPanel formPanel = new JPanel();
                formPanel.setLayout(new GridLayout(5, 2));
                formPanel.add(nameLabel);
                formPanel.add(nameField);
                formPanel.add(phoneLabel);
                formPanel.add(phoneField);
                formPanel.add(emailLabel);
                formPanel.add(emailField);
                formPanel.add(genderLabel);
                formPanel.add(genderField);
                formPanel.add(submitButton);

                // Add an ActionListener for the submit button
                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Retrieve input values and create a customer


                        int currentCustomerCount = customers1.size();
                        String name = nameField.getText();
                        String phone = phoneField.getText();
                        String email = emailField.getText();
                        String gender = genderField.getText();

                        // Create a Customer object and perform any necessary actions
                        Customer newCustomer = new Customer(currentCustomerCount,gender,name,phone,email);
                        customers1.add(newCustomer);
                        try {
                            mapper.writeValue(Paths.get("C:\\OOPMISTIC\\44_40_OOPM\\mini project\\src\\Model\\customers.json").toFile(),customers1);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }


                        // Close the customer form
                        customerForm.dispose();
                    }
                });

                // Add the form panel to the JFrame
                customerForm.add(formPanel);

                // Make the JFrame visible
                customerForm.setVisible(true);
            }
        });
    }

    private void insertListener2(Model c1) {
        view.getMf().getIp().getBp().getBtn_CreateDev().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Insert Device Pressed");

                ObjectMapper mapper = new ObjectMapper();
                ArrayList<Electronic_Device> devcie1;
                devcie1 = c1.getManageCustomerData().getTable();

                // Create a new JFrame for the customer input form
                JFrame deviceForm = new JFrame("Add Device");
                deviceForm.setSize(400, 300);
                deviceForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Create input fields
                JLabel nameLabel = new JLabel("Name:");
                JTextField nameField = new JTextField(20);

                JLabel priceLabel = new JLabel("Price:");
                JTextField priceField = new JTextField(20);

                JLabel dwattageLabel = new JLabel("Device Wattage:");
                JTextField dwattageField = new JTextField(20);

                JLabel lwattageLabel = new JLabel("User Wattage:");
                JTextField lwattageField = new JTextField(20);

                // Create a button to submit the form
                JButton submitButton = new JButton("Submit");

                // Create a panel to hold the form components
                JPanel formPanel = new JPanel();
                formPanel.setLayout(new GridLayout(5, 2));
                formPanel.add(nameLabel);
                formPanel.add(nameField);
                formPanel.add(priceLabel);
                formPanel.add(priceField);
                formPanel.add(dwattageLabel);
                formPanel.add(dwattageField);
                formPanel.add(lwattageLabel);
                formPanel.add(lwattageField);
                formPanel.add(submitButton);

                // Add an ActionListener for the submit button
                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Retrieve input values and create a customer


                        int currentdevicecount = devcie1.size();
                        String name = nameField.getText();
                        String phone = priceField.getText();
                        String email = dwattageField.getText();
                        String gender = lwattageField.getText();

                        // Create a Customer object and perform any necessary actions
                        Electronic_Device newDevice = new Electronic_Device(currentdevicecount,gender,name,phone,email);
                        devcie1.add(newDevice);
                        try {
                            mapper.writeValue(Paths.get("C:\\OOPMISTIC\\44_40_OOPM\\mini project\\src\\Model\\Electronic_Device.json").toFile(), devcie1);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }


                        // Close the customer form
                        deviceForm.dispose();
                    }
                });

                // Add the form panel to the JFrame
                deviceForm.add(formPanel);

                // Make the JFrame visible
                deviceForm.setVisible(true);
            }
        });
    }





    private void deletelistner(Model model1)   {
        ArrayList<JButton> allbuttons = view.getMf().getIp().getCp().getCustomer_buttons();
        JFrame frame = new JFrame("Delete Customer");
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
                        int button_id =         Integer.parseInt(seprated[1]);
                        System.out.println(button_id);
                        String message = "Do you want to delete Button ID: " + button_id + "?";
                        int option = JOptionPane.showOptionDialog(null, message, "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                        if (option == JOptionPane.YES_OPTION) {

                            ArrayList<Customer> customers = model1.getManageCustomerData().getTable();
                            customers.removeIf(customer1 -> customer1.getCustomer_id() == button_id);

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

    private void editlistner(Customer cust1)   {
        ArrayList<JButton> allbuttons = view.getMf().getIp().getCp().getCustomer_buttons();
        JFrame frame = new JFrame("Edit Customer");
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());
        for(JButton allbutton : allbuttons)
            allbutton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    String buttonText = allbutton.getText();
                    System.out.println(buttonText);
                    if(buttonText.contains("edit")) {
                        System.out.println("this is an edit button");
                        String[] seprated_edit = buttonText.split(":");
                        System.out.println("string " + seprated_edit[1]);
                        int edit_button_id = Integer.parseInt(seprated_edit[1]);
                        System.out.println(edit_button_id);
                        JPanel panel = new JPanel(new GridLayout(10, 10));

                        ObjectMapper mapper = new ObjectMapper();
                        ArrayList<Customer> customers;
                        customers = model.getManageCustomerData().getTable();

                        JTextField name = new JTextField();
                        JTextField phone_no = new JTextField();
                        JTextField email = new JTextField();
                        JTextField gender = new JTextField();
                        panel.add(new JLabel("Name: "));
                        panel.add(name);
                        panel.add(new JLabel("Phone No.: "));
                        panel.add(phone_no);
                        panel.add(new JLabel("Email: "));
                        panel.add(email);
                        panel.add(new JLabel("Gender: "));
                        panel.add(gender);

                        // Show the custom dialog
                        String message = "Edit data for Button ID: " + edit_button_id;
                        int option = JOptionPane.showOptionDialog(null, panel, message, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                        if (option == JOptionPane.OK_OPTION) {
                            // User clicked "OK," perform edit operation here
                            // Access the text entered in the text fields and update customer information

                            String edited_customer_name = name.getText();
                            String edited_phone_no = phone_no.getText();
                            String edited_email = email.getText();
                            String edited_gender = gender.getText();

                            // Update the customer information if the corresponding text fields are not empty

                            Customer customer = customers.get(edit_button_id - 1);


                            if (!edited_customer_name.isEmpty()) {
                                customer.setCustomer_name(edited_customer_name);
                            }
                            if (!edited_phone_no.isEmpty()) {
                                customer.setPhone_no(edited_phone_no);
                            }
                            if (!edited_email.isEmpty()) {
                                customer.setEmail_id(edited_email);
                            }
                            if (!edited_gender.isEmpty()) {
                                customer.setGender(edited_gender);
                            }
                        }



                        try {
                                mapper.writeValue(Paths.get("C:\\OOPMISTIC\\44_40_OOPM\\mini project\\src\\Model\\customers.json").toFile(), customers);
                            } catch (IOException ex) {
                                System.out.println(ex);
                            }

                        }

                    }

            });

    }


    private void deletelistner2(Model model1)   {
        ArrayList<JButton> allbuttons = view.getMf().getIp().getCp().getDevices_buttons();
        JFrame frame = new JFrame("Delete Devices");
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
                        int button_id =         Integer.parseInt(seprated[1]);
                        System.out.println(button_id);
                        String message = "Do you want to delete Button ID: " + button_id + "?";
                        int option = JOptionPane.showOptionDialog(null, message, "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                        if (option == JOptionPane.YES_OPTION) {

                            ArrayList<Electronic_Device> devices = model1.getManageCustomerData().getTable();
                            devices.removeIf(customer1 -> customer1.getId() == button_id);

                            ObjectMapper mapper = new ObjectMapper();
                            try {
                                mapper.writeValue(Paths.get("C:\\OOPMISTIC\\44_40_OOPM\\mini project\\src\\Model\\Electronic_Device.json").toFile(), devices);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            JOptionPane.showMessageDialog(frame, "Device Deleted: " + button_id);
                        }



                    }


                }

            });

    }

    private void editlistner2(Electronic_Device dev1)   {
        ArrayList<JButton> allbuttons = view.getMf().getIp().getCp().getCustomer_buttons();
        JFrame frame = new JFrame("Edit Device");
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());
        for(JButton allbutton : allbuttons)
            allbutton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    String buttonText = allbutton.getText();
                    System.out.println(buttonText);
                    if(buttonText.contains("edit")) {
                        System.out.println("this is an edit button");
                        String[] seprated_edit = buttonText.split(":");
                        System.out.println("string " + seprated_edit[1]);
                        int edit_button_id = Integer.parseInt(seprated_edit[1]);
                        System.out.println(edit_button_id);
                        JPanel panel = new JPanel(new GridLayout(10, 10));

                        ObjectMapper mapper = new ObjectMapper();
                        ArrayList<Electronic_Device> devices;
                        devices = model.getManageElectronicDeviceData().getTable();

                        JTextField name = new JTextField();
                        JTextField price = new JTextField();
                        JTextField dwattage = new JTextField();
                        JTextField lwattage = new JTextField();
                        panel.add(new JLabel("Name: "));
                        panel.add(name);
                        panel.add(new JLabel("Price: "));
                        panel.add(price);
                        panel.add(new JLabel("Device Wattage: "));
                        panel.add(dwattage);
                        panel.add(new JLabel("User Wattage: "));
                        panel.add(lwattage);

                        // Show the custom dialog
                        String message = "Edit data for Button ID: " + edit_button_id;
                        int option = JOptionPane.showOptionDialog(null, panel, message, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                        if (option == JOptionPane.OK_OPTION) {
                            // User clicked "OK," perform edit operation here
                            // Access the text entered in the text fields and update customer information

                            String edited_name = name.getText();
                            String edited_price = price.getText();
                            String edited_dwattage = dwattage.getText();
                            String edited_lwattage = lwattage.getText();

                            // Update the customer information if the corresponding text fields are not empty

                            Electronic_Device device = devices.get(edit_button_id - 1);

                            if (!edited_name.isEmpty()) {
                                device.setDevice_Name(edited_name);
                            }
                            if (!edited_price.isEmpty()) {
                                device.setDevice_Price(edited_price);
                            }
                            if (!edited_dwattage.isEmpty()) {
                                device.setDevice_wattage(edited_dwattage);
                            }
                            if (!edited_lwattage.isEmpty()) {
                                device.setUser_set_wattage(edited_lwattage);
                            }
                        }



                        try {
                            mapper.writeValue(Paths.get("C:\\OOPMISTIC\\44_40_OOPM\\mini project\\src\\Model\\Electronic_Device.json").toFile(), devices);
                        } catch (IOException ex) {
                            System.out.println(ex);
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
