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

/**
 * Clase que representa la interfaz gráfica de usuario (UI) para la gestión de estudiantes.
 * Permite realizar operaciones como agregar, buscar, actualizar, eliminar y listar estudiantes.
 */
public class EstudianteUI {
    private EstudianteService service;
    private TextField idField;
    private TextField nombreField;
    private TextField edadField;
    private TextArea listaEstudiantes;
    private Label mensajeLabel;

    /**
     * Constructor de la clase EstudianteUI.
     * Inicializa el servicio de lógica de negocios para la gestión de estudiantes.
     */
    public EstudianteUI() {
        this.service = new EstudianteService();
    }

    /**
     * Método que configura y muestra la ventana principal de la aplicación.
     *
     * @param primaryStage La ventana principal de la aplicación JavaFX.
     */
    public void mostrarVentana(Stage primaryStage) {
        primaryStage.setTitle("Gestión de Estudiantes");

        // Crear un diseño GridPane para los controles de la interfaz
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10)); // Márgenes
        grid.setVgap(10); // Espaciado vertical
        grid.setHgap(10); // Espaciado horizontal

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

        // Área de texto para mostrar la lista de estudiantes
        listaEstudiantes = new TextArea();
        listaEstudiantes.setEditable(false); // Solo lectura
        listaEstudiantes.setPrefHeight(200); // Altura preferida

        // Etiqueta para mostrar mensajes al usuario
        mensajeLabel = new Label();

        // Agregar componentes al GridPane
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
        grid.add(listaEstudiantes, 0, 6, 2, 1); // Área de texto ocupa dos columnas
        grid.add(mensajeLabel, 0, 7, 2, 1);

        // Configurar las acciones de los botones
        agregarButton.setOnAction(e -> agregarEstudiante());
        buscarButton.setOnAction(e -> buscarEstudiante());
        actualizarButton.setOnAction(e -> actualizarEstudiante());
        eliminarButton.setOnAction(e -> eliminarEstudiante());
        listarButton.setOnAction(e -> mostrarEstudiantes());
        salirButton.setOnAction(e -> Platform.exit()); // Cierra la aplicación

        // Configurar la escena y mostrar la ventana
        VBox root = new VBox(grid); // Contenedor principal
        Scene scene = new Scene(root, 400, 500); // Crear escena
        primaryStage.setScene(scene); // Asignar escena a la ventana
        primaryStage.show(); // Mostrar la ventana
    }

    /**
     * Agrega un nuevo estudiante basado en los datos ingresados por el usuario.
     * Verifica que los campos ID y edad sean numéricos.
     */
    private void agregarEstudiante() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nombre = nombreField.getText();
            int edad = Integer.parseInt(edadField.getText());
            service.agregarEstudiante(id, nombre, edad); // Agregar estudiante al servicio
            mensajeLabel.setText("Estudiante agregado con éxito.");
            limpiarCampos();
            mostrarEstudiantes(); // Refrescar la lista de estudiantes
        } catch (NumberFormatException e) {
            mensajeLabel.setText("Error: ID y edad deben ser números."); // Manejo de error numérico
        }
    }

    /**
     * Muestra la lista de estudiantes en el área de texto.
     */
    private void mostrarEstudiantes() {
        StringBuilder sb = new StringBuilder();
        for (Estudiante e : service.obtenerTodos()) {
            sb.append(e.toString()).append("\n"); // Agregar cada estudiante a la lista
        }
        listaEstudiantes.setText(sb.toString());
        mensajeLabel.setText("Lista actualizada.");
    }

    /**
     * Busca un estudiante por su ID basado en el input del usuario.
     * Si lo encuentra, muestra los datos en los campos de entrada.
     */
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

    /**
     * Actualiza los datos de un estudiante existente basado en el input del usuario.
     */
    private void actualizarEstudiante() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nombre = nombreField.getText();
            int edad = Integer.parseInt(edadField.getText());
            Estudiante estudiante = service.buscarPorId(id);
            if (estudiante != null) {
                service.actualizarEstudiante(id, nombre, edad);
                mensajeLabel.setText("Estudiante actualizado con éxito.");
                mostrarEstudiantes();
                limpiarCampos();
            } else {
                mensajeLabel.setText("Estudiante no encontrado.");
            }
        } catch (NumberFormatException e) {
            mensajeLabel.setText("Error: ID y edad deben ser números.");
        }
    }

    /**
     * Elimina un estudiante basado en su ID ingresado por el usuario.
     */
    private void eliminarEstudiante() {
        try {
            int id = Integer.parseInt(idField.getText());
            Estudiante estudiante = service.buscarPorId(id);
            if (estudiante != null) {
                service.eliminarEstudiante(id);
                mensajeLabel.setText("Estudiante eliminado con éxito.");
                mostrarEstudiantes();
                limpiarCampos();
            } else {
                mensajeLabel.setText("Estudiante no encontrado.");
            }
        } catch (NumberFormatException e) {
            mensajeLabel.setText("Error: ID debe ser un número.");
        }
    }

    /**
     * Limpia los campos de entrada de texto.
     */
    private void limpiarCampos() {
        idField.clear();
        nombreField.clear();
        edadField.clear();
    }
}