package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class manageCustomer extends filehandlingcustomer implements Displayable {
    ArrayList<Customer> customers = new ArrayList<Customer>();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageCustomer(){
        readJsonFile("C:\\OOPMISTIC\\10 Controller\\src\\model\\customers.json");
    }

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

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("MobileNo");
        headers.add("Email");
        headers.add("Gender");



        return headers;
    }

    /*
    The getLine(int line) method returns an ArrayList of String objects that represent a single row of the table.
    The method takes an integer argument line that specifies which row to retrieve. The method retrieves the FootballPlayer object
    at the specified index in the students list and then extracts the various attributes of the student such as their name, height, weight,
    etc. These attributes are then added to the ArrayList and returned.
     */
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> Customer_details = new ArrayList<String>();

        Customer_details.add(String.valueOf(customers.get(line).getCustomer_id()));
        Customer_details.add(customers.get(line).getCustomer_name());
        Customer_details.add(String.valueOf(customers.get(line).getCustomer_name()));
        Customer_details.add(customers.get(line).getEmail_id());
        Customer_details.add(customers.get(line).getGender());



        return Customer_details;
    }

    /*
    The getLines(int firstLine, int lastLine) method returns an ArrayList of ArrayList of String objects that represent a subset of rows
    of the table. The method takes two integer arguments firstLine and lastLine that specify the range of rows to retrieve.
    The method then iterates over this range and calls getLine(int line) for each row, adding the resulting ArrayList of attributes to a
    new ArrayList of ArrayList of String objects that is then returned.
     */
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> Customes_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            Customes_subset.add(getLine(i));
        }
        return Customes_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        linesBeingDisplayed = numberOfLines;
    }

    public ArrayList getTable() {
        return customers;
    }
}
