package unal.ejercicio14;

import java.util.Scanner;

public class Ejercicio14 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Ingrese un número: ");
        double numero = in.nextDouble();

        double cuadrado = Math.pow(numero, 2);
        double cubo = Math.pow(numero, 3);

        System.out.println("\nResultados:");
        System.out.println("Número   : " + numero);
        System.out.println("Cuadrado : " + cuadrado);
        System.out.println("Cubo     : " + cubo);

        in.close();
    }
}
