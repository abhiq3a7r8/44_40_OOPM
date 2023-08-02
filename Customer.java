package Model;
import java.util.Date;

public class Customer {

    private int customer_id;
    private String customer_name;
    private long phone_no;
    private long pincode;
    private Date purchase_date;



    public void setCustomer_id(int customer_id){
        this.customer_id = customer_id;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setPhone_no(long phone_no) {
        this.phone_no = phone_no;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }


    public int getCustomer_id() {
        return this.customer_id;
    }

    public String getCustomer_name() {
        return this.customer_name;
    }

    public long getPhone_no() {
        return this.phone_no;
    }

    public long getPincode() {
        return this.pincode;
    }
    //test commit
    public Date getPurchase_date() {
        return purchase_date;
    }
}
