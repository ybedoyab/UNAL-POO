package unal.actividad5;

import javax.swing.SwingUtilities;

/**
 * Clase principal de la Actividad 5.
 * Aplicación de interfaz gráfica con operaciones CRUD para gestión de contactos.
 * 
 * @author yulcr
 */
public class Actividad5 {

    /**
     * Método principal que inicia la aplicación.
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Crear la GUI en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            ContactGUI gui = new ContactGUI();
            gui.setVisible(true);
        });
    }
}
