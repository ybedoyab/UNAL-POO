package unal.ejercicio6_8;

public class Ejercicio6_8 {
    public static void main(String[] args) {
        try {
            LeerEscribirArchivo.main(args);
            LeerArchivo.main(args);
            LeerArchivoTeclado.main(args);
            LeerArchivoMayusculas.main(args);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
}
