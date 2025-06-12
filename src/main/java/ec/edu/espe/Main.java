package ec.edu.espe;

import ec.edu.espe.presentacion.EstudianteUI;
import javafx.application.Application;

/**
 * Clase principal de la aplicación que extiende de Application,
 * utilizada para iniciar una aplicación JavaFX.
 */
public class Main extends Application {
    /**
     * Metodo `start` que se ejecuta al iniciar la aplicación JavaFX.
     * Inicializa e invoca la interfaz de usuario principal de la aplicación.
     *
     * @param primaryStage La ventana principal de la aplicación JavaFX.
     */
    @Override
    public void start(javafx.stage.Stage primaryStage) {
        EstudianteUI ui = new EstudianteUI();
        ui.mostrarVentana(primaryStage);
    }

    /**
     * Metodo principal (`main`) de la aplicación.
     * Es el punto de entrada de la aplicación Java.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch(args);
    }
}