import Controller.Controller;
import Model.*;
import View.View;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
    }
}