package unal.ejercicio8_5.Hotel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Esta clase denominada Hotel define un hotel que contiene diez
 * habitaciones a ser ocupadas y liberadas por diferentes huéspedes en
 * fechas determinadas.
 * @version 2.0/2024
 */
public class Hotel {
    // Atributo que establece el conjunto de habitaciones del hotel
    public static Vector<Habitación> listaHabitaciones;
    // Historial de ocupaciones
    private static Vector<RegistroOcupacion> historialOcupaciones;

    /**
     * Constructor de la clase Hotel
     */
    public Hotel() {
        // Inicializar historial solo si no existe
        if (historialOcupaciones == null) {
            historialOcupaciones = new Vector<RegistroOcupacion>(); /* Crea el vector
            de historial solo si no existe */
        }
        
        // Inicializar habitaciones solo si el vector está vacío o no existe
        if (listaHabitaciones == null || listaHabitaciones.isEmpty()) {
            if (listaHabitaciones == null) {
                listaHabitaciones = new Vector<Habitación>(); /* Crea el vector
                de habitaciones solo si no existe */
            }

        /* Crea cada habitación con un número de habitación,
        disponibilidad inicial, precio por día y tipo */
        // Habitaciones simples (1-3)
        Habitación habitación1 = new Habitación(1, true, 120000, TipoHabitacion.SIMPLE);
        Habitación habitación2 = new Habitación(2, true, 120000, TipoHabitacion.SIMPLE);
        Habitación habitación3 = new Habitación(3, true, 120000, TipoHabitacion.SIMPLE);
        
        // Habitaciones dobles (4-6)
        Habitación habitación4 = new Habitación(4, true, 150000, TipoHabitacion.DOBLE);
        Habitación habitación5 = new Habitación(5, true, 150000, TipoHabitacion.DOBLE);
        Habitación habitación6 = new Habitación(6, true, 150000, TipoHabitacion.DOBLE);
        
        // Habitaciones triples (7-10)
        Habitación habitación7 = new Habitación(7, true, 180000, TipoHabitacion.TRIPLE);
        Habitación habitación8 = new Habitación(8, true, 180000, TipoHabitacion.TRIPLE);
        Habitación habitación9 = new Habitación(9, true, 180000, TipoHabitacion.TRIPLE);
        Habitación habitación10 = new Habitación(10, true, 180000, TipoHabitacion.TRIPLE);

            // Se agrega cada habitación al vector de habitaciones del hotel
            listaHabitaciones.add(habitación1);
            listaHabitaciones.add(habitación2);
            listaHabitaciones.add(habitación3);
            listaHabitaciones.add(habitación4);
            listaHabitaciones.add(habitación5);
            listaHabitaciones.add(habitación6);
            listaHabitaciones.add(habitación7);
            listaHabitaciones.add(habitación8);
            listaHabitaciones.add(habitación9);
            listaHabitaciones.add(habitación10);
        }
    }

    /**
     * Método que dado un número de habitación, busca la fecha de
     * ingreso de un huésped a dicha habitación
     * @param número Número de habitación a buscar
     * @return Fecha de ingreso a la habitación
     */
    public String buscarFechaIngresoHabitación(int número) {
        for(int i = 0; i < listaHabitaciones.size(); i++) { /* Recorre el vector
        de habitaciones */
            // Obtiene un elemento del vector
            Habitación habitación = (Habitación) listaHabitaciones.
                    elementAt(i);
            if (habitación.getNúmeroHabitación() == número) { /* Si el
            número buscado es encontrado */
                // Se obtiene la fecha de ingreso del primer huésped
                if (habitación.getHuésped() != null) {
                    Date fecha = habitación.getHuésped().getFechaIngreso();
                    // Se le da formato a la fecha de ingreso
                    DateFormat formatoFecha = new
                            SimpleDateFormat("yyyy/MM/dd");
                    return formatoFecha.format(fecha); /* Devuelve la fecha
                    de ingreso */
                }
            }
        }
        return ""; // En caso de no encontrar la habitación
    }

    /**
     * Método que dado un número de habitación, devuelve si la
     * habitación está ocupada o no
     * @param número Número de habitación a buscar
     * @return Valor booleano con la disponibilidad de la habitación
     * buscada
     */
    public boolean buscarHabitaciónOcupada(int número) {
        for(int i = 0; i < listaHabitaciones.size(); i++) { /* Recorre el vector
        de habitaciones */
            // Obtiene un elemento del vector
            Habitación habitación = (Habitación) listaHabitaciones.
                    elementAt(i);
            if (habitación.getNúmeroHabitación() == número &&
                    !habitación.getDisponible()) {
                // Si la habitación está ocupada
                return true;
            }
        }
        return false; // Si la habitación no está ocupada
    }

    /**
     * Método que registra una ocupación en el historial
     * @param registro El registro de ocupación a agregar
     */
    public void agregarRegistroOcupacion(RegistroOcupacion registro) {
        if (historialOcupaciones == null) {
            historialOcupaciones = new Vector<RegistroOcupacion>();
        }
        historialOcupaciones.add(registro);
    }

    /**
     * Método que obtiene el historial de ocupaciones de una habitación
     * @param numeroHabitacion El número de habitación
     * @return Vector con los registros de ocupación de la habitación
     */
    public Vector<RegistroOcupacion> obtenerHistorialHabitacion(int numeroHabitacion) {
        Vector<RegistroOcupacion> historial = new Vector<RegistroOcupacion>();
        if (historialOcupaciones != null) {
            for (RegistroOcupacion registro : historialOcupaciones) {
                if (registro.getNumeroHabitacion() == numeroHabitacion) {
                    historial.add(registro);
                }
            }
        }
        return historial;
    }

    /**
     * Método que obtiene el historial de ocupaciones de un huésped
     * @param documentoIdentidad El documento de identidad del huésped
     * @return Vector con los registros de ocupación del huésped
     */
    public Vector<RegistroOcupacion> obtenerHistorialHuesped(int documentoIdentidad) {
        Vector<RegistroOcupacion> historial = new Vector<RegistroOcupacion>();
        if (historialOcupaciones != null) {
            for (RegistroOcupacion registro : historialOcupaciones) {
                Vector<Huésped> huespedes = registro.getHuespedes();
                if (huespedes != null) {
                    for (Huésped huesped : huespedes) {
                        if (huesped.getDocumentoIdentidad() == documentoIdentidad) {
                            historial.add(registro);
                            break;
                        }
                    }
                }
            }
        }
        return historial;
    }

    /**
     * Método que obtiene todas las ocupaciones históricas
     * @return Vector con todos los registros de ocupación
     */
    public Vector<RegistroOcupacion> obtenerTodoElHistorial() {
        return historialOcupaciones;
    }
}


