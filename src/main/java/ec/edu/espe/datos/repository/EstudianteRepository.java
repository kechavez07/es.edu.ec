package ec.edu.espe.datos.repository;

import ec.edu.espe.datos.model.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class EstudianteRepository {
    private List<Estudiante> estudiantes;

    public EstudianteRepository() {
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public List<Estudiante> obtenerTodos() {
        return new ArrayList<>(estudiantes);
    }

    public Estudiante buscarPorId(int id) {
        return estudiantes.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void actualizarEstudiante(Estudiante estudiante) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getId() == estudiante.getId()) {
                estudiantes.set(i, estudiante);
                break;
            }
        }
    }

    public void eliminarEstudiante(int id) {
        estudiantes.removeIf(e -> e.getId() == id);
    }
}
