package Model;

public class Individual{

    protected  String customer_name;
    protected String phone_no;
    protected String email_id;
    protected String gender;



    public Individual(String gender,String name,String phone_no,String email_id){
        setGender(gender);
        setCustomer_name(name);
        setPhone_no(phone_no);
        setEmail_id(email_id);
    }

    public Individual() {

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

    final public String displayIndividual()
    {
        return (" Customer Name : "+getCustomer_name()+ " Phone No  : "+getPhone_no()+ " Email ID : "+getEmail_id()+ " Gender : "+getGender());
    }
}