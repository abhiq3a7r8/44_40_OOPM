import model.Electronic_Device;
import model.purchases;
import model.Customer;
import model.Brand;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int currentCustomerCount = 0;
        int currentElectronic_DeviceCount = 0;
        int currentPurchasesCount = 0;
        int currentBrandCount = 0;

        Scanner scanner = new Scanner(System.in);

        ArrayList<Customer> cust_array = new ArrayList<>();
        ArrayList<Electronic_Device> device_array = new ArrayList<>();
        ArrayList<Brand> brand_array = new ArrayList<>();
        ArrayList<purchases> purchases_array = new ArrayList<>();


        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add a new Customer");
            System.out.println("2. Display a Customer");
            System.out.println("3. Add a new Electronic_Device");
            System.out.println("4. Display a Electronic_Device");
            System.out.println("5. Add a new device Brand");
            System.out.println("6. Display a new brand");
            System.out.println("7. Add a Purchase");
            System.out.println("8. Display all Purchases");
            System.out.println("9. Generate A power Consumption report");
            System.out.println("10. Set timer on a device");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    if (currentCustomerCount < cust_array.size())
                    {

                        System.out.print("Enter Customer Name: ");
                        String name = scanner.nextLine();

                        String phone_no;
                        do {
                            System.out.print("Enter Phone No: ");
                            phone_no = scanner.nextLine();
                            if (phone_no.length() != 10){
                                System.out.println("Invalid Phone Number!" );
                            }
                        } while (phone_no.length() != 10);


                        System.out.print("Enter Email Id: ");
                        String email_id = scanner.nextLine();

                        System.out.print("Enter Gender(male or female): ");
                        String gender = scanner.nextLine();


                        currentCustomerCount++;

                        System.out.print("Do you want to apply for Extended warranty Duration? (Y/N): ");
                        String extendedwstat = scanner.nextLine();


                        Customer newCustomer = null;

                        if (extendedwstat.equalsIgnoreCase("Y")){
                            int upperBound = (int) Math.pow(10,1);
                            Random rduration = new Random();
                            int extended_warranty_duration = rduration.nextInt(upperBound);
                            newCustomer = new Customer(currentCustomerCount,gender,name,phone_no,email_id,extended_warranty_duration);
                        }
                        else if (extendedwstat.equalsIgnoreCase("N")){
                            newCustomer = new Customer(currentCustomerCount,gender,name,phone_no,email_id);
                        }

                        cust_array.add(newCustomer);



                        System.out.println("The Customer ID is: " + currentCustomerCount);

                        System.out.println("Customer created and added to the array.");
                    }
                    else {
                        System.out.println("Array is full. Cannot create more Customers.");
                    }
                    break;
                case 2:

                    System.out.print("Enter Id of the Customer to Display: ");
                    int cust_id_to_display = scanner.nextInt();

                    System.out.println("CustomerId : " + cust_array.get(cust_id_to_display - 1).getCustomer_id());
                    System.out.println("Gender: " + cust_array.get(cust_id_to_display - 1).getGender());
                    System.out.println("Name : " + cust_array.get(cust_id_to_display - 1).getCustomer_name());
                    System.out.println("MobileNo : " + cust_array.get(cust_id_to_display - 1).getPhone_no());
                    System.out.println("Email Id : " + cust_array.get(cust_id_to_display - 1).getEmail_id());
                    System.out.println("Extended warranty:"+ cust_array.get(cust_id_to_display - 1).getExtended_warranty_duration()+" Months");

                    System.out.println("--------------------------------------------------------");

                    break;
                case 3:
                    if (currentElectronic_DeviceCount < device_array.size()) {


                        System.out.print("Enter Electonic_Device Name: ");
                        String device_Name = scanner.nextLine();


                        System.out.print("Enter Electonic_Device Price: ");
                        double device_Price = scanner.nextDouble();

                        System.out.print("Enter the power consumption limit: ");
                        int l1wattage = scanner.nextInt();

                        int upperBound = (int) Math.pow(10,2);
                        Random rwattage = new Random();
                        int d1wattage = rwattage.nextInt(upperBound);
                        currentElectronic_DeviceCount++;

                        // Create the object dynamically
//                        device_array(currentElectronic_DeviceCount) = new Electronic_Device();
//                        currentElectronic_DeviceCount++;

                        Electronic_Device newDevice  = new Electronic_Device();


                        System.out.println("The Electronic_device ID is: "+ currentElectronic_DeviceCount);
                        System.out.println("The power consumption: "+ d1wattage+"KWh");

                        newDevice.setDevice_Name(device_Name);
                        newDevice.setDevice_Price(device_Price);
                        newDevice.setDevice_wattage(d1wattage);
                        newDevice.setUser_set_wattage(l1wattage);

                        device_array.add(newDevice);



                        System.out.println("Electonic_Device created and added to the array.");
                    } else {
                        System.out.println("Array is full. Cannot create more Electonic_Devices.");
                    }
                    break;
                case 4:

                    System.out.print("Enter Id of the ELectronic Device to Display: ");
                    int Electronic_Device_id_to_display = scanner.nextInt();

                    System.out.println("ELectronic Device Name : " + device_array.get(Electronic_Device_id_to_display - 1).getDevice_Name());
                    System.out.println("ELectronic Device Price : " + device_array.get(Electronic_Device_id_to_display - 1).getDevice_Price());
                    System.out.println("ELectronic Device Wattage : " + device_array.get(Electronic_Device_id_to_display - 1).getDevice_wattage());
                    System.out.println("--------------------------------------------------------");
                    break;
                case 5:
                    if(currentBrandCount < brand_array.size()) {
                        System.out.print("Enter Device Brand: ");
                        String brand_name = scanner.nextLine();

                        Brand newBrand = new Brand();
                        currentBrandCount++;

                        System.out.println("The current brand ID is " + currentBrandCount);
                        newBrand.setBrand_Name(brand_name);

                        brand_array.add(newBrand);

                    }
                    else {
                        System.out.println("Brand array is full, cannot create anymore Brands");
                    }
                    break;
                case 6:
                    System.out.println("Enter the ID of Brand to display");
                    int Brand_id_to_Display = scanner.nextInt();
                    System.out.println("ELectronic Device Brand: " + brand_array.get(Brand_id_to_Display - 1).getBrand_Name());


                case 7:
                    if (currentPurchasesCount < purchases_array.size())
                    {
                        System.out.print("Enter Id of the Customer to make purchase: ");
                        int selected_customer_id = scanner.nextInt();

                        System.out.print("Enter Id of the device to purchase: ");
                        int selected_Electronic_device_id = scanner.nextInt();

                        System.out.print("Enter Brand ID to make purchase of: ");
                        int selected_brand_id = scanner.nextInt();
                        currentPurchasesCount++;



                        purchases_array.get(currentPurchasesCount-1).purchases_objDev_objCust(device_array.get(selected_Electronic_device_id - 1),cust_array.get(selected_customer_id - 1),brand_array.get(selected_brand_id - 1));

                        System.out.println("Purchase logged and added to the array.");

                    } else {
                        System.out.println("Array is full. Cannot create more purchases.");
                    }
                    break;
                case 8:
                    for (int i = 0; i < currentPurchasesCount; i++) {

                        purchases_array.get(i).display_ELectronic_Device_Customer();
                    }
                    break;
                case 9:
                    System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s","User","Brand","Device","Status","Exceeds"));
                    for (int i = 0;i < currentElectronic_DeviceCount;i++) {
                        if(device_array.get(i).getUser_set_wattage() < device_array.get(i).getDevice_wattage()) {
                            int difference = device_array.get(i).getDevice_wattage() - device_array.get(i).getUser_set_wattage();


                            purchases_array.get(i).dispay_powerstatus(difference);
                        }
                        else {
                            purchases_array.get(i).dispay_powerstatus();
                        }
                    }
                    break;
                case 10:
                    System.out.print("Enter Id of the Electronic Device to add timer: ");
                    int timer = scanner.nextInt();
                    device_array.get(timer - 1).setTurnedOn(false);
                    System.out.println("Timer duration:");
                    int time = scanner.nextInt();
                    device_array.get(timer - 1).setTimer(time);
                    break;



                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 10);

        scanner.close();
    }
}