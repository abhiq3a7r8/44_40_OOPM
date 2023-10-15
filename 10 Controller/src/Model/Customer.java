package Model;


import java.util.ArrayList;

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

public class Customer extends Individual implements Customer_dsc {

    //DEFINE CLASS ATTRIBUTES WITH THEIR DATA TYPES

    private int customer_id;

    private int extended_warranty_duration;
    ArrayList<String> cart;


    public Customer(int currentcustomercount, String gender, String name, String phone_no, String email_id, int extended_warranty_duration) {
        super(gender, name, phone_no, email_id);
        setCustomer_id(currentcustomercount);
        setExtended_warranty_duration(extended_warranty_duration);
    }

    public Customer(int currentcustomercount, String gender, String name, String phone_no, String email_id) {
        super(gender, name, phone_no, email_id);
        setCustomer_id(currentcustomercount);
        setExtended_warranty_duration(0);
    }


    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setExtended_warranty_duration(int extended_warranty_duration) {
        this.extended_warranty_duration = extended_warranty_duration;
    }


        /* GETTER FUNCTIONS TO FETCH THE VALUES OF CLASS VARIABLES
        WHEN THE RESPECTIVE FUNCTION IS CALLED */

    public int getCustomer_id() {
        return this.customer_id;
    }

    public int getExtended_warranty_duration() {
        return this.extended_warranty_duration;
    }


    public void addToCart(String product) {
        cart.add(product);
        System.out.println(super.getCustomer_name() + " added to cart.");
    }

    public void removeFromCart(String product) {
        cart.remove(product);
        System.out.println(super.getCustomer_name() + " removed from cart.");
    }

    public void viewCart() {
        System.out.println("Items in cart:");
        for (String product : cart) {
            System.out.println("- " + super.getCustomer_name());
        }

    }

    public String displayCustomer() {
        return displayIndividual() + this.getCustomer_id() + this.getExtended_warranty_duration();
    }
}   