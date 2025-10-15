package unal.ejercicio8_3;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Esta clase denominada ImagenFigura proporciona métodos para dibujar
 * las figuras geométricas en un panel.
 * EXTENSIÓN DEL EJERCICIO PROPUESTO - Soporte de imágenes
 * @version 1.2/2020
 */
public class ImagenFigura extends JPanel {
    private String tipoFigura;
    private double[] parametros;

    /**
     * Constructor de la clase ImagenFigura
     * @param tipoFigura Tipo de figura a dibujar
     * @param parametros Parámetros de la figura
     */
    public ImagenFigura(String tipoFigura, double... parametros) {
        this.tipoFigura = tipoFigura;
        this.parametros = parametros;
        setPreferredSize(new Dimension(200, 200));
        setBackground(Color.WHITE);
    }

    /**
     * Método para dibujar la figura geométrica
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.BLUE);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        switch (tipoFigura.toLowerCase()) {
            case "cilindro":
                dibujarCilindro(g2d, centerX, centerY);
                break;
            case "esfera":
                dibujarEsfera(g2d, centerX, centerY);
                break;
            case "piramide":
                dibujarPiramide(g2d, centerX, centerY);
                break;
            case "cubo":
                dibujarCubo(g2d, centerX, centerY);
                break;
            case "prisma":
                dibujarPrisma(g2d, centerX, centerY);
                break;
        }
    }

    /**
     * Método para dibujar un cilindro
     */
    private void dibujarCilindro(Graphics2D g2d, int centerX, int centerY) {
        int radio = (int) Math.min(50, parametros.length > 0 ? parametros[0] * 5 : 30);
        int altura = (int) Math.min(80, parametros.length > 1 ? parametros[1] * 5 : 40);
        
        // Cuerpo del cilindro
        g2d.drawOval(centerX - radio, centerY - altura/2, radio * 2, altura);
        
        // Base superior
        g2d.drawOval(centerX - radio, centerY - altura/2 - 5, radio * 2, 10);
        
        // Base inferior
        g2d.drawOval(centerX - radio, centerY + altura/2 - 5, radio * 2, 10);
    }

    /**
     * Método para dibujar una esfera
     */
    private void dibujarEsfera(Graphics2D g2d, int centerX, int centerY) {
        int radio = (int) Math.min(60, parametros.length > 0 ? parametros[0] * 8 : 40);
        g2d.drawOval(centerX - radio, centerY - radio, radio * 2, radio * 2);
        
        // Líneas de contorno para dar efecto 3D
        g2d.drawArc(centerX - radio, centerY - radio/2, radio * 2, radio, 0, 180);
        g2d.drawArc(centerX - radio, centerY - radio/2, radio * 2, radio, 0, -180);
    }

    /**
     * Método para dibujar una pirámide
     */
    private void dibujarPiramide(Graphics2D g2d, int centerX, int centerY) {
        int base = (int) Math.min(80, parametros.length > 0 ? parametros[0] * 10 : 50);
        int altura = (int) Math.min(60, parametros.length > 1 ? parametros[1] * 8 : 40);
        
        // Base de la pirámide
        g2d.drawRect(centerX - base/2, centerY + altura/2, base, base);
        
        // Vértice superior
        int verticeY = centerY - altura/2;
        
        // Líneas desde el vértice a las esquinas de la base
        g2d.drawLine(centerX, verticeY, centerX - base/2, centerY + altura/2);
        g2d.drawLine(centerX, verticeY, centerX + base/2, centerY + altura/2);
        g2d.drawLine(centerX, verticeY, centerX - base/2, centerY + altura/2 + base);
        g2d.drawLine(centerX, verticeY, centerX + base/2, centerY + altura/2 + base);
    }

    /**
     * Método para dibujar un cubo
     */
    private void dibujarCubo(Graphics2D g2d, int centerX, int centerY) {
        int lado = (int) Math.min(60, parametros.length > 0 ? parametros[0] * 8 : 40);
        
        // Cara frontal
        g2d.drawRect(centerX - lado/2, centerY - lado/2, lado, lado);
        
        // Cara trasera (con perspectiva)
        int offset = lado/3;
        g2d.drawRect(centerX - lado/2 + offset, centerY - lado/2 + offset, lado, lado);
        
        // Líneas de conexión
        g2d.drawLine(centerX - lado/2, centerY - lado/2, centerX - lado/2 + offset, centerY - lado/2 + offset);
        g2d.drawLine(centerX + lado/2, centerY - lado/2, centerX + lado/2 + offset, centerY - lado/2 + offset);
        g2d.drawLine(centerX - lado/2, centerY + lado/2, centerX - lado/2 + offset, centerY + lado/2 + offset);
        g2d.drawLine(centerX + lado/2, centerY + lado/2, centerX + lado/2 + offset, centerY + lado/2 + offset);
    }

    /**
     * Método para dibujar un prisma
     */
    private void dibujarPrisma(Graphics2D g2d, int centerX, int centerY) {
        int base = (int) Math.min(60, parametros.length > 0 ? parametros[0] * 8 : 40);
        int altura = (int) Math.min(50, parametros.length > 1 ? parametros[1] * 6 : 30);
        
        // Base del prisma
        g2d.drawRect(centerX - base/2, centerY + altura/2, base, altura);
        
        // Líneas superiores (perspectiva)
        int offset = base/4;
        g2d.drawLine(centerX - base/2, centerY + altura/2, centerX - base/2 + offset, centerY - altura/2);
        g2d.drawLine(centerX + base/2, centerY + altura/2, centerX + base/2 + offset, centerY - altura/2);
        g2d.drawLine(centerX - base/2, centerY + altura/2 + altura, centerX - base/2 + offset, centerY - altura/2 + altura);
        g2d.drawLine(centerX + base/2, centerY + altura/2 + altura, centerX + base/2 + offset, centerY - altura/2 + altura);
        
        // Cara superior
        g2d.drawRect(centerX - base/2 + offset, centerY - altura/2, base, altura);
    }
}
