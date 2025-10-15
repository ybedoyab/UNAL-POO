package unal.ejercicio8_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Esta clase denominada VentanaEsfera define una ventana para
 * ingresar los datos de una esfera y calcular su volumen y superficie.
 * @version 1.2/2020
 */
public class VentanaEsfera extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, volumen, superficie;
    private JTextField campoRadio;
    private JButton calcular;

    /**
     * Constructor de la clase VentanaEsfera
     */
    public VentanaEsfera() {
        inicio();
        setTitle("Esfera");
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

        radio = new JLabel();
        radio.setText("Radio (cms):");
        radio.setBounds(20, 20, 135, 23);
        campoRadio = new JTextField();
        campoRadio.setBounds(100, 20, 135, 23);

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

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    /**
     * Método que gestiona los eventos generados en la ventana de la esfera
     */
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            boolean error = false;
            try {
                double radio = Double.parseDouble(campoRadio.getText());
                Esfera esfera = new Esfera(radio);
                
                volumen.setText("Volumen (cm3): " + String.format("%.2f", esfera.calcularVolumen()));
                superficie.setText("Superficie (cm2): " + String.format("%.2f", esfera.calcularSuperficie()));
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
