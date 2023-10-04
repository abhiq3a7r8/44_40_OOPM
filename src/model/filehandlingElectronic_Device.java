package model;
import java.util.ArrayList;

abstract class filehandlingElectronic_Device {
    abstract public ArrayList<Electronic_Device> readJsonFile(String file_path);
    abstract public void writeJsonFile(ArrayList<Electronic_Device> students);
}
