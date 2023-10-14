package Model;

public class Model
{
    protected manageElectronic_Device manageElectronicDeviceData = new manageElectronic_Device();
    protected manageCustomer manageCustomerData = new manageCustomer();

    public Model()
    {
        manageElectronicDeviceData.setLinesBeingDisplayed(25);
        manageElectronicDeviceData.setFirstLineToDisplay(0);
        manageCustomerData.setLinesBeingDisplayed(25);
        manageCustomerData.setFirstLineToDisplay(0);
    }

    public manageElectronic_Device getManageElectronicDeviceData()
    {
        return manageElectronicDeviceData;
    }
    public manageCustomer getManageCustomerData(){
        return manageCustomerData;
    }
}
