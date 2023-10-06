package Model;

public class Device {
    private int id;
    private String device_Name;
    private double device_Price;

    private int device_wattage;
    public Device(int id,String device_Name, double device_Price, int device_wattage){
        setId(id);
        setDevice_Name(device_Name);
        setDevice_Price(device_Price);
        setDevice_wattage(device_wattage);
    }
    public Device(String device_Name, double device_Price, int device_wattage){
        int id =(int) Math.random();
        System.out.println("Student Created with Id: "+ id);
        setDevice_Name(device_Name);
        setDevice_Price(device_Price);
        setDevice_wattage(device_wattage);
    }

    public void setId(int id) {
        this.id = id;
    }

    public  void setDevice_wattage(int device_wattage){
        this.device_wattage = device_wattage;
    }

    public void setDevice_Name(String device_Name){
        this.device_Name=device_Name;
    }
    public void setDevice_Price(double Price) {
        this.device_Price = Price;
    }

            /* GETTER FUNCTIONS TO FETCH THE VALUES OF CLASS VARIABLES
            WHEN THE RESPECTIVE FUNCTION IS CALLED */

    public int getId() {
        return id;
    }
    public String getDevice_Name(){
        return this.device_Name;
    }
    public double getDevice_Price(){
        return this.device_Price;
    }

    public int getDevice_wattage(){
        return this.device_wattage;
    }
    final public String displayDevice()
    {
        return ("id : "+getId()+" device_name : "+getDevice_Name()+ " device_Price : "+getDevice_Price()+ " device_wattage : "+getDevice_wattage() );
    }
}