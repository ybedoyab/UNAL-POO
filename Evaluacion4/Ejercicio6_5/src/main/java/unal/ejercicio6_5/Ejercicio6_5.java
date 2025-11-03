/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package unal.ejercicio6_5;

import javax.swing.JOptionPane;

/**
 *
 * @author yulcr
 */
public class Ejercicio6_5 {

    public static void main(String[] args) {
        try {
            Vendedor.main(new String[]{});
            JOptionPane.showMessageDialog(null, "EP1 - Constructor que lanza excepción (demostración normal)", "Ejercicio 6_5", JOptionPane.INFORMATION_MESSAGE);
            ConstructorConExcepcion.main(new String[]{});
            JOptionPane.showMessageDialog(null, "EP2 - Tabla ASCII", "Ejercicio 6_5", JOptionPane.INFORMATION_MESSAGE);
            TablaASCII.main(new String[]{});
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
