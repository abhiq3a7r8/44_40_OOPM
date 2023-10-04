package Model;

import java.util.ArrayList;

public class Model
{
    protected manageStudent manageStudentData = new manageStudent();

    public Model()
    {
        manageStudentData.setLinesBeingDisplayed(25);
        manageStudentData.setFirstLineToDisplay(0);
    }

    public manageStudent getManageStudentData()
    {
        return manageStudentData;
    }
}
