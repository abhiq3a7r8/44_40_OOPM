package model;

public class purchases {
      
      //DECLARE THREE INSTANCE VARIABLES OF EACH CLASS
      
      Electronic_Device objDev;
      Customer objCust;
      Brand objBrand;
      
      // METHOD TO SET THE REFERENCES TO THE ELECTRONIC_DEVICE, CUSTOMER, AND BRAND OBJECTS

      public void purchases_objDev_objCust(Electronic_Device tempDev, Customer tempCust,Brand tempBrand)
      {
            objDev = tempDev;
            objCust = tempCust;
            objBrand = tempBrand;
      }

      // METHOD TO DISPLAY THE PURCHASE DETAILS, INCLUDING THE CUSTOMER'S INFORMATION AND THE PURCHASED ELECTRONIC_DEVICE

      public void display_ELectronic_Device_Customer()
      {
          System.out.println("Customer_id:"+this.objCust.getCustomer_id()+" Mr."+this.objCust.getCustomer_name()+" (Phone no:"+this.objCust.getPhone_no()+") has purchased a "+this.objBrand.getBrand_Name()+" "+this.objDev.getDevice_Name()+" worth Rs. "+this.objDev.getDevice_Price());
      }

}
