package Model;

import java.util.ArrayList;

public class Course implements CourseDesc{
    /* Course attributes */
    private int id;
    private String course_name;
    private String course_desc;
    private int course_fees;
    private int course_duration_months;
    ArrayList<String> course_objectives;
    ArrayList<String> course_outcomes;

    public void setCourseId(int courseId) { this.id = courseId; }
    public void setCourseName(String course_name)
    {
        this.course_name = course_name;
    }

    public void setCourseDesc(String course_desc)
    {
        this.course_desc = course_desc;
    }

    public void setCourseFees(int course_fees)
    {
        this.course_fees = course_fees;
    }
    public void setCourseDurationMonths(int course_duration_months)
    {
        this.course_duration_months = course_duration_months;
    }

    public int getCourseId()
    {
        return this.id;
    }

    public String getCourseName()
    {
        return this.course_name;
    }

    public String getCourseDesc()
    {
        return this.course_desc;
    }

    public int getCourseFees()
    {
        return this.course_fees;
    }
    public int getCourseDurationMonths()
    {
        return this.course_duration_months;
    }

    public void display()
    {
        System.out.println("Course Id: "+this.getCourseId()+" ,Course Name :"+this.getCourseName()+" ,Course Description :"+this.getCourseDesc()+" ,Course Fees :"+this.getCourseFees()+" ,Course Duration :"+this.getCourseDurationMonths());
    }

    @Override
    public void addCourseObjectives(String objective) {
        this.course_objectives.add(objective);
    }

    @Override
    public void removeCourseObjectives(int objective_no) {
        this.course_objectives.remove(objective_no);
    }

    @Override
    public void displayCourseObjectives() {
        for (int i = 0; i < course_objectives.size(); i++) {
            System.out.println("Course Objective "+i+" : "+course_objectives.get(i));
        }
    }

    @Override
    public void addCourseOutcomes(String outcome) {
        this.course_outcomes.add(outcome);
    }

    @Override
    public void removeCourseOutcomes(int outcome_no) {
        this.course_outcomes.remove(outcome_no);
    }

    @Override
    public void displayCourseOutcomes() {
        for (int i = 0; i < course_outcomes.size(); i++) {
            System.out.println("Course Outcomes "+i+" : "+course_outcomes.get(i));
        }
    }
}
