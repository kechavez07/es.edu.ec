package ec.edu.espe.logica_negocio;

import ec.edu.espe.datos.model.Estudiante;
import ec.edu.espe.datos.repository.EstudianteRepository;

import java.util.List;

/**
 * Clase que contiene la lógica de negocio para la gestión de estudiantes.
 * Esta clase actúa como un intermediario entre la capa de datos y el resto
 * de la aplicación.
 */
public class EstudianteService {
    /**
     * Referencia al repositorio donde se almacenan los datos de los estudiantes.
     */
    private EstudianteRepository repository;

    /**
     * Constructor de la clase EstudianteService.
     * Inicializa la instancia de EstudianteRepository.
     */
    public EstudianteService() {
        this.repository = new EstudianteRepository();
    }

    /**
     * Agrega un nuevo estudiante utilizando su ID, nombre y edad.
     *
     * @param id     Identificador único del estudiante.
     * @param nombre El nombre del estudiante.
     * @param edad   La edad del estudiante.
     */
    public void agregarEstudiante(int id, String nombre, int edad) {
        Estudiante estudiante = new Estudiante(id, nombre, edad);
        repository.agregarEstudiante(estudiante);
    }

    /**
     * Obtiene la lista de todos los estudiantes almacenados.
     *
     * @return Una lista de objetos Estudiante.
     */
    public List<Estudiante> obtenerTodos() {
        return repository.obtenerTodos();
    }

    /**
     * Busca un estudiante utilizando su identificador único.
     *
     * @param id Identificador del estudiante que se desea buscar.
     * @return El objeto Estudiante si se encuentra, de lo contrario, retorna null.
     */
    public Estudiante buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    /**
     * Actualiza la información de un estudiante utilizando su ID, un nuevo nombre y edad.
     *
     * @param id     Identificador único del estudiante.
     * @param nombre Nuevo nombre del estudiante.
     * @param edad   Nueva edad del estudiante.
     */
    public void actualizarEstudiante(int id, String nombre, int edad) {
        Estudiante estudiante = new Estudiante(id, nombre, edad);
        repository.actualizarEstudiante(estudiante);
    }

    /**
     * Elimina un estudiante del repositorio utilizando su identificador único.
     *
     * @param id El identificador del estudiante que se desea eliminar.
     */
    public void eliminarEstudiante(int id) {
        repository.eliminarEstudiante(id);
    }
}