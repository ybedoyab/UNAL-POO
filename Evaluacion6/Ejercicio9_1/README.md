# Ejercicio 9.1 – Escenarios JavaFX

Este ejercicio contiene tres aplicaciones JavaFX que implementan ejercicios propuestos:

## Ejercicios Implementados

### Ejercicio 1: Calculadora Numérica
**Clase:** `CalculadoraNumerica`

Permite ingresar un valor numérico y calcular:
- Logaritmo natural
- Logaritmo en base 10
- Raíz cuadrada
- Verificación si es un número primo

### Ejercicio 2: Conversor de Temperatura
**Clase:** `ConversorTemperatura`

Permite convertir entre:
- Fahrenheit a Celsius
- Celsius a Fahrenheit

### Ejercicio 3: Figuras Geométricas
**Clase principal:** `FigurasGeometricas`
**Clases de modelo:** `FiguraGeometrica`, `Cilindro`, `Esfera`, `Piramide`

Implementación del ejercicio 8.3 con JavaFX. Permite calcular el volumen y superficie de:
- Cilindro
- Esfera
- Pirámide

## Ejecutar

### Ejecutar el menú principal:
```bash
mvn -q exec:java -Dexec.mainClass="unal.ejercicio9_1.Ejercicio9_1"
```

### Ejecutar ejercicios individuales:
```bash
# Ejercicio 1
mvn -q exec:java -Dexec.mainClass="unal.ejercicio9_1.CalculadoraNumerica"

# Ejercicio 2
mvn -q exec:java -Dexec.mainClass="unal.ejercicio9_1.ConversorTemperatura"

# Ejercicio 3
mvn -q exec:java -Dexec.mainClass="unal.ejercicio9_1.FigurasGeometricas"
```

## Requisitos

- **Java 17+**
- **Apache Maven 3.8+**
- **JavaFX 21** (incluido en las dependencias del proyecto)

## Estructura del Proyecto

```
Ejercicio9_1/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── unal/
                └── ejercicio9_1/
                    ├── Ejercicio9_1.java           # Menú principal
                    ├── CalculadoraNumerica.java    # Ejercicio 1
                    ├── ConversorTemperatura.java   # Ejercicio 2
                    ├── FigurasGeometricas.java     # Ejercicio 3
                    ├── FiguraGeometrica.java       # Clase base
                    ├── Cilindro.java               # Subclase
                    ├── Esfera.java                 # Subclase
                    └── Piramide.java               # Subclase
```

