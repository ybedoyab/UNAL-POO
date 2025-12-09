package unal.ejercicio8_5.Hotel;

/**
 * Enum que define los tipos de habitación disponibles en el hotel
 */
public enum TipoHabitacion {
    SIMPLE(1, 120000),
    DOBLE(2, 150000),
    TRIPLE(3, 180000);

    private final int capacidad;
    private final double precioPorDia;

    TipoHabitacion(int capacidad, double precioPorDia) {
        this.capacidad = capacidad;
        this.precioPorDia = precioPorDia;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }
}


