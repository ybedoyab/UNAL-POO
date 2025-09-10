package unal.ejercicio05;

public class Ejercicio05 {

    public static void main(String[] args) {
        double SUMA = 0;
        int X = 20;
        SUMA = SUMA + X;
        int Y = 40;
        X = (int) (X + Math.pow(Y, 2)); // X = 20 + 40^2 = 1620
        SUMA = SUMA + (double) X / Y;   // 20 + 1620/40 = 60.5

        System.out.println("EL VALOR DE LA SUMA ES: " + SUMA);
    }
}
