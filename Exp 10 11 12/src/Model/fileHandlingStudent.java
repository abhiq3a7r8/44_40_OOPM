package Model;

import java.util.ArrayList;

abstract class fileHandlingStudent {

    String student_parent_email;
    abstract public ArrayList<Student> readJsonFile(String file_path);
    abstract public void writeJsonFile(ArrayList<Student> students);
    //public void readCSVFile(String file_path);
    //public void readXMLFile(String file_path);

}
