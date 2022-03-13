package calculator;

import controller.CalcController;
import model.CalcModel;
import view.CalcView;

// Clasa ce instantiaza cele 3 componente ale calculatorului si permite rularea aplicatiei
public class CalcMVC {
    public static void main(String[] args) {
        CalcModel model = new CalcModel();
        CalcView view = new CalcView(model);
        CalcController controller = new CalcController(model, view);
        view.setVisible(true);
    }
}
