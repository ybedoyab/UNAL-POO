package unal.ejercicio9_1;

/**
 * Esta clase denominada Piramide es una subclase de FiguraGeometrica
 * que cuenta con una base, una altura y un apotema.
 * @version 1.0/2024
 */
public class Piramide extends FiguraGeometrica {
    private double base;
    private double altura;
    private double apotema;

    /**
     * Constructor de la clase Piramide
     * @param base Parámetro que define la base de una pirámide
     * @param altura Parámetro que define la altura de una pirámide
     * @param apotema Parámetro que define el apotema de una pirámide
     */
    public Piramide(double base, double altura, double apotema) {
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    /**
     * Método para calcular el volumen de una pirámide
     * @return El volumen de una pirámide
     */
    public double calcularVolumen() {
        double volumen = (Math.pow(base, 2.0) * altura) / 3.0;
        return volumen;
    }

    /**
     * Método para calcular la superficie de una pirámide
     * @return La superficie de una pirámide
     */
    public double calcularSuperficie() {
        double areaBase = Math.pow(base, 2.0);
        double areaLado = 2.0 * base * apotema;
        return areaBase + areaLado;
    }
}

