package unal.ejercicio6_8;

import java.io.*;
import javax.swing.*;

/**
 * Ejercicio Propuesto 2: Lectura de archivo con conversion a mayusculas
 * Esta clase lee un archivo y muestra su contenido con todos los caracteres
 * en minusculas convertidos a mayusculas.
 */
public class LeerArchivoMayusculas {
    /**
     * Metodo que lee un archivo y convierte todo el contenido a mayusculas
     * @param nombreArchivo El nombre del archivo a leer
     * @throws IOException Excepcion que indica que no se pudo leer el archivo
     */
    public static void leerArchivoEnMayusculas(String nombreArchivo) throws IOException {
        FileInputStream archivo = null;
        InputStreamReader conversor = null;
        BufferedReader filtro = null;
        
        try {
            // Crear los objetos para la lectura del archivo
            archivo = new FileInputStream(nombreArchivo);
            conversor = new InputStreamReader(archivo);
            filtro = new BufferedReader(conversor);
            
            StringBuilder sb = new StringBuilder();
            sb.append("Archivo: ").append(nombreArchivo).append("\n\n");
            
            String linea = filtro.readLine();
            int numeroLinea = 1;
            
            while (linea != null) {
                // Convertir toda la linea a mayusculas
                String lineaMayusculas = linea.toUpperCase();
                sb.append("Linea ").append(numeroLinea).append(": ").append(lineaMayusculas).append('\n');
                linea = filtro.readLine();
                numeroLinea++;
            }
            JTextArea area = new JTextArea(sb.toString());
            area.setEditable(false);
            JScrollPane scroll = new JScrollPane(area);
            scroll.setPreferredSize(new java.awt.Dimension(600, 400));
            JOptionPane.showMessageDialog(null, scroll, "Contenido en MAYUSCULAS", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "El archivo no existe.", "Error", JOptionPane.ERROR_MESSAGE);
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

    /**
     * Metodo que demuestra la conversion a mayusculas con un archivo de ejemplo
     */
    public static void demostrarConversion() {
        JFileChooser chooser = new JFileChooser(new File("src"));
        chooser.setDialogTitle("Seleccione el archivo para convertir a MAYUSCULAS");
        int res = chooser.showOpenDialog(null);
        if (res != JFileChooser.APPROVE_OPTION) { return; }
        String archivoEjemplo = chooser.getSelectedFile().getAbsolutePath();
        
        try {
            leerArchivoEnMayusculas(archivoEjemplo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        demostrarConversion();
    }
}
