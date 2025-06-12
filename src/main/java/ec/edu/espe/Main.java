package ec.edu.espe;

import ec.edu.espe.presentacion.EstudianteUI;
import javafx.application.Application;

public class Main extends Application {
    @Override
    public void start(javafx.stage.Stage primaryStage) {
        EstudianteUI ui = new EstudianteUI();
        ui.mostrarVentana(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}