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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejercicio 3: Figuras Geométricas (ejercicio 8.3 con JavaFX)
 * Permite calcular el volumen y superficie de figuras geométricas:
 * - Cilindro
 * - Esfera
 * - Pirámide
 * - Cubo (extensión)
 * - Prisma (extensión)
 * @version 1.0/2024
 */
public class FigurasGeometricas extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        crearUI(primaryStage);
    }
    
    /**
     * Método helper para crear la UI en un Stage dado
     * @param primaryStage El stage donde se mostrará la ventana
     */
    public void crearUI(Stage primaryStage) {
        primaryStage.setTitle("Figuras Geométricas");
        
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        
        Label titulo = new Label("Seleccione una figura geométrica:");
        titulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        Button btnCilindro = new Button("Cilindro");
        btnCilindro.setPrefWidth(200);
        btnCilindro.setOnAction(e -> abrirVentanaCilindro());
        
        Button btnEsfera = new Button("Esfera");
        btnEsfera.setPrefWidth(200);
        btnEsfera.setOnAction(e -> abrirVentanaEsfera());
        
        Button btnPiramide = new Button("Pirámide");
        btnPiramide.setPrefWidth(200);
        btnPiramide.setOnAction(e -> abrirVentanaPiramide());
        
        Button btnCubo = new Button("Cubo");
        btnCubo.setPrefWidth(200);
        btnCubo.setOnAction(e -> abrirVentanaCubo());
        
        Button btnPrisma = new Button("Prisma");
        btnPrisma.setPrefWidth(200);
        btnPrisma.setOnAction(e -> abrirVentanaPrisma());
        
        root.getChildren().addAll(titulo, btnCilindro, btnEsfera, btnPiramide, btnCubo, btnPrisma);
        
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void abrirVentanaCilindro() {
        Stage stage = new Stage();
        stage.setTitle("Cilindro");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        Label labelRadio = new Label("Radio (cm):");
        TextField campoRadio = new TextField();
        
        Label labelAltura = new Label("Altura (cm):");
        TextField campoAltura = new TextField();
        
        Label labelVolumen = new Label("Volumen (cm³):");
        Label labelSuperficie = new Label("Superficie (cm²):");
        
        Button btnCalcular = new Button("Calcular");
        btnCalcular.setMaxWidth(Double.MAX_VALUE);
        btnCalcular.setOnAction(e -> {
            try {
                double radio = Double.parseDouble(campoRadio.getText());
                double altura = Double.parseDouble(campoAltura.getText());
                Cilindro cilindro = new Cilindro(radio, altura);
                labelVolumen.setText(String.format("Volumen (cm³): %.2f", cilindro.getVolumen()));
                labelSuperficie.setText(String.format("Superficie (cm²): %.2f", cilindro.getSuperficie()));
            } catch (Exception ex) {
                mostrarError("Error", "Campo nulo o error en formato de número");
            }
        });
        
        grid.add(labelRadio, 0, 0);
        grid.add(campoRadio, 1, 0);
        grid.add(labelAltura, 0, 1);
        grid.add(campoAltura, 1, 1);
        grid.add(btnCalcular, 0, 2, 2, 1);
        grid.add(labelVolumen, 0, 3);
        grid.add(labelSuperficie, 0, 4);
        
        grid.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");
        
        Scene scene = new Scene(grid, 350, 200);
        stage.setScene(scene);
        stage.show();
    }
    
    private void abrirVentanaEsfera() {
        Stage stage = new Stage();
        stage.setTitle("Esfera");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        Label labelRadio = new Label("Radio (cm):");
        TextField campoRadio = new TextField();
        
        Label labelVolumen = new Label("Volumen (cm³):");
        Label labelSuperficie = new Label("Superficie (cm²):");
        
        Button btnCalcular = new Button("Calcular");
        btnCalcular.setMaxWidth(Double.MAX_VALUE);
        btnCalcular.setOnAction(e -> {
            try {
                double radio = Double.parseDouble(campoRadio.getText());
                Esfera esfera = new Esfera(radio);
                labelVolumen.setText(String.format("Volumen (cm³): %.2f", esfera.getVolumen()));
                labelSuperficie.setText(String.format("Superficie (cm²): %.2f", esfera.getSuperficie()));
            } catch (Exception ex) {
                mostrarError("Error", "Campo nulo o error en formato de número");
            }
        });
        
        grid.add(labelRadio, 0, 0);
        grid.add(campoRadio, 1, 0);
        grid.add(btnCalcular, 0, 1, 2, 1);
        grid.add(labelVolumen, 0, 2);
        grid.add(labelSuperficie, 0, 3);
        
        grid.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");
        
        Scene scene = new Scene(grid, 350, 180);
        stage.setScene(scene);
        stage.show();
    }
    
    private void abrirVentanaPiramide() {
        Stage stage = new Stage();
        stage.setTitle("Pirámide");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        Label labelBase = new Label("Base (cm):");
        TextField campoBase = new TextField();
        
        Label labelAltura = new Label("Altura (cm):");
        TextField campoAltura = new TextField();
        
        Label labelApotema = new Label("Apotema (cm):");
        TextField campoApotema = new TextField();
        
        Label labelVolumen = new Label("Volumen (cm³):");
        Label labelSuperficie = new Label("Superficie (cm²):");
        
        Button btnCalcular = new Button("Calcular");
        btnCalcular.setMaxWidth(Double.MAX_VALUE);
        btnCalcular.setOnAction(e -> {
            try {
                double base = Double.parseDouble(campoBase.getText());
                double altura = Double.parseDouble(campoAltura.getText());
                double apotema = Double.parseDouble(campoApotema.getText());
                Piramide piramide = new Piramide(base, altura, apotema);
                labelVolumen.setText(String.format("Volumen (cm³): %.2f", piramide.getVolumen()));
                labelSuperficie.setText(String.format("Superficie (cm²): %.2f", piramide.getSuperficie()));
            } catch (Exception ex) {
                mostrarError("Error", "Campo nulo o error en formato de número");
            }
        });
        
        grid.add(labelBase, 0, 0);
        grid.add(campoBase, 1, 0);
        grid.add(labelAltura, 0, 1);
        grid.add(campoAltura, 1, 1);
        grid.add(labelApotema, 0, 2);
        grid.add(campoApotema, 1, 2);
        grid.add(btnCalcular, 0, 3, 2, 1);
        grid.add(labelVolumen, 0, 4);
        grid.add(labelSuperficie, 0, 5);
        
        grid.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");
        
        Scene scene = new Scene(grid, 350, 250);
        stage.setScene(scene);
        stage.show();
    }
    
    private void abrirVentanaCubo() {
        Stage stage = new Stage();
        stage.setTitle("Cubo");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        Label labelArista = new Label("Arista (cm):");
        TextField campoArista = new TextField();
        
        Label labelVolumen = new Label("Volumen (cm³):");
        Label labelSuperficie = new Label("Superficie (cm²):");
        
        Button btnCalcular = new Button("Calcular");
        btnCalcular.setMaxWidth(Double.MAX_VALUE);
        btnCalcular.setOnAction(e -> {
            try {
                double arista = Double.parseDouble(campoArista.getText());
                Cubo cubo = new Cubo(arista);
                labelVolumen.setText(String.format("Volumen (cm³): %.2f", cubo.getVolumen()));
                labelSuperficie.setText(String.format("Superficie (cm²): %.2f", cubo.getSuperficie()));
            } catch (Exception ex) {
                mostrarError("Error", "Campo nulo o error en formato de número");
            }
        });
        
        grid.add(labelArista, 0, 0);
        grid.add(campoArista, 1, 0);
        grid.add(btnCalcular, 0, 1, 2, 1);
        grid.add(labelVolumen, 0, 2);
        grid.add(labelSuperficie, 0, 3);
        
        grid.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");
        
        Scene scene = new Scene(grid, 350, 180);
        stage.setScene(scene);
        stage.show();
    }
    
    private void abrirVentanaPrisma() {
        Stage stage = new Stage();
        stage.setTitle("Prisma");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        Label labelBase = new Label("Base (cm):");
        TextField campoBase = new TextField();
        
        Label labelAltura = new Label("Altura (cm):");
        TextField campoAltura = new TextField();
        
        Label labelLados = new Label("Número de lados:");
        TextField campoLados = new TextField();
        
        Label labelVolumen = new Label("Volumen (cm³):");
        Label labelSuperficie = new Label("Superficie (cm²):");
        
        Button btnCalcular = new Button("Calcular");
        btnCalcular.setMaxWidth(Double.MAX_VALUE);
        btnCalcular.setOnAction(e -> {
            try {
                double base = Double.parseDouble(campoBase.getText());
                double altura = Double.parseDouble(campoAltura.getText());
                int lados = Integer.parseInt(campoLados.getText());
                
                if (lados < 3) {
                    mostrarError("Error", "El número de lados debe ser mayor o igual a 3");
                    return;
                }
                
                Prisma prisma = new Prisma(base, altura, lados);
                labelVolumen.setText(String.format("Volumen (cm³): %.2f", prisma.getVolumen()));
                labelSuperficie.setText(String.format("Superficie (cm²): %.2f", prisma.getSuperficie()));
            } catch (NumberFormatException ex) {
                mostrarError("Error", "Campo nulo o error en formato de número");
            } catch (Exception ex) {
                mostrarError("Error", "Error al calcular: " + ex.getMessage());
            }
        });
        
        grid.add(labelBase, 0, 0);
        grid.add(campoBase, 1, 0);
        grid.add(labelAltura, 0, 1);
        grid.add(campoAltura, 1, 1);
        grid.add(labelLados, 0, 2);
        grid.add(campoLados, 1, 2);
        grid.add(btnCalcular, 0, 3, 2, 1);
        grid.add(labelVolumen, 0, 4);
        grid.add(labelSuperficie, 0, 5);
        
        grid.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");
        
        Scene scene = new Scene(grid, 350, 250);
        stage.setScene(scene);
        stage.show();
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

