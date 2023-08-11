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


        //SETTER FUNCTIONS TO SET THE VALUES OF RESPECTIVE CLASS VARIABLES

        public void setCustomer_id(int customer_id){
            this.customer_id = customer_id;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public void setPhone_no(String phone_no) {
            this.phone_no = phone_no;
        }


        /* GETTER FUNCTIONS TO FETCH THE VALUES OF CLASS VARIABLES
        WHEN THE RESPECTIVE FUNCTION IS CALLED */

        public int getCustomer_id() {
            return this.customer_id;
        }

        public String getCustomer_name() {
            return this.customer_name;
        }

        public String getPhone_no() {
            return this.phone_no;
        }

    }
