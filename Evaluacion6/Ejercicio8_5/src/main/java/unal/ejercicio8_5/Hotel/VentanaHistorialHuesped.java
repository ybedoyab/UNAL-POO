package unal.ejercicio8_5.Hotel;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana que muestra el historial de habitaciones ocupadas por un huésped
 */
public class VentanaHistorialHuesped extends JFrame {
    private Hotel hotel;
    private int documentoIdentidad;
    private JTable tabla;
    private JScrollPane scrollPane;

    public VentanaHistorialHuesped(Hotel hotel, int documentoIdentidad) {
        this.hotel = hotel;
        this.documentoIdentidad = documentoIdentidad;
        inicio();
        setTitle("Historial de Huésped - Documento: " + documentoIdentidad);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void inicio() {
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());

        // Crear tabla
        String[] columnas = {"Habitación", "Fecha Ingreso", "Fecha Salida", 
                           "Días", "Total Pagado", "Otros Huéspedes"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Obtener historial
        Vector<RegistroOcupacion> historial = hotel.obtenerHistorialHuesped(documentoIdentidad);
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        if (historial.isEmpty()) {
            JLabel mensaje = new JLabel("No hay registros históricos para este huésped", 
                                        SwingConstants.CENTER);
            contenedor.add(mensaje, BorderLayout.CENTER);
        } else {
            for (RegistroOcupacion registro : historial) {
                String fechaIngreso = formatoFecha.format(registro.getFechaIngreso());
                String fechaSalida = registro.getFechaSalida() != null ? 
                                    formatoFecha.format(registro.getFechaSalida()) : "N/A";
                int dias = registro.getDiasOcupacion();
                
                // Encontrar el huésped en el registro y obtener otros huéspedes
                Vector<Huésped> huespedes = registro.getHuespedes();
                StringBuilder otrosHuespedes = new StringBuilder();
                if (huespedes != null) {
                    for (Huésped h : huespedes) {
                        if (h.getDocumentoIdentidad() != documentoIdentidad) {
                            if (otrosHuespedes.length() > 0) {
                                otrosHuespedes.append(", ");
                            }
                            otrosHuespedes.append(h.getNombres()).append(" ").append(h.getApellidos());
                        }
                    }
                }
                if (otrosHuespedes.length() == 0) {
                    otrosHuespedes.append("Ninguno");
                }
                
                Object[] fila = {
                    registro.getNumeroHabitacion(),
                    fechaIngreso,
                    fechaSalida,
                    dias,
                    "$" + registro.getTotalPagado(),
                    otrosHuespedes.toString()
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


