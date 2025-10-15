package unal.ejercicio8_2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Esta clase denominada VentanaPrincipal define una interfaz gráfica
 * que permitirá crear un array de notas. Luego, se puede calcular el
 * promedio de notas, la desviación, la nota mayor y la nota menor del
 * array.
 * 
 * EJERCICIOS PROPUESTOS RESUELTOS:
 * - Validación de datos numéricos con mensajes de alerta
 * - Verificación obligatoria de ingreso de las cinco notas
 * 
 * @author yulcr
 * @version 1.2/2020
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
    
    // Un contenedor de elementos gráficos
    private Container contenedor;
    
    // Etiquetas estáticas de cada nota
    private JLabel nota1, nota2, nota3, nota4, nota5, promedio, desviacion, mayor, menor;
    
    // Campos de ingreso de cada nota
    private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
    
    // Botones para realizar cálculos y para borrar las notas
    private JButton calcular, limpiar;
    
    /**
     * Constructor de la clase VentanaPrincipal
     */
    public VentanaPrincipal() {
        inicio();
        
        setTitle("Notas");
        setSize(280, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    /**
     * Método que crea la ventana con sus diferentes componentes gráficos
     */
    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        
        // Configuración de etiquetas y campos para Nota 1
        nota1 = new JLabel();
        nota1.setText("Nota 1:");
        nota1.setBounds(20, 20, 135, 23);
        
        campoNota1 = new JTextField();
        campoNota1.setBounds(105, 20, 135, 23);
        
        // Configuración de etiquetas y campos para Nota 2
        nota2 = new JLabel();
        nota2.setText("Nota 2:");
        nota2.setBounds(20, 50, 135, 23);
        
        campoNota2 = new JTextField();
        campoNota2.setBounds(105, 50, 135, 23);
        
        // Configuración de etiquetas y campos para Nota 3
        nota3 = new JLabel();
        nota3.setText("Nota 3:");
        nota3.setBounds(20, 80, 135, 23);
        
        campoNota3 = new JTextField();
        campoNota3.setBounds(105, 80, 135, 23);
        
        // Configuración de etiquetas y campos para Nota 4
        nota4 = new JLabel();
        nota4.setText("Nota 4:");
        nota4.setBounds(20, 110, 135, 23);
        
        campoNota4 = new JTextField();
        campoNota4.setBounds(105, 110, 135, 23);
        
        // Configuración de etiquetas y campos para Nota 5
        nota5 = new JLabel();
        nota5.setText("Nota 5:");
        nota5.setBounds(20, 140, 135, 23);
        
        campoNota5 = new JTextField();
        campoNota5.setBounds(105, 140, 135, 23);
        
        // Configuración del botón Calcular
        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(20, 170, 100, 23);
        calcular.addActionListener(this);
        
        // Configuración del botón Limpiar
        limpiar = new JButton();
        limpiar.setText("Limpiar");
        limpiar.setBounds(125, 170, 80, 23);
        limpiar.addActionListener(this);
        
        // Configuración de etiquetas de resultados
        promedio = new JLabel();
        promedio.setText("Promedio = ");
        promedio.setBounds(20, 210, 135, 23);
        
        desviacion = new JLabel();
        desviacion.setText("Desviación = ");
        desviacion.setBounds(20, 240, 200, 23);
        
        mayor = new JLabel();
        mayor.setText("Nota mayor = ");
        mayor.setBounds(20, 270, 120, 23);
        
        menor = new JLabel();
        menor.setText("Nota menor = ");
        menor.setBounds(20, 300, 120, 23);
        
        // Agregar todos los componentes al contenedor
        contenedor.add(nota1);
        contenedor.add(campoNota1);
        contenedor.add(nota2);
        contenedor.add(campoNota2);
        contenedor.add(nota3);
        contenedor.add(campoNota3);
        contenedor.add(nota4);
        contenedor.add(campoNota4);
        contenedor.add(nota5);
        contenedor.add(campoNota5);
        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(promedio);
        contenedor.add(desviacion);
        contenedor.add(mayor);
        contenedor.add(menor);
    }
    
    /**
     * EJERCICIO PROPUESTO 1: Validación de datos numéricos
     * Método que valida si un texto representa un número válido
     * 
     * @param texto El texto a validar
     * @return true si es un número válido, false en caso contrario
     */
    private boolean esNumeroValido(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }
        
        try {
            double valor = Double.parseDouble(texto.trim());
            // Validar que la nota esté en un rango razonable (0-5.0)
            return valor >= 0.0 && valor <= 5.0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * EJERCICIO PROPUESTO 2: Verificación de campos obligatorios
     * Método que verifica si todos los campos de notas han sido ingresados
     * 
     * @return true si todos los campos tienen valores, false en caso contrario
     */
    private boolean todosLosCamposCompletos() {
        String[] textos = {
            campoNota1.getText(),
            campoNota2.getText(),
            campoNota3.getText(),
            campoNota4.getText(),
            campoNota5.getText()
        };
        
        for (String texto : textos) {
            if (texto == null || texto.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Método que muestra un mensaje de error utilizando JOptionPane
     * 
     * @param mensaje El mensaje de error a mostrar
     */
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Método que gestiona los eventos generados en la ventana principal
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if (evento.getSource() == calcular) {
            // EJERCICIO PROPUESTO 2: Verificar que todas las notas estén ingresadas
            if (!todosLosCamposCompletos()) {
                mostrarError("Debe ingresar las cinco notas. Ningún campo puede estar vacío.");
                return;
            }
            
            // EJERCICIO PROPUESTO 1: Validar que todos los valores sean numéricos
            String[] textosNotas = {
                campoNota1.getText(),
                campoNota2.getText(),
                campoNota3.getText(),
                campoNota4.getText(),
                campoNota5.getText()
            };
            
            for (int i = 0; i < textosNotas.length; i++) {
                if (!esNumeroValido(textosNotas[i])) {
                    mostrarError("Error en la Nota " + (i + 1) + ": Debe ingresar un número válido entre 0.0 y 5.0");
                    return;
                }
            }
            
            // Si llegamos aquí, todos los datos son válidos
            try {
                Notas notas = new Notas();
                
                // Convertir y asignar las notas
                double[] valoresNotas = new double[5];
                valoresNotas[0] = Double.parseDouble(campoNota1.getText().trim());
                valoresNotas[1] = Double.parseDouble(campoNota2.getText().trim());
                valoresNotas[2] = Double.parseDouble(campoNota3.getText().trim());
                valoresNotas[3] = Double.parseDouble(campoNota4.getText().trim());
                valoresNotas[4] = Double.parseDouble(campoNota5.getText().trim());
                
                notas.establecerNotas(valoresNotas);
                
                // Calcular y mostrar resultados
                double promedioCalculado = notas.calcularPromedio();
                double desviacionCalculada = notas.calcularDesviacion();
                double mayorCalculado = notas.calcularMayor();
                double menorCalculado = notas.calcularMenor();
                
                // Mostrar resultados formateados
                promedio.setText("Promedio = " + String.format("%.2f", promedioCalculado));
                desviacion.setText("Desviación estándar = " + String.format("%.2f", desviacionCalculada));
                mayor.setText("Valor mayor = " + String.format("%.1f", mayorCalculado));
                menor.setText("Valor menor = " + String.format("%.1f", menorCalculado));
                
            } catch (Exception e) {
                mostrarError("Error inesperado: " + e.getMessage());
            }
        }
        
        if (evento.getSource() == limpiar) {
            // Limpiar todos los campos de entrada
            campoNota1.setText("");
            campoNota2.setText("");
            campoNota3.setText("");
            campoNota4.setText("");
            campoNota5.setText("");
            
            // Limpiar resultados
            promedio.setText("Promedio = ");
            desviacion.setText("Desviación = ");
            mayor.setText("Nota mayor = ");
            menor.setText("Nota menor = ");
        }
    }
}
