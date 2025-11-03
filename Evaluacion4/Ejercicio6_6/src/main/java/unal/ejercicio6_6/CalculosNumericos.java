package unal.ejercicio6_6;

import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Esta clase denominada CalculosNumericos permite realizar dos
 * calculos matematicos: calcular el logaritmo neperiano de un valor y
 * calcular la raiz cuadrada de un valor.
 * @version 1.2/2020
 */
public class CalculosNumericos {
    
    /**
     * Metodo que calcula el logaritmo neperiano de un valor numerico.
     * Si el valor pasado como parametro no es correcto se genera la
     * excepcion correspondiente
     * @param valor Parametro que define el valor al cual se le calculara
     * el logaritmo neperiano
     * @throws ArithmeticException Excepcion aritmetica que indica
     * que el numero debe ser positivo
     * @throws InputMismatchException Excepcion que indica que el
     * valor ingresado debe ser numerico
     */
    static void calcularLogaritmoNeperiano(double valor) {
        try {
            if (valor < 0) {
                // Si el valor es negativo, se genera una excepcion aritmetica
                throw new ArithmeticException("El valor debe ser un numero positivo");
            }
            // Si el valor es positivo, se calcula el algoritmo neperiano
            double resultado = Math.log(valor);
            JOptionPane.showMessageDialog(null, "Logaritmo neperiano de " + valor + " = " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } catch (ArithmeticException e) {
            /* Si ocurre una excepcion aritmetica, se muestra un mensaje
            de error */
            JOptionPane.showMessageDialog(null, "El valor debe ser un numero positivo para calcular el logaritmo", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InputMismatchException e) {
            /* Si el valor a calcular no es numerico, se muestra un mensaje
            de error */
            JOptionPane.showMessageDialog(null, "El valor debe ser numerico para calcular el logaritmo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Metodo que calcula la raiz cuadrada de un valor numerico. Si el
     * valor pasado como parametro no es correcto se genera la
     * excepcion correspondiente
     * @param valor Parametro que define el valor al cual se le calculara
     * la raiz cuadrada
     * @throws ArithmeticException Excepcion aritmetica que indica
     * que el numero debe ser positivo
     * @throws InputMismatchException Excepcion que indica que el
     * valor ingresado debe ser numerico
     */
    static void calcularRaizCuadrada(double valor) {
        try {
            if (valor < 0) {
                // Si el valor es negativo, se genera una excepcion aritmetica
                throw new ArithmeticException("El valor debe ser un numero positivo");
            }
            double resultado = Math.sqrt(valor); /* Si el valor es positivo,
            se calcula la raiz cuadrada */
            JOptionPane.showMessageDialog(null, "Raiz cuadrada de " + valor + " = " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } catch (ArithmeticException e) {
            /* Si ocurre una excepcion aritmetica, se muestra un mensaje
            de error */
            JOptionPane.showMessageDialog(null, "El valor debe ser un numero positivo para calcular la raiz cuadrada", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InputMismatchException e) {
            /* Si el valor a calcular no es numerico, se muestra un mensaje
            de error */
            JOptionPane.showMessageDialog(null, "El valor debe ser numerico para calcular la raiz cuadrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Calcula ambos resultados y devuelve un texto consolidado para mostrar en un solo dialogo.
     */
    private static String construirResultadosConsolidados(double valor) {
        StringBuilder sb = new StringBuilder();
        sb.append("Resultados para ").append(valor).append(':').append('\n');

        // Logaritmo neperiano
        try {
            if (valor < 0) {
                throw new ArithmeticException("El valor debe ser un numero positivo");
            }
            double ln = Math.log(valor);
            sb.append("- Logaritmo neperiano: ").append(ln).append('\n');
        } catch (ArithmeticException | InputMismatchException e) {
            sb.append("- Logaritmo neperiano: ERROR - ")
              .append(e instanceof ArithmeticException ? "El valor debe ser un numero positivo" : "El valor debe ser numerico")
              .append('\n');
        }

        // Raiz cuadrada
        try {
            if (valor < 0) {
                throw new ArithmeticException("El valor debe ser un numero positivo");
            }
            double raiz = Math.sqrt(valor);
            sb.append("- Raiz cuadrada: ").append(raiz).append('\n');
        } catch (ArithmeticException | InputMismatchException e) {
            sb.append("- Raiz cuadrada: ERROR - ")
              .append(e instanceof ArithmeticException ? "El valor debe ser un numero positivo" : "El valor debe ser numerico")
              .append('\n');
        }

        return sb.toString();
    }

    /**
     * Construye el texto para la pestaña "Ejercicios propuestos" con ejemplos.
     */
    private static String construirEjerciciosPropuestos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ejercicios propuestos\n\n");

        sb.append(OperacionesMatematicas.pendienteStr(1, 2, 3, 4)).append('\n');
        sb.append(OperacionesMatematicas.puntoMedioStr(1, 2, 5, 6)).append('\n');
        sb.append(OperacionesMatematicas.raicesCuadraticasStr(1, -5, 6)).append('\n');
        sb.append(OperacionesMatematicas.conversionBaseStr(38, 16)).append('\n');

        return sb.toString();
    }
    
    /**
     * Metodo main que solicita un valor numerico por teclado. Para
     * dicho valor se calcula el logaritmo neperiano y la raiz cuadrada. Si
     * el valor ingresado no es correcto, se generan las excepciones
     * correspondientes.
     */
    public static void main(String args[]) {
        String input = JOptionPane.showInputDialog(null, "Valor numerico:", "Calculos Numericos", JOptionPane.QUESTION_MESSAGE);
        if (input == null) {
            return;
        }
        double valor;
        try {
            valor = Double.parseDouble(input.trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un numero valido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Mostrar resultados en una ventana con pestañas
        String consolidado = construirResultadosConsolidados(valor);
        String propuestos = construirEjerciciosPropuestos();

        JTextArea area1 = new JTextArea(consolidado);
        area1.setEditable(false);
        JTextArea area2 = new JTextArea(propuestos);
        area2.setEditable(false);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Calculos", new JScrollPane(area1));
        tabs.addTab("Ejercicios propuestos", new JScrollPane(area2));

        JOptionPane.showMessageDialog(null, tabs, "Calculos Numericos", JOptionPane.INFORMATION_MESSAGE);
    }
}
