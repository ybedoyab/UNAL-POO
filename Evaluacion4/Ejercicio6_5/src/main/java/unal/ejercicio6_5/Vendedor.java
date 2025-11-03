package unal.ejercicio6_5;

import java.util.*;
import javax.swing.JOptionPane;

/**
 * Esta clase denominada Vendedor modela un vendedor que tiene
 * como atributos un nombre, apellidos y una edad.
 * @version 1.2/2020
 */
public class Vendedor {
    String nombre; // Atributo que identifica el nombre de un vendedor
    String apellidos; // Atributo que identifica los apellidos de un vendedor
    int edad; // Atributo que identifica la edad de un vendedor

    /**
     * Constructor de la clase Vendedor
     * @param nombre Parámetro que define el nombre de un vendedor
     * @param apellidos Parámetro que define los apellidos de un vendedor
     */
    Vendedor(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    /**
     * Método que muestra en pantalla los datos de un vendedor
     */
	void imprimir() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre del vendedor = ").append(nombre).append('\n');
		sb.append("Apellidos del vendedor = ").append(apellidos).append('\n');
		sb.append("Edad del vendedor = ").append(edad);
		JOptionPane.showMessageDialog(null, sb.toString(), "Datos del vendedor", JOptionPane.INFORMATION_MESSAGE);
	}

    /**
     * Método que verifica que la edad de un vendedor es apropiada; si
     * no lo es, se generan las excepciones correspondientes
     * @throws IllegalArgumentException Excepción de argumento ilegal
     * cuyo valor debe ser mayor que 18, ni negativo, ni mayor a 120
     */
    void verificarEdad(int edad) {
        if (edad < 18) { /* El vendedor debe tener una edad mayor de 18 años */
            // Se genera una excepción de argumento ilegal
            throw new IllegalArgumentException("El vendedor debe ser mayor de 18 anos.");
        }
        if (edad >= 0 && edad < 120) { /* El vendedor debe tener una edad entre 0 y 120 */
            this.edad = edad;
        } else {
            throw new IllegalArgumentException("La edad no puede ser negativa ni mayor a 120.");
        }
        /* En cualquier otro caso se genera una excepción de argumento ilegal */
    }

    /**
     * Método que solicita por teclado el nombre, apellidos y edad de un
     * vendedor. Luego, se verifica la edad. Si la edad no es correcta, se
     * generan las excepciones correspondientes.
     */
	public static void main(String[] args) {
		try {
			String n = JOptionPane.showInputDialog(null, "Nombre del vendedor:", "Entrada", JOptionPane.QUESTION_MESSAGE);
			if (n == null || n.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String a = JOptionPane.showInputDialog(null, "Apellidos del vendedor:", "Entrada", JOptionPane.QUESTION_MESSAGE);
			if (a == null || a.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Los apellidos no pueden estar vacios.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Vendedor vendedor = new Vendedor(n.trim(), a.trim());
			String edadStr = JOptionPane.showInputDialog(null, "Edad del vendedor:", "Entrada", JOptionPane.QUESTION_MESSAGE);
			if (edadStr == null) {
				return;
			}
			int e;
			try {
				e = Integer.parseInt(edadStr.trim());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "La edad debe ser un numero entero.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			vendedor.verificarEdad(e);
			vendedor.imprimir();
		} catch (IllegalArgumentException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
