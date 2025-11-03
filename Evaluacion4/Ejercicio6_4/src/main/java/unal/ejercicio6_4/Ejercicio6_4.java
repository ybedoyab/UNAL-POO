/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package unal.ejercicio6_4;

import javax.swing.JOptionPane;

/**
 *
 * @author yulcr
 */
public class Ejercicio6_4 {

    public static void main(String[] args) {
        String[] opciones = new String[] {
            "PruebaExcepciones",
            "ExcepcionFormatoNumero",
            "ExcepcionFueraLimite",
            "Ejecutar todos",
            "Salir"
        };
        while (true) {
            String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el ejercicio a ejecutar:",
                "Ejercicio 6_4",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );
            if (seleccion == null || seleccion.equals("Salir")) {
                return;
            }
            try {
                switch (seleccion) {
                    case "PruebaExcepciones":
                        PruebaExcepciones.main(new String[]{});
                        break;
                    case "ExcepcionFormatoNumero":
                        ExcepcionFormatoNumero.main(new String[]{});
                        break;
                    case "ExcepcionFueraLimite":
                        ExcepcionFueraLimite.main(new String[]{});
                        break;
                    case "Ejecutar todos":
                        PruebaExcepciones.main(new String[]{});
                        ExcepcionFormatoNumero.main(new String[]{});
                        ExcepcionFueraLimite.main(new String[]{});
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
