package unal.ejercicio6_8;

import java.io.*;
import javax.swing.*;

/**
 * Ejercicio Propuesto 1: Lectura de archivo con nombre ingresado por teclado
 * Esta clase permite al usuario ingresar el nombre de un archivo por teclado
 * y muestra su contenido en pantalla.
 */
public class LeerArchivoTeclado {
    /**
     * Metodo que lee un archivo cuyo nombre se ingresa por teclado
     * @throws IOException Excepcion que indica que no se pudo leer el archivo
     */
    public static void leerArchivoPorTeclado() throws IOException {
        JFileChooser chooser = new JFileChooser(new File("src"));
        chooser.setDialogTitle("Seleccione el archivo a leer");
        int res = chooser.showOpenDialog(null);
        if (res != JFileChooser.APPROVE_OPTION) { return; }
        String nombreArchivo = chooser.getSelectedFile().getAbsolutePath();
        
        FileInputStream archivo = null;
        InputStreamReader conversor = null;
        BufferedReader filtro = null;
        
        try {
            // Crear los objetos para la lectura del archivo
            archivo = new FileInputStream(nombreArchivo);
            conversor = new InputStreamReader(archivo);
            filtro = new BufferedReader(conversor);
            
            StringBuilder sb = new StringBuilder();
            sb.append("--- Contenido del archivo ---\n");
            String linea = filtro.readLine();
            int numeroLinea = 1;
            
            while (linea != null) {
                sb.append("Linea ").append(numeroLinea).append(": ").append(linea).append('\n');
                linea = filtro.readLine();
                numeroLinea++;
            }
            JTextArea area = new JTextArea(sb.toString());
            area.setEditable(false);
            JScrollPane scroll = new JScrollPane(area);
            scroll.setPreferredSize(new java.awt.Dimension(600, 400));
            JOptionPane.showMessageDialog(null, scroll, "Contenido de " + nombreArchivo, JOptionPane.INFORMATION_MESSAGE);
            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "El archivo no existe:", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo leer el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cerrar los recursos
            try {
                if (filtro != null) filtro.close();
                if (conversor != null) conversor.close();
                if (archivo != null) archivo.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        try {
            leerArchivoPorTeclado();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
