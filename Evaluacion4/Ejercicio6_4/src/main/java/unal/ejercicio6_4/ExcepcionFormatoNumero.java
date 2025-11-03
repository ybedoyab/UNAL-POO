package unal.ejercicio6_4;

public class ExcepcionFormatoNumero {
    public static void main(String[] args) {
        try {
            int numero = Integer.parseInt("Numero");
            System.out.println(numero);
        } catch (NumberFormatException e) {
            System.out.println("Excepcion de formato de numero");
        } finally {
            System.out.println("Ingresando al finally");
        }
    }
}


