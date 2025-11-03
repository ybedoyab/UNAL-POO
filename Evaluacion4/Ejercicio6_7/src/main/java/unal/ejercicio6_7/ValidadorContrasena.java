package unal.ejercicio6_7;

import java.util.*;
import javax.swing.JOptionPane;

/**
 * Ejercicio Propuesto: Validacion de Contraseña
 * 
 * Esta clase implementa un sistema de validacion de contraseñas con
 * requisitos especificos y confirmacion de entrada.
 */
public class ValidadorContrasena {
    
    /**
     * Valida una contraseña segun los requisitos especificados
     * @param contrasena La contraseña a validar
     * @throws Exception Si la contraseña no cumple los requisitos
     */
    public static void validarContrasena(String contrasena) throws Exception {
        // Verificar longitud minima
        if (contrasena.length() < 8) {
            throw new Exception("La contrasena debe tener minimo 8 caracteres");
        }
        
        // Verificar espacios en blanco
        if (contrasena.contains(" ")) {
            throw new Exception("La contrasena no puede tener espacios en blanco");
        }
        
        boolean tieneMinuscula = false;
        boolean tieneMayuscula = false;
        boolean tieneNumero = false;
        boolean tieneEspecial = false;
        
        // Verificar cada caracter
        for (char c : contrasena.toCharArray()) {
            if (Character.isLowerCase(c)) {
                tieneMinuscula = true;
            } else if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            } else if (Character.isDigit(c)) {
                tieneNumero = true;
            } else if (esCaracterEspecial(c)) {
                tieneEspecial = true;
            }
        }
        
        // Verificar que tenga al menos un caracter de cada tipo
        if (!tieneMinuscula) {
            throw new Exception("La contrasena debe tener al menos una letra minuscula");
        }
        if (!tieneMayuscula) {
            throw new Exception("La contrasena debe tener al menos una letra mayuscula");
        }
        if (!tieneNumero) {
            throw new Exception("La contrasena debe tener al menos un numero");
        }
        if (!tieneEspecial) {
            throw new Exception("La contrasena debe tener al menos un caracter especial");
        }
    }
    
    /**
     * Verifica si un caracter es especial
     * @param c El caracter a verificar
     * @return true si es especial, false en caso contrario
     */
    private static boolean esCaracterEspecial(char c) {
        String especiales = "!@#$%^&*()_+-=[]{}|;:,.<>?";
        return especiales.indexOf(c) != -1;
    }
    
    /**
     * Valida que dos contraseñas sean iguales
     * @param contrasena1 Primera contraseña
     * @param contrasena2 Segunda contraseña (confirmacion)
     * @throws Exception Si las contraseñas no coinciden
     */
    public static void validarConfirmacion(String contrasena1, String contrasena2) throws Exception {
        if (!contrasena1.equals(contrasena2)) {
            throw new Exception("Las contrasenas no coinciden");
        }
    }
    
    /**
     * Metodo principal que demuestra la validacion de contraseñas
     */
    public static void main(String[] args) {
        String info = "=== Validador de Contrasena ===\n" +
                "Requisitos de la contrasena:\n" +
                "- Minimo 8 caracteres\n" +
                "- No espacios en blanco\n" +
                "- Al menos una letra minuscula\n" +
                "- Al menos una letra mayuscula\n" +
                "- Al menos un numero\n" +
                "- Al menos un caracter especial (!@#$%^&*()_+-=[]{}|;:,.<>?)";
        JOptionPane.showMessageDialog(null, info, "Validador", JOptionPane.INFORMATION_MESSAGE);
        
        boolean contrasenaValida = false;
        String contrasena = "";
        
        while (!contrasenaValida) {
            try {
                contrasena = JOptionPane.showInputDialog(null, "Ingrese su contrasena:", "Validador", JOptionPane.QUESTION_MESSAGE);
                if (contrasena == null) { return; }
                validarContrasena(contrasena);
                contrasenaValida = true;
                JOptionPane.showMessageDialog(null, "Contrasena valida!", "Validador", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        boolean confirmacionValida = false;
        while (!confirmacionValida) {
            try {
                String confirmacion = JOptionPane.showInputDialog(null, "Confirme su contrasena:", "Validador", JOptionPane.QUESTION_MESSAGE);
                if (confirmacion == null) { return; }
                validarConfirmacion(contrasena, confirmacion);
                confirmacionValida = true;
                JOptionPane.showMessageDialog(null, "Contrasena confirmada exitosamente!", "Validador", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null, "=== Contrasena Registrada Exitosamente ===", "Validador", JOptionPane.INFORMATION_MESSAGE);
    }
}
