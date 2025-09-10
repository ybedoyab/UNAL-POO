package unal.ejercicio17;

import java.util.Scanner;

public class Ejercicio17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Ingrese el radio del círculo: ");
        double radio = in.nextDouble();

        double area = Math.PI * Math.pow(radio, 2);
        double circunferencia = 2 * Math.PI * radio;

        System.out.println("\nResultados:");
        System.out.println("Radio          : " + radio);
        System.out.println("Área           : " + area);
        System.out.println("Circunferencia : " + circunferencia);

        in.close();
    }
}
