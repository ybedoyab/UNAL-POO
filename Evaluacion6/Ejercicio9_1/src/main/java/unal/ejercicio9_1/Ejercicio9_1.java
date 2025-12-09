package unal.ejercicio9_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Clase principal que muestra un menú para seleccionar el ejercicio a ejecutar
 * @version 1.0/2024
 */
public class Ejercicio9_1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ejercicio 9.1 - Menú Principal");
        
        Label titulo = new Label("Seleccione el ejercicio a ejecutar:");
        titulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        Button btnEjercicio1 = new Button("Ejercicio 1: Calculadora Numérica");
        btnEjercicio1.setMaxWidth(Double.MAX_VALUE);
        btnEjercicio1.setOnAction(e -> {
            CalculadoraNumerica calc = new CalculadoraNumerica();
            Stage stage = new Stage();
            calc.crearUI(stage);
            stage.show();
        });
        
        Button btnEjercicio2 = new Button("Ejercicio 2: Conversor de Temperatura");
        btnEjercicio2.setMaxWidth(Double.MAX_VALUE);
        btnEjercicio2.setOnAction(e -> {
            ConversorTemperatura conv = new ConversorTemperatura();
            Stage stage = new Stage();
            conv.crearUI(stage);
            stage.show();
        });
        
        Button btnEjercicio3 = new Button("Ejercicio 3: Figuras Geométricas");
        btnEjercicio3.setMaxWidth(Double.MAX_VALUE);
        btnEjercicio3.setOnAction(e -> {
            FigurasGeometricas fig = new FigurasGeometricas();
            Stage stage = new Stage();
            fig.crearUI(stage);
            stage.show();
        });
        
        Button btnSalir = new Button("Salir");
        btnSalir.setMaxWidth(Double.MAX_VALUE);
        btnSalir.setOnAction(e -> primaryStage.close());
        
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(titulo, btnEjercicio1, btnEjercicio2, btnEjercicio3, btnSalir);
        
        Scene scene = new Scene(root, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(Ejercicio9_1.class, args);
    }
}
