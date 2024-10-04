package dad.calculadora;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable {

    // model

    private final Calculadora calculadora = new Calculadora();
    private final StringProperty pantalla = calculadora.getPantalla();

    // view

    @FXML
    private TextField resultTextField;

    @FXML
    private GridPane root;

    public CalculadoraController(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalculadoraView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // bindings

        resultTextField.textProperty().bind(pantalla);

    }

    public GridPane getRoot(){
        return root;
    }

    @FXML
    void onAddAction(ActionEvent event) {
        calculadora.operar(Calculadora.SUMAR);
    }

    @FXML
    void onClearAction(ActionEvent event) {
        calculadora.borrarTodo();
    }

    @FXML
    void onClearAllAction(ActionEvent event) {
        calculadora.borrar();
    }

    @FXML
    void onDivideAction(ActionEvent event) {
        calculadora.operar('/');
    }

    @FXML
    void onDotAction(ActionEvent event) {
        calculadora.insertarComa();
    }

    @FXML
    void onEightAction(ActionEvent event) {
        calculadora.insertar('8');
    }

    @FXML
    void onEqualsAction(ActionEvent event) {
        calculadora.operar(Calculadora.IGUAL);
    }

    @FXML
    void onFiveAction(ActionEvent event) {
        calculadora.insertar('5');
    }

    @FXML
    void onFourAction(ActionEvent event) {
        calculadora.insertar('4');
    }

    @FXML
    void onMultiplyAction(ActionEvent event) {
        calculadora.operar(Calculadora.MULTIPLICAR);
    }

    @FXML
    void onNineAction(ActionEvent event) {
        calculadora.insertar('9');
    }

    @FXML
    void onOneAction(ActionEvent event) {
        calculadora.insertar('1');
    }

    @FXML
    void onSevenAction(ActionEvent event) {
        calculadora.insertar('7');
    }

    @FXML
    void onSixAction(ActionEvent event) {
        calculadora.insertar('6');
    }

    @FXML
    void onSubstractAction(ActionEvent event) {
        calculadora.operar(Calculadora.RESTAR);
    }

    @FXML
    void onThreeAction(ActionEvent event) {
        calculadora.insertar('3');
    }

    @FXML
    void onTwoAction(ActionEvent event) {
        calculadora.insertar('2');
    }

    @FXML
    void onZeroAction(ActionEvent event) {
        calculadora.insertar('0');
    }

}
