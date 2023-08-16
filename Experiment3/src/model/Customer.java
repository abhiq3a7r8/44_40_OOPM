package model;
import java.util.Date;
import java.util.Locale;

public class Customer {

    private int customer_id;
    private String customer_name;
    private String phone_no;
    private String email_id;
    private String gender;                                  //change


    public void setCustomer_id(int customer_id){
        this.customer_id = customer_id;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
//EMAIL ID REFERENCE
    public void setEmail_id(String email_id){this.email_id = email_id.toLowerCase();}  //Lowercase
    public void setGender(String gender){this.gender = gender;}

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
}
