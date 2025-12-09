# Ejercicio 8.5 – Gestión de Contenidos - Sistema de Hotel

Este ejercicio implementa un sistema completo de gestión de hotel con interfaces gráficas de usuario utilizando diferentes layouts de Swing. El sistema permite gestionar el ingreso y salida de huéspedes, así como consultar historiales de ocupaciones.

## Características Implementadas

### Funcionalidades Base
- Consultar habitaciones y su disponibilidad
- Registrar ingreso de huéspedes
- Registrar salida de huéspedes y calcular pagos
- Gestión de habitaciones simples, dobles y triples

### Funcionalidades Avanzadas (Ejercicios Propuestos)
- **Tipos de habitación**: El sistema soporta habitaciones simples (1 huésped), dobles (2 huéspedes) y triples (3 huéspedes)
- **Múltiples huéspedes**: Cada tipo de habitación puede alojar el número correspondiente de huéspedes
- **Historial por habitación**: Consulta de todas las ocupaciones históricas de una habitación específica
- **Historial por huésped**: Consulta de todas las habitaciones ocupadas por un huésped específico (identificado por documento)

## Tipos de Habitación

| Tipo | Capacidad | Precio por Día |
|------|-----------|----------------|
| Simple | 1 huésped | $120,000 |
| Doble | 2 huéspedes | $150,000 |
| Triple | 3 huéspedes | $180,000 |

**Distribución de habitaciones:**
- Habitaciones 1-3: Simples
- Habitaciones 4-6: Dobles
- Habitaciones 7-10: Triples

## Layouts Utilizados

- **BorderLayout**: Para organizar componentes principales
- **GridBagLayout**: Para formularios con múltiples campos (VentanaIngreso, VentanaSalida)
- **Layout null (absolute positioning)**: Para VentanaPrincipal y VentanaHabitaciones con posiciones fijas
- **ScrollPane**: Para listas largas de componentes (campos de múltiples huéspedes)

## Ejecutar

```bash
mvn -q exec:java -Dexec.mainClass="unal.ejercicio8_5.Principal"
```

## Requisitos

- **Java 17+**
- **Apache Maven 3.8+**

## Estructura del Proyecto

```
Ejercicio8_5/
├── pom.xml
├── README.md
├── DOCUMENTATION.md
└── src/
    └── main/
        └── java/
            └── unal/
                └── ejercicio8_5/
                    ├── Principal.java                    # Punto de entrada
                    └── Hotel/
                        ├── Hotel.java                    # Clase principal del hotel
                        ├── Habitación.java               # Modelo de habitación
                        ├── Huésped.java                  # Modelo de huésped
                        ├── TipoHabitacion.java           # Enum de tipos de habitación
                        ├── RegistroOcupacion.java        # Registro histórico
                        ├── VentanaPrincipal.java         # Ventana principal con menú
                        ├── VentanaHabitaciones.java      # Consulta de habitaciones
                        ├── VentanaIngreso.java           # Registro de ingreso
                        ├── VentanaSalida.java            # Registro de salida y pago
                        ├── VentanaHistorialHabitacion.java  # Historial por habitación
                        └── VentanaHistorialHuesped.java     # Historial por huésped
```

## Casos de Uso

### CU1: Consultar Habitaciones
1. Seleccionar "Consultar habitaciones" del menú
2. Ver listado de 10 habitaciones con estado y tipo
3. Seleccionar habitación a ocupar mediante spinner
4. Hacer clic en "Aceptar"

### CU2: Registrar Ingreso
1. Desde VentanaHabitaciones, seleccionar habitación disponible
2. Ingresar fecha de ingreso (formato: aaaa-mm-dd)
3. Ingresar datos de todos los huéspedes según capacidad de la habitación:
   - Nombre
   - Apellidos
   - Documento de identidad
4. Hacer clic en "Aceptar"
5. Sistema valida campos y registra ingreso

### CU3: Registrar Salida
1. Seleccionar "Salida de huéspedes" del menú
2. Ingresar número de habitación
3. Ingresar fecha de salida
4. Hacer clic en "Calcular" para ver días y total
5. Hacer clic en "Registrar Salida" para confirmar
6. Sistema registra en historial y libera habitación

### CU4: Consultar Historial por Habitación
1. Seleccionar "Historial por habitación" del menú
2. Ingresar número de habitación (1-10)
3. Ver tabla con todas las ocupaciones históricas:
   - Fechas de ingreso y salida
   - Días de ocupación
   - Huéspedes alojados
   - Total pagado

### CU5: Consultar Historial por Huésped
1. Seleccionar "Historial por huésped" del menú
2. Ingresar documento de identidad del huésped
3. Ver tabla con todas las habitaciones ocupadas:
   - Número de habitación
   - Fechas de ingreso y salida
   - Días de alojamiento
   - Total pagado
   - Otros huéspedes que compartieron la habitación

## Validaciones

- Todos los campos de huéspedes son obligatorios
- La fecha de salida debe ser posterior a la fecha de ingreso
- No se pueden ocupar habitaciones ya ocupadas
- Formato de fecha: yyyy-MM-dd
- Número de habitación debe estar entre 1 y 10
