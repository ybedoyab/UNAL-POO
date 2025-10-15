package unal.ejercicio8_3;

/**
 * Esta clase define el punto de ingreso al programa de figuras
 * geométricas. Por lo tanto, cuenta con un método main de acceso al
 * programa.
 * @version 1.2/2020
 */
public class Principal {
    /**
     * Método main que sirve de punto de entrada al programa
     */
    public static void main(String[] args) {
        VentanaPrincipal miVentanaPrincipal;
        miVentanaPrincipal = new VentanaPrincipal();
        miVentanaPrincipal.setVisible(true);
        miVentanaPrincipal.setResizable(false);
    }
}
