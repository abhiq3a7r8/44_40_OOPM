import model.*;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Electronic_Device> Electronic_Devices = new ArrayList<Electronic_Device>();
        Scanner scanner = new Scanner(System.in);
        manageElectronic_Device ms1 = new manageElectronic_Device();
        Electronic_Devices = ms1.readJsonFile("src/Model/Electronic_Device.json");
        ObjectMapper mapper = new ObjectMapper();

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Create a Electronic_Device");
            System.out.println("2. Update a Electronic_Device");
            System.out.println("3. Display a Electronic_Device");
            System.out.println("4. Display All Electronic_Devices");
            System.out.println("5. Delete a Electronic_Devices");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Electronic_Device Name : ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Electronic Device Price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter Electronic Device Wattage: ");
                    int wattage = scanner.nextInt();

                    System.out.print("Enter User Set Wattage: ");
                    int usersetwattage = scanner.nextInt();

                    System.out.print("Do you wish for a Electronic_Device Id in sequence or random (Type S for Sequence or Type R for Random): ");
                    String seq_ran = scanner.next();

                    int device_id = Electronic_Devices.size() + 1;

                    if (seq_ran.equals("S")) {
                        System.out.println("Sequence Chosen");
                        Electronic_Device dev = new Electronic_Device(device_id,name,price,wattage,usersetwattage);
                        Electronic_Devices.add(dev);
                    }
                    else if(seq_ran.equals("R")) {
                        System.out.println("Random Chosen");
                        Electronic_Device dev = new Electronic_Device(name,price,wattage,usersetwattage);
                        Electronic_Devices.add(dev);
                    }

                    System.out.println("Electronic_Device created and added to the array.");
                    break;
                case 2:
                    System.out.print("Enter Electronic_Device Id to Update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    int choice_to_change;
                    do {
                        System.out.println("1. Change Device Name");
                        System.out.println("2. Change Device Price");
                        System.out.println("3. Change Device Wattage");
                        System.out.println("4. Change user_set_wattage");
                        System.out.println("5. Exit Update");

                        System.out.print("Enter your choice: ");
                        choice_to_change = scanner.nextInt();

                        switch (choice_to_change){
                            case 1:
                                scanner.nextLine();
                                System.out.print("Enter Electronic_Device Name: ");
                                System.out.print("Enter Electronic_Device Name: ");
                                String name_update = scanner.nextLine();
                                Electronic_Devices.get(id-1).setDevice_Name(name_update);
                                mapper.writeValue(Paths.get("src/model/Electronic_Devices.json").toFile(), Electronic_Devices);
                                break;
                            case 2:
                                System.out.print("Enter Electronic_Device price: ");
                                double Device_Price = scanner.nextDouble();
                                Electronic_Devices.get(id-1).setDevice_Price(Device_Price);
                                mapper.writeValue(Paths.get("src/model/Electronic_Devices.json").toFile(), Electronic_Devices);
                                break;
                            case 3:
                                System.out.print("Enter Electronic Device Wattage: ");
                                int Device_Wattage = scanner.nextInt();
                                Electronic_Devices.get(id-1).setDevice_wattage(Device_Wattage);
                                mapper.writeValue(Paths.get("src/model/Electronic_Devices.json").toFile(), Electronic_Devices);
                                break;
                            case 4:
                                System.out.print("Enter User Set Wattage: ");
                                int User_Set_Wattage = scanner.nextInt();
                                Electronic_Devices.get(id-1).setUser_set_wattage(User_Set_Wattage);
                                mapper.writeValue(Paths.get("src/model/Electronic_Devices.json").toFile(), Electronic_Devices);
                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                                break;
                        }
                    } while (choice_to_change != 5);
                    break;
                case 3:
                   // Electronic_Devices = ms1.readJsonFile("src/model/Electronic_Devices.json");
                    System.out.print("Enter Electronic_Device Id to Display: ");
                    int device_id_display = scanner.nextInt();
                    System.out.println(Electronic_Devices.get(device_id_display-1).displayElectronic_Device());
                    break;
                case 4:
                   // Electronic_Devices = ms1.readJsonFile("src/model/Electronic_Devices.json");
                    for(int i = 0; i < Electronic_Devices.size(); i++)
                    {
                        System.out.println(Electronic_Devices.get(i).display());
                    }
                    break;
                case 5:
                    System.out.print("Enter Electronic_Device Id to Delete: ");
                    int device_id_delete = scanner.nextInt();
                    String Electronic_Device = Electronic_Devices.get(device_id_delete-1).getDevice_Name();
                    System.out.println("Electronic_Device Deleted Name : "+Electronic_Device);
                    Electronic_Devices.remove(device_id_delete-1);
                    mapper.writeValue(Paths.get("src/model/Electronic_Devices.json").toFile(), Electronic_Devices);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }
}