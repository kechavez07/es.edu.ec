package ec.edu.espe.presentacion;

import ec.edu.espe.datos.model.Estudiante;
import ec.edu.espe.logica_negocio.EstudianteService;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;




public class EstudianteUI {
    private EstudianteService service;
    private TextField idField;
    private TextField nombreField;
    private TextField edadField;
    private TextArea listaEstudiantes;
    private Label mensajeLabel;

    public EstudianteUI() {
        this.service = new EstudianteService();
    }

    public void mostrarVentana(Stage primaryStage) {
        primaryStage.setTitle("Gestión de Estudiantes");

        // Crear componentes de la UI
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        // Campos de entrada
        Label idLabel = new Label("ID:");
        idField = new TextField();
        Label nombreLabel = new Label("Nombre:");
        nombreField = new TextField();
        Label edadLabel = new Label("Edad:");
        edadField = new TextField();

        // Botones
        Button agregarButton = new Button("Agregar");
        Button buscarButton = new Button("Buscar");
        Button actualizarButton = new Button("Actualizar");
        Button eliminarButton = new Button("Eliminar");
        Button listarButton = new Button("Listar Todos");
        Button salirButton = new Button("Salir");

        // Área de texto para mostrar estudiantes
        listaEstudiantes = new TextArea();
        listaEstudiantes.setEditable(false);
        listaEstudiantes.setPrefHeight(200);

        // Etiqueta para mensajes
        mensajeLabel = new Label();

        // Agregar componentes al grid
        grid.add(idLabel, 0, 0);
        grid.add(idField, 1, 0);
        grid.add(nombreLabel, 0, 1);
        grid.add(nombreField, 1, 1);
        grid.add(edadLabel, 0, 2);
        grid.add(edadField, 1, 2);
        grid.add(agregarButton, 0, 3);
        grid.add(buscarButton, 1, 3);
        grid.add(actualizarButton, 0, 4);
        grid.add(eliminarButton, 1, 4);
        grid.add(listarButton, 0, 5);
        grid.add(salirButton, 1, 5);
        grid.add(listaEstudiantes, 0, 6, 2, 1);
        grid.add(mensajeLabel, 0, 7, 2, 1);

        // Configurar acciones de los botones
        agregarButton.setOnAction(e -> agregarEstudiante());
        buscarButton.setOnAction(e -> buscarEstudiante());
        actualizarButton.setOnAction(e -> actualizarEstudiante());
        eliminarButton.setOnAction(e -> eliminarEstudiante());
        listarButton.setOnAction(e -> mostrarEstudiantes());
        salirButton.setOnAction(e -> Platform.exit());

        // Configurar la escena
        VBox root = new VBox(grid);
        Scene scene = new Scene(root, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void agregarEstudiante() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nombre = nombreField.getText();
            int edad = Integer.parseInt(edadField.getText());
            service.agregarEstudiante(id, nombre, edad);
            mensajeLabel.setText("Estudiante agregado con éxito.");
            limpiarCampos();
        } catch (NumberFormatException e) {
            mensajeLabel.setText("Error: ID y edad deben ser números.");
        }
    }

    private void mostrarEstudiantes() {
        StringBuilder sb = new StringBuilder();
        for (Estudiante e : service.obtenerTodos()) {
            sb.append(e.toString()).append("\n");
        }
        listaEstudiantes.setText(sb.toString());
        mensajeLabel.setText("Lista actualizada.");
    }

    private void buscarEstudiante() {
        try {
            int id = Integer.parseInt(idField.getText());
            Estudiante estudiante = service.buscarPorId(id);
            if (estudiante != null) {
                nombreField.setText(estudiante.getNombre());
                edadField.setText(String.valueOf(estudiante.getEdad()));
                mensajeLabel.setText("Estudiante encontrado.");
            } else {
                mensajeLabel.setText("Estudiante no encontrado.");
            }
        } catch (NumberFormatException e) {
            mensajeLabel.setText("Error: ID debe ser un número.");
        }
    }

    private void actualizarEstudiante() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nombre = nombreField.getText();
            int edad = Integer.parseInt(edadField.getText());
            Estudiante estudiante = service.buscarPorId(id);
            if (estudiante != null) {
                service.actualizarEstudiante(id, nombre, edad);
                mensajeLabel.setText("Estudiante actualizado con éxito.");
                limpiarCampos();
            } else {
                mensajeLabel.setText("Estudiante no encontrado.");
            }
        } catch (NumberFormatException e) {
            mensajeLabel.setText("Error: ID y edad deben ser números.");
        }
    }

    private void eliminarEstudiante() {
        try {
            int id = Integer.parseInt(idField.getText());
            Estudiante estudiante = service.buscarPorId(id);
            if (estudiante != null) {
                service.eliminarEstudiante(id);
                mensajeLabel.setText("Estudiante eliminado con éxito.");
                limpiarCampos();
            } else {
                mensajeLabel.setText("Estudiante no encontrado.");
            }
        } catch (NumberFormatException e) {
            mensajeLabel.setText("Error: ID debe ser un número.");
        }
    }

    private void limpiarCampos() {
        idField.clear();
        nombreField.clear();
        edadField.clear();
    }
}
