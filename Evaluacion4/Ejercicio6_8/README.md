# Ejercicio 6.8 - Lectura de Archivos

## Descripción General

Este ejercicio implementa un sistema de lectura de archivos de texto utilizando las clases `FileInputStream`, `InputStreamReader` y `BufferedReader` de Java. El programa demuestra cómo crear un flujo de bytes para leer archivos de texto y mostrar su contenido en pantalla.

## Requisitos

- Java 24 o superior
- Maven 3.6 o superior
- Archivo de texto de prueba (opcional)

## Cómo Abrir el Proyecto en NetBeans

1. Abra NetBeans IDE
2. Seleccione **File** → **Open Project**
3. Navegue hasta la carpeta `Evaluacion4/Ejercicio6_8`
4. Seleccione el proyecto y haga clic en **Open Project**

## Cómo Ejecutar el Proyecto

### Opción 1: Desde NetBeans
1. Haga clic derecho en el proyecto
2. Seleccione **Run**

### Opción 2: Desde Terminal
```bash
# Navegar al directorio del proyecto
cd Evaluacion4/Ejercicio6_8

# Compilar el proyecto
mvn compile

# Ejecutar el programa principal
mvn exec:java -Dexec.mainClass="unal.ejercicio6_8.Ejercicio6_8"
```

## Estructura del Proyecto

```
Ejercicio6_8/
├── pom.xml
├── DOCUMENTATION.md
├── README.md
└── src/
    └── main/
        └── java/
            └── unal/
                └── ejercicio6_8/
                    ├── Ejercicio6_8.java          # Clase principal
                    ├── LeerArchivo.java           # Ejercicio del enunciado
                    ├── LeerArchivoTeclado.java    # Ejercicio propuesto 1
                    └── LeerArchivoMayusculas.java # Ejercicio propuesto 2
```

## Clases Implementadas

### Clase Principal
- **[Ejercicio6_8.java](https://github.com/ybedoyab/UNAL-POO/blob/main/Evaluacion4/Ejercicio6_8/src/main/java/unal/ejercicio6_8/Ejercicio6_8.java)** - Punto de entrada del programa

### Ejercicio del Enunciado
- **[LeerArchivo.java](https://github.com/ybedoyab/UNAL-POO/blob/main/Evaluacion4/Ejercicio6_8/src/main/java/unal/ejercicio6_8/LeerArchivo.java)** - Lectura básica de archivo de texto

### Ejercicios Propuestos
- **[LeerArchivoTeclado.java](https://github.com/ybedoyab/UNAL-POO/blob/main/Evaluacion4/Ejercicio6_8/src/main/java/unal/ejercicio6_8/LeerArchivoTeclado.java)** - Lectura con nombre de archivo por teclado
- **[LeerArchivoMayusculas.java](https://github.com/ybedoyab/UNAL-POO/blob/main/Evaluacion4/Ejercicio6_8/src/main/java/unal/ejercicio6_8/LeerArchivoMayusculas.java)** - Lectura con conversión a mayúsculas

## Ejecución de Ejercicios Propuestos

### Ejercicio Propuesto 1: Lectura por Teclado
```bash
mvn exec:java -Dexec.mainClass="unal.ejercicio6_8.LeerArchivoTeclado"
```

### Ejercicio Propuesto 2: Conversión a Mayúsculas
```bash
mvn exec:java -Dexec.mainClass="unal.ejercicio6_8.LeerArchivoMayusculas"
```

## Salida Esperada

### Programa Principal
```
Linea 1
Linea 2
Linea 3
...
```

### Ejercicio Propuesto 1
```
=== Lectura de Archivo por Teclado ===
Ingrese el nombre del archivo (con ruta completa): C:/prueba.txt

--- Contenido del archivo 'C:/prueba.txt' ---
Linea 1: Linea 1
Linea 2: Linea 2
--- Fin del archivo ---
```

### Ejercicio Propuesto 2
```
=== Contenido del archivo en MAYUSCULAS ===
Archivo: C:/prueba.txt
--- Contenido convertido ---
Linea 1: LINEA 1
Linea 2: LINEA 2
--- Fin del archivo ---
```

## Notas Importantes

- **Archivo de Prueba**: El programa principal intenta leer "C:/prueba.txt". Asegúrese de que este archivo exista o modifique la ruta en el código.
- **Manejo de Excepciones**: Todos los programas incluyen manejo robusto de excepciones IOException y FileNotFoundException.
- **Cierre de Recursos**: Se utiliza el patrón de cierre de recursos en bloques `finally` para evitar memory leaks.

## Documentación Completa

Para más detalles sobre la implementación, casos de uso y diagramas, consulte el archivo [DOCUMENTATION.md](DOCUMENTATION.md).
