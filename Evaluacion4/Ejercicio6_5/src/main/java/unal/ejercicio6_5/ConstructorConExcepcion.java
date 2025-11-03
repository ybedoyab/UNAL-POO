package unal.ejercicio6_5;

/**
 * Ejercicio Propuesto 1: Constructor que lanza excepción
 * 
 * Este programa demuestra cómo un constructor puede lanzar una excepción
 * y cómo un controlador de excepciones puede detectarla.
 */
public class ConstructorConExcepcion {
    
    private String nombre;
    private int valor;
    
    /**
     * Constructor que lanza IllegalArgumentException si el valor es negativo
     * @param nombre Nombre del objeto
     * @param valor Valor que debe ser positivo
     * @throws IllegalArgumentException Si el valor es negativo
     */
    public ConstructorConExcepcion(String nombre, int valor) {
        this.nombre = nombre;
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo: " + valor);
        }
        this.valor = valor;
    }
    
    public void imprimir() {
        javax.swing.JOptionPane.showMessageDialog(null, "Nombre: " + nombre + ", Valor: " + valor, "Objeto", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        try {
            // Demostración normal (sin provocar excepciones)
            ConstructorConExcepcion obj1 = new ConstructorConExcepcion("Objeto1", 10);
            obj1.imprimir();
        } catch (IllegalArgumentException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Excepcion: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
}
