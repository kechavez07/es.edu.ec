package ec.edu.espe.datos.model;

/**
 * Representa un estudiante con un ID, nombre y edad.
 */
public class Estudiante {
    /**
     * ID único del estudiante.
     */
    private int id;

    /**
     * Nombre del estudiante.
     */
    private String nombre;

    /**
     * Edad del estudiante.
     */
    private int edad;

    /**
     * Constructor para crear una instancia de Estudiante.
     *
     * @param id     ID único del estudiante.
     * @param nombre Nombre completo del estudiante.
     * @param edad   Edad del estudiante.
     */
    public Estudiante(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Obtiene el ID del estudiante.
     *
     * @return ID del estudiante.
     */
    public int getId() {
        return id;
    }

    /**
     * Actualiza el ID del estudiante.
     *
     * @param id Nuevo ID del estudiante.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del estudiante.
     *
     * @return Nombre del estudiante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre del estudiante.
     *
     * @param nombre Nuevo nombre del estudiante.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad del estudiante.
     *
     * @return Edad del estudiante.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Actualiza la edad del estudiante.
     *
     * @param edad Nueva edad del estudiante.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Estudiante.
     *
     * @return Cadena que describe al estudiante con su ID, nombre y edad.
     */
    @Override
    public String toString() {
        return "Estudiante{id=" + id + ", nombre='" + nombre + "', edad=" + edad + "}";
    }
}