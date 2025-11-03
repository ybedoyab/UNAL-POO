package unal.ejercicio6_6;

import java.util.*;

/**
 * Ejercicio Propuesto: Operaciones Matematicas Avanzadas
 * 
 * Esta clase implementa cuatro operaciones matematicas adicionales
 * con manejo apropiado de excepciones usando multiples catch.
 */
public class OperacionesMatematicas {
    
    /**
     * Calcula la pendiente de una recta dados dos puntos
     * @param x1 Coordenada x del primer punto
     * @param y1 Coordenada y del primer punto
     * @param x2 Coordenada x del segundo punto
     * @param y2 Coordenada y del segundo punto
     * @throws ArithmeticException Si los puntos son iguales (division por cero)
     * @throws IllegalArgumentException Si los parametros son invalidos
     */
    public static void calcularPendiente(double x1, double y1, double x2, double y2) {
        try {
            if (x1 == x2 && y1 == y2) {
                throw new ArithmeticException("Los puntos no pueden ser iguales");
            }
            if (x1 == x2) {
                throw new ArithmeticException("La pendiente es infinita (recta vertical)");
            }
            double pendiente = (y2 - y1) / (x2 - x1);
            System.out.println("Pendiente de la recta: " + pendiente);
        } catch (ArithmeticException e) {
            System.out.println("Error aritmetico: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error de argumento: " + e.getMessage());
        }
    }
    
    /**
     * Calcula el punto medio de una recta dados dos puntos
     * @param x1 Coordenada x del primer punto
     * @param y1 Coordenada y del primer punto
     * @param x2 Coordenada x del segundo punto
     * @param y2 Coordenada y del segundo punto
     */
    public static void calcularPuntoMedio(double x1, double y1, double x2, double y2) {
        try {
            double xMedio = (x1 + x2) / 2.0;
            double yMedio = (y1 + y2) / 2.0;
            System.out.println("Punto medio: (" + xMedio + ", " + yMedio + ")");
        } catch (Exception e) {
            System.out.println("Error al calcular el punto medio: " + e.getMessage());
        }
    }
    
    /**
     * Calcula las raices de una ecuacion cuadratica ax^2 + bx + c = 0
     * @param a Coeficiente de x^2
     * @param b Coeficiente de x
     * @param c Termino independiente
     * @throws ArithmeticException Si el discriminante es negativo
     * @throws IllegalArgumentException Si a es cero
     */
    public static void calcularRaicesCuadraticas(double a, double b, double c) {
        try {
            if (a == 0) {
                throw new IllegalArgumentException("El coeficiente 'a' no puede ser cero");
            }
            
            double discriminante = b * b - 4 * a * c;
            
            if (discriminante < 0) {
                throw new ArithmeticException("El discriminante es negativo, no hay raices reales");
            }
            
            if (discriminante == 0) {
                double raiz = -b / (2 * a);
                System.out.println("Raiz unica: " + raiz);
            } else {
                double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                System.out.println("Raiz 1: " + raiz1);
                System.out.println("Raiz 2: " + raiz2);
            }
        } catch (ArithmeticException e) {
            System.out.println("Error aritmetico: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error de argumento: " + e.getMessage());
        }
    }
    
    /**
     * Convierte un numero en base 10 a un numero en base b
     * @param numero Numero en base 10
     * @param base Base de destino (entre 2 y 36)
     * @throws IllegalArgumentException Si la base no esta en el rango valido
     * @throws ArithmeticException Si el numero es negativo
     */
    public static void convertirBase(int numero, int base) {
        try {
            if (base < 2 || base > 36) {
                throw new IllegalArgumentException("La base debe estar entre 2 y 36");
            }
            if (numero < 0) {
                throw new ArithmeticException("El numero debe ser positivo para conversion de base");
            }
            
            String resultado = Integer.toString(numero, base);
            System.out.println(numero + " en base " + base + " = " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error aritmetico: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error de argumento: " + e.getMessage());
        }
    }
    
    public static String pendienteStr(double x1, double y1, double x2, double y2) {
        try {
            if (x1 == x2 && y1 == y2) throw new ArithmeticException("Los puntos no pueden ser iguales");
            if (x1 == x2) throw new ArithmeticException("La pendiente es infinita (recta vertical)");
            double pendiente = (y2 - y1) / (x2 - x1);
            return "- Pendiente entre (" + x1 + "," + y1 + ") y (" + x2 + "," + y2 + "): " + pendiente;
        } catch (Exception e) {
            return "- Pendiente: ERROR - " + e.getMessage();
        }
    }
    
    public static String puntoMedioStr(double x1, double y1, double x2, double y2) {
        try {
            double xMedio = (x1 + x2) / 2.0;
            double yMedio = (y1 + y2) / 2.0;
            return "- Punto medio entre (" + x1 + "," + y1 + ") y (" + x2 + "," + y2 + "): (" + xMedio + ", " + yMedio + ")";
        } catch (Exception e) {
            return "- Punto medio: ERROR - " + e.getMessage();
        }
    }
    
    public static String raicesCuadraticasStr(double a, double b, double c) {
        try {
            if (a == 0) throw new IllegalArgumentException("El coeficiente 'a' no puede ser cero");
            double disc = b * b - 4 * a * c;
            if (disc < 0) throw new ArithmeticException("El discriminante es negativo, no hay raices reales");
            if (disc == 0) {
                double raiz = -b / (2 * a);
                return "- Raiz unica: " + raiz;
            } else {
                double r1 = (-b + Math.sqrt(disc)) / (2 * a);
                double r2 = (-b - Math.sqrt(disc)) / (2 * a);
                return "- Raices de x^2 + (" + b + ")x + " + c + " = 0: " + r1 + ", " + r2;
            }
        } catch (Exception e) {
            return "- Raices cuadraticas: ERROR - " + e.getMessage();
        }
    }
    
    public static String conversionBaseStr(int numero, int base) {
        try {
            if (base < 2 || base > 36) throw new IllegalArgumentException("La base debe estar entre 2 y 36");
            if (numero < 0) throw new ArithmeticException("El numero debe ser positivo para conversion de base");
            String resultado = Integer.toString(numero, base);
            String destino = (base == 16 ? "hexadecimal" : (base == 2 ? "binario" : (base == 8 ? "octal" : "base " + base)));
            String valor = (base == 16 ? resultado.toLowerCase() : resultado);
            return "- " + numero + " (base 10) a " + destino + ": " + valor;
        } catch (Exception e) {
            return "- Conversion de base: ERROR - " + e.getMessage();
        }
    }
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("=== Operaciones Matematicas Avanzadas ===");
        
        // Pruebas de pendiente
        System.out.println("\n1. Calculo de pendiente:");
        calcularPendiente(1, 2, 3, 4); // Caso exitoso
        calcularPendiente(1, 2, 1, 2); // Puntos iguales
        calcularPendiente(1, 2, 1, 4); // Recta vertical
        
        // Pruebas de punto medio
        System.out.println("\n2. Calculo de punto medio:");
        calcularPuntoMedio(1, 2, 5, 6);
        calcularPuntoMedio(-1, -2, 3, 4);
        
        // Pruebas de raices cuadraticas
        System.out.println("\n3. Calculo de raices cuadraticas:");
        calcularRaicesCuadraticas(1, -5, 6); // Dos raices reales
        calcularRaicesCuadraticas(1, -4, 4);  // Una raiz
        calcularRaicesCuadraticas(1, 2, 3);   // Sin raices reales
        calcularRaicesCuadraticas(0, 2, 3);   // a = 0
        
        // Pruebas de conversion de base
        System.out.println("\n4. Conversion de base:");
        convertirBase(10, 2);   // 10 en binario
        convertirBase(255, 16); // 255 en hexadecimal
        convertirBase(100, 8);  // 100 en octal
        convertirBase(10, 1);   // Base invalida
        convertirBase(-5, 2);   // Numero negativo
        
        // Demostracion de catch multiples con operador |
        System.out.println("\n5. Demostracion de catch multiples:");
        try {
            int resultado = 10 / 0;
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Excepcion capturada con operador |: " + e.getMessage());
        }
    }
}
