package Model;

/*THIS CLASS IS USED FOR THE MANY TO MANY RELATION
FORMED BETWEEN Brand AND Electronic_Device Class */

abstract class Brand {
    private String Brand_Name;



    public void setBrand_Name(String Brand_Name)
    {
        this.Brand_Name = Brand_Name;
    }
    public String getBrand_Name(){
        return(this.Brand_Name);
    }




}