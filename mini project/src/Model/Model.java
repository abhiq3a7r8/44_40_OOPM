package Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Model {
    protected manageElectronic_Device manageElectronicDeviceData = new manageElectronic_Device();
    public manageCustomer manageCustomerData = new manageCustomer();
    private ObjectMapper mapper = new ObjectMapper();

    public Model() {
        manageElectronicDeviceData.setLinesBeingDisplayed(25);
        manageElectronicDeviceData.setFirstLineToDisplay(0);
        manageCustomerData.setLinesBeingDisplayed(25);
        manageCustomerData.setFirstLineToDisplay(0);
    }

    public manageElectronic_Device getManageElectronicDeviceData() {
        return manageElectronicDeviceData;
    }

    public manageCustomer getManageCustomerData() {
        return manageCustomerData;
    }


}
