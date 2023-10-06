package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class manageElectronic_Device extends filehandlingElectronic_Device implements Displayable {
    ArrayList<Electronic_Device> Electronic_Device = new ArrayList<Electronic_Device>();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageElectronic_Device(){
        readJsonFile("src/Model/Electronic_Device.json");
    }

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

                    Electronic_Device dev = new Electronic_Device(id, device_Name, device_price, device_wattage, user_set_wattage);
                    Electronic_Device.add(dev);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return Electronic_Device;
    }

    @Override
    public void writeJsonFile(ArrayList<Electronic_Device> Electronic_Device) {
        ObjectMapper Obj = new ObjectMapper();
        try {

            for (int i = 0; i < Electronic_Device.size(); i++)
            {
                // Converting the Java object into a JSON string
                String dev_str = Obj.writeValueAsString(Electronic_Device.get(i));
                // Displaying Java object into a JSON string
                System.out.println(dev_str);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Device Name");
        headers.add("Price");
        headers.add("Device Wattage");
        headers.add("User Set Wattage");
        return headers;
    }

    /*
    The getLine(int line) method returns an ArrayList of String objects that represent a single row of the table.
    The method takes an integer argument line that specifies which row to retrieve. The method retrieves the FootballPlayer object
    at the specified index in the Electronic_Device list and then extracts the various attributes of the Electronic_Device such as their name, height, weight,
    etc. These attributes are then added to the ArrayList and returned.
     */
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> Electronic_Device_details = new ArrayList<String>();

        Electronic_Device_details.add(String.valueOf(Electronic_Device.get(line).getId()));
        Electronic_Device_details.add(Electronic_Device.get(line).getDevice_Name());
        Electronic_Device_details.add(String.valueOf(Electronic_Device.get(line).getDevice_Price()));
        Electronic_Device_details.add(String.valueOf(Electronic_Device.get(line).getDevice_wattage()));
        Electronic_Device_details.add(String.valueOf(Electronic_Device.get(line).getUser_set_wattage()));

        return Electronic_Device_details;
    }

    /*
    The getLines(int firstLine, int lastLine) method returns an ArrayList of ArrayList of String objects that represent a subset of rows
    of the table. The method takes two integer arguments firstLine and lastLine that specify the range of rows to retrieve.
    The method then iterates over this range and calls getLine(int line) for each row, adding the resulting ArrayList of attributes to a
    new ArrayList of ArrayList of String objects that is then returned.
     */
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> Electronic_Device_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            Electronic_Device_subset.add(getLine(i));
        }
        return Electronic_Device_subset;
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
        return Electronic_Device;
    }
}
