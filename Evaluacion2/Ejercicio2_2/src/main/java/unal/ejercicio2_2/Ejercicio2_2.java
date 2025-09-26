package unal.ejercicio2_2;

class Planeta {
    String nombre = null;
    int cantidadSatelites = 0;
    double masa = 0;
    double volumen = 0;
    int diametro = 0;
    int distanciaSol = 0; // km
    enum TipoPlaneta { GASEOSO, TERRESTRE, ENANO }
    TipoPlaneta tipo;
    boolean esObservable = false;

    // Ejercicios propuestos: nuevos atributos
    double periodoOrbitalAnnios = 0.0; // anios
    double periodoRotacionDias = 0.0;  // dias

    Planeta(String nombre,
            int cantidadSatelites,
            double masa,
            double volumen,
            int diametro,
            int distanciaSol,
            TipoPlaneta tipo,
            boolean esObservable,
            double periodoOrbitalAnnios,
            double periodoRotacionDias) {

        this.nombre = nombre;
        this.cantidadSatelites = cantidadSatelites;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.distanciaSol = distanciaSol;
        this.tipo = tipo;
        this.esObservable = esObservable;
        this.periodoOrbitalAnnios = periodoOrbitalAnnios;
        this.periodoRotacionDias = periodoRotacionDias;
    }

    void imprimir() {
        System.out.println("Nombre del planeta = " + nombre);
        System.out.println("Cantidad de satelites = " + cantidadSatelites);
        System.out.println("Masa del planeta = " + masa);
        System.out.println("Volumen del planeta = " + volumen);
        System.out.println("Diametro del planeta = " + diametro);
        System.out.println("Distancia al sol = " + distanciaSol);
        System.out.println("Tipo de planeta = " + tipo);
        System.out.println("Es observable = " + esObservable);
        System.out.println("Periodo orbital (anios) = " + periodoOrbitalAnnios);
        System.out.println("Periodo de rotacion (dias) = " + periodoRotacionDias);
    }

    double calcularDensidad() {
        return masa / volumen;
    }

    boolean esPlanetaExterior() {
        double limiteKm = 149_597_870d * 3.4d; // 3.4 UA en km
        return distanciaSol > limiteKm;
    }
}

public class Ejercicio2_2 {
    public static void main(String[] args) {
        Planeta tierra = new Planeta(
                "Tierra",
                1,
                5.9736E24,
                1.08321E12,
                12742,
                150_000_000,
                Planeta.TipoPlaneta.TERRESTRE,
                true,
                1.0,
                0.99726968
        );

        Planeta jupiter = new Planeta(
                "Jupiter",
                79,
                1.899E27,
                1.4313E15,
                139_820,
                750_000_000,
                Planeta.TipoPlaneta.GASEOSO,
                true,
                11.86,
                0.41354
        );

        tierra.imprimir();
        System.out.println("Densidad del planeta = " + tierra.calcularDensidad());
        System.out.println("Es planeta exterior = " + tierra.esPlanetaExterior());
        System.out.println();

        jupiter.imprimir();
        System.out.println("Densidad del planeta = " + jupiter.calcularDensidad());
        System.out.println("Es planeta exterior = " + jupiter.esPlanetaExterior());
    }
}
