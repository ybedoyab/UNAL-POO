package unal.ejercicio6_4;

/**
 * Esta clase denominada PruebaExcepciones lanza diferentes excepciones en
 * situaciones específicas del programa. Los mensajes que se muestran en
 * pantalla ayudan a identificar la porción de código que se ejecutó o no.
 *
 * <p>Salida esperada:
 * Ingresando al primer try
 * División por cero
 * Ingresando al primer finally
 * Ingresando al segundo try
 * Ocurrió una excepción
 * Ingresando al segundo finally
 *
 * @version 1.2/2020
 */
public class PruebaExcepciones {

    /**
     * Método main con dos bloques try que generan excepciones que deben ser
     * gestionadas.
     *
     * @throws ArithmeticException Excepción aritmética de división por cero
     * @throws Exception Excepción general
     */
    public static void main(String[] args) {
        // Primer bloque try
        try {
            System.out.println("Ingresando al primer try");
            double cociente = 10000 / 0; // Se lanza una excepción
            System.out.println("Después de la división: " + cociente);
        } catch (ArithmeticException e) { // Se captura la excepción
            System.out.println("Division por cero");
        } finally {
            // La sentencia finally siempre se ejecuta, ocurra o no una excepción
            System.out.println("Ingresando al primer finally");
        }

        // Segundo bloque try
        try {
            System.out.println("Ingresando al segundo try");
            Object objeto = null;
            objeto.toString(); // Se lanza una excepción
            System.out.println("Imprimiendo objeto");
        } catch (ArithmeticException e) { // La excepción lanzada no es de este tipo
            System.out.println("Division por cero");
        } catch (Exception e) { // Se captura la excepción
            System.out.println("Ocurrio una excepcion");
        } finally {
            // La sentencia finally siempre se ejecuta, ocurra o no una excepción
            System.out.println("Ingresando al segundo finally");
        }
    }
}


