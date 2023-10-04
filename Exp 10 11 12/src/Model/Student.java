package Model;
import java.lang.Math;
import java.util.Calendar;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Identification comments:
 *   Name: Richard Joseph
 *   Experiment No:
 *   Experiment Title:
 *   Experiment Date:
 *   @version 1.0
 *
 *
 * Beginning comments: 
 * Filename: Student.java
 * @author:  Richard Joseph
 * /*  Overview: This class is created to store the attributes of Student. It is a subclass of the class "Person" which inherits
some of the attributes from the Person class. And the class representing the "Person" object implements the interface named 
"Table Member".
 *
 * Attribute comments: 
 * id : Its Student Id
 * Name :
 * DOB : 
 *
 *
 */

public class Student extends Person {

    /* Student attributes */
    private double per_10th;
    private double per_12_dip;

    public Student(int Id, String name, long mobile_no, String email, String gender, String category, double per_10th, double per_12_dip)
    {
        super(Id,name,mobile_no,email,gender,category);
        setPer_10th(per_10th);
        setPer_12_dip(per_12_dip);
    }

    public Student(String name, long mobile_no, String email, String gender, String category, double per_10th, double per_12_dip)
    {
        super(name, mobile_no, email, gender, category);
        setPer_10th(per_10th);
        setPer_12_dip(per_12_dip);
    }

    public void setPer_10th(double per_10th)
    {
        this.per_10th = per_10th;
    }

    public void setPer_12_dip(double per_12_dip)
    {
        this.per_12_dip = per_12_dip;
    }

    public double getPer_10th()
    {
        return this.per_10th;
    }

    public double getPer_12_dip()
    {
        return this.per_12_dip;
    }

    public String displayStudent()
    {
        return display() +" ,10th Percentage :"+this.getPer_10th()+" ,12th Percentage :"+this.getPer_12_dip();
    }

}
