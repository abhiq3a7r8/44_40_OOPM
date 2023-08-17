package model;


    /**
     * Identification comments:
     *   Name1: Abhirat More
     *   Name2: Akshat Mahajan
     *   Experiment No: 1
     *   Experiment Title: 
     *   Experiment Date: 28.07.2023
     *   @version 1.0
     *
     *
     * Beginning comments: 
     * Filename: Customer.java
     * author:  Akshat Mahajan, Abhirat More
     * /*  Overview: This class is created to store the attributes of Customer. It is a subclass of the class "Person" which inherits
    some of the attributes from the Person class. And the class representing the "Person" object implements the interface named 
    "Table Member".
    *  Attribute comments: 
    *  customer_id: customer ID
    *  customer_name
    *  phone_no 
    *  pincode
    *  purchase_date
    */
    
    public class Customer {
        
        //DEFINE CLASS ATTRIBUTES WITH THEIR DATA TYPES

        private int customer_id;
        private String customer_name;
        private String phone_no;
        private String email_id;
        private String gender;
        private int extended_warranty_duration;




        public void customerinfo(int currentcustomercount,String gender,String name,String phone_no,String email_id,int extended_warranty_duration){
            setCustomer_id(currentcustomercount);
            setGender(gender);
            setCustomer_name(name);
            setPhone_no(phone_no);
            setEmail_id(email_id);
            setExtended_warranty_duration(extended_warranty_duration);
        }

        public void customerinfo(int currentcustomercount,String gender,String name,String phone_no,String email_id){
            setCustomer_id(currentcustomercount);
            setGender(gender);
            setCustomer_name(name);
            setPhone_no(phone_no);
            setEmail_id(email_id);
            setExtended_warranty_duration(0);
        }


        public void setCustomer_id(int customer_id){
            this.customer_id = customer_id;
        }
        public void setEmail_id(String email_id){
            this.email_id = email_id.toLowerCase();
        }

        public void setGender(String gender){
            this.gender = gender;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public void setPhone_no(String phone_no) {
            this.phone_no = phone_no;
        }
        public void setExtended_warranty_duration(int extended_warranty_duration) {
            this.extended_warranty_duration = extended_warranty_duration;
        }


        /* GETTER FUNCTIONS TO FETCH THE VALUES OF CLASS VARIABLES
        WHEN THE RESPECTIVE FUNCTION IS CALLED */

        public int getCustomer_id() {
            return this.customer_id;
        }

        public String getCustomer_name() {
            String fullName = customer_name;
            if (gender != null && gender.equalsIgnoreCase("male")) {
                fullName = "Mr. ".concat(fullName);                               //Concat+equals
            }
            else if (gender != null && gender.equalsIgnoreCase("female")) {
                fullName = "Mrs. ".concat(fullName);                             //concat+equals
            }
            return fullName;
        }


        public String getPhone_no() {
            return this.phone_no;
        }
        public String getEmail_id(){
            return this.email_id.toLowerCase();
        }
        public String getGender(){
            return this.gender;
        }

        public int getExtended_warranty_duration(){
            return this.extended_warranty_duration;
        }

    }
