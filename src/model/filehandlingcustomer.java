package model;

import java.util.ArrayList;

abstract class filehandlingcustomer {

    String student_parent_email;
    abstract public ArrayList<Customer> readJsonFile(String file_path);
    abstract public void writeJsonFile(ArrayList<Customer> students);
    //public void readCSVFile(String file_path);
    //public void readXMLFile(String file_path);

}
