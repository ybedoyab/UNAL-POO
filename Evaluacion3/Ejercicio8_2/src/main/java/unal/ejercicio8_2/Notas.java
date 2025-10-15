package unal.ejercicio8_2;

/**
 * Esta clase denominada Notas define un array de notas numéricas de
 * tipo double y proporciona métodos para realizar cálculos estadísticos
 * sobre dichas notas.
 * 
 * @author yulcr
 * @version 1.2/2020
 */
public class Notas {
    
    /**
     * Atributo que identifica un array de notas de tipo double.
     * Este array almacena las 5 notas ingresadas por el usuario.
     */
    private double[] listaNotas;
    
    /**
     * Constructor de la clase Notas, instancia un array con 5 notas de
     * tipo double inicializadas en 0.0.
     */
    public Notas() {
        listaNotas = new double[5];
    }
    
    /**
     * Método que calcula el promedio de notas.
     * Suma todas las notas del array y las divide entre el número total de notas.
     * 
     * @return El promedio de notas calculado como double
     */
    public double calcularPromedio() {
        double suma = 0;
        // CORRECCIÓN: El bucle original tenía un error - iniciaba en i=1 en lugar de i=0
        // Esto causaba que se omitiera la primera nota en el cálculo del promedio
        for(int i = 0; i < listaNotas.length; i++) {
            suma = suma + listaNotas[i];
        }
        return (suma / listaNotas.length);
    }

    /**
     * Método que calcula la desviación estándar del array de notas.
     * Utiliza la fórmula: sqrt(Σ(xi - μ)² / n)
     * donde xi es cada nota, μ es el promedio y n es el número de notas.
     * 
     * @return La desviación estándar del array de notas como double
     */
    public double calcularDesviacion() {
        double promedio = calcularPromedio();
        double suma = 0;
        
        for(int i = 0; i < listaNotas.length; i++) {
            suma += Math.pow(listaNotas[i] - promedio, 2);
        }
        
        return Math.sqrt(suma / listaNotas.length);
    }
    
    /**
     * Método que calcula el valor menor del array de notas.
     * Recorre todo el array comparando cada elemento para encontrar el menor.
     * 
     * @return El valor menor del array de notas como double
     */
    public double calcularMenor() {
        double menor = listaNotas[0];
        
        for(int i = 1; i < listaNotas.length; i++) {
            if (listaNotas[i] < menor) {
                menor = listaNotas[i];
            }
        }
        
        return menor;
    }
    
    /**
     * Método que calcula el valor mayor del array de notas.
     * Recorre todo el array comparando cada elemento para encontrar el mayor.
     * 
     * @return El valor mayor del array de notas como double
     */
    public double calcularMayor() {
        double mayor = listaNotas[0];
        
        for(int i = 1; i < listaNotas.length; i++) {
            if (listaNotas[i] > mayor) {
                mayor = listaNotas[i];
            }
        }
        
        return mayor;
    }
    
    /**
     * Método para establecer las notas en el array.
     * 
     * @param notas Array de notas de tipo double
     * @throws IllegalArgumentException Si el array no tiene exactamente 5 elementos
     */
    public void establecerNotas(double[] notas) {
        if (notas == null || notas.length != 5) {
            throw new IllegalArgumentException("Debe proporcionar exactamente 5 notas");
        }
        
        for (int i = 0; i < 5; i++) {
            this.listaNotas[i] = notas[i];
        }
    }
    
    /**
     * Método para obtener una copia del array de notas.
     * 
     * @return Una copia del array de notas
     */
    public double[] obtenerNotas() {
        return listaNotas.clone();
    }
    
    /**
     * Método para verificar si todas las notas han sido ingresadas.
     * Una nota se considera ingresada si es diferente de 0.0.
     * 
     * @return true si todas las notas han sido ingresadas, false en caso contrario
     */
    public boolean todasLasNotasIngresadas() {
        for (double nota : listaNotas) {
            if (nota == 0.0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Método para limpiar todas las notas, estableciendo el array en 0.0.
     */
    public void limpiarNotas() {
        for (int i = 0; i < listaNotas.length; i++) {
            listaNotas[i] = 0.0;
        }
    }
}
