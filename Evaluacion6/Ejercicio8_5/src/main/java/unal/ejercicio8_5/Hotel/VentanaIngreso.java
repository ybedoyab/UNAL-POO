package unal.ejercicio8_5.Hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Esta clase denominada VentanaIngreso define una ventana que
 * permite ingresar los datos de los huéspedes que tomarán una habitación
 * previamente seleccionada
 * @version 2.0/2024
 */
public class VentanaIngreso extends JFrame implements ActionListener {
    private Container contenedor; // Un contenedor de elementos gráficos
    private JLabel habitación; /* Etiqueta para identificar la habitación
    seleccionada */
    private JButton aceptar, cancelar; /* Botones para aceptar o cancelar
    el ingreso del huésped */
    private JLabel fechaIngreso; // Etiqueta de la fecha de ingreso
    private JTextField campoFechaIngreso; /* Campo de texto de la
    fecha de ingreso */
    private int númeroHabitaciónReservada; /* Número de la habitación
    reservada */
    private Hotel hotel; // Objeto Hotel
    private Date fechaInicial; /* Fecha de inicio del alojamiento del
    huésped */
    private Habitación habitaciónReservada; // Habitación reservada
    
    // Campos dinámicos para múltiples huéspedes
    private Vector<JLabel> etiquetasNombre;
    private Vector<JLabel> etiquetasApellidos;
    private Vector<JLabel> etiquetasDocumento;
    private Vector<JTextField> camposNombre;
    private Vector<JTextField> camposApellidos;
    private Vector<JTextField> camposDocumento;
    private JScrollPane scrollPane;

    /**
     * Constructor de la clase VentanaIngreso
     * @param hotel Parámetro que define el hotel con habitaciones y
     * huéspedes
     * @param númeroHabitaciónReservada Parámetro que define el
     * número de la habitación reservada
     */
    public VentanaIngreso(Hotel hotel, int númeroHabitaciónReservada) {
        this.hotel = hotel;
        this.númeroHabitaciónReservada = númeroHabitaciónReservada;
        
        // Obtener la habitación para conocer su tipo
        for (int i = 0; i < hotel.listaHabitaciones.size(); i++) {
            Habitación hab = (Habitación) hotel.listaHabitaciones.elementAt(i);
            if (hab.getNúmeroHabitación() == númeroHabitaciónReservada) {
                habitaciónReservada = hab;
                break;
            }
        }
        
        inicio();
        setTitle("Ingreso"); // Establece el título de la ventana
        setSize(400, 500); // Establece el tamaño de la ventana
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

        // Establece la etiqueta del número de la habitación reservada
        habitación = new JLabel();
        habitación.setText("Habitación: " + númeroHabitaciónReservada);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        contenedor.add(habitación, c);

        // Establece la etiqueta y campo de texto de la fecha de ingreso
        fechaIngreso = new JLabel();
        fechaIngreso.setText("Fecha (aaaa-mm-dd):");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        contenedor.add(fechaIngreso, c);

        campoFechaIngreso = new JTextField();
        c.gridx = 1;
        c.gridy = 1;
        contenedor.add(campoFechaIngreso, c);

        // Etiqueta de información del tipo de habitación
        JLabel infoTipo = new JLabel();
        if (habitaciónReservada != null) {
            infoTipo.setText("Tipo: " + habitaciónReservada.getTipoHabitacion().name() + 
                           " (Capacidad: " + habitaciónReservada.getTipoHabitacion().getCapacidad() + ")");
        }
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        contenedor.add(infoTipo, c);

        // Crear campos dinámicos para los huéspedes
        int capacidad = habitaciónReservada != null ? 
                        habitaciónReservada.getTipoHabitacion().getCapacidad() : 1;
        
        etiquetasNombre = new Vector<JLabel>();
        etiquetasApellidos = new Vector<JLabel>();
        etiquetasDocumento = new Vector<JLabel>();
        camposNombre = new Vector<JTextField>();
        camposApellidos = new Vector<JTextField>();
        camposDocumento = new Vector<JTextField>();

        // Panel para los campos de huéspedes con scroll
        JPanel panelHuespedes = new JPanel();
        panelHuespedes.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.insets = new Insets(3,3,3,3);

        JLabel tituloHuespedes = new JLabel("Datos de los huéspedes:");
        c2.gridx = 0;
        c2.gridy = 0;
        c2.gridwidth = 3;
        panelHuespedes.add(tituloHuespedes, c2);

        for (int i = 0; i < capacidad; i++) {
            int filaBase = i * 4 + 1; // Cada huésped ocupa 4 filas (título + 3 campos)
            
            // Etiqueta "Huésped X"
            JLabel labelHuesped = new JLabel("Huésped " + (i + 1) + ":");
            c2.gridx = 0;
            c2.gridy = filaBase;
            c2.gridwidth = 3;
            panelHuespedes.add(labelHuesped, c2);
            
            // Nombre
            JLabel labelNombre = new JLabel("Nombre:");
            c2.gridx = 0;
            c2.gridy = filaBase + 1;
            c2.gridwidth = 1;
            panelHuespedes.add(labelNombre, c2);
            JTextField campoNombre = new JTextField();
            c2.gridx = 1;
            c2.gridy = filaBase + 1;
            c2.gridwidth = 2;
            panelHuespedes.add(campoNombre, c2);
            camposNombre.add(campoNombre);
            
            // Apellidos
            JLabel labelApellidos = new JLabel("Apellidos:");
            c2.gridx = 0;
            c2.gridy = filaBase + 2;
            c2.gridwidth = 1;
            panelHuespedes.add(labelApellidos, c2);
            JTextField campoApellidos = new JTextField();
            c2.gridx = 1;
            c2.gridy = filaBase + 2;
            c2.gridwidth = 2;
            panelHuespedes.add(campoApellidos, c2);
            camposApellidos.add(campoApellidos);
            
            // Documento
            JLabel labelDocumento = new JLabel("Doc. Identidad:");
            c2.gridx = 0;
            c2.gridy = filaBase + 3;
            c2.gridwidth = 1;
            panelHuespedes.add(labelDocumento, c2);
            JTextField campoDocumento = new JTextField();
            c2.gridx = 1;
            c2.gridy = filaBase + 3;
            c2.gridwidth = 2;
            panelHuespedes.add(campoDocumento, c2);
            camposDocumento.add(campoDocumento);
        }

        scrollPane = new JScrollPane(panelHuespedes);
        scrollPane.setPreferredSize(new Dimension(380, 300));
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1.0;
        contenedor.add(scrollPane, c);

        // Botones
        aceptar = new JButton("Aceptar");
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.0;
        contenedor.add(aceptar, c);
        aceptar.addActionListener(this);

        cancelar = new JButton("Cancelar");
        c.gridx = 1;
        c.gridy = 4;
        contenedor.add(cancelar, c);
        cancelar.addActionListener(this);
    }

    /**
     * Método que gestiona los eventos generados en la ventana de
     * ingreso de huéspedes
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == aceptar) { // Se pulsa el botón Aceptar
            int posición = -1;
            for (int i = 0; i < hotel.listaHabitaciones.size(); i++) {
                Habitación habitación = (Habitación) hotel.
                        listaHabitaciones.elementAt(i);
                if (habitación.getNúmeroHabitación() == this.
                        númeroHabitaciónReservada) {
                    try {
                        posición = i;
                        // Obtiene la fecha de ingreso tecleada
                        String fechaIngresada = campoFechaIngreso.
                                getText();
                        // Establece formato de fecha
                        SimpleDateFormat formatoFecha = new
                                SimpleDateFormat("yyyy-MM-dd");
                        // Convierte la fecha de ingreso al formato
                        Date fecha = formatoFecha.parse(fechaIngresada);

                        // Validar que todos los campos estén llenos
                        boolean camposValidos = true;
                        for (int j = 0; j < camposNombre.size(); j++) {
                            if (camposNombre.elementAt(j).getText().trim().isEmpty() ||
                                camposApellidos.elementAt(j).getText().trim().isEmpty() ||
                                camposDocumento.elementAt(j).getText().trim().isEmpty()) {
                                camposValidos = false;
                                break;
                            }
                        }

                        if (!camposValidos) {
                            JOptionPane.showMessageDialog(this,
                                    "Todos los campos son obligatorios", "Mensaje",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Crear vector de huéspedes
                        Vector<Huésped> huespedes = new Vector<Huésped>();
                        for (int j = 0; j < camposNombre.size(); j++) {
                            Huésped huésped = new Huésped(
                                    camposNombre.elementAt(j).getText(),
                                    camposApellidos.elementAt(j).getText(),
                                    Integer.parseInt(camposDocumento.elementAt(j).getText())
                            );
                            huésped.setFechaIngreso(fecha);
                            huespedes.add(huésped);
                        }

                        // Establecer huéspedes en la habitación
                        habitación.setHuéspedes(huespedes);
                        habitación.setDisponible(false);
                        habitaciónReservada = habitación;

                        // Actualizar la lista de habitaciones
                        hotel.listaHabitaciones.set(posición, habitación);
                        
                        JOptionPane.showMessageDialog(this,"Los huéspedes han sido registrados","Mensaje", JOptionPane.
                                INFORMATION_MESSAGE,null);
                        setVisible(false);
                        break;
                    } catch (ParseException e) {
                        JOptionPane.showMessageDialog(this,"La fecha no está en el formato solicitado", "Mensaje",
                                JOptionPane.ERROR_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this,"Campo nulo o error en formato de numero",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        if (evento.getSource() == cancelar) {
            setVisible(false);
        }
    }
}

