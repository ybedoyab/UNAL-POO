package unal.ejercicio2_5;

class CuentaBancaria {
    String nombresTitular;
    String apellidosTitular;
    int numeroCuenta;
    enum Tipo { AHORROS, CORRIENTE }
    Tipo tipoCuenta;
    float saldo = 0f;

    // Solucion ejercicios propuestos: nuevo atributo porcentaje de interes mensual
    float interesMensualPorc = 0f;

    CuentaBancaria(String nombresTitular, String apellidosTitular, int numeroCuenta,
                   Tipo tipoCuenta, float interesMensualPorc) {
        this.nombresTitular = nombresTitular;
        this.apellidosTitular = apellidosTitular;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        // Solucion ejercicios propuestos: inicializar interes mensual
        this.interesMensualPorc = interesMensualPorc;
    }

    void imprimir() {
        System.out.println("Nombres del titular = " + nombresTitular);
        System.out.println("Apellidos del titular = " + apellidosTitular);
        System.out.println("Numero de cuenta = " + numeroCuenta);
        System.out.println("Tipo de cuenta = " + tipoCuenta);
        System.out.println("Saldo = " + saldo);
        System.out.println("Interes mensual (%) = " + interesMensualPorc);
    }

    void consultarSaldo() {
        System.out.println("El saldo actual es = " + saldo);
    }

    boolean consignar(int valor) {
        if (valor > 0) {
            saldo = saldo + valor;
            System.out.println("Se ha consignado $" + valor + " en la cuenta. El nuevo saldo es $" + saldo);
            return true;
        } else {
            System.out.println("El valor a consignar debe ser mayor que cero.");
            return false;
        }
    }

    boolean retirar(int valor) {
        if (valor > 0 && valor <= saldo) {
            saldo = saldo - valor;
            System.out.println("Se ha retirado $" + valor + " en la cuenta. El nuevo saldo es $" + saldo);
            return true;
        } else {
            System.out.println("El valor a retirar debe ser menor o igual que el saldo actual.");
            return false;
        }
    }

    // Solucion ejercicios propuestos: calcular y aplicar el nuevo saldo con interes mensual
    float aplicarInteresMensual() {
        float incremento = saldo * (interesMensualPorc / 100f);
        saldo += incremento;
        System.out.println("Se aplico interes mensual. Incremento = $" + incremento + ". Nuevo saldo = $" + saldo);
        return saldo;
    }
}

public class Ejercicio2_5 {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Pedro", "Perez", 123456789,
                CuentaBancaria.Tipo.AHORROS, 1.5f);

        cuenta.imprimir();
        cuenta.consignar(200000);
        cuenta.consignar(300000);
        cuenta.retirar(400000);
        cuenta.aplicarInteresMensual(); // Solucion ejercicios propuestos: demostracion del metodo
    }
}
