package Model;

public class purchases {

      //DECLARE THREE INSTANCE VARIABLES OF EACH CLASS

      Electronic_Device objDev;
      Customer objCust;
      Brand objBrand;

      // METHOD TO SET THE REFERENCES TO THE ELECTRONIC_DEVICE, CUSTOMER, AND BRAND OBJECTS

      public void purchases_objDev_objCust(Electronic_Device tempDev, Customer tempCust, Brand tempBrand) {
            objDev = tempDev;
            objCust = tempCust;
            objBrand = tempBrand;
      }

      // METHOD TO DISPLAY THE PURCHASE DETAILS, INCLUDING THE CUSTOMER'S INFORMATION AND THE PURCHASED ELECTRONIC_DEVICE

      public void display_ELectronic_Device_Customer()
      {
            System.out.println("User: " +this.objCust.getCustomer_name() +" has purchased a "+this.objDev.getDevice_Name() +" of brand: "+ this.objBrand.getBrand_Name()+ " worth: "+ this.objDev.getDevice_Price());
      }

      public void dispay_powerstatus(int difference)
      {
            System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s",this.objCust.getCustomer_name(),this.objBrand.getBrand_Name(),this.objDev.getDevice_Name(),"over",difference+"Kwh "));
      }

      public void dispay_powerstatus()
      {
            System.out.println(String.format("%-15s%-15s%-15s%-15s",this.objCust.getCustomer_name(),this.objBrand.getBrand_Name(),this.objDev.getDevice_Name(),"OK"));
      }

}