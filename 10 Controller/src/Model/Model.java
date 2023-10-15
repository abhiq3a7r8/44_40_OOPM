package Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Model
{
    Scanner scanner = new Scanner(System.in);
    protected manageCustomer manageCustomerData = new manageCustomer();
        ArrayList<Customer> Customer = new ArrayList<Customer>();
        ObjectMapper mapper = new ObjectMapper();
    protected manageElectronic_Device manageElectronicDeviceData = new manageElectronic_Device();
        ArrayList<Electronic_Device> Electronic_Device = new ArrayList<Electronic_Device>();

    public Model()
    {
        manageElectronicDeviceData.setLinesBeingDisplayed(25);
        manageElectronicDeviceData.setFirstLineToDisplay(0);
        manageCustomerData.setLinesBeingDisplayed(25);
        manageCustomerData.setFirstLineToDisplay(0);
    }

    public manageElectronic_Device getManageElectronicDeviceData()
    {
        return manageElectronicDeviceData;
    }
    public manageCustomer getManageCustomerData(){
        return manageCustomerData;
    }
    public void createCustomer() throws IOException {
        System.out.println("Enter Customer id: ");
        int Customer_id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone no: ");
        String phone = scanner.nextLine();

        System.out.print("Enter email id: ");
        String email = scanner.nextLine();

        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();


        System.out.print("Enter ewd ");
        int ewd = scanner.nextInt();

        Customer cust = new Customer(Customer_id,gender,name,phone,email,ewd);
        Customer.add(cust);
        mapper.writeValue(Paths.get("src/Model/Customers.json").toFile(), Customer);

        System.out.println("Customer created and added to the array with id "+Customer.size());

    }
    public void createDevice() throws IOException {
        System.out.println("Enter Device id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Device Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Device price: ");
        int price = scanner.nextInt();

        System.out.print("Enter wattage: ");
        int wattage = scanner.nextInt();

        System.out.print("Enter User Set Wattage: ");
        int usw = scanner.nextInt();

        Electronic_Device Dev = new Electronic_Device(id,name,price,wattage,usw);
        Electronic_Device.add(Dev);
        mapper.writeValue(Paths.get("src/Model/Electronic_Device.json").toFile(), Electronic_Device);

        System.out.println("Electronic Device created and added to the array with id "+Electronic_Device.size());

    }

}


