package model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


//public class manageElectronic_Device {
//
//    public ArrayList<Electronic_Device> readJsonFile(String s) {
//        return null;
//    }

    public class manageElectronic_Device extends filehandlingElectronic_Device {
        ArrayList<Electronic_Device> Electronic_Devices = new ArrayList<Electronic_Device>();
        /*publicArrayList<Electronic_Device loadJsonFile(String file_path) {
            return readJsonFile(file_path);
        }*/
        public ArrayList<Electronic_Device> readJsonFile(String file_path) {
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                // Read JSON file
                //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
                JsonNode rootNode = objectMapper.readTree(new File(file_path));

                // Iterate through JSON array
                if (rootNode.isArray()) {
                    for (JsonNode node : rootNode) {
                        int id = node.get("id").asInt();
                        String device_Name = node.get("device_Name").asText();
                        int device_price = node.get("device_Price").asInt();
                        int device_wattage = node.get("device_wattage").asInt();
                        int user_set_wattage = node.get("user_set_wattage").asInt();
                        Electronic_Device dev = new Electronic_Device(id,device_Name,device_price,device_wattage,user_set_wattage);
                        Electronic_Devices.add(dev);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return Electronic_Devices;
        }

        @Override
        public void writeJsonFile(ArrayList<Electronic_Device> Electronic_Device) {
            ObjectMapper Obj = new ObjectMapper();
            try {

                for (int i = 0; i < Electronic_Devices.size(); i++)
                {
                    // Converting the Java object into a JSON string
                    String dev_str = Obj.writeValueAsString(Electronic_Devices.get(i));
                    // Displaying Java object into a JSON string
                    System.out.println(dev_str);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

