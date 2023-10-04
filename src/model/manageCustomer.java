package model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class manageCustomer extends filehandlingcustomer {
    ArrayList<Customer> customers = new ArrayList<Customer>();
    /*public ArrayList<Student> loadJsonFile(String file_path) {
        return readJsonFile(file_path);
    }*/
    public ArrayList<Customer> readJsonFile(String file_path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file
            //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int currentCustomerCount = node.get("id").asInt();
                    String name = node.get("first_name").asText();
                    String phone_no = node.get("phone no").asText();
                    String email_id = node.get("email").asText();
                    String gender = node.get("gender").asText();
                    int extended_warranty_duration = node.get("wxtw").asInt();
                    Customer newCustomer = new Customer(currentCustomerCount,gender,name,phone_no,email_id,extended_warranty_duration);
                    customers.add(newCustomer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }

    @Override
    public void writeJsonFile(ArrayList<Customer> customers) {
        ObjectMapper Obj = new ObjectMapper();
        try {
            for (int i = 0; i < customers.size(); i++) {
                // Create a JSON object with the original field names
                ObjectNode jsonNode = Obj.createObjectNode();
                Customer customer = customers.get(i);

                // Map customer properties to original field names
                jsonNode.put("id", customer.getCustomer_id());
                jsonNode.put("first_name", customer.getCustomer_name());
                jsonNode.put("phone no", customer.getPhone_no());
                jsonNode.put("email", customer.getEmail_id());
                jsonNode.put("gender", customer.getGender());
                jsonNode.put("wxtw", customer.getExtended_warranty_duration());

                // Convert the JSON object to a JSON string and print it
                String cust_str = Obj.writeValueAsString(jsonNode);
                System.out.println(cust_str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
