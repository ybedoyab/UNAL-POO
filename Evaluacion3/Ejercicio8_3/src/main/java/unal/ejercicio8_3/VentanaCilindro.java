package unal.ejercicio8_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Esta clase denominada VentanaCilindro define una ventana para
 * ingresar los datos de un cilindro y calcular su volumen y superficie.
 * @version 1.2/2020
 */
public class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, altura, volumen, superficie;
    private JTextField campoRadio, campoAltura;
    private JButton calcular;
    private ImagenFigura imagenFigura;

    /**
     * Constructor de la clase VentanaCilindro
     */
    public VentanaCilindro() {
        inicio();
        setTitle("Cilindro");
        setSize(500, 250);
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

        altura = new JLabel();
        altura.setText("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(100, 50, 135, 23);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(100, 80, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        volumen.setBounds(20, 110, 135, 23);

        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        superficie.setBounds(20, 140, 135, 23);

        imagenFigura = new ImagenFigura("cilindro", 0, 0);
        imagenFigura.setBounds(250, 20, 220, 180);

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        contenedor.add(imagenFigura);
    }

    /**
     * Método que gestiona los eventos generados en la ventana del cilindro
     */
    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        double radio = 0;
        double altura = 0;
        
        try {
            radio = Double.parseDouble(campoRadio.getText());
            altura = Double.parseDouble(campoAltura.getText());
            Cilindro cilindro = new Cilindro(radio, altura);
            
            volumen.setText("Volumen (cm3): " + String.format("%.2f", cilindro.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", cilindro.calcularSuperficie()));
            
            imagenFigura = new ImagenFigura("cilindro", radio, altura);
            imagenFigura.setBounds(250, 20, 220, 180);
            contenedor.remove(contenedor.getComponent(contenedor.getComponentCount() - 1));
            contenedor.add(imagenFigura);
            repaint();
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de numero",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
