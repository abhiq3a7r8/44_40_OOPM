package Model;

public interface CourseDesc {

    void addCourseObjectives(String objective);

    void removeCourseObjectives(int objective_no);
    void displayCourseObjectives();
    void addCourseOutcomes(String outcome);
    void removeCourseOutcomes(int outcome_no);
    void displayCourseOutcomes();
}
