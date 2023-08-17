import model.Electronic_Device;
import model.purchases;
import model.Customer;
import model.Brand;


import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int currentCustomerCount = 0;
        int currentElectronic_DeviceCount = 0;
        int currentPurchasesCount = 0;
        int currentBrandCount = 0;

        Scanner scanner = new Scanner(System.in);

        Customer[] cust_array;
        cust_array = new Customer[100];

        Electronic_Device[] device_array;
        device_array = new Electronic_Device[20];

        purchases[] purchases_array;
        purchases_array = new purchases[200];

         Brand[] brand_array;
         brand_array = new Brand[10];

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
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    if (currentCustomerCount < cust_array.length) {

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

                        cust_array[currentCustomerCount] = new Customer();
                        currentCustomerCount++;

                        System.out.print("Do you want to apply for Extended warranty Duration? (Y/N): ");
                        String extendedwstat = scanner.nextLine();
                        if (extendedwstat.equalsIgnoreCase("Y")){
                            int upperBound = (int) Math.pow(10,1);
                            Random rduration = new Random();
                            int extended_warranty_duration = rduration.nextInt(upperBound);
                            cust_array[currentCustomerCount - 1].customerinfo(currentCustomerCount,gender,name,phone_no,email_id,extended_warranty_duration);
                        }
                        else if(extendedwstat.equalsIgnoreCase("N")){
                            cust_array[currentCustomerCount - 1].customerinfo(currentCustomerCount,gender,name,phone_no,email_id);
                        }

                        System.out.println("The Customer ID is: " + currentCustomerCount);

                        System.out.println("Customer created and added to the array.");
                    } else {
                        System.out.println("Array is full. Cannot create more Customers.");
                    }
                    break;
                case 2:

                    System.out.print("Enter Id of the Customer to Display: ");
                    int cust_id_to_display = scanner.nextInt();

                    System.out.println("CustomerId : " + cust_array[cust_id_to_display - 1].getCustomer_id());
                    System.out.println("Gender: " + cust_array[cust_id_to_display - 1].getGender());
                    System.out.println("Name : " + cust_array[cust_id_to_display - 1].getCustomer_name());
                    System.out.println("MobileNo : " + cust_array[cust_id_to_display - 1].getPhone_no());
                    System.out.println("Email Id : " + cust_array[cust_id_to_display - 1].getEmail_id());
                    System.out.println("Extended warranty:"+cust_array[cust_id_to_display -1].getExtended_warranty_duration()+" months");

                    System.out.println("--------------------------------------------------------");

                    break;
                case 3:
                    if (currentElectronic_DeviceCount < device_array.length) {


                        System.out.print("Enter Electonic_Device Name: ");
                        String device_Name = scanner.nextLine();


                        System.out.print("Enter Electonic_Device Price: ");
                        double device_Price = scanner.nextDouble();

                        System.out.print("Enter the power consumption limit: ");
                        int l1wattage = scanner.nextInt();

                        int upperBound = (int) Math.pow(10,2);
                        Random rwattage = new Random();
                        int d1wattage = rwattage.nextInt(upperBound);


                        // Create the object dynamically
                        device_array[currentElectronic_DeviceCount] = new Electronic_Device();
                        currentElectronic_DeviceCount++;


                        System.out.println("The Electronic_device ID is: "+ currentElectronic_DeviceCount);
                        System.out.println("The power consumption: "+ d1wattage+"KWh");

                        device_array[currentElectronic_DeviceCount - 1].setDevice_Name(device_Name);
                        device_array[currentElectronic_DeviceCount - 1].setDevice_Price(device_Price);
                        device_array[currentElectronic_DeviceCount - 1].setDevice_wattage(d1wattage);
                        device_array[currentElectronic_DeviceCount - 1].setUser_set_wattage(l1wattage);

                        System.out.println("Electonic_Device created and added to the array.");
                    } else {
                        System.out.println("Array is full. Cannot create more Electonic_Devices.");
                    }
                    break;
                case 4:

                    System.out.print("Enter Id of the ELectronic Device to Display: ");
                    int Electronic_Device_id_to_display = scanner.nextInt();

                    System.out.println("ELectronic Device Name : " + device_array[Electronic_Device_id_to_display - 1].getDevice_Name());
                    System.out.println("ELectronic Device Price : " + device_array[Electronic_Device_id_to_display - 1].getDevice_Price());
                    System.out.println("ELectronic Device Wattage : " + device_array[Electronic_Device_id_to_display - 1].getDevice_wattage());
                    System.out.println("--------------------------------------------------------");
                    break;
                case 5:
                    if(currentBrandCount < brand_array.length) {
                        System.out.print("Enter Device Brand: ");
                        String brand_name = scanner.nextLine();

                        brand_array[currentBrandCount] = new Brand();
                        currentBrandCount++;

                        System.out.println("The current brand ID is " + currentBrandCount);
                        brand_array[currentBrandCount - 1].setBrand_Name(brand_name);

                    }
                    else {
                        System.out.println("Brand array is full, cannot create anymore Brands");
                    }
                    break;
                case 6:
                    System.out.println("Enter the ID of Brand to display");
                    int Brand_id_to_Display = scanner.nextInt();
                    System.out.println("ELectronic Device Brand: " + brand_array[Brand_id_to_Display - 1].getBrand_Name());


                case 7:
                    if (currentPurchasesCount < purchases_array.length)
                    {
                        System.out.print("Enter Id of the Customer to make purchase: ");
                        int selected_customer_id = scanner.nextInt();

                        System.out.print("Enter Id of the device to purchase: ");
                        int selected_Electronic_device_id = scanner.nextInt();

                        System.out.print("Enter Brand ID to make purchase of: ");
                        int selected_brand_id = scanner.nextInt();
                        purchases_array[currentPurchasesCount] = new purchases();
                        currentPurchasesCount++;

                        purchases_array[currentPurchasesCount-1].purchases_objDev_objCust(device_array[selected_Electronic_device_id - 1],cust_array[selected_customer_id - 1],brand_array[selected_brand_id - 1]);

                        System.out.println("Purchase logged and added to the array.");
                    } else {
                        System.out.println("Array is full. Cannot create more purchases.");
                    }
                    break;
                case 8:
                    for (int i = 0; i < currentPurchasesCount; i++) {

                        purchases_array[i].display_ELectronic_Device_Customer();
                    }
                    break;
                case 9:
                System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s","User","Brand","Device","Status","Exceeds"));
                for (int i = 0;i < currentElectronic_DeviceCount;i++) {
                    if(device_array[i].getUser_set_wattage() < device_array[i].getDevice_wattage()) {
                        int difference = device_array[i].getDevice_wattage() - device_array[i].getUser_set_wattage();


                            purchases_array[i].dispay_powerstatus(difference);
                    }
                    else {
                            purchases_array[i].dispay_powerstatus();
                    }
                }
                break;


                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 9);

        scanner.close();
    }
}
