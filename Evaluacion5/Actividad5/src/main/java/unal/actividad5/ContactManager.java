package unal.actividad5;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para gestionar contactos en un archivo de texto.
 * Implementa operaciones CRUD (Create, Read, Update, Delete) usando RandomAccessFile.
 */
public class ContactManager {
    private static final String FILENAME = "friendsContact.txt";
    private static final String SEPARATOR = "!";
    
    /**
     * Crea un nuevo contacto en el archivo.
     * @param name Nombre del contacto
     * @param number Número de teléfono del contacto
     * @return true si el contacto fue agregado exitosamente, false si ya existe
     * @throws IOException Si ocurre un error al escribir en el archivo
     */
    public boolean createContact(String name, long number) throws IOException {
        File file = new File(FILENAME);
        
        if (!file.exists()) {
            file.createNewFile();
        }
        
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        boolean found = false;
        
        try {
            // Verificar si el contacto ya existe
            while (raf.getFilePointer() < raf.length()) {
                String line = raf.readLine();
                if (line == null || line.trim().isEmpty()) {
                    continue;
                }
                
                String[] parts = line.split(SEPARATOR);
                if (parts.length >= 2) {
                    String existingName = parts[0];
                    long existingNumber = Long.parseLong(parts[1]);
                    
                    if (existingName.equals(name) || existingNumber == number) {
                        found = true;
                        break;
                    }
                }
            }
            
            if (!found) {
                // Agregar el nuevo contacto
                String contactLine = name + SEPARATOR + number;
                raf.seek(raf.length()); // Ir al final del archivo
                raf.writeBytes(contactLine);
                raf.writeBytes(System.lineSeparator());
                return true;
            }
            
            return false;
        } finally {
            raf.close();
        }
    }
    
    /**
     * Lee todos los contactos del archivo.
     * @return Lista de contactos (cada contacto es un array [nombre, número])
     * @throws IOException Si ocurre un error al leer el archivo
     */
    public List<String[]> readAllContacts() throws IOException {
        List<String[]> contacts = new ArrayList<>();
        File file = new File(FILENAME);
        
        if (!file.exists()) {
            return contacts;
        }
        
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        
        try {
            while (raf.getFilePointer() < raf.length()) {
                String line = raf.readLine();
                if (line == null || line.trim().isEmpty()) {
                    continue;
                }
                
                String[] parts = line.split(SEPARATOR);
                if (parts.length >= 2) {
                    contacts.add(new String[]{parts[0], parts[1]});
                }
            }
        } finally {
            raf.close();
        }
        
        return contacts;
    }
    
    /**
     * Actualiza un contacto existente.
     * @param oldName Nombre del contacto a actualizar
     * @param newName Nuevo nombre (puede ser el mismo)
     * @param newNumber Nuevo número de teléfono
     * @return true si el contacto fue actualizado, false si no se encontró
     * @throws IOException Si ocurre un error al leer o escribir en el archivo
     */
    public boolean updateContact(String oldName, String newName, long newNumber) throws IOException {
        File file = new File(FILENAME);
        
        if (!file.exists()) {
            return false;
        }
        
        File tmpFile = new File("temp.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");
        boolean found = false;
        
        try {
            raf.seek(0);
            
            while (raf.getFilePointer() < raf.length()) {
                String line = raf.readLine();
                if (line == null || line.trim().isEmpty()) {
                    continue;
                }
                
                int index = line.indexOf(SEPARATOR);
                if (index > 0) {
                    String name = line.substring(0, index);
                    
                    if (name.equals(oldName)) {
                        // Actualizar este contacto
                        String updatedLine = newName + SEPARATOR + newNumber;
                        tmpraf.writeBytes(updatedLine);
                        tmpraf.writeBytes(System.lineSeparator());
                        found = true;
                    } else {
                        // Mantener el contacto sin cambios
                        tmpraf.writeBytes(line);
                        tmpraf.writeBytes(System.lineSeparator());
                    }
                }
            }
            
            if (found) {
                // Copiar el contenido del archivo temporal al original
                raf.seek(0);
                tmpraf.seek(0);
                
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    String line = tmpraf.readLine();
                    if (line != null) {
                        raf.writeBytes(line);
                        raf.writeBytes(System.lineSeparator());
                    }
                }
                
                raf.setLength(tmpraf.length());
            }
        } finally {
            tmpraf.close();
            raf.close();
            if (tmpFile.exists()) {
                tmpFile.delete();
            }
        }
        
        return found;
    }
    
    /**
     * Elimina un contacto del archivo.
     * @param name Nombre del contacto a eliminar
     * @return true si el contacto fue eliminado, false si no se encontró
     * @throws IOException Si ocurre un error al leer o escribir en el archivo
     */
    public boolean deleteContact(String name) throws IOException {
        File file = new File(FILENAME);
        
        if (!file.exists()) {
            return false;
        }
        
        File tmpFile = new File("temp.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");
        boolean found = false;
        
        try {
            raf.seek(0);
            
            while (raf.getFilePointer() < raf.length()) {
                String line = raf.readLine();
                if (line == null || line.trim().isEmpty()) {
                    continue;
                }
                
                int index = line.indexOf(SEPARATOR);
                if (index > 0) {
                    String contactName = line.substring(0, index);
                    
                    if (contactName.equals(name)) {
                        // Omitir este contacto (no copiarlo al archivo temporal)
                        found = true;
                    } else {
                        // Mantener este contacto
                        tmpraf.writeBytes(line);
                        tmpraf.writeBytes(System.lineSeparator());
                    }
                }
            }
            
            if (found) {
                // Copiar el contenido del archivo temporal al original
                raf.seek(0);
                tmpraf.seek(0);
                
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    String line = tmpraf.readLine();
                    if (line != null) {
                        raf.writeBytes(line);
                        raf.writeBytes(System.lineSeparator());
                    }
                }
                
                raf.setLength(tmpraf.length());
            }
        } finally {
            tmpraf.close();
            raf.close();
            if (tmpFile.exists()) {
                tmpFile.delete();
            }
        }
        
        return found;
    }
}

