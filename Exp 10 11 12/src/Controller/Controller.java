package Controller;

import Model.Model;
import View.View;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Controller {
    Model model;
    View view;

    public Controller(Model m, View v) {
        model = m;
        view = v;
        view.centerInitialSetup(model.getManageStudentData().getLinesBeingDisplayed(), model.getManageStudentData().getHeaders().size());
        view.centerUpdate(model.getManageStudentData().getLines(model.getManageStudentData().getFirstLineToDisplay(), model.getManageStudentData().getLastLineToDisplay()), model.getManageStudentData().getHeaders());
        addScrolling();
    }

    private void addScrolling()
    {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getManageStudentData().getFirstLineToDisplay();
                int current_last_line = model.getManageStudentData().getLastLineToDisplay();
                int no_of_players = model.getManageStudentData().getTable().size();
                int no_of_display_lines = model.getManageStudentData().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getManageStudentData().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getManageStudentData().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getManageStudentData().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_players-1)
                {
                    model.getManageStudentData().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_players-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_players - no_of_display_lines)
                    {
                        new_first_line = no_of_players-no_of_display_lines;
                        model.getManageStudentData().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getManageStudentData().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdate(model.getManageStudentData().getLines(model.getManageStudentData().getFirstLineToDisplay(), model.getManageStudentData().getLastLineToDisplay()), model.getManageStudentData().getHeaders());
            }
        });
    }
}
