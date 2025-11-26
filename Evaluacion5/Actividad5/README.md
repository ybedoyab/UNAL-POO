# Actividad 5: Aplicación de Interfaz Gráfica con CRUD

**Evaluación 5 (20%) – En equipo (Máximo 3 personas)**

Esta carpeta contiene la Actividad 5, implementada como **proyecto Maven** independiente.

---

## Descripción

Aplicación de interfaz gráfica (GUI) con formulario que permite realizar operaciones CRUD (Create, Read, Update, Delete) para gestionar contactos de amigos. Los contactos se almacenan en un archivo de texto utilizando `RandomAccessFile`.

## Requisitos

- **Java 17** o superior
- **Apache Maven 3.8+**
- **NetBeans 12+** (o IDE compatible con Maven)

## Cómo abrir y ejecutar (NetBeans)

1. `File → Open Project…`
2. Abre la carpeta `Actividad5`
3. Ejecuta con **Run Project**

## Compilación y Ejecución desde Terminal

### Compilación
```bash
mvn clean compile
```

### Ejecución
```bash
mvn exec:java
```

## Funcionalidades

- **Create**: Agregar nuevos contactos (nombre y número)
- **Read**: Visualizar todos los contactos almacenados
- **Update**: Modificar información de contactos existentes
- **Delete**: Eliminar contactos de la lista

## Archivos del Proyecto

- `Actividad5.java`: Clase principal que inicia la aplicación
- `ContactGUI.java`: Interfaz gráfica de usuario con componentes Swing
- `ContactManager.java`: Lógica de negocio para operaciones CRUD con archivos

## Documentación

Ver `DOCUMENTATION.md` para documentación completa incluyendo:
- Casos de uso
- Diagramas de clase
- Descripción de componentes
- Instrucciones detalladas

## Entregables

- ✅ Documento PDF (DOCUMENTATION.md)
- ✅ Imagen de la Interfaz de usuario (captura de pantalla)
- ✅ Enlaces GitHub
- ✅ Diagrama de clases (incluido en DOCUMENTATION.md)
- ✅ Casos de uso (incluidos en DOCUMENTATION.md)

## Referencias

- [File Handling in Java with CRUD operations - GeeksforGeeks](https://www.geeksforgeeks.org/file-handling-in-java-with-crud-operations/)

