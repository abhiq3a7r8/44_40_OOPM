package Model;

import java.util.Calendar;
import java.util.Date;

public class Person {
    private int id;
    private String name;
    private long mobileNo;
    private String email;
    private String gender;
    private String category;

    public Person(int Id, String name, long mobile_no, String email, String gender, String category)
    {
        setId(Id);
        setName(name);
        setMobileNo(mobile_no);
        setEmail(email);
        setGender(gender);
        setCategory(category);
    }

    public Person(String name, long mobile_no, String email, String gender, String category)
    {
        int Id = (int) Math.random();
        System.out.println("Student Created with Id: "+ Id);
        setId(Id);
        setName(name);
        setMobileNo(mobile_no);
        setEmail(email);
        setGender(gender);
        setCategory(category);
    }

    public void setId(int id) { this.id = id; }
    public void setName(String name)
    {
        this.name = name;
    }


    public void setMobileNo(long mobile_no)
    {
        this.mobileNo = mobile_no;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    public void setCategory(String category)
    {
        this.category = category;
    }

    public int getId()
    {
        return this.id;
    }
    public String getName()
    {
        return this.name;
    }

    public long getMobileNo()
    {
        return this.mobileNo;
    }
    public String getEmail() { return this.email; }

    public String getGender()
    {
        return this.gender;
    }
    public String getCategory()
    {
        return this.category;
    }

    final public String display()
    {
        return ("id : "+getId()+ " Name : "+getName()+ " Mobile No  : "+getMobileNo()+ " Email : "+getEmail()+ " Gender : "+getGender()+ " Category : "+getCategory());
    }
}
