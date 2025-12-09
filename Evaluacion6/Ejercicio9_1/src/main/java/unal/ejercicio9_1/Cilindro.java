package unal.ejercicio9_1;

/**
 * Esta clase denominada Cilindro es una subclase de FiguraGeometrica
 * que cuenta con un radio y una altura.
 * @version 1.0/2024
 */
public class Cilindro extends FiguraGeometrica {
    private double radio;
    private double altura;

    /**
     * Constructor de la clase Cilindro
     * @param radio Parámetro que define el radio de un cilindro
     * @param altura Parámetro que define la altura de un cilindro
     */
    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    /**
     * Método para calcular el volumen de un cilindro
     * @return El volumen de un cilindro
     */
    public double calcularVolumen() {
        double volumen = Math.PI * altura * Math.pow(radio, 2.0);
        return volumen;
    }

    /**
     * Método para calcular la superficie de un cilindro
     * @return La superficie de un cilindro
     */
    public double calcularSuperficie() {
        double areaLadoA = 2.0 * Math.PI * radio * altura;
        double areaLadoB = 2.0 * Math.PI * Math.pow(radio, 2.0);
        return areaLadoA + areaLadoB;
    }
}

