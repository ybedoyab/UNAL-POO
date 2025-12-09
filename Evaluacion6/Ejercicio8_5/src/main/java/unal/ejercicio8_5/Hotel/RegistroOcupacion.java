package unal.ejercicio8_5.Hotel;

import java.util.Date;
import java.util.Vector;

/**
 * Clase que registra una ocupación histórica de una habitación
 */
public class RegistroOcupacion {
    private int numeroHabitacion;
    private Date fechaIngreso;
    private Date fechaSalida;
    private Vector<Huésped> huespedes;
    private double totalPagado;

    public RegistroOcupacion(int numeroHabitacion, Date fechaIngreso, Date fechaSalida, 
                            Vector<Huésped> huespedes, double totalPagado) {
        this.numeroHabitacion = numeroHabitacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.huespedes = huespedes;
        this.totalPagado = totalPagado;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public Vector<Huésped> getHuespedes() {
        return huespedes;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    public int getDiasOcupacion() {
        if (fechaIngreso != null && fechaSalida != null) {
            return (int) ((fechaSalida.getTime() - fechaIngreso.getTime()) / 86400000);
        }
        return 0;
    }
}


