package unal.ejercicio8_5.Hotel;

import java.util.Vector;

/**
 * Esta clase denominada Habitación define una habitación de un hotel
 * a ser ocupada y desocupada por uno o más huéspedes.
 * @version 2.0/2024
 */
public class Habitación {
    private int númeroHabitación; /* Atributo que indica el número de
    la habitación */
    private boolean disponible; /* Atributo que indica la disponibilidad
    de la habitación */
    private double precioDía; /* Atributo que indica el precio por día de
    la habitación */
    private TipoHabitacion tipoHabitacion; /* Tipo de habitación: simple, doble o triple */
    private Vector<Huésped> huéspedes; /* Atributo que indica los huéspedes que
    ocupan la habitación */

    /**
     * Constructor de la clase Habitación
     * @param númeroHabitación Parámetro que define el número de la
     * habitación
     * @param disponible Parámetro que define la disponibilidad de la
     * habitación
     * @param precioDía Parámetro que define el precio por día de la
     * habitación
     * @param tipoHabitacion Parámetro que define el tipo de habitación
     */
    public Habitación(int númeroHabitación, boolean disponible,
                     double precioDía, TipoHabitacion tipoHabitacion) {
        this.númeroHabitación = númeroHabitación;
        this.disponible = disponible;
        this.precioDía = precioDía;
        this.tipoHabitacion = tipoHabitacion;
        this.huéspedes = new Vector<Huésped>();
    }

    /**
     * Método que obtiene el número de habitación
     * @return El número de habitación
     */
    public int getNúmeroHabitación() {
        return númeroHabitación;
    }

    /**
     * Método que obtiene la disponibilidad de la habitación
     * @return La disponibilidad de la habitación
     */
    public boolean getDisponible() {
        return disponible;
    }

    /**
     * Método que obtiene el precio por día de la habitación
     * @return El precio por día de la habitación
     */
    public double getPrecioDía() {
        return precioDía;
    }

    /**
     * Método que obtiene el tipo de habitación
     * @return El tipo de habitación
     */
    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    /**
     * Método que obtiene los huéspedes de la habitación
     * @return Los huéspedes de la habitación
     */
    public Vector<Huésped> getHuéspedes() {
        return huéspedes;
    }

    /**
     * Método que obtiene el primer huésped de la habitación (para compatibilidad)
     * @return El primer huésped de la habitación o null si no hay huéspedes
     */
    public Huésped getHuésped() {
        if (huéspedes != null && !huéspedes.isEmpty()) {
            return huéspedes.elementAt(0);
        }
        return null;
    }

    /**
     * Método que establece los huéspedes de la habitación
     * @param huéspedes Parámetro que define los huéspedes de la habitación
     */
    public void setHuéspedes(Vector<Huésped> huéspedes) {
        this.huéspedes = huéspedes;
    }

    /**
     * Método que establece un huésped de la habitación (para compatibilidad)
     * @param huésped Parámetro que define el huésped de la habitación
     */
    public void setHuésped(Huésped huésped) {
        this.huéspedes.clear();
        if (huésped != null) {
            this.huéspedes.add(huésped);
        }
    }

    /**
     * Método que establece la disponibilidad de la habitación
     * @param disponible Parámetro que define la disponibilidad de la habitación
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Método que agrega un huésped a la habitación
     * @param huésped El huésped a agregar
     */
    public void agregarHuésped(Huésped huésped) {
        if (huéspedes == null) {
            huéspedes = new Vector<Huésped>();
        }
        huéspedes.add(huésped);
    }
}


