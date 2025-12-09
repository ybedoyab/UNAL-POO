package unal.ejercicio8_4.nomina;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

/**
 * Esta clase denominada VentanaPrincipal define una interfaz gráfica
 * que permitirá generar la nómina de empleados.
 * @version 1.2/2020
 */
public class VentanaPrincipal extends JFrame implements
        ActionListener {

    private Container contenedor; // Un contenedor de elementos gráficos
    ListaEmpleados empleados; // Un vector de empleados
    private JMenuBar barraMenu; // Una barra de menú principal
    private JMenu menuOpciones; /* Un menú de la barra de menú
    principal */
    private JMenuItem itemMenu1; // Un ítem de menú
    private JMenuItem itemMenu2; // Un ítem de menú
    private JMenuItem itemMenu3; // Un ítem de menú
    private JMenuItem itemMenu4; // Un ítem de menú para editar
    private JMenuItem itemMenu5; // Un ítem de menú para eliminar
    private JMenuItem itemMenu6; // Un ítem de menú para guardar binario
    private JMenuItem itemMenu7; // Un ítem de menú para cargar binario

    /**
     * Constructor de la clase VentanaPrincipal
     */
    public VentanaPrincipal() {
        empleados = new ListaEmpleados(); // Se crea la lista de empleados
        inicio();
        setTitle("Nómina"); // Establece el título de la ventana
        setSize(280, 380); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); /* La ventana se posiciona en el
        centro de la pantalla */
        // Establece que el botón de cerrar permitirá salir de la aplicación
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); /* Establece que el tamaño de la ventana no
        puede cambiar */
    }

    /**
     * Método que crea la ventana con sus diferentes componentes gráficos
     */
    public void inicio() {
        contenedor = getContentPane(); /* Obtiene el panel de
        contenidos de la ventana */
        contenedor.setLayout(null); /* Establece que el contenedor no
        tiene un layout */

        // Se crea la barra de menús, un menú y los ítems de menú
        barraMenu = new JMenuBar();
        menuOpciones = new JMenu("Menú");
        itemMenu1 = new JMenuItem("Agregar empleado");
        itemMenu2 = new JMenuItem("Calcular nómina");
        itemMenu3 = new JMenuItem("Guardar archivo");
        itemMenu4 = new JMenuItem("Editar empleado");
        itemMenu5 = new JMenuItem("Eliminar empleado");
        itemMenu6 = new JMenuItem("Guardar archivo binario");
        itemMenu7 = new JMenuItem("Cargar archivo binario");

        menuOpciones.add(itemMenu1); /* Se agrega el ítem de menú 1
        al menú */
        menuOpciones.add(itemMenu2); /* Se agrega el ítem de menú 2
        al menú */
        menuOpciones.add(new JSeparator()); /* Se agrega una línea
        divisoria */
        menuOpciones.add(itemMenu4); // Se agrega el ítem de editar
        menuOpciones.add(itemMenu5); // Se agrega el ítem de eliminar
        menuOpciones.add(new JSeparator()); /* Se agrega una línea
        divisoria */
        menuOpciones.add(itemMenu3); /* Se agrega el ítem de menú 3
        al menú */
        menuOpciones.add(itemMenu6); // Se agrega el ítem de guardar binario
        menuOpciones.add(itemMenu7); // Se agrega el ítem de cargar binario
        barraMenu.add(menuOpciones); /* Se agregan las opciones de
        menú al menú */
        setJMenuBar(barraMenu); // Se agrega el menú a la ventana

        /* Agrega al ítem de menú un ActionListener para que gestione
        eventos del ítem de menú */
        itemMenu1.addActionListener(this);
        itemMenu2.addActionListener(this);
        itemMenu3.addActionListener(this);
        itemMenu4.addActionListener(this);
        itemMenu5.addActionListener(this);
        itemMenu6.addActionListener(this);
        itemMenu7.addActionListener(this);
    }

    /**
     * Método que gestiona los eventos generados en la ventana principal
     * throws Exception Excepción en la creación o escritura del archivo
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == itemMenu1) { /* Se selecciona el ítem
        de menú 1 */
            // Se crea la ventana de agregar empleado
            VentanaAgregarEmpleado ventanaAgregar = new
                    VentanaAgregarEmpleado(empleados, null, -1);
            ventanaAgregar.setVisible(true); // Se hace visible la ventana
        }
        if (evento.getSource() == itemMenu2) { /* Se selecciona el ítem
        de menú 2 */
            // Se crea la ventana de nómina
            VentanaNómina ventanaNómina = new
                    VentanaNómina(empleados);
            ventanaNómina.setVisible(true); // Se hace visible la ventana
        }
        if (evento.getSource() == itemMenu3) { /* Se selecciona el ítem
        de menú 3 */
            JFileChooser fc = new JFileChooser(); /* Crea un selector de
            archivo */
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            // Es un selector de directorio
            int respuesta = fc.showOpenDialog(this); /* Se muestra el
            selector de directorio en pantalla */
            if (respuesta == JFileChooser.APPROVE_OPTION) { /* Si se
            pulsa aceptar en el selector */
                File directorioElegido = fc.getSelectedFile(); /* Se obtiene
                el directorio seleccionado */
                String nombre = directorioElegido.getAbsolutePath(); /* Se
                obtiene la ruta absoluta del directorio */
                try {
                    // Convierte los datos de los empleados en texto
                    String contenido = empleados.convertirTexto();

                    // Se asigna el nombre del archivo de texto
                    File file = new File(nombre + File.separator + "Nómina.txt");
                    file.createNewFile(); // Se crea el archivo de texto
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw); /* Se
                    crea el flujo de escritura de datos */
                    bw.write(contenido); /* Se escriben los datos en el
                    archivo */
                    bw.close(); // Se cierra el archivo
                    String texto = "El archivo de la nómina Nómina.txt se ha creado en " + nombre;
                    // Mensaje de confirmación
                    JOptionPane.showMessageDialog(this, texto,
                            "Mensaje",
                            JOptionPane.INFORMATION_MESSAGE, null);
                } catch (Exception e) {
                    /* En caso que se presente una excepción en la
                    creación y escritura del archivo */
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this,
                            "Error al guardar el archivo: " + e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (evento.getSource() == itemMenu4) { // Editar empleado
            if (empleados.lista.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay empleados para editar",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            // Mostrar lista de empleados para seleccionar
            String[] nombres = new String[empleados.lista.size()];
            for (int i = 0; i < empleados.lista.size(); i++) {
                Empleado e = empleados.lista.elementAt(i);
                nombres[i] = (i + 1) + ". " + e.getNombre() + " " + e.getApellidos();
            }
            String seleccion = (String) JOptionPane.showInputDialog(
                    this,
                    "Seleccione el empleado a editar:",
                    "Editar Empleado",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    nombres,
                    nombres[0]
            );
            if (seleccion != null) {
                int indice = Integer.parseInt(seleccion.substring(0, seleccion.indexOf("."))) - 1;
                Empleado empleadoAEditar = empleados.obtenerEmpleado(indice);
                if (empleadoAEditar != null) {
                    VentanaAgregarEmpleado ventanaEditar = new
                            VentanaAgregarEmpleado(empleados, empleadoAEditar, indice);
                    ventanaEditar.setVisible(true);
                }
            }
        }
        if (evento.getSource() == itemMenu5) { // Eliminar empleado
            if (empleados.lista.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay empleados para eliminar",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            // Mostrar lista de empleados para seleccionar
            String[] nombres = new String[empleados.lista.size()];
            for (int i = 0; i < empleados.lista.size(); i++) {
                Empleado e = empleados.lista.elementAt(i);
                nombres[i] = (i + 1) + ". " + e.getNombre() + " " + e.getApellidos();
            }
            String seleccion = (String) JOptionPane.showInputDialog(
                    this,
                    "Seleccione el empleado a eliminar:",
                    "Eliminar Empleado",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    nombres,
                    nombres[0]
            );
            if (seleccion != null) {
                int indice = Integer.parseInt(seleccion.substring(0, seleccion.indexOf("."))) - 1;
                int confirmacion = JOptionPane.showConfirmDialog(
                        this,
                        "¿Está seguro de eliminar este empleado?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (empleados.eliminarEmpleado(indice)) {
                        JOptionPane.showMessageDialog(this,
                                "Empleado eliminado correctamente",
                                "Mensaje",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Error al eliminar el empleado",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        if (evento.getSource() == itemMenu6) { // Guardar archivo binario
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.setDialogTitle("Guardar archivo binario de nómina");
            int respuesta = fc.showSaveDialog(this);
            if (respuesta == JFileChooser.APPROVE_OPTION) {
                File archivo = fc.getSelectedFile();
                // Si no tiene extensión, agregar .dat
                if (!archivo.getName().endsWith(".dat")) {
                    archivo = new File(archivo.getParent(), archivo.getName() + ".dat");
                }
                try {
                    empleados.guardarBinario(archivo);
                    JOptionPane.showMessageDialog(this,
                            "Archivo binario guardado correctamente en:\n" + archivo.getAbsolutePath(),
                            "Mensaje",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this,
                            "Error al guardar el archivo binario: " + e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (evento.getSource() == itemMenu7) { // Cargar archivo binario
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.setDialogTitle("Cargar archivo binario de nómina");
            int respuesta = fc.showOpenDialog(this);
            if (respuesta == JFileChooser.APPROVE_OPTION) {
                File archivo = fc.getSelectedFile();
                try {
                    ListaEmpleados listaCargada = ListaEmpleados.cargarBinario(archivo);
                    int confirmacion = JOptionPane.showConfirmDialog(
                            this,
                            "¿Desea reemplazar la lista actual con los datos del archivo?",
                            "Confirmar carga",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        empleados = listaCargada;
                        JOptionPane.showMessageDialog(this,
                                "Archivo binario cargado correctamente.\n" +
                                        "Empleados cargados: " + empleados.lista.size(),
                                "Mensaje",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(this,
                            "Error al cargar el archivo binario: " + e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}

