package unal.ejercicio8_3;

/**
 * Esta clase denominada Cubo es una subclase de FiguraGeométrica
 * que cuenta con una arista.
 * EXTENSIÓN DEL EJERCICIO PROPUESTO
 * @version 1.2/2020
 */
public class Cubo extends FiguraGeometrica {
    private double arista;

    /**
     * Constructor de la clase Cubo
     * @param arista Parámetro que define la arista de un cubo
     */
    public Cubo(double arista) {
        this.arista = arista;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    /**
     * Método para calcular el volumen de un cubo
     * @return El volumen de un cubo
     */
    public double calcularVolumen() {
        double volumen = Math.pow(arista, 3.0);
        return volumen;
    }

    /**
     * Método para calcular la superficie de un cubo
     * @return La superficie de un cubo
     */
    public double calcularSuperficie() {
        double superficie = 6.0 * Math.pow(arista, 2.0);
        return superficie;
    }
}
