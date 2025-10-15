package unal.ejercicio8_2;

import javax.swing.SwingUtilities;

/**
 * Esta clase define el punto de ingreso al programa de operaciones
 * sobre notas. Por lo tanto, cuenta con un método main de acceso al
 * programa.
 * 
 * @author yulcr
 * @version 1.2/2020
 */
public class Ejercicio8_2 {
    
    /**
     * Método main que sirve de punto de entrada al programa.
     * Crea una instancia de VentanaPrincipal y la hace visible.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Crear la ventana principal en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();
            miVentanaPrincipal.setVisible(true);
        });
    }
}
