package unal.actividad5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Interfaz gráfica para gestionar contactos con operaciones CRUD.
 */
public class ContactGUI extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField numberField;
    private JList<String> contactList;
    private DefaultListModel<String> listModel;
    private JButton createButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JLabel statusLabel;
    
    private ContactManager contactManager;
    private List<String[]> currentContacts;
    
    public ContactGUI() {
        contactManager = new ContactManager();
        currentContacts = new ArrayList<>();
        listModel = new DefaultListModel<>();
        initializeGUI();
        // Cargar contactos automáticamente al iniciar
        SwingUtilities.invokeLater(() -> {
            try {
                handleRead();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, 
                    "Error al cargar contactos: " + e.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    private void initializeGUI() {
        setTitle("Gestión de Contactos - CRUD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);
        
        // Crear un panel principal con borde para el espaciado
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(mainPanel, BorderLayout.CENTER);
        
        // Panel superior: Campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        
        inputPanel.add(new JLabel("Nombre:"));
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 25));
        inputPanel.add(nameField);
        
        inputPanel.add(new JLabel("Número:"));
        numberField = new JTextField();
        numberField.setPreferredSize(new Dimension(200, 25));
        inputPanel.add(numberField);
        
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        
        // Panel central: Lista de contactos seleccionable
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        
        JLabel listLabel = new JLabel("Lista de Contactos (haz clic para seleccionar):");
        listPanel.add(listLabel, BorderLayout.NORTH);
        
        contactList = new JList<>(listModel);
        contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contactList.setBackground(Color.WHITE);
        
        // Listener para detectar selección/deselección
        contactList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = contactList.getSelectedIndex();
                    if (selectedIndex >= 0 && selectedIndex < currentContacts.size()) {
                        // Contacto seleccionado
                        String[] contact = currentContacts.get(selectedIndex);
                        nameField.setText(contact[0]);
                        numberField.setText(contact[1]);
                        updateStatus("Contacto seleccionado: " + contact[0]);
                        showUpdateDeleteButtons();
                    } else {
                        // Ningún contacto seleccionado
                        showCreateButton();
                    }
                }
            }
        });
        
        // También manejar clic para actualizar campos
        contactList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedIndex = contactList.getSelectedIndex();
                    if (selectedIndex >= 0 && selectedIndex < currentContacts.size()) {
                        String[] contact = currentContacts.get(selectedIndex);
                        nameField.setText(contact[0]);
                        numberField.setText(contact[1]);
                        updateStatus("Contacto seleccionado: " + contact[0]);
                        showUpdateDeleteButtons();
                    }
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(contactList);
        scrollPane.setPreferredSize(new Dimension(0, 300));
        listPanel.add(scrollPane, BorderLayout.CENTER);
        
        mainPanel.add(listPanel, BorderLayout.CENTER);
        
        // Panel inferior: Botones y estado
        JPanel bottomPanel = new JPanel(new BorderLayout());
        
        // Panel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        createButton = new JButton("Create");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Limpiar");
        
        // Estilos de botones
        createButton.setBackground(new Color(76, 175, 80));
        createButton.setForeground(Color.WHITE);
        createButton.setFocusPainted(false);
        
        updateButton.setBackground(new Color(33, 150, 243));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusPainted(false);
        
        deleteButton.setBackground(new Color(244, 67, 54));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        
        clearButton.setBackground(new Color(158, 158, 158));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);
        
        createButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
        
        // Agregar tooltips
        createButton.setToolTipText("Crear un nuevo contacto");
        updateButton.setToolTipText("Actualizar el contacto seleccionado");
        deleteButton.setToolTipText("Eliminar el contacto seleccionado");
        clearButton.setToolTipText("Limpiar los campos de entrada");
        contactList.setToolTipText("Selecciona un contacto para modificar o eliminar");
        
        // Agregar todos los botones al panel (se ocultarán/mostrarán según necesidad)
        buttonPanel.add(createButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        
        // Etiqueta de estado
        statusLabel = new JLabel("Listo");
        statusLabel.setBorder(new EmptyBorder(5, 10, 0, 10));
        statusLabel.setForeground(new Color(100, 100, 100));
        bottomPanel.add(statusLabel, BorderLayout.SOUTH);
        
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        // Inicializar con solo el botón Create visible (después de que statusLabel esté inicializado)
        showCreateButton();
    }
    
    private void updateStatus(String message) {
        statusLabel.setText(message);
    }
    
    /**
     * Muestra solo el botón Create y oculta Update y Delete.
     */
    private void showCreateButton() {
        createButton.setVisible(true);
        updateButton.setVisible(false);
        deleteButton.setVisible(false);
        updateStatus("Listo - Selecciona un contacto para modificar o eliminar");
    }
    
    /**
     * Muestra los botones Update y Delete, oculta Create.
     */
    private void showUpdateDeleteButtons() {
        createButton.setVisible(false);
        updateButton.setVisible(true);
        deleteButton.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        try {
            if (source == createButton) {
                handleCreate();
            } else if (source == updateButton) {
                handleUpdate();
            } else if (source == deleteButton) {
                handleDelete();
            } else if (source == clearButton) {
                handleClear();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error de E/S: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            updateStatus("Error al procesar operación");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "El número debe ser un valor numérico válido.", 
                "Error de Formato", 
                JOptionPane.ERROR_MESSAGE);
            updateStatus("Error: número inválido");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Error inesperado: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            updateStatus("Error inesperado");
        }
    }
    
    private void handleCreate() throws IOException, NumberFormatException {
        String name = nameField.getText().trim();
        String numberText = numberField.getText().trim();
        
        if (name.isEmpty() || numberText.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Debe ingresar nombre y número.", 
                "Campos Vacíos", 
                JOptionPane.WARNING_MESSAGE);
            updateStatus("Error: campos vacíos");
            return;
        }
        
        long number = Long.parseLong(numberText);
        
        boolean success = contactManager.createContact(name, number);
        
        if (success) {
            JOptionPane.showMessageDialog(this, 
                "Contacto agregado exitosamente.", 
                "Éxito", 
                JOptionPane.INFORMATION_MESSAGE);
            nameField.setText("");
            numberField.setText("");
            contactList.clearSelection();
            handleRead(); // Actualizar la lista automáticamente
            showCreateButton(); // Volver a mostrar solo Create
            updateStatus("Contacto creado exitosamente");
        } else {
            JOptionPane.showMessageDialog(this, 
                "El contacto ya existe (nombre o número duplicado).", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            updateStatus("Error: contacto duplicado");
        }
    }
    
    private void handleRead() throws IOException {
        currentContacts = contactManager.readAllContacts();
        listModel.clear();
        
        if (currentContacts.isEmpty()) {
            listModel.addElement("No hay contactos registrados.");
            updateStatus("No hay contactos");
        } else {
            for (String[] contact : currentContacts) {
                listModel.addElement(contact[0] + " - " + contact[1]);
            }
            updateStatus("Total de contactos: " + currentContacts.size());
        }
    }
    
    private void handleUpdate() throws IOException, NumberFormatException {
        String oldName = nameField.getText().trim();
        String numberText = numberField.getText().trim();
        
        if (oldName.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Seleccione un contacto de la lista o ingrese el nombre del contacto a actualizar.", 
                "Campo Vacío", 
                JOptionPane.WARNING_MESSAGE);
            updateStatus("Error: debe seleccionar o ingresar un nombre");
            return;
        }
        
        if (numberText.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Debe ingresar el nuevo número.", 
                "Campo Vacío", 
                JOptionPane.WARNING_MESSAGE);
            updateStatus("Error: debe ingresar un número");
            return;
        }
        
        long newNumber = Long.parseLong(numberText);
        
        // Para actualizar, mantenemos el mismo nombre o pedimos el nuevo
        String newName = JOptionPane.showInputDialog(this, 
            "Ingrese el nuevo nombre (o deje vacío para mantener el mismo):", 
            "Actualizar Contacto", 
            JOptionPane.QUESTION_MESSAGE);
        
        if (newName == null) {
            updateStatus("Operación cancelada");
            return; // Usuario canceló
        }
        
        if (newName.trim().isEmpty()) {
            newName = oldName; // Mantener el mismo nombre
        }
        
        boolean success = contactManager.updateContact(oldName, newName.trim(), newNumber);
        
        if (success) {
            JOptionPane.showMessageDialog(this, 
                "Contacto actualizado exitosamente.", 
                "Éxito", 
                JOptionPane.INFORMATION_MESSAGE);
            nameField.setText("");
            numberField.setText("");
            contactList.clearSelection();
            handleRead(); // Actualizar la lista automáticamente
            showCreateButton(); // Volver a mostrar solo Create
            updateStatus("Contacto actualizado exitosamente");
        } else {
            JOptionPane.showMessageDialog(this, 
                "No se encontró el contacto con ese nombre.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            updateStatus("Error: contacto no encontrado");
        }
    }
    
    private void handleDelete() throws IOException {
        // Intentar obtener el nombre del campo o de la selección
        String name = nameField.getText().trim();
        
        // Si no hay nombre en el campo, intentar obtenerlo de la selección
        if (name.isEmpty()) {
            int selectedIndex = contactList.getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < currentContacts.size()) {
                name = currentContacts.get(selectedIndex)[0];
                nameField.setText(name);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Seleccione un contacto de la lista o ingrese el nombre del contacto a eliminar.", 
                    "Campo Vacío", 
                    JOptionPane.WARNING_MESSAGE);
                updateStatus("Error: debe seleccionar o ingresar un nombre");
                return;
            }
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de que desea eliminar el contacto: " + name + "?", 
            "Confirmar Eliminación", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = contactManager.deleteContact(name);
            
            if (success) {
                JOptionPane.showMessageDialog(this, 
                    "Contacto eliminado exitosamente.", 
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
                nameField.setText("");
                numberField.setText("");
                contactList.clearSelection();
                handleRead(); // Actualizar la lista automáticamente
                showCreateButton(); // Volver a mostrar solo Create
                updateStatus("Contacto eliminado exitosamente");
            } else {
                JOptionPane.showMessageDialog(this, 
                    "No se encontró el contacto con ese nombre.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                updateStatus("Error: contacto no encontrado");
            }
        } else {
            updateStatus("Operación cancelada");
        }
    }
    
    private void handleClear() {
        nameField.setText("");
        numberField.setText("");
        contactList.clearSelection();
        showCreateButton(); // Mostrar solo Create después de limpiar
        updateStatus("Campos limpiados");
    }
}

