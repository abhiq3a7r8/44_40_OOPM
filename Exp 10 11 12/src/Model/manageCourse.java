package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class manageCourse {
    ArrayList<Course> courses = new ArrayList<Course>();
    public ArrayList<Course> loadJsonFile(String file_path) {
        return readJsonFile(file_path);
    }
    public ArrayList<Course> readJsonFile(String file_path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file
            //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int id = node.get("id").asInt();
                    String course_name = node.get("course_name").asText();
                    String course_desc = node.get("course_desc").asText();
                    int course_fees = node.get("course_fees").asInt();
                    int course_duration_months = node.get("course_duration_months").asInt();
                    Course temp_course = new Course();
                    temp_course.setCourseId(id);
                    temp_course.setCourseName(course_name);
                    temp_course.setCourseDesc(course_desc);
                    temp_course.setCourseFees(course_fees);
                    temp_course.setCourseDurationMonths(course_duration_months);
                    courses.add(temp_course);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return courses;
    }
}
