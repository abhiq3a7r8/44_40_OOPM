//package Model;
//
//import Model.*;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.util.ArrayList;
//import java.io.*;
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.*;
//
//public class crud {
//    public static void main(String[] args) throws IOException {
//
//        ArrayList<Customer> customers = new ArrayList<Customer>();
//        ArrayList<Electronic_Device> Electronic_Devices = new ArrayList<Electronic_Device>();
//
//        Scanner scanner = new Scanner(System.in);
//
//        manageCustomer mc1 = new manageCustomer();
//        customers = mc1.readJsonFile("C:\\OOPMISTIC\\src\\model\\customers.json");
//
//        manageElectronic_Device ms1 = new manageElectronic_Device();
//        Electronic_Devices = ms1.readJsonFile("C:\\OOPMISTIC\\src\\model\\Electronic_Device.json");
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        String filepath = "C:\\OOPMISTIC\\src\\model\\customers.json";
//
//
//        int choice;
//        do {
//            System.out.println("Menu:");
//            System.out.println("1. Create a Customer");
//            System.out.println("2. Update a Customer");
//            System.out.println("3. Display a Customer");
//            System.out.println("4. Display All Customer");
//            System.out.println("5. Delete a Customer");
//            System.out.println("6. Create a Electronic Device");
//            System.out.println("7. Update a Electronic Device");
//            System.out.println("8. Display a Electronic Device");
//            System.out.println("9. Display All Electronic Device");
//            System.out.println("10. Delete a Electronic Device");
//            System.out.println("11. Exit");
//            System.out.println("6. Exit");
//            System.out.print("Enter your choice: ");
//            choice = scanner.nextInt();
//            scanner.nextLine(); // Consume the newline character
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter Customer Name ");
//                    String name = scanner.nextLine();
//
//                    System.out.print("Enter Phone No: ");
//                    String phone_no = scanner.next();
//
//                    try {
//
//                        if (phone_no.length() != 10) {
//                            throw new IllegalArgumentException("Phone number must be 10 digits");
//                        }
//
//
//                        System.out.println("Phone number is valid: " + phone_no);
//                    } catch (IllegalArgumentException e) {
//
//                        System.out.println("Invalid input: " + e.getMessage());
//
//                    }
//
//                    System.out.print("Enter Email Id: ");
//                    String email_id = scanner.next();
//
//                    try {
//
//                        if (isValidEmail(email_id)) {
//                            // Email is valid
//                            System.out.println("Email is valid: " + email_id);
//                        } else {
//                            throw new RuntimeException("Invalid email address");
//                        }
//                    } catch (RuntimeException e) {
//
//                        System.out.println("Invalid email input: " + e.getMessage());
//
//                    }
//
//
//
//                    System.out.print("Enter Gender(male or female): ");
//                    String gender = scanner.next();
//
//                    System.out.print("Do you want to apply for Extended warranty Duration? (Y/N): ");
//                    String extendedwstat = scanner.next();
//
//                    int currentCustomerCount = customers.size() + 1;
//
//                    if (extendedwstat.equalsIgnoreCase("Y")){
//                        int upperBound = (int) Math.pow(10,1);
//                        Random rduration = new Random();
//                        int extended_warranty_duration = rduration.nextInt(upperBound);
//                        Customer newCustomer = new Customer(currentCustomerCount,gender,name,phone_no,email_id,extended_warranty_duration);
//                        customers.add(newCustomer);
//                        try {
//
//                            mapper.writeValue(Paths.get(filepath).toFile(), customers);
//                        } catch (FileNotFoundException e) {
//
//                            throw new RuntimeException("File not found", e);
//                        }
//
//
//                    }
//
//                    else if (extendedwstat.equalsIgnoreCase("N")){
//                        Customer newCustomer = new Customer(currentCustomerCount,gender,name,phone_no,email_id);
//                        customers.add(newCustomer);
//                        try {
//
//                            mapper.writeValue(Paths.get(filepath).toFile(), customers);
//                        } catch (FileNotFoundException e) {
//
//                            throw new RuntimeException("File not found", e);
//                        } catch (IOException e) {
//
//                            throw new RuntimeException("I/O error", e);
//                        }
//
//                    }
//
//
//
//                    System.out.println("Customer created and added to the array.");
//                    break;
//                case 2:
//                    System.out.print("Enter Student Id to Update: ");
//                    int cust_id = scanner.nextInt();
//                    scanner.nextLine();
//                    int choice_to_change;
//                    do {
//                        System.out.println("1. Change Customer Name");
//                        System.out.println("2. Change Phone No");
//                        System.out.println("3. Change Email Id");
//                        System.out.println("4. Change Gender");
//                        System.out.println("5. Exit Update");
//
//                        System.out.print("Enter your choice: ");
//                        choice_to_change = scanner.nextInt();
//
//                        switch (choice_to_change){
//                            case 1:
//                                scanner.nextLine();
//                                System.out.print("Enter Customer Name: ");
//                                String name_update = scanner.nextLine();
//                                customers.get(cust_id-1).setCustomer_name(name_update);
//                                mapper.writeValue(Paths.get(filepath).toFile(), customers);
//                                break;
//                            case 2:
//                                System.out.print("Enter Phone No: ");
//                                String mobile_no_update = scanner.next();
//                                customers.get(cust_id-1).setPhone_no(mobile_no_update);
//                                mapper.writeValue(Paths.get(filepath).toFile(), customers);
//                                break;
//                            case 3:
//                                System.out.print("Enter Email Id: ");
//                                String email_update = scanner.next();
//                                customers.get(cust_id-1).setEmail_id(email_update);
//                                mapper.writeValue(Paths.get(filepath).toFile(), customers);
//                                break;
//                            case 4:
//                                System.out.print("Enter Gender: ");
//                                String gender_update = scanner.next();
//                                customers.get(cust_id-1).setGender(gender_update);
//                                mapper.writeValue(Paths.get(filepath).toFile(), customers);
//                                break;
//                            default:
//                                System.out.println("Invalid choice. Try again.");
//                                break;
//                        }
//                    } while (choice_to_change != 5);
//                    break;
//                case 3:
//                    // customers = mc1.readJsonFile(filepath);
//                    System.out.print("Enter Customer Id to Display: ");
//                    int stud_id_display = scanner.nextInt();
//                    System.out.println(customers.get(stud_id_display-1).displayCustomer());
//                    break;
//                case 4:
//                    // customers = mc1.readJsonFile(filepath);
//                    for(int i = 0; i < customers.size(); i++)
//                    {
//                        System.out.println(customers.get(i).displayCustomer());
//                    }
//                    break;
//                case 5:
//                    System.out.print("Enter Customer Id to Delete: ");
//                    int cust_id_delete = scanner.nextInt();
//                    String customer_name = customers.get(cust_id_delete-1).getCustomer_name();
//                    System.out.println("Customer Deleted Name : "+customer_name);
//                    customers.remove(cust_id_delete-1);
//                    mapper.writeValue(Paths.get(filepath).toFile(), customers);
//                    break;
//                case 6:
//                    System.out.print("Enter Electronic_Device Name : ");
//                    String dev_name = scanner.nextLine();
//
//                    System.out.print("Enter Electronic Device Price: ");
//                    double price = scanner.nextDouble();
//
//                    System.out.print("Enter Electronic Device Wattage: ");
//                    int wattage = scanner.nextInt();
//
//                    System.out.print("Enter User Set Wattage: ");
//                    int usersetwattage = scanner.nextInt();
//
//                    System.out.print("Do you wish for a Electronic_Device Id in sequence or random (Type S for Sequence or Type R for Random): ");
//                    String seq_ran = scanner.next();
//
//                    int device_id = Electronic_Devices.size() + 1;
//
//                    if (seq_ran.equals("S")) {
//                        System.out.println("Sequence Chosen");
//                        Electronic_Device dev = new Electronic_Device(device_id,dev_name,price,wattage,usersetwattage);
//                        Electronic_Devices.add(dev);
//                    }
//                    else if(seq_ran.equals("R")) {
//                        System.out.println("Random Chosen");
//                        Electronic_Device dev = new Electronic_Device(dev_name,price,wattage,usersetwattage);
//                        Electronic_Devices.add(dev);
//                    }
//
//                    System.out.println("Electronic_Device created and added to the array.");
//                    break;
//                case 7:
//                    System.out.print("Enter Electronic_Device Id to Update: ");
//                    int id = scanner.nextInt();
//                    scanner.nextLine();
//                    int choice_to_change2;
//                    do {
//                        System.out.println("1. Change Device Name");
//                        System.out.println("2. Change Device Price");
//                        System.out.println("3. Change Device Wattage");
//                        System.out.println("4. Change user_set_wattage");
//                        System.out.println("5. Exit Update");
//
//                        System.out.print("Enter your choice: ");
//                        choice_to_change2 = scanner.nextInt();
//
//                        switch (choice_to_change2){
//                            case 1:
//                                scanner.nextLine();
//                                System.out.print("Enter Electronic_Device Name: ");
//                                System.out.print("Enter Electronic_Device Name: ");
//                                String name_update = scanner.nextLine();
//                                Electronic_Devices.get(id-1).setDevice_Name(name_update);
//                                mapper.writeValue(Paths.get("src/model/Electronic_Devices.json").toFile(), Electronic_Devices);
//                                break;
//                            case 2:
//
//                                System.out.print("Enter Electronic_Device price: ");
//                                double Device_Price = scanner.nextDouble();
//                                try {
//
//                                    if (Device_Price < 0) {
//                                        throw new IllegalArgumentException("Price cannot be negative");
//                                    }
//
//
//                                    System.out.println("Device price is: " + Device_Price);
//                                } catch (IllegalArgumentException e) {
//
//                                    System.out.println("Invalid input: " + e.getMessage());
//
//                                }
//                                Electronic_Devices.get(id-1).setDevice_Price(Device_Price);
//                                mapper.writeValue(Paths.get("src/model/Electronic_Devices.json").toFile(), Electronic_Devices);
//                                break;
//                            case 3:
//                                System.out.print("Enter Electronic Device Wattage: ");
//                                int Device_Wattage = scanner.nextInt();
//                                Electronic_Devices.get(id-1).setDevice_wattage(Device_Wattage);
//                                mapper.writeValue(Paths.get("src/model/Electronic_Devices.json").toFile(), Electronic_Devices);
//                                break;
//                            case 4:
//                                System.out.print("Enter User Set Wattage: ");
//                                int User_Set_Wattage = scanner.nextInt();
//                                try {
//
//
//                                    if (User_Set_Wattage > 500) {
//                                        throw new IllegalArgumentException("Overwattage!");
//                                    }
//
//
//                                    System.out.println("User Set Wattage is: " + User_Set_Wattage);
//                                } catch (IllegalArgumentException e) {
//
//                                    System.out.println("Invalid input: " + e.getMessage());
//
//                                }
//                                Electronic_Devices.get(id-1).setUser_set_wattage(User_Set_Wattage);
//                                mapper.writeValue(Paths.get("src/model/Electronic_Devices.json").toFile(), Electronic_Devices);
//                                break;
//                            default:
//                                System.out.println("Invalid choice. Try again.");
//                                break;
//                        }
//                    } while (choice_to_change2 != 5);
//                    break;
//                case 8:
//                    // Electronic_Devices = ms1.readJsonFile("src/model/Electronic_Devices.json); this d
//                    System.out.print("Enter Electronic_Device Id to Display: ");
//                    int device_id_display = scanner.nextInt();
//                    System.out.println(Electronic_Devices.get(device_id_display-1).displayElectronic_Device());
//                    break;
//                case 9:
//                    // Electronic_Devices = ms1.readJsonFile("src/model/Electronic_Devices.json");
//                    for(int i = 0; i < Electronic_Devices.size(); i++)
//                    {
//                        System.out.println(Electronic_Devices.get(i).displayDevice());
//                    }
//                    break;
//                case 10:
//                    System.out.print("Enter Electronic_Device Id to Delete: ");
//                    int device_id_delete = scanner.nextInt();
//                    String Electronic_Device = Electronic_Devices.get(device_id_delete-1).getDevice_Name();
//                    System.out.println("Electronic_Device Deleted Name : "+Electronic_Device);
//                    Electronic_Devices.remove(device_id_delete-1);
//                    mapper.writeValue(Paths.get("src/model/Electronic_Devices.json").toFile(), Electronic_Devices);
//                    break;
//                default:
//                    System.out.println("Invalid choice. Try again.");
//                    break;
//
//            }
//        } while (choice != 11);
//
//        scanner.close();
//    }
//    static boolean isValidEmail(String email_id) {
//        return email_id.matches("^[A-Za-z0-9]+@+[A-Za-z0-9]+\\.com$");
//    }
//}