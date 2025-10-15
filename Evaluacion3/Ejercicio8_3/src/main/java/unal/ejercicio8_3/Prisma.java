package unal.ejercicio8_3;

/**
 * Esta clase denominada Prisma es una subclase de FiguraGeométrica
 * que cuenta con una base, altura y número de lados.
 * EXTENSIÓN DEL EJERCICIO PROPUESTO
 * @version 1.2/2020
 */
public class Prisma extends FiguraGeometrica {
    private double base;
    private double altura;
    private int lados;

    /**
     * Constructor de la clase Prisma
     * @param base Parámetro que define la base de un prisma
     * @param altura Parámetro que define la altura de un prisma
     * @param lados Parámetro que define el número de lados de un prisma
     */
    public Prisma(double base, double altura, int lados) {
        this.base = base;
        this.altura = altura;
        this.lados = lados;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    /**
     * Método para calcular el volumen de un prisma
     * @return El volumen de un prisma
     */
    public double calcularVolumen() {
        double areaBase = (lados * Math.pow(base, 2.0)) / (4.0 * Math.tan(Math.PI / lados));
        double volumen = areaBase * altura;
        return volumen;
    }

    /**
     * Método para calcular la superficie de un prisma
     * @return La superficie de un prisma
     */
    public double calcularSuperficie() {
        double areaBase = (lados * Math.pow(base, 2.0)) / (4.0 * Math.tan(Math.PI / lados));
        double areaLateral = lados * base * altura;
        double superficie = 2.0 * areaBase + areaLateral;
        return superficie;
    }
}
