package unal.ejercicio8_5;

import unal.ejercicio8_5.Hotel.Hotel;
import unal.ejercicio8_5.Hotel.VentanaPrincipal;

/**
 * Esta clase define el punto de ingreso al programa de ingreso y salida
 * de huéspedes de un hotel. Por lo tanto, cuenta con un método main
 * de acceso al programa.
 * @version 2.0/2024
 */
public class Principal {
    /**
     * Método main que sirve de punto de entrada al programa
     */
    public static void main(String[] args) {
        VentanaPrincipal miVentanaPrincipal; // Define la ventana principal
        Hotel hotel = new Hotel(); // Crea un objeto Hotel
        miVentanaPrincipal = new VentanaPrincipal(hotel); /* Crea la
        ventana principal */
        miVentanaPrincipal.setVisible(true); /* Establece la ventana
        como visible */
    }
}


