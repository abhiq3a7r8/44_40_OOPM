package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class manageStudent extends fileHandlingStudent implements Displayable {
    ArrayList<Student> students = new ArrayList<Student>();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageStudent(){
        readJsonFile("src/Model/students.json");
    }

    public ArrayList<Student> readJsonFile(String file_path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file
            //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int id = node.get("id").asInt();
                    String name = node.get("name").asText();
                    long mobile_no = node.get("mobileNo").asLong();
                    String email = node.get("email").asText();
                    String gender = node.get("gender").asText();
                    String category = node.get("category").asText();
                    double per_10th = node.get("per_10th").asDouble();
                    double per_12th = node.get("per_10th").asDouble();
                    Student stud = new Student(id,name,mobile_no,email,gender,category,per_10th,per_12th);
                    students.add(stud);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public void writeJsonFile(ArrayList<Student> students) {
        ObjectMapper Obj = new ObjectMapper();
        try {

            for (int i = 0; i < students.size(); i++)
            {
                // Converting the Java object into a JSON string
                String stud_str = Obj.writeValueAsString(students.get(i));
                // Displaying Java object into a JSON string
                System.out.println(stud_str);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("Email");
        headers.add("Gender");
        headers.add("MobileNo");
        headers.add("Category");
        headers.add("10th Percentage");
        headers.add("12th/Diploma Percentage");

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
        ArrayList<String> student_details = new ArrayList<String>();

        student_details.add(String.valueOf(students.get(line).getId()));
        student_details.add(students.get(line).getName());
        student_details.add(students.get(line).getEmail());
        student_details.add(students.get(line).getGender());
        student_details.add(String.valueOf(students.get(line).getMobileNo()));
        student_details.add(students.get(line).getCategory());
        student_details.add(String.valueOf(students.get(line).getPer_10th()));
        student_details.add(String.valueOf(students.get(line).getPer_12_dip()));

        return student_details;
    }

    /*
    The getLines(int firstLine, int lastLine) method returns an ArrayList of ArrayList of String objects that represent a subset of rows
    of the table. The method takes two integer arguments firstLine and lastLine that specify the range of rows to retrieve.
    The method then iterates over this range and calls getLine(int line) for each row, adding the resulting ArrayList of attributes to a
    new ArrayList of ArrayList of String objects that is then returned.
     */
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> students_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            students_subset.add(getLine(i));
        }
        return students_subset;
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
        return students;
    }
}
