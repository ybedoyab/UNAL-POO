package unal.ejercicio2_4;

class Circulo {
    int radio;
    Circulo(int radio) { this.radio = radio; }
    double calcularArea() { return Math.PI * Math.pow(radio, 2); }
    double calcularPerimetro() { return 2 * Math.PI * radio; }
}

class Rectangulo {
    int base;
    int altura;
    Rectangulo(int base, int altura) { this.base = base; this.altura = altura; }
    double calcularArea() { return base * altura; }
    double calcularPerimetro() { return 2 * base + 2 * altura; }
}

class Cuadrado {
    int lado;
    Cuadrado(int lado) { this.lado = lado; }
    double calcularArea() { return lado * lado; }
    double calcularPerimetro() { return 4 * lado; }
}

class TrianguloRectangulo {
    int base;
    int altura;
    TrianguloRectangulo(int base, int altura) { this.base = base; this.altura = altura; }
    double calcularArea() { return (base * altura) / 2.0; }
    double calcularPerimetro() { return base + altura + calcularHipotenusa(); }
    double calcularHipotenusa() { return Math.pow(base * base + altura * altura, 0.5); }
    void determinarTipoTriangulo() {
        double h = calcularHipotenusa();
        if (base == altura && base == h && altura == h) {
            System.out.println("Es un triangulo equilatero");
        } else if (base != altura && base != h && altura != h) {
            System.out.println("Es un triangulo escaleno");
        } else {
            System.out.println("Es un triangulo isosceles");
        }
    }
}

// Solucion ejercicios propuestos: nueva clase Rombo
class Rombo {
    int lado;
    int diagonalMayor;
    int diagonalMenor;
    Rombo(int lado, int diagonalMayor, int diagonalMenor) {
        this.lado = lado;
        this.diagonalMayor = diagonalMayor;
        this.diagonalMenor = diagonalMenor;
    }
    double calcularArea() { return (diagonalMayor * diagonalMenor) / 2.0; }
    double calcularPerimetro() { return 4 * lado; }
}

// Solucion ejercicios propuestos: nueva clase Trapecio
class Trapecio {
    int baseMayor;
    int baseMenor;
    int altura;
    int ladoIzquierdo;
    int ladoDerecho;
    Trapecio(int baseMayor, int baseMenor, int altura, int ladoIzquierdo, int ladoDerecho) {
        this.baseMayor = baseMayor;
        this.baseMenor = baseMenor;
        this.altura = altura;
        this.ladoIzquierdo = ladoIzquierdo;
        this.ladoDerecho = ladoDerecho;
    }
    double calcularArea() { return (baseMayor + baseMenor) * altura / 2.0; }
    double calcularPerimetro() { return baseMayor + baseMenor + ladoIzquierdo + ladoDerecho; }
}

public class Ejercicio2_4 {
    public static void main(String[] args) {
        Circulo figura1 = new Circulo(2);
        Rectangulo figura2 = new Rectangulo(1, 2);
        Cuadrado figura3 = new Cuadrado(3);
        TrianguloRectangulo figura4 = new TrianguloRectangulo(3, 5);

        System.out.println("El area del circulo es = " + figura1.calcularArea());
        System.out.println("El perimetro del circulo es = " + figura1.calcularPerimetro());
        System.out.println();

        System.out.println("El area del rectangulo es = " + figura2.calcularArea());
        System.out.println("El perimetro del rectangulo es = " + figura2.calcularPerimetro());
        System.out.println();

        System.out.println("El area del cuadrado es = " + figura3.calcularArea());
        System.out.println("El perimetro del cuadrado es = " + figura3.calcularPerimetro());
        System.out.println();

        System.out.println("El area del triangulo es = " + figura4.calcularArea());
        System.out.println("El perimetro del triangulo es = " + figura4.calcularPerimetro());
        figura4.determinarTipoTriangulo();
        System.out.println();

        // pruebas de ejercicios propuestos
        Rombo r = new Rombo(6, 10, 8);
        System.out.println("Rombo -> area = " + r.calcularArea() + ", perimetro = " + r.calcularPerimetro());

        Trapecio t = new Trapecio(10, 6, 4, 5, 5);
        System.out.println("Trapecio -> area = " + t.calcularArea() + ", perimetro = " + t.calcularPerimetro());
    }
}
