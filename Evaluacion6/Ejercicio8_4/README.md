# Ejercicio 8.4 - Cuadros de Diálogo: Sistema de Nómina

## Descripción General

Este ejercicio implementa un sistema completo de gestión de nómina de empleados utilizando una interfaz gráfica de usuario (Swing) con cuadros de diálogo modales. El programa permite agregar, editar, eliminar y consultar empleados, calcular nóminas y guardar/cargar datos en formato texto y binario.

## Requisitos

- Java 24 o superior
- Apache Maven 3.8+
- NetBeans 12+ (o IDE compatible con Maven)

## Cómo Abrir el Proyecto en NetBeans

1. Abra NetBeans IDE
2. Seleccione **File** → **Open Project**
3. Navegue hasta la carpeta `Evaluacion6/Ejercicio8_4`
4. Seleccione el proyecto y haga clic en **Open Project**

## Cómo Ejecutar el Proyecto

### Opción 1: Desde NetBeans
1. Haga clic derecho en el proyecto
2. Seleccione **Run Project**

### Opción 2: Desde Terminal
```bash
# Navegar al directorio del proyecto
cd Evaluacion6/Ejercicio8_4

# Compilar el proyecto
mvn compile

# Ejecutar el programa principal
mvn exec:java -Dexec.mainClass="unal.ejercicio8_4.nomina.Principal"
```

## Estructura del Proyecto

```
Ejercicio8_4/
├── pom.xml
├── DOCUMENTATION.md
├── README.md
└── src/
    └── main/
        └── java/
            └── unal/
                └── ejercicio8_4/
                    └── nomina/
                        ├── Principal.java                    # Punto de entrada
                        ├── VentanaPrincipal.java             # Ventana principal con menú
                        ├── VentanaAgregarEmpleado.java      # Formulario agregar/editar
                        ├── VentanaNómina.java               # Tabla de nómina
                        ├── ListaEmpleados.java              # Gestión de empleados
                        ├── Empleado.java                    # Modelo de empleado
                        ├── TipoCargo.java                  # Enum cargo
                        └── TipoGénero.java                 # Enum género
```

## Clases Implementadas

### Clase Principal
- **[Principal.java](src/main/java/unal/ejercicio8_4/nomina/Principal.java)** - Punto de entrada del programa

### Clases del Enunciado
- **[VentanaPrincipal.java](src/main/java/unal/ejercicio8_4/nomina/VentanaPrincipal.java)** - Ventana principal con barra de menús
- **[VentanaAgregarEmpleado.java](src/main/java/unal/ejercicio8_4/nomina/VentanaAgregarEmpleado.java)** - Formulario para agregar empleados
- **[VentanaNómina.java](src/main/java/unal/ejercicio8_4/nomina/VentanaNómina.java)** - Ventana para mostrar nómina calculada
- **[ListaEmpleados.java](src/main/java/unal/ejercicio8_4/nomina/ListaEmpleados.java)** - Gestión de la lista de empleados
- **[Empleado.java](src/main/java/unal/ejercicio8_4/nomina/Empleado.java)** - Modelo de datos de empleado
- **[TipoCargo.java](src/main/java/unal/ejercicio8_4/nomina/TipoCargo.java)** - Enumeración de tipos de cargo
- **[TipoGénero.java](src/main/java/unal/ejercicio8_4/nomina/TipoGénero.java)** - Enumeración de géneros

## Funcionalidades

### Funcionalidades del Enunciado
- ✅ Agregar empleado con todos sus datos
- ✅ Calcular nómina y mostrar en tabla
- ✅ Guardar archivo de texto con datos de nómina

### Ejercicios Propuestos Resueltos
- ✅ **EP1**: Editar empleados existentes
- ✅ **EP1**: Eliminar empleados del sistema
- ✅ **EP2**: Guardar datos como archivo binario
- ✅ **EP2**: Cargar datos desde archivo binario

## Características

- **Cuadros de diálogo modales**: Utilización de `JOptionPane` para mensajes, confirmaciones y selecciones
- **Selector de archivos**: `JFileChooser` para seleccionar directorios y archivos
- **Validación de datos**: Manejo de excepciones para campos inválidos
- **Persistencia dual**: Soporte para archivos de texto y binarios
- **Interfaz intuitiva**: Formularios claros y diálogos informativos

## Documentación

Para más detalles sobre la implementación, casos de uso y diagramas, consulte [DOCUMENTATION.md](DOCUMENTATION.md).


