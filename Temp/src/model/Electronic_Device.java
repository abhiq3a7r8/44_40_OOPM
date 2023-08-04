package model;

      //DEFINE CLASS ATTRIBUTES WITH THEIR DATA TYPES
      
      public class Electronic_Device {
            private String device_Name;
            private double device_Price;

            //SETTER FUNCTIONS TO SET THE VALUES OF RESPECTIVE CLASS VARIABLES


            public void setDevice_Name(String device_Name){
                  this.device_Name=device_Name;
            }
            public void setDevice_Price(int Price) {
                  this.device_Price = Price;
            }

            /* GETTER FUNCTIONS TO FETCH THE VALUES OF CLASS VARIABLES
            WHEN THE RESPECTIVE FUNCTION IS CALLED */

            public String getDevice_Name(){
                  return this.device_Name;
            }
            public double getDevice_Price(){
                  return this.device_Price;
            }


}
