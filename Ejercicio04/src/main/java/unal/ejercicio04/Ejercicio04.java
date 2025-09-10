package unal.ejercicio04;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio04 {

    // Formatea: sin decimales cuando el valor es entero; si no, 2 decimales
    private static String fmt(double x) {
        if (Math.abs(x - Math.rint(x)) < 1e-9) {
            return String.format("%.0f", x);
        }
        return String.format(Locale.US, "%.2f", x);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        System.out.print("Ingrese la edad de Juan: ");
        double juan = in.nextDouble();
        if (juan <= 0) {
            System.out.println("La edad debe ser positiva.");
            return;
        }

        double alberto = (2.0 / 3.0) * juan;
        double ana     = (4.0 / 3.0) * juan;
        double mama    = juan + alberto + ana;

        System.out.println("\nLAS EDADES SON:");
        System.out.println("ALBERTO: " + fmt(alberto));
        System.out.println("JUAN:    " + fmt(juan));
        System.out.println("ANA:     " + fmt(ana));
        System.out.println("MAMA:    " + fmt(mama));

        in.close();
    }
}
