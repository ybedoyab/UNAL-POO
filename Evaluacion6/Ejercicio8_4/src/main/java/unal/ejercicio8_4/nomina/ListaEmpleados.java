package unal.ejercicio8_4.nomina;

import java.util.*;
import java.io.*;

/**
 * Esta clase denominada ListaEmpleados define un vector de objetos
 * Empleado y un total de la nómina de empleados.
 * @version 1.2/2020
 */
public class ListaEmpleados implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Vector<Empleado> lista; // Atributo que identifica un vector de empleados
    public double totalNómina = 0; /* Atributo que identifica el total de
    la nómina de la empresa */

    /**
     * Constructor de la clase ListaEmpleados
     */
    public ListaEmpleados() {
        lista = new Vector<Empleado>(); // Crea el vector de empleados
    }

    /**
     * Método que agrega un empleado a la lista de empleados
     * @param a Parámetro que define un empleado a agregar a la lista
     * de empleados
     */
    public void agregarEmpleado(Empleado a) {
        lista.add(a);
    }

    /**
     * Método que calcula la nómina total mensual de la empresa
     * @return La nómina total mensual de la empresa
     */
    public double calcularTotalNómina() {
        totalNómina = 0; // Reinicia el total
        for (int i = 0; i < lista.size(); i++) { /* Recorre el vector de
        empleados */
            // Obtiene un elemento de la lista de empleados
            Empleado e = lista.elementAt(i);
            // Calcula el salario de un empleado y lo totaliza
            totalNómina = totalNómina + e.calcularNómina();
        }
        return totalNómina;
    }

    /**
     * Método que convierte los datos de la lista de empleados en una
     * matriz
     */
    public String[][] obtenerMatriz() {
        String datos[][] = new String[lista.size()][3]; // Se crea la matriz
        totalNómina = 0; // Reinicia el total
        for (int i = 0; i < lista.size(); i++) { // Recorre el vector de empleados
            // Obtiene un elemento de la lista de empleados
            Empleado e = lista.elementAt(i);
            /* Coloca el nombre del empleado en la primera columna de
            la matriz */
            datos[i][0] = e.getNombre();
            /* Coloca los apellidos del empleado en la segunda columna
            de la matriz */
            datos[i][1] = e.getApellidos();
            /* Coloca el salario del empleado en la tercera columna de la
            matriz */
            datos[i][2] = Double.toString(e.calcularNómina());
            // Va acumulando el total de nómina mensual de la empresa
            totalNómina = totalNómina + e.calcularNómina();
        }
        return datos;
    }

    /**
     * Método que convierte los datos de la lista de empleados a texto
     */
    public String convertirTexto() {
        String texto = "";
        for (int i = 0; i < lista.size(); i++) { // Recorre el vector de empleados
            // Obtiene un elemento de la lista de empleados
            Empleado e = lista.elementAt(i);
            // Concatena en una variable String los datos de un empleado
            texto = texto + "Nombre = " + e.getNombre() + "\n" +
                    "Apellidos = " + e.getApellidos() + "\n" + "Cargo = " +
                    e.getCargo() + "\n" + "Género = " + e.getGénero() + "\n" +
                    "Salario = $" + e.getSalarioDía() + "\n" + "Días trabajados = " + 
                    e.getDíasTrabajados() + "\n" + "Otros ingresos = $" + 
                    e.getOtrosIngresos() + "\n" + "Pagos saludo = $" +
                    e.getPagosSalud() + "\n" + "Aportes pensiones = $" +
                    e.getAportePensiones() + "\n---------\n";
        }
        // Concatena en una variable String el total de la nómina
        texto = texto + "Total nómina = $" + String.format("%.2f",
                calcularTotalNómina());
        return texto;
    }
    
    /**
     * Método que obtiene un empleado de la lista por índice
     * @param indice El índice del empleado en la lista
     * @return El empleado en el índice especificado, o null si el índice es inválido
     */
    public Empleado obtenerEmpleado(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            return lista.elementAt(indice);
        }
        return null;
    }
    
    /**
     * Método que elimina un empleado de la lista por índice
     * @param indice El índice del empleado a eliminar
     * @return true si se eliminó correctamente, false si el índice es inválido
     */
    public boolean eliminarEmpleado(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            lista.remove(indice);
            return true;
        }
        return false;
    }
    
    /**
     * Método que guarda la lista de empleados en un archivo binario
     * @param archivo El archivo donde se guardará la lista
     * @throws IOException Si ocurre un error al escribir el archivo
     */
    public void guardarBinario(File archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(archivo))) {
            oos.writeObject(this);
        }
    }
    
    /**
     * Método estático que carga una lista de empleados desde un archivo binario
     * @param archivo El archivo desde donde se cargará la lista
     * @return La lista de empleados cargada desde el archivo
     * @throws IOException Si ocurre un error al leer el archivo
     * @throws ClassNotFoundException Si la clase no se encuentra al deserializar
     */
    public static ListaEmpleados cargarBinario(File archivo) 
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(archivo))) {
            return (ListaEmpleados) ois.readObject();
        }
    }
}

