package unal.ejercicio8_3;

/**
 * Esta clase denominada Esfera es una subclase de FiguraGeométrica
 * que cuenta con un radio.
 * @version 1.2/2020
 */
public class Esfera extends FiguraGeometrica {
    private double radio;

    /**
     * Constructor de la clase Esfera
     * @param radio Parámetro de define el radio de una esfera
     */
    public Esfera(double radio) {
        this.radio = radio;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    /**
     * Método para calcular el volumen de una esfera
     * @return El volumen de una esfera
     */
    public double calcularVolumen() {
        double volumen = 1.333 * Math.PI * Math.pow(this.radio, 3.0);
        return volumen;
    }

    /**
     * Método para calcular la superficie de una esfera
     * @return La superficie de una esfera
     */
    public double calcularSuperficie() {
        double superficie = 4.0 * Math.PI * Math.pow(this.radio, 2.0);
        return superficie;
    }
}
