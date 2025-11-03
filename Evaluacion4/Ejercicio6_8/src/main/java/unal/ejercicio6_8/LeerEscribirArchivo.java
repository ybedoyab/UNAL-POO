package unal.ejercicio6_8;

import java.io.*;
import javax.swing.*;

/**
 * Esta clase lee un archivo de entrada (input.txt) y escribe el resultado
 * a un archivo de salida (output.txt) en la misma ubicacion
 * @version 1.2/2020
 */
public class LeerEscribirArchivo {
    /**
     * Metodo main que lee input.txt y escribe el resultado a output.txt
     * @throws IOException Excepcion que indica que no se pudo leer o escribir
     * el archivo
     */
    public static void main(String[] args) throws Exception {
        JFileChooser chooser = new JFileChooser(new File("src"));
        chooser.setDialogTitle("Seleccione el archivo de entrada (.txt)");
        int resIn = chooser.showOpenDialog(null);
        if (resIn != JFileChooser.APPROVE_OPTION) { return; }
        File inputFile = chooser.getSelectedFile();

        chooser.setDialogTitle("Seleccione la ubicacion del archivo de salida");
        chooser.setSelectedFile(new File("output.txt"));
        int resOut = chooser.showSaveDialog(null);
        if (resOut != JFileChooser.APPROVE_OPTION) { return; }
        File outputFile = chooser.getSelectedFile();
        
        FileInputStream archivo; // Definicion de flujo de datos de entrada
        InputStreamReader conversor; // Definicion del flujo de lectura
        BufferedReader filtro; // Definicion del buffer de entrada
        
        FileOutputStream archivoSalidaStream; // Definicion de flujo de datos de salida
        OutputStreamWriter escritorSalida; // Definicion del flujo de escritura
        BufferedWriter bufferSalida; // Definicion del buffer de salida
        
        String linea;
        
        try {
            /* Crear los objetos para la lectura del archivo de entrada */
            archivo = new FileInputStream(inputFile);
            conversor = new InputStreamReader(archivo);
            filtro = new BufferedReader(conversor);
            
            /* Crear los objetos para la escritura del archivo de salida */
            archivoSalidaStream = new FileOutputStream(outputFile);
            escritorSalida = new OutputStreamWriter(archivoSalidaStream);
            bufferSalida = new BufferedWriter(escritorSalida);
            
            StringBuilder preview = new StringBuilder();
            preview.append("=== Procesando archivo ===\n");
            preview.append("Entrada: ").append(inputFile.getAbsolutePath()).append('\n');
            preview.append("Salida: ").append(outputFile.getAbsolutePath()).append("\n\n");
            
            linea = filtro.readLine();
            
            while (linea != null) {
                // Convertir la linea a mayusculas
                String lineaMayusculas = linea.toUpperCase();
                // Agregar a vista previa
                preview.append(lineaMayusculas).append('\n');
                // Escribir al archivo de salida
                bufferSalida.write(lineaMayusculas);
                bufferSalida.newLine(); // Agregar salto de linea
                
                linea = filtro.readLine(); // Lee la siguiente linea
            }
            
            JOptionPane.showMessageDialog(null, preview.toString(), "Procesamiento completado", JOptionPane.INFORMATION_MESSAGE);
            
            // Cerrar los recursos
            filtro.close(); // Cierra el archivo de entrada
            bufferSalida.close(); // Cierra el archivo de salida
            
        } catch (IOException e) { // En caso que se genere una excepcion
            JOptionPane.showMessageDialog(null, "Error al procesar archivos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
