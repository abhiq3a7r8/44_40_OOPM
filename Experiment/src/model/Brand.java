package model;

/*THIS CLASS IS USED FOR THE MANY TO MANY RELATION 
FORMED BETWEEN Brand AND Electronic_Device Class */

public class Brand {
    private String Brand_Name;
    


    public void setBrand_Name(String Name)
    {
        this.Brand_Name=Name;
    }
    public String getBrand_Name(){
        return(this.Brand_Name);
    }
}
