package unal.ejercicio12;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio12 {

    /**
     * Lee un número (double) desde consola. Si el usuario deja la línea vacía,
     * usa el valor por defecto (def). Acepta coma o punto decimal.
     */
    private static double readOrDefault(Scanner in, String prompt, Double def) {
        System.out.print(prompt);
        String line = in.nextLine().trim();
        if (line.isEmpty() && def != null) return def;
        try {
            return Double.parseDouble(line.replace(',', '.'));
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Usando valor por defecto: " + def);
            return def;
        }
    }

    public static void main(String[] args) {
        // Formato local Colombia para moneda
        Locale.setDefault(new Locale("es", "CO"));
        NumberFormat dinero = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        Scanner in = new Scanner(System.in);

        System.out.println("=== Ejercicio 12: Salario bruto, retención (12.5%) y neto ===");
        System.out.println("Presiona Enter para usar los valores del enunciado.\n");

        // Datos (con valores por defecto del enunciado)
        double horas = readOrDefault(in, "Horas trabajadas [48]: ", 48.0);
        double tarifa = readOrDefault(in, "Tarifa por hora [$5000]: ", 5000.0);
        double porcentaje = readOrDefault(in, "Retención en la fuente (%) [12.5]: ", 12.5);

        // Cálculos
        double bruto = horas * tarifa;
        double retencion = bruto * (porcentaje / 100.0);
        double neto = bruto - retencion;

        // Salida
        System.out.println("\n--- Resultados ---");
        System.out.println("Horas trabajadas : " + horas);
        System.out.println("Tarifa por hora  : " + dinero.format(tarifa));
        System.out.println("Salario bruto    : " + dinero.format(bruto));
        System.out.println("Retención (" + porcentaje + "%): " + dinero.format(retencion));
        System.out.println("Salario neto     : " + dinero.format(neto));

        in.close();
    }
}
