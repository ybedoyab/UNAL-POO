package unal.ejercicio8_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Esta clase denominada VentanaCubo define una ventana para
 * ingresar los datos de un cubo y calcular su volumen y superficie.
 * EXTENSIÓN DEL EJERCICIO PROPUESTO
 * @version 1.2/2020
 */
public class VentanaCubo extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel arista, volumen, superficie;
    private JTextField campoArista;
    private JButton calcular;

    /**
     * Constructor de la clase VentanaCubo
     */
    public VentanaCubo() {
        inicio();
        setTitle("Cubo");
        setSize(280, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    /**
     * Método que crea la ventana con sus diferentes componentes gráficos
     */
    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        arista = new JLabel();
        arista.setText("Arista (cms):");
        arista.setBounds(20, 20, 135, 23);
        campoArista = new JTextField();
        campoArista.setBounds(100, 20, 135, 23);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(100, 50, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        volumen.setBounds(20, 90, 135, 23);

        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        superficie.setBounds(20, 120, 135, 23);

        contenedor.add(arista);
        contenedor.add(campoArista);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    /**
     * Método que gestiona los eventos generados en la ventana del cubo
     */
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            boolean error = false;
            try {
                double arista = Double.parseDouble(campoArista.getText());
                Cubo cubo = new Cubo(arista);
                
                volumen.setText("Volumen (cm3): " + String.format("%.2f", cubo.calcularVolumen()));
                superficie.setText("Superficie (cm2): " + String.format("%.2f", cubo.calcularSuperficie()));
            } catch (Exception e) {
                error = true;
            } finally {
                if (error) {
                    JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
