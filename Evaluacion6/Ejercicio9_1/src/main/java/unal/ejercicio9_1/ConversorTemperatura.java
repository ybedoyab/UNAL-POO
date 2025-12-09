package unal.ejercicio9_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejercicio 2: Conversor de Temperatura
 * Permite convertir grados Fahrenheit a Celsius y viceversa
 * @version 1.0/2024
 */
public class ConversorTemperatura extends Application {
    
    private TextField campoTemperatura;
    private TextField campoResultado;
    private RadioButton radioFahrenheitACelsius;
    private RadioButton radioCelsiusAFahrenheit;
    
    @Override
    public void start(Stage stage) {
        crearUI(stage);
    }
    
    /**
     * Método helper para crear la UI en un Stage dado
     * @param stage El stage donde se mostrará la ventana
     */
    public void crearUI(Stage stage) {
        stage.setTitle("Conversor de Temperatura");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        // Grupo de botones de radio
        ToggleGroup grupo = new ToggleGroup();
        radioFahrenheitACelsius = new RadioButton("Fahrenheit a Celsius");
        radioFahrenheitACelsius.setToggleGroup(grupo);
        radioFahrenheitACelsius.setSelected(true);
        
        radioCelsiusAFahrenheit = new RadioButton("Celsius a Fahrenheit");
        radioCelsiusAFahrenheit.setToggleGroup(grupo);
        
        VBox radioBox = new VBox(5);
        radioBox.getChildren().addAll(radioFahrenheitACelsius, radioCelsiusAFahrenheit);
        
        grid.add(new Label("Tipo de conversión:"), 0, 0);
        grid.add(radioBox, 1, 0);
        
        // Campo de temperatura de entrada
        Label labelTemperatura = new Label("Temperatura:");
        campoTemperatura = new TextField();
        campoTemperatura.setPromptText("Ingrese la temperatura");
        
        grid.add(labelTemperatura, 0, 1);
        grid.add(campoTemperatura, 1, 1);
        
        // Botón convertir
        Button btnConvertir = new Button("Convertir");
        btnConvertir.setMaxWidth(Double.MAX_VALUE);
        btnConvertir.setOnAction(e -> convertir());
        
        grid.add(btnConvertir, 0, 2, 2, 1);
        
        // Campo de resultado
        Label labelResultado = new Label("Resultado:");
        campoResultado = new TextField();
        campoResultado.setEditable(false);
        campoResultado.setStyle("-fx-background-color: #f0f0f0;");
        
        grid.add(labelResultado, 0, 3);
        grid.add(campoResultado, 1, 3);
        
        // Botón limpiar
        Button btnLimpiar = new Button("Limpiar");
        btnLimpiar.setMaxWidth(Double.MAX_VALUE);
        btnLimpiar.setOnAction(e -> {
            campoTemperatura.clear();
            campoResultado.clear();
        });
        
        grid.add(btnLimpiar, 0, 4, 2, 1);
        
        // Estilo
        grid.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: green;");
        
        Scene scene = new Scene(grid, 400, 250);
        stage.setScene(scene);
        stage.show();
    }
    
    private void convertir() {
        try {
            String texto = campoTemperatura.getText().trim();
            if (texto.isEmpty()) {
                mostrarError("Error", "Por favor ingrese una temperatura");
                return;
            }
            
            double temperatura = Double.parseDouble(texto);
            double resultado;
            String unidad;
            
            if (radioFahrenheitACelsius.isSelected()) {
                // Convertir Fahrenheit a Celsius
                resultado = (temperatura - 32) * 5.0 / 9.0;
                unidad = "°C";
            } else {
                // Convertir Celsius a Fahrenheit
                resultado = (temperatura * 9.0 / 5.0) + 32;
                unidad = "°F";
            }
            
            campoResultado.setText(String.format("%.2f %s", resultado, unidad));
            
        } catch (NumberFormatException e) {
            mostrarError("Error", "Por favor ingrese un número válido");
        }
    }
    
    private void mostrarError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

