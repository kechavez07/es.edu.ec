package ec.edu.espe.datos.repository;

import ec.edu.espe.datos.model.Estudiante;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que actúa como repositorio para gestionar las operaciones CRUD
 * relacionadas con los estudiantes.
 */
public class EstudianteRepository {
    /**
     * Lista que almacena los objetos de tipo Estudiante.
     */
    private List<Estudiante> estudiantes;

    /**
     * Constructor de la clase EstudianteRepository.
     * Inicializa un repositorio vacío para almacenar estudiantes.
     */
    public EstudianteRepository() {
        this.estudiantes = new ArrayList<>();
    }

    /**
     * Agrega un nuevo estudiante al repositorio.
     *
     * @param estudiante El estudiante que se desea agregar.
     */
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    /**
     * Obtiene una lista con todos los estudiantes almacenados.
     *
     * @return Una nueva lista que contiene todos los estudiantes.
     */
    public List<Estudiante> obtenerTodos() {
        return new ArrayList<>(estudiantes);
    }

    /**
     * Busca un estudiante en el repositorio utilizando su ID.
     *
     * @param id El identificador del estudiante que se desea buscar.
     * @return El objeto Estudiante si se encuentra, de lo contrario, retorna null.
     */
    public Estudiante buscarPorId(int id) {
        return estudiantes.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Actualiza la información de un estudiante existente en el repositorio.
     * Si el ID del estudiante existe, reemplaza su información.
     *
     * @param estudiante El estudiante con la información actualizada.
     */
    public void actualizarEstudiante(Estudiante estudiante) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getId() == estudiante.getId()) {
                estudiantes.set(i, estudiante);
                break;
            }
        }
    }

    /**
     * Elimina un estudiante del repositorio utilizando su ID.
     *
     * @param id El identificador del estudiante que se desea eliminar.
     */
    public void eliminarEstudiante(int id) {
        estudiantes.removeIf(e -> e.getId() == id);
    }
}