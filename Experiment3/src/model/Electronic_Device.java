package model;

      //DEFINE CLASS ATTRIBUTES WITH THEIR DATA TYPES
      
      public class Electronic_Device {






            private String device_Name;
            private double device_Price;

            private int device_wattage;

            private int user_set_wattage;

            //SETTER FUNCTIONS TO SET THE VALUES OF RESPECTIVE CLASS VARIABLES

            public void setUser_set_wattage(int user_set_wattage){
                  this.user_set_wattage = user_set_wattage;
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

            public String getDevice_Name(){
                  return this.device_Name;
            }
            public double getDevice_Price(){
                  return this.device_Price;
            }

            public int getDevice_wattage(){
                  return this.device_wattage;
            }
            public int getUser_set_wattage(){
                  return this.user_set_wattage;
            }




      }
