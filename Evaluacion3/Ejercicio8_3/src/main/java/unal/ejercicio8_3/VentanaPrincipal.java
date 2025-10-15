package unal.ejercicio8_3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Esta clase denominada VentanaPrincipal define una interfaz gráfica
 * que permitirá consultar un menú principal con tres figuras geométricas.
 * @version 1.2/2020
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JButton cilindro, esfera, piramide, cubo, prisma;

    /**
     * Constructor de la clase VentanaPrincipal
     */
    public VentanaPrincipal() {
        inicio();
        setTitle("Figuras");
        setSize(450, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Método que crea la ventana con sus diferentes componentes gráficos
     */
    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        cilindro = new JButton();
        cilindro.setText("Cilindro");
        cilindro.setBounds(20, 50, 80, 23);
        cilindro.addActionListener(this);

        esfera = new JButton();
        esfera.setText("Esfera");
        esfera.setBounds(125, 50, 80, 23);
        esfera.addActionListener(this);

        piramide = new JButton();
        piramide.setText("Pirámide");
        piramide.setBounds(225, 50, 100, 23);
        piramide.addActionListener(this);

        cubo = new JButton();
        cubo.setText("Cubo");
        cubo.setBounds(20, 90, 80, 23);
        cubo.addActionListener(this);

        prisma = new JButton();
        prisma.setText("Prisma");
        prisma.setBounds(125, 90, 80, 23);
        prisma.addActionListener(this);

        contenedor.add(cilindro);
        contenedor.add(esfera);
        contenedor.add(piramide);
        contenedor.add(cubo);
        contenedor.add(prisma);
    }

    /**
     * Método que gestiona los eventos generados en la ventana principal
     */
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == esfera) {
            VentanaEsfera ventanaEsfera = new VentanaEsfera();
            ventanaEsfera.setVisible(true);
        }
        if (evento.getSource() == cilindro) {
            VentanaCilindro ventanaCilindro = new VentanaCilindro();
            ventanaCilindro.setVisible(true);
        }
        if (evento.getSource() == piramide) {
            VentanaPiramide ventanaPiramide = new VentanaPiramide();
            ventanaPiramide.setVisible(true);
        }
        if (evento.getSource() == cubo) {
            VentanaCubo ventanaCubo = new VentanaCubo();
            ventanaCubo.setVisible(true);
        }
        if (evento.getSource() == prisma) {
            VentanaPrisma ventanaPrisma = new VentanaPrisma();
            ventanaPrisma.setVisible(true);
        }
    }
}
