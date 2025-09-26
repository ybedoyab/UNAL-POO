package unal.ejercicio2_3;

class Automovil {
    String marca;
    int modelo;
    int motor;
    enum TipoCom { GASOLINA, BIOETANOL, DIESEL, BIODIESEL, GAS_NATURAL }
    TipoCom tipoCombustible;
    enum TipoA { CIUDAD, SUBCOMPACTO, COMPACTO, FAMILIAR, EJECUTIVO, SUV }
    TipoA tipoAutomovil;
    int numeroPuertas;
    int cantidadAsientos;
    int velocidadMaxima;
    enum TipoColor { BLANCO, NEGRO, ROJO, NARANJA, AMARILLO, VERDE, AZUL, VIOLETA }
    TipoColor color;
    int velocidadActual = 0;

    // Solucion ejercicio propuesto: atributo esAutomatico
    boolean esAutomatico;

    // Solucion ejercicio propuesto: contador de multas
    int multas = 0;

    Automovil(String marca, int modelo, int motor, TipoCom tipoCombustible,
              TipoA tipoAutomovil, int numeroPuertas, int cantidadAsientos,
              int velocidadMaxima, TipoColor color,
              boolean esAutomatico) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.tipoCombustible = tipoCombustible;
        this.tipoAutomovil = tipoAutomovil;
        this.numeroPuertas = numeroPuertas;
        this.cantidadAsientos = cantidadAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.color = color;
        this.esAutomatico = esAutomatico;
    }

    String getMarca() { return marca; }
    int getModelo() { return modelo; }
    int getMotor() { return motor; }
    TipoCom getTipoCombustible() { return tipoCombustible; }
    TipoA getTipoAutomovil() { return tipoAutomovil; }
    int getNumeroPuertas() { return numeroPuertas; }
    int getCantidadAsientos() { return cantidadAsientos; }
    int getVelocidadMaxima() { return velocidadMaxima; }
    TipoColor getColor() { return color; }
    int getVelocidadActual() { return velocidadActual; }

    // Solucion ejercicio propuesto: getters extra
    boolean getEsAutomatico() { return esAutomatico; }
    int getMultas() { return multas; }

    void setMarca(String marca) { this.marca = marca; }
    void setModelo(int modelo) { this.modelo = modelo; }
    void setMotor(int motor) { this.motor = motor; }
    void setTipoCombustible(TipoCom tipoCombustible) { this.tipoCombustible = tipoCombustible; }
    void setTipoAutomovil(TipoA tipoAutomovil) { this.tipoAutomovil = tipoAutomovil; }
    void setNumeroPuertas(int numeroPuertas) { this.numeroPuertas = numeroPuertas; }
    void setCantidadAsientos(int cantidadAsientos) { this.cantidadAsientos = cantidadAsientos; }
    void setVelocidadMaxima(int velocidadMaxima) { this.velocidadMaxima = velocidadMaxima; }
    void setColor(TipoColor color) { this.color = color; }
    void setVelocidadActual(int velocidadActual) { this.velocidadActual = velocidadActual; }

    // Solucion ejercicio propuesto: setter extra
    void setEsAutomatico(boolean esAutomatico) { this.esAutomatico = esAutomatico; }

    void acelerar(int incrementoVelocidad) {
        int nueva = velocidadActual + incrementoVelocidad;
        if (nueva <= velocidadMaxima) {
            velocidadActual = nueva;
        } else {
            // Solucion ejercicio propuesto: generar multa al exceder
            multas++;
            System.out.println("No se puede exceder la velocidad maxima. Multa generada.");
            velocidadActual = velocidadMaxima;
        }
    }

    void desacelerar(int decrementoVelocidad) {
        int nueva = velocidadActual - decrementoVelocidad;
        if (nueva >= 0) {
            velocidadActual = nueva;
        } else {
            System.out.println("No se puede desacelerar a velocidad negativa.");
            velocidadActual = 0;
        }
    }

    void frenar() {
        velocidadActual = 0;
    }

    double calcularTiempoLlegada(int distanciaKm) {
        if (velocidadActual <= 0) return Double.POSITIVE_INFINITY;
        return distanciaKm / (double) velocidadActual;
    }

    // Solucion ejercicio propuesto: metodos de multas
    boolean tieneMultas() { return multas > 0; }
    int getTotalMultas() { return multas; }

    void imprimir() {
        System.out.println("Marca = " + marca);
        System.out.println("Modelo = " + modelo);
        System.out.println("Motor = " + motor);
        System.out.println("Tipo de combustible = " + tipoCombustible);
        System.out.println("Tipo de automovil = " + tipoAutomovil);
        System.out.println("Numero de puertas = " + numeroPuertas);
        System.out.println("Cantidad de asientos = " + cantidadAsientos);
        System.out.println("Velocidad maxima = " + velocidadMaxima);
        System.out.println("Color = " + color);
        System.out.println("Velocidad actual = " + velocidadActual);
        System.out.println("Es automatico = " + esAutomatico);
        System.out.println("Multas = " + multas);
    }
}

public class Ejercicio2_3 {
    public static void main(String[] args) {
        Automovil auto = new Automovil(
                "Ford",
                2018,
                3,
                Automovil.TipoCom.DIESEL,
                Automovil.TipoA.EJECUTIVO,
                5,
                5,
                250,
                Automovil.TipoColor.NEGRO,
                true
        );

        auto.imprimir();

        auto.setVelocidadActual(100);
        System.out.println("Velocidad actual = " + auto.getVelocidadActual());

        auto.acelerar(20);
        System.out.println("Velocidad actual = " + auto.getVelocidadActual());

        auto.desacelerar(50);
        System.out.println("Velocidad actual = " + auto.getVelocidadActual());

        auto.frenar();
        System.out.println("Velocidad actual = " + auto.getVelocidadActual());

        auto.desacelerar(20); // mensaje por intento de negativa
        System.out.println("Tiene multas = " + auto.tieneMultas());
        System.out.println("Total multas = " + auto.getTotalMultas());
    }
}
