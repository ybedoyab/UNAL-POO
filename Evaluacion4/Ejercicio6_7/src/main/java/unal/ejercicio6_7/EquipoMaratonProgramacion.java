package unal.ejercicio6_7;

import java.util.*;
import javax.swing.JOptionPane;

/**
 * Esta clase denominada EquipoMaratonProgramacion modela un
 * equipo de programadores que participara en una maraton de
 * programacion. Un equipo cuenta con un nombre, la universidad
 * a la que pertenece, el lenguaje de programacion que utilizara en la
 * competicion, el tamano del equipo y un array de programadores.
 * @version 1.2/2020
 */
public class EquipoMaratonProgramacion {
    /* Atributo que define el nombre el equipo de la maraton de
    programacion */
    String nombreEquipo;
    /* Atributo que define el nombre de la universidad a la que
    pertenece el equipo de la maraton de programacion */
    String universidad;
    /* Atributo que define el lenguaje de programacion utilizado por el
    equipo de la maraton de programacion */
    String lenguajeProgramacion;
    /* Atributo que define los programadores que conforman el equipo
    de la maraton de programacion */
    Programador[] programadores;
    /* Atributo que define el tamano del equipo de la maraton de
    programacion */
    int tamanoEquipo;

    /**
     * Constructor de la clase EquipoMaratonProgramacion
     * @param nombreEquipo Parametro que define el nombre del
     * equipo de la maraton de programacion
     * @param universidad Parametro que define la universidad a la que
     * pertenece el equipo de la maraton de programacion
     * @param lenguajeProgramacion Parametro que define el lenguaje
     * de programacion que utilizara el equipo de la maraton de
     * programacion
     */
    EquipoMaratonProgramacion(String nombreEquipo, String universidad, String lenguajeProgramacion) {
        this.nombreEquipo = nombreEquipo;
        this.universidad = universidad;
        this.lenguajeProgramacion = lenguajeProgramacion;
        this.tamanoEquipo = 0; // El tamano del equipo inicialmente es cero
        programadores = new Programador[3]; /* Crea un array con tres
        programadores */
    }

    /**
     * Metodo que determina si el array de programadores del equipo
     * esta lleno o no
     * @return Valor boolean que determina si el array de programadores
     * esta lleno o no
     */
    boolean estaLleno() {
        return tamanoEquipo == programadores.length;
    }

    /**
     * Metodo que permite anadir un programador al array de
     * programadores
     * @param programador Parametro que define el programador a
     * agregar al array de programadores
     * @throws Exception Excepcion que indica que el equipo de
     * programacion esta completo
     */
    void anadir(Programador programador) throws Exception {
        if (estaLleno()) { /* Si el array esta lleno, se genera la excepcion
        correspondiente */
            throw new Exception("El equipo esta completo. No se pudo agregar programador.");
        }
        // Se asigna el programador al array de programadores
        programadores[tamanoEquipo] = programador;
        tamanoEquipo++; // Se incrementa el tamano del equipo
    }

    /**
     * Metodo que permite validar un campo evaluando si el campo no
     * tiene digitos y su longitud no debe ser superior a 20 caracteres. Si
     * no cumple estos criterios, se generan las excepciones
     * correspondientes
     * @param campo Parametro que define el campo a validar
     * @throws Exception Excepcion que indica que el nombre ingresado
     * no puede tener digitos o que la longitud no debe ser superior a 20
     * caracteres
     */
    static void validarCampo(String campo) throws Exception {
        for (int j = 0; j < campo.length(); j++) {
            char c = campo.charAt(j);
            if (Character.isDigit(c)) { /* Si el caracter es un digito se genera
            la excepcion correspondiente */
                throw new Exception("El nombre no puede tener digitos.");
            }
        }
        /* Si la longitud del campo es mayor que 20 caracateres, se
        genera una excepcion */
        if (campo.length() > 20) {
            throw new Exception("La longitud no debe ser superior a 20 caracteres.");
        }
    }

    /**
     * Metodo que muestra la informacion del equipo
     */
    void mostrarEquipo() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Informacion del Equipo ===\n");
        sb.append("Nombre del equipo: ").append(nombreEquipo).append('\n');
        sb.append("Universidad: ").append(universidad).append('\n');
        sb.append("Lenguaje de programacion: ").append(lenguajeProgramacion).append('\n');
        sb.append("Tamano del equipo: ").append(tamanoEquipo).append("/3\n\n");
        sb.append("Integrantes:\n");
        for (int i = 0; i < tamanoEquipo; i++) {
            sb.append(i + 1).append(". ").append(programadores[i].nombre).append(' ').append(programadores[i].apellidos).append('\n');
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Equipo registrado", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Metodo main que solicita ingresar por teclado el nombre del
     * equipo, la universidad, el lenguaje de programacion, crea un
     * equipo de maraton de programacion y luego solicita ingresar por
     * teclado tres integrantes del equipo, realizando las validaciones de
     * datos.
     */
    public static void main(String args[]) throws Exception {
        String nombre = JOptionPane.showInputDialog(null, "Nombre del equipo:", "Registro de Equipo", JOptionPane.QUESTION_MESSAGE);
        if (nombre == null || nombre.trim().isEmpty()) { return; }
        String universidad = JOptionPane.showInputDialog(null, "Universidad:", "Registro de Equipo", JOptionPane.QUESTION_MESSAGE);
        if (universidad == null || universidad.trim().isEmpty()) { return; }
        String lenguaje = JOptionPane.showInputDialog(null, "Lenguaje de programacion:", "Registro de Equipo", JOptionPane.QUESTION_MESSAGE);
        if (lenguaje == null || lenguaje.trim().isEmpty()) { return; }

        String requisitos = "Requisitos de la contrasena:\n" +
                "- Minimo 8 caracteres\n" +
                "- No espacios en blanco\n" +
                "- Al menos una letra minuscula\n" +
                "- Al menos una letra mayuscula\n" +
                "- Al menos un numero\n" +
                "- Al menos un caracter especial (!@#$%^&*()_+-=[]{}|;:,.<>?)";
        JOptionPane.showMessageDialog(null, requisitos, "Seguridad", JOptionPane.INFORMATION_MESSAGE);

        boolean contrasenaValida = false;
        String contrasena = "";
        while (!contrasenaValida) {
            try {
                contrasena = JOptionPane.showInputDialog(null, "Ingrese la contrasena del equipo:", "Seguridad", JOptionPane.QUESTION_MESSAGE);
                if (contrasena == null) { return; }
                ValidadorContrasena.validarContrasena(contrasena);
                contrasenaValida = true;
                JOptionPane.showMessageDialog(null, "Contrasena valida!", "Seguridad", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        boolean confirmacionValida = false;
        while (!confirmacionValida) {
            try {
                String confirmacion = JOptionPane.showInputDialog(null, "Confirme la contrasena:", "Seguridad", JOptionPane.QUESTION_MESSAGE);
                if (confirmacion == null) { return; }
                ValidadorContrasena.validarConfirmacion(contrasena, confirmacion);
                confirmacionValida = true;
                JOptionPane.showMessageDialog(null, "Contrasena confirmada exitosamente!", "Seguridad", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        EquipoMaratonProgramacion equipo = new EquipoMaratonProgramacion(nombre.trim(), universidad.trim(), lenguaje.trim());
        for (int i = 0; i < 3; i++) {
            String nombreProgramador = JOptionPane.showInputDialog(null, "Nombre del integrante " + (i + 1) + ":", "Integrantes", JOptionPane.QUESTION_MESSAGE);
            if (nombreProgramador == null) { return; }
            validarCampo(nombreProgramador);
            String apellidosProgramador = JOptionPane.showInputDialog(null, "Apellidos del integrante " + (i + 1) + ":", "Integrantes", JOptionPane.QUESTION_MESSAGE);
            if (apellidosProgramador == null) { return; }
            validarCampo(apellidosProgramador);
            Programador programador = new Programador(nombreProgramador, apellidosProgramador);
            equipo.anadir(programador);
        }

        equipo.mostrarEquipo();
        JOptionPane.showMessageDialog(null, "Equipo registrado exitosamente con contrasena segura", "Exito", JOptionPane.INFORMATION_MESSAGE);
    }
}
