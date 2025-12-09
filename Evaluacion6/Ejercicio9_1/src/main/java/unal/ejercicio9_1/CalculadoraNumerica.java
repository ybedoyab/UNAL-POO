package unal.ejercicio9_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejercicio 1: Calculadora Numérica
 * Permite ingresar un valor numérico y calcular:
 * - Logaritmo natural
 * - Logaritmo en base 10
 * - Raíz cuadrada
 * - Si es un número primo
 * @version 1.0/2024
 */
public class CalculadoraNumerica extends Application {
    
    private TextField campoNumero;
    private Label labelLogaritmoNatural;
    private Label labelLogaritmoBase10;
    private Label labelRaizCuadrada;
    private Label labelEsPrimo;
    
    @Override
    public void start(Stage stage) {
        crearUI(stage);
    }
    
    /**
     * Método helper para crear la UI en un Stage dado
     * @param stage El stage donde se mostrará la ventana
     */
    public void crearUI(Stage stage) {
        stage.setTitle("Calculadora Numérica");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        // Campo de entrada
        Label labelNumero = new Label("Ingrese un número:");
        campoNumero = new TextField();
        campoNumero.setPromptText("Número");
        
        grid.add(labelNumero, 0, 0);
        grid.add(campoNumero, 1, 0);
        
        // Botón calcular
        Button btnCalcular = new Button("Calcular");
        btnCalcular.setMaxWidth(Double.MAX_VALUE);
        btnCalcular.setOnAction(e -> calcular());
        
        grid.add(btnCalcular, 0, 1, 2, 1);
        
        // Resultados
        labelLogaritmoNatural = new Label("Logaritmo natural: ");
        labelLogaritmoBase10 = new Label("Logaritmo base 10: ");
        labelRaizCuadrada = new Label("Raíz cuadrada: ");
        labelEsPrimo = new Label("¿Es primo?: ");
        
        VBox resultadosBox = new VBox(5);
        resultadosBox.setPadding(new Insets(10));
        resultadosBox.getChildren().addAll(
            labelLogaritmoNatural,
            labelLogaritmoBase10,
            labelRaizCuadrada,
            labelEsPrimo
        );
        
        grid.add(new Label("Resultados:"), 0, 2);
        grid.add(resultadosBox, 0, 3, 2, 1);
        
        // Estilo
        grid.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");
        
        Scene scene = new Scene(grid, 450, 300);
        stage.setScene(scene);
        stage.show();
    }
    
    private void calcular() {
        try {
            String texto = campoNumero.getText().trim();
            if (texto.isEmpty()) {
                mostrarError("Error", "Por favor ingrese un número");
                return;
            }
            
            double numero = Double.parseDouble(texto);
            
            // Validar que el número sea positivo para logaritmos y raíz cuadrada
            if (numero <= 0) {
                mostrarError("Error", "El número debe ser mayor que 0 para calcular logaritmos y raíz cuadrada");
                return;
            }
            
            // Calcular logaritmo natural
            double ln = Math.log(numero);
            labelLogaritmoNatural.setText(String.format("Logaritmo natural: %.4f", ln));
            
            // Calcular logaritmo base 10
            double log10 = Math.log10(numero);
            labelLogaritmoBase10.setText(String.format("Logaritmo base 10: %.4f", log10));
            
            // Calcular raíz cuadrada
            double raiz = Math.sqrt(numero);
            labelRaizCuadrada.setText(String.format("Raíz cuadrada: %.4f", raiz));
            
            // Verificar si es primo (solo para enteros positivos)
            if (numero == Math.floor(numero) && numero > 0) {
                boolean esPrimo = esPrimo((long) numero);
                labelEsPrimo.setText("¿Es primo?: " + (esPrimo ? "Sí" : "No"));
            } else {
                labelEsPrimo.setText("¿Es primo?: Solo se puede verificar para números enteros positivos");
            }
            
        } catch (NumberFormatException e) {
            mostrarError("Error", "Por favor ingrese un número válido");
        }
    }
    
    private boolean esPrimo(long numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero <= 3) {
            return true;
        }
        if (numero % 2 == 0 || numero % 3 == 0) {
            return false;
        }
        
        for (long i = 5; i * i <= numero; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }
        return true;
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

