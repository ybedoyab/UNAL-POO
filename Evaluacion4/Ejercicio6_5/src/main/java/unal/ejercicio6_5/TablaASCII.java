package unal.ejercicio6_5;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * Ejercicio Propuesto 2: Tabla ASCII con manejo de excepciones
 * 
 * Esta clase implementa una tabla ASCII donde cada símbolo tiene asociado
 * un valor numérico, con manejo apropiado de excepciones.
 */
public class TablaASCII {
    
    private Map<String, Integer> tabla;
    
    /**
     * Constructor que inicializa la tabla ASCII básica
     */
    public TablaASCII() {
        tabla = new HashMap<>();
        // Inicializar algunos símbolos básicos
        tabla.put("A", 65);
        tabla.put("B", 66);
        tabla.put("C", 67);
        tabla.put("a", 97);
        tabla.put("b", 98);
        tabla.put("c", 99);
        tabla.put("0", 48);
        tabla.put("1", 49);
        tabla.put("2", 50);
        tabla.put(" ", 32); // espacio
        tabla.put("!", 33); // exclamación
    }
    
    /**
     * Obtiene el valor numérico asociado a un símbolo
     * @param simbolo El símbolo a buscar
     * @return El valor numérico asociado
     * @throws IllegalArgumentException Si el símbolo es nulo, vacío o no existe
     */
    public int get(String simbolo) {
        if (simbolo == null) {
            throw new IllegalArgumentException("El simbolo no puede ser nulo");
        }
        if (simbolo.isEmpty()) {
            throw new IllegalArgumentException("El simbolo no puede estar vacio");
        }
        if (!tabla.containsKey(simbolo)) {
            throw new IllegalArgumentException("El simbolo '" + simbolo + "' no existe en la tabla ASCII");
        }
        return tabla.get(simbolo);
    }
    
    /**
     * Asocia un número con un símbolo
     * @param simbolo El símbolo a asociar
     * @param numero El valor numérico a asociar
     * @throws IllegalArgumentException Si el símbolo es nulo, vacío o el número es inválido
     */
    public void set(String simbolo, int numero) {
        if (simbolo == null) {
            throw new IllegalArgumentException("El simbolo no puede ser nulo");
        }
        if (simbolo.isEmpty()) {
            throw new IllegalArgumentException("El simbolo no puede estar vacio");
        }
        if (numero < 0 || numero > 127) {
            throw new IllegalArgumentException("El numero debe estar entre 0 y 127 (ASCII valido)");
        }
        tabla.put(simbolo, numero);
    }
    
    /**
     * Muestra todos los símbolos y sus valores
     */
    public void mostrarTabla() {
        StringBuilder sb = new StringBuilder("Tabla ASCII actual:\n");
        for (Map.Entry<String, Integer> entry : tabla.entrySet()) {
            sb.append("'").append(entry.getKey()).append("' = ").append(entry.getValue()).append('\n');
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Tabla ASCII", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        TablaASCII tabla = new TablaASCII();
        try {
            String msg = "Valor de 'A': " + tabla.get("A") + "\n" +
                         "Valor de 'a': " + tabla.get("a");
            JOptionPane.showMessageDialog(null, msg, "Consulta", JOptionPane.INFORMATION_MESSAGE);
            tabla.set("Z", 90);
            JOptionPane.showMessageDialog(null, "Valor de 'Z': " + tabla.get("Z"), "Consulta", JOptionPane.INFORMATION_MESSAGE);
            tabla.mostrarTabla();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Nota: Las pruebas de excepciones se omitieron en el flujo principal para evitar
        // mostrar múltiples diálogos de error consecutivos. Se mantiene validación interna.
    }
}
