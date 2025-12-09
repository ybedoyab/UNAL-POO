package unal.ejercicio8_5.Hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;

/**
 * Esta clase denominada VentanaSalida define una ventana que permite
 * registrar la salida de un huésped y su pago correspondiente de
 * acuerdo al número de días de alojamiento.
 * @version 2.0/2024
 */
public class VentanaSalida extends JFrame implements ActionListener {
    private Container contenedor; /* Un contenedor de elementos
    gráficos*/
    private JLabel habitación; // Etiqueta de habitación ocupada
    // Etiquetas de fecha de ingreso, de salida y días de alojamiento
    private JLabel fechaIngreso, fechaSalida, cantidadDías;
    private JTextField campoFechaSalida; /* Campo de texto para
    ingresar fecha de salida */
    private JLabel totalPago; // Etiqueta del total a pagar por alojamiento
    /* Botón para calcular el valor a pagar y para registrar la salida del
    huésped */
    private JButton calcular, registrarSalida;
    private Hotel hotel; // Objeto Hotel
    private int númeroHabitación; // Número de la habitación ocupada
    private int posiciónHabitación; /* Posición de la habitación en el
    vector de habitaciones */
    private Habitación habitaciónOcupada; /* Habitación ocupada por
    el huésped */

    /**
     * Constructor de la clase VentanaSalida
     * @param hotel Parámetro que define el hotel con habitaciones y
     * huéspedes
     * @param número Parámetro que define el número de habitación
     * ocupada
     */
    public VentanaSalida(Hotel hotel, int número) {
        this.hotel = hotel;
        this.númeroHabitación = número;
        inicio();
        setTitle("Salida huéspedes"); // Establece el título de la ventana
        setSize(260,260); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); /* La ventana se posiciona en el
        centro de la pantalla */
        setResizable(false); /* Establece que el tamaño de la ventana no
        puede cambiar */
    }

    /**
     * Método que crea la ventana con sus diferentes componentes
     * gráficos
     */
    private void inicio() {
        contenedor = getContentPane(); /* Obtiene el panel de
        contenidos de la ventana */
        // Establece que el contenedor tendrá un GridBagLayout
        contenedor.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints(); /* Define las
        restricciones del layout */
        c.fill = GridBagConstraints.HORIZONTAL; /* El layout es
        horizontal */
        c.insets = new Insets(3,3,3,3); /* Define los bordes del
        contenedor */

        // Establece la etiqueta de la habitación
        habitación = new JLabel();
        habitación.setText("Habitación: " + númeroHabitación);
        c.gridx = 0;
        c.gridy = 0;
        contenedor.add(habitación, c);

        // Obtiene la fecha de ingreso para un número de habitación
        String fecha = hotel.
                buscarFechaIngresoHabitación(númeroHabitación);
        fechaIngreso = new JLabel();
        fechaIngreso.setText("Fecha de ingreso: " + fecha);
        c.gridx = 0;
        c.gridy = 1;
        contenedor.add(fechaIngreso, c);

        /* Establece la etiqueta y campo de texto de la fecha de salida de
        la habitación */
        fechaSalida = new JLabel();
        fechaSalida.setText("Fecha de salida (aaaa-mm-dd): ");
        c.gridx = 0;
        c.gridy = 2;
        contenedor.add(fechaSalida, c);

        campoFechaSalida = new JTextField();
        c.gridx = 0;
        c.gridy = 3;
        contenedor.add(campoFechaSalida, c);

        // Establece el botón calcular
        calcular = new JButton("Calcular");
        c.gridx = 0;
        c.gridy = 4;
        contenedor.add(calcular, c);
        calcular.addActionListener(this);

        // Establece la etiqueta cantidad de días de alojamiento
        cantidadDías = new JLabel();
        cantidadDías.setText("Cantidad de días: ");
        c.gridx = 0;
        c.gridy = 5;
        contenedor.add(cantidadDías, c);

        // Establece la etiqueta de total a pagar
        totalPago = new JLabel();
        totalPago.setText("Total: $");
        c.gridx = 0;
        c.gridy = 6;
        contenedor.add(totalPago, c);

        // Establece el botón registrar salida del huésped
        registrarSalida = new JButton("Registrar Salida");
        c.gridx = 0;
        c.gridy = 7;
        contenedor.add(registrarSalida, c);
        registrarSalida.setEnabled(false);
        registrarSalida.addActionListener(this);
    }

    /**
     * Método que gestiona los eventos generados en la ventana de salida
     * de huéspedes
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) { // Se pulsa el botón Calcular
            String fechaS = campoFechaSalida.getText();
            String fechaI = hotel.
                    buscarFechaIngresoHabitación(númeroHabitación);
            for (int i = 0; i < hotel.listaHabitaciones.size(); i++) {
                habitaciónOcupada = (Habitación) hotel.
                        listaHabitaciones.elementAt(i);
                if (habitaciónOcupada.getNúmeroHabitación() == this.
                        númeroHabitación) {
                    try {
                        posiciónHabitación = i;
                        SimpleDateFormat formatoFecha = new
                                SimpleDateFormat("yyyy-MM-dd");
                        Date fecha2 = formatoFecha.parse(fechaS);
                        
                        // Establecer fecha de salida para todos los huéspedes
                        Vector<Huésped> huespedes = habitaciónOcupada.getHuéspedes();
                        if (huespedes != null && !huespedes.isEmpty()) {
                            Date fecha1 = huespedes.elementAt(0).getFechaIngreso();
                            
                            if (fecha1.compareTo(fecha2) < 0) {
                                // Establecer fecha de salida para todos los huéspedes
                                for (Huésped h : huespedes) {
                                    h.setFechaSalida(fecha2);
                                }
                                
                                // Calcular días usando el primer huésped
                                int cantidad = huespedes.elementAt(0).obtenerDíasAlojamiento();
                                cantidadDías.setText("Cantidad de días: " + cantidad);
                                
                                // Calcula el total a pagar
                                double valor = cantidad * habitaciónOcupada.
                                        getPrecioDía();
                                totalPago.setText("Total: $" + valor);
                                
                                registrarSalida.setEnabled(true);
                            } else {
                                JOptionPane.showMessageDialog(this,"La fecha de salida es menor que la de ingreso","Mensaje", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (ParseException e) {
                        JOptionPane.showMessageDialog(this,"La fecha no está en el formato solicitado","Mensaje",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        if (evento.getSource() == registrarSalida) {
            try {
                // Obtener la habitación más reciente del hotel
                Habitación habitacionActual = null;
                int posicionActual = -1;
                for (int i = 0; i < hotel.listaHabitaciones.size(); i++) {
                    Habitación hab = (Habitación) hotel.listaHabitaciones.elementAt(i);
                    if (hab.getNúmeroHabitación() == this.númeroHabitación) {
                        habitacionActual = hab;
                        posicionActual = i;
                        break;
                    }
                }
                
                // Verificar que se encontró la habitación
                if (habitacionActual == null) {
                    JOptionPane.showMessageDialog(this,"Error: No se encontró la habitación",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Obtener huéspedes de la habitación
                Vector<Huésped> huespedes = habitacionActual.getHuéspedes();
                if (huespedes == null || huespedes.isEmpty()) {
                    JOptionPane.showMessageDialog(this,"Error: No hay huéspedes registrados en la habitación",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Crear registro histórico antes de liberar la habitación
                Date fechaSalida = null;
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                fechaSalida = formatoFecha.parse(campoFechaSalida.getText());
                
                Vector<Huésped> huespedesCopia = new Vector<Huésped>();
                // Crear copias de los huéspedes para el historial
                for (Huésped h : huespedes) {
                    if (h != null) {
                        Huésped copia = new Huésped(h.getNombres(), h.getApellidos(), 
                                                   h.getDocumentoIdentidad());
                        copia.setFechaIngreso(h.getFechaIngreso());
                        copia.setFechaSalida(h.getFechaSalida());
                        huespedesCopia.add(copia);
                    }
                }
                
                // Verificar que se crearon copias válidas
                if (huespedesCopia.isEmpty()) {
                    JOptionPane.showMessageDialog(this,"Error: No se pudieron copiar los datos de los huéspedes",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Calcular total pagado
                int dias = huespedesCopia.elementAt(0).obtenerDíasAlojamiento();
                double total = dias * habitacionActual.getPrecioDía();
                
                // Crear y agregar registro histórico
                RegistroOcupacion registro = new RegistroOcupacion(
                    númeroHabitación,
                    huespedesCopia.elementAt(0).getFechaIngreso(),
                    fechaSalida,
                    huespedesCopia,
                    total
                );
                hotel.agregarRegistroOcupacion(registro);
                
                // Liberar la habitación
                habitacionActual.setHuéspedes(new Vector<Huésped>());
                habitacionActual.setDisponible(true);
                hotel.listaHabitaciones.set(posicionActual, habitacionActual);
                
                JOptionPane.showMessageDialog(this,"Se ha registrado la salida de los huéspedes","Mensaje", JOptionPane.
                        INFORMATION_MESSAGE,null);
                setVisible(false);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this,"Error: La fecha no está en el formato solicitado",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace(); // Para debugging
                JOptionPane.showMessageDialog(this,"Error al registrar salida: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}


