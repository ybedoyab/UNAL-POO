package unal.ejercicio6_8;

import java.io.*;
import javax.swing.*;

/**
 * Esta clase denominada LeerArchivo tiene como objetivo leer los datos
 * presentes en un archivo de texto con extension .txt
 * @version 1.2/2020
 */
public class LeerArchivo {
    /**
     * Metodo main que lee una archivo de texto y muestra su contenido
     * en pantalla
     * @throws IOException Excepcion que indica que no se pudo leer
     * el archivo
     */
    public static void main(String[] args) throws Exception {
        JFileChooser chooser = new JFileChooser(new File("src"));
        chooser.setDialogTitle("Seleccione el archivo de texto");
        int res = chooser.showOpenDialog(null);
        if (res != JFileChooser.APPROVE_OPTION) { return; }
        String nombreArchivo = chooser.getSelectedFile().getAbsolutePath(); /* Archivo a leer */
        FileInputStream archivo; // Definicion de flujo de datos
        InputStreamReader conversor; // Definicion del flujo de lectura
        BufferedReader filtro; // Definicion del buffer
        String linea;
        try {
            /* Crea los objetos FileInputStream, BufferedReader y
            BufferedReader */
            archivo = new FileInputStream(nombreArchivo);
            conversor = new InputStreamReader(archivo);
            filtro = new BufferedReader(conversor);
            linea = filtro.readLine();
            StringBuilder sb = new StringBuilder();
            while (linea != null) {
                sb.append(linea).append('\n');
                linea = filtro.readLine(); // Lee la siguiente linea
            }
            JTextArea area = new JTextArea(sb.toString());
            area.setEditable(false);
            JScrollPane scroll = new JScrollPane(area);
            scroll.setPreferredSize(new java.awt.Dimension(600, 400));
            JOptionPane.showMessageDialog(null, scroll, "Contenido de " + nombreArchivo, JOptionPane.INFORMATION_MESSAGE);
            filtro.close(); // Cierra el archivo
        } catch (IOException e) { // En caso que se genere una excepcion
            JOptionPane.showMessageDialog(null, "No se pudo leer el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
