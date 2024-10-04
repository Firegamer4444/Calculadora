package dad.calculadora;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Calculadora {

    public static final char IGUAL = '=';
    public static final char SUMAR = '+';
    public static final char RESTAR = '-';
    public static final char DIVIDIR = '/';
    public static final char MULTIPLICAR = '*';

    private static final char COMA = '.';

    private Double operando;
    private char operador;
    private Boolean nuevoOperando;
    private StringProperty pantalla = new SimpleStringProperty();

    public Calculadora() {
        borrar();
    }

    /**
     * Devuelve el contenido de la pantalla de la calculadora.
     * @return Cadena de texto con el contenido de la pantalla de la calculdora.
     */
    public StringProperty getPantalla() {
        return pantalla;
    }

    /**
     * Inicializa por completo la calculadora, borrando la información que tiene memorizada y la pantalla.
     */
    public void borrar() {
        operando = 0.0;
        operador = '=';
        borrarTodo();
    }

    /**
     * Borra lo que hay en la pantalla (el último operando introducido).
     */
    public void borrarTodo() {
        nuevoOperando = true;
        pantalla.set("0.0");
    }

    /**
     * Indica a la calculadora que realice la operación indicada.
     * @param operador Operación a realizar; usar una constante: IGUAL, SUMAR, RESTAR, MULTIPLCIAR, DIVIDIR.
     */
    public void operar(char operador) {
        nuevoOperando = true;
        double operando2 = Double.parseDouble(String.valueOf(pantalla.getValue()));
        switch (this.operador) {
            case SUMAR: operando += operando2; break;
            case RESTAR: operando -= operando2; break;
            case MULTIPLICAR: operando *= operando2; break;
            case DIVIDIR: operando /= operando2; break;
            case IGUAL: operando = operando2; break;
        }
        this.operador = operador;
        pantalla.set("" + operando);
    }

    /**
     * Inserta una coma en el operando actual (pantalla).
     */
    public void insertarComa() {
        if (!pantalla.getValue().contains("" + COMA)) {
            pantalla.set(pantalla.getValue() + COMA);
        }
    }

    /**
     * Inserta un dígito en el operando actual (pantalla).
     * @param digito Digito a introducir en la pantalla.
     */
    public void insertar(char digito) {
        if (digito >= '0' && digito <= '9') {
            if (nuevoOperando) {
                nuevoOperando = false;
                pantalla.set("");
            }
            pantalla.set(pantalla.getValue() + digito);
        } else if (digito == COMA) {
            insertarComa();
        }
    }


}
