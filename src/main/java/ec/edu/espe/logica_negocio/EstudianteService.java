package ec.edu.espe.logica_negocio;

import ec.edu.espe.datos.model.Estudiante;
import ec.edu.espe.datos.repository.EstudianteRepository;

import java.util.List;

public class EstudianteService {
    private EstudianteRepository repository;

    public EstudianteService() {
        this.repository = new EstudianteRepository();
    }

    public void agregarEstudiante(int id, String nombre, int edad) {
        Estudiante estudiante = new Estudiante(id, nombre, edad);
        repository.agregarEstudiante(estudiante);
    }

    public List<Estudiante> obtenerTodos() {
        return repository.obtenerTodos();
    }

    public Estudiante buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public void actualizarEstudiante(int id, String nombre, int edad) {
        Estudiante estudiante = new Estudiante(id, nombre, edad);
        repository.actualizarEstudiante(estudiante);
    }

    public void eliminarEstudiante(int id) {
        repository.eliminarEstudiante(id);
    }

}
