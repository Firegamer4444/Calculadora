package dad.calculadora;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculadoraApplication extends Application {

    private final CalculadoraController calculadoraController = new CalculadoraController();

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(calculadoraController.getRoot());

        stage.setScene(scene);
        stage.setTitle("Calculadora");
        stage.show();
    }
}
