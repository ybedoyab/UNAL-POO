package unal.ejercicio8_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Esta clase denominada VentanaPrisma define una ventana para
 * ingresar los datos de un prisma y calcular su volumen y superficie.
 * EXTENSIÓN DEL EJERCICIO PROPUESTO
 * @version 1.2/2020
 */
public class VentanaPrisma extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base, altura, lados, volumen, superficie;
    private JTextField campoBase, campoAltura, campoLados;
    private JButton calcular;

    /**
     * Constructor de la clase VentanaPrisma
     */
    public VentanaPrisma() {
        inicio();
        setTitle("Prisma");
        setSize(280, 260);
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

        base = new JLabel();
        base.setText("Base (cms):");
        base.setBounds(20, 20, 135, 23);
        campoBase = new JTextField();
        campoBase.setBounds(120, 20, 135, 23);

        altura = new JLabel();
        altura.setText("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 135, 23);

        lados = new JLabel();
        lados.setText("Lados:");
        lados.setBounds(20, 80, 135, 23);
        campoLados = new JTextField();
        campoLados.setBounds(120, 80, 135, 23);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(120, 110, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        volumen.setBounds(20, 140, 135, 23);

        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        superficie.setBounds(20, 170, 135, 23);

        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(lados);
        contenedor.add(campoLados);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    /**
     * Método que gestiona los eventos generados en la ventana del prisma
     */
    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        double base = 0;
        double altura = 0;
        int lados = 0;
        
        try {
            base = Double.parseDouble(campoBase.getText());
            altura = Double.parseDouble(campoAltura.getText());
            lados = Integer.parseInt(campoLados.getText());
            
            if (lados < 3) {
                throw new IllegalArgumentException("El número de lados debe ser mayor o igual a 3");
            }
            
            Prisma prisma = new Prisma(base, altura, lados);
            
            volumen.setText("Volumen (cm3): " + String.format("%.2f", prisma.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", prisma.calcularSuperficie()));
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
