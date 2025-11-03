package unal.ejercicio6_4;

public class ExcepcionFueraLimite {
    public static void main(String[] args) {
        try {
            String texto = "Programacion";
            char caracter = texto.charAt(14);
            System.out.println(caracter);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Indice de string por fuera del limite");
        }
    }
}


