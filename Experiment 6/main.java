import model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.io.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Customer> customers = new ArrayList<Customer>();
        Scanner scanner = new Scanner(System.in);
        manageCustomer mc1 = new manageCustomer();
        customers = mc1.readJsonFile("C:\\OOPMISTIC\\src\\model\\customers.json");
        ObjectMapper mapper = new ObjectMapper();
        String filepath = "C:\\OOPMISTIC\\src\\model\\customers.json";

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Create a Customer");
            System.out.println("2. Update a Customer");
            System.out.println("3. Display a Customer");
            System.out.println("4. Display All Customer");
            System.out.println("5. Delete a Customer");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Phone No: ");
                    String phone_no = scanner.next();

                    System.out.print("Enter Email Id: ");
                    String email_id = scanner.next();

                    System.out.print("Enter Gender(male or female): ");
                    String gender = scanner.next();

                    System.out.print("Do you want to apply for Extended warranty Duration? (Y/N): ");
                    String extendedwstat = scanner.next();

                    int currentCustomerCount = customers.size() + 1;

                    if (extendedwstat.equalsIgnoreCase("Y")){
                        int upperBound = (int) Math.pow(10,1);
                        Random rduration = new Random();
                        int extended_warranty_duration = rduration.nextInt(upperBound);
                        Customer newCustomer = new Customer(currentCustomerCount,gender,name,phone_no,email_id,extended_warranty_duration);
                        customers.add(newCustomer);
                    }

                    else if (extendedwstat.equalsIgnoreCase("N")){
                        Customer newCustomer = new Customer(currentCustomerCount,gender,name,phone_no,email_id);
                        customers.add(newCustomer);
                    }

                    System.out.println("Customer created and added to the array.");
                    break;
                case 2:
                    System.out.print("Enter Student Id to Update: ");
                    int cust_id = scanner.nextInt();
                    scanner.nextLine();
                    int choice_to_change;
                    do {
                        System.out.println("1. Change Customer Name");
                        System.out.println("2. Change Phone No");
                        System.out.println("3. Change Email Id");
                        System.out.println("4. Change Gender");
                        System.out.println("5. Exit Update");

                        System.out.print("Enter your choice: ");
                        choice_to_change = scanner.nextInt();

                        switch (choice_to_change){
                            case 1:
                                scanner.nextLine();
                                System.out.print("Enter Customer Name: ");
                                System.out.print("Enter Customer Name: ");
                                String name_update = scanner.nextLine();
                                customers.get(cust_id-1).setCustomer_name(name_update);
                                mapper.writeValue(Paths.get(filepath).toFile(), customers);
                                break;
                            case 2:
                                System.out.print("Enter Phone No: ");
                                String mobile_no_update = scanner.next();
                                customers.get(cust_id-1).setPhone_no(mobile_no_update);
                                mapper.writeValue(Paths.get(filepath).toFile(), customers);
                                break;
                            case 3:
                                System.out.print("Enter Email Id: ");
                                String email_update = scanner.next();
                                customers.get(cust_id-1).setEmail_id(email_update);
                                mapper.writeValue(Paths.get(filepath).toFile(), customers);
                                break;
                            case 4:
                                System.out.print("Enter Gender: ");
                                String gender_update = scanner.next();
                                customers.get(cust_id-1).setGender(gender_update);
                                mapper.writeValue(Paths.get(filepath).toFile(), customers);
                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                                break;
                        }
                    } while (choice_to_change != 5);
                    break;
                case 3:
                    customers = mc1.readJsonFile(filepath);
                    System.out.print("Enter Customer Id to Display: ");
                    int stud_id_display = scanner.nextInt();
                    System.out.println(customers.get(stud_id_display-1).displayCustomer());
                    break;
                case 4:
                    customers = mc1.readJsonFile(filepath);
                    for(int i = 0; i < customers.size(); i++)
                    {
                        System.out.println(customers.get(i).displayCustomer());
                    }
                    break;
                case 5:
                    System.out.print("Enter Customer Id to Delete: ");
                    int cust_id_delete = scanner.nextInt();
                    String customer_name = customers.get(cust_id_delete-1).getCustomer_name();
                    System.out.println("Customer Deleted Name : "+customer_name);
                    customers.remove(cust_id_delete-1);
                    mapper.writeValue(Paths.get(filepath).toFile(), customers);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }
}
