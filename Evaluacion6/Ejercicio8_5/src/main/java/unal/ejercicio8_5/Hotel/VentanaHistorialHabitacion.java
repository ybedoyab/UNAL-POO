package unal.ejercicio8_5.Hotel;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana que muestra el historial de ocupaciones de una habitación
 */
public class VentanaHistorialHabitacion extends JFrame {
    private Hotel hotel;
    private int numeroHabitacion;
    private JTable tabla;
    private JScrollPane scrollPane;

    public VentanaHistorialHabitacion(Hotel hotel, int numeroHabitacion) {
        this.hotel = hotel;
        this.numeroHabitacion = numeroHabitacion;
        inicio();
        setTitle("Historial de Habitación " + numeroHabitacion);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void inicio() {
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());

        // Crear tabla
        String[] columnas = {"Fecha Ingreso", "Fecha Salida", "Días", 
                           "Huéspedes", "Total Pagado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Obtener historial
        Vector<RegistroOcupacion> historial = hotel.obtenerHistorialHabitacion(numeroHabitacion);
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        if (historial.isEmpty()) {
            JLabel mensaje = new JLabel("No hay registros históricos para esta habitación", 
                                        SwingConstants.CENTER);
            contenedor.add(mensaje, BorderLayout.CENTER);
        } else {
            for (RegistroOcupacion registro : historial) {
                String fechaIngreso = formatoFecha.format(registro.getFechaIngreso());
                String fechaSalida = registro.getFechaSalida() != null ? 
                                    formatoFecha.format(registro.getFechaSalida()) : "N/A";
                int dias = registro.getDiasOcupacion();
                
                // Construir lista de huéspedes
                StringBuilder huespedesStr = new StringBuilder();
                Vector<Huésped> huespedes = registro.getHuespedes();
                if (huespedes != null) {
                    for (int i = 0; i < huespedes.size(); i++) {
                        Huésped h = huespedes.elementAt(i);
                        huespedesStr.append(h.getNombres()).append(" ").append(h.getApellidos());
                        if (i < huespedes.size() - 1) {
                            huespedesStr.append(", ");
                        }
                    }
                }
                
                Object[] fila = {
                    fechaIngreso,
                    fechaSalida,
                    dias,
                    huespedesStr.toString(),
                    "$" + registro.getTotalPagado()
                };
                modelo.addRow(fila);
            }

            tabla = new JTable(modelo);
            tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            scrollPane = new JScrollPane(tabla);
            contenedor.add(scrollPane, BorderLayout.CENTER);
        }

        // Botón cerrar
        JButton cerrar = new JButton("Cerrar");
        cerrar.addActionListener(e -> dispose());
        JPanel panelBoton = new JPanel();
        panelBoton.add(cerrar);
        contenedor.add(panelBoton, BorderLayout.SOUTH);
    }
}


