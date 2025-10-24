/**
 * Interfaz {@code ConstructorCompu}.
 * <p>
 * Define los métodos que un builder de computadoras debe implementar
 * para agregar componentes individuales y finalmente construir
 * un objeto {@link Compu}.
 * </p>
 */
public interface ConstructorCompu {

    /**
     * Agrega un procesador {@link CPU} a la computadora en construcción.
     *
     * @param cpu la CPU a agregar.
     */
    void agregarCPU(CPU cpu);

    /**
     * Agrega una tarjeta gráfica {@link GPU} a la computadora en construcción.
     *
     * @param gpu la GPU a agregar.
     */
    void agregarGPU(GPU gpu);

    /**
     * Agrega una placa madre {@link Madre} a la computadora en construcción.
     *
     * @param madre la placa madre a agregar.
     */
    void agregarMadre(Madre madre);

    /**
     * Agrega un módulo de memoria RAM {@link RAM} a la computadora en construcción.
     *
     * @param ram la memoria RAM a agregar.
     */
    void agregarRAM(RAM ram);

    /**
     * Agrega un disco duro o SSD {@link Disco} a la computadora en construcción.
     *
     * @param disco el disco a agregar.
     */
    void agregarDisco(Disco disco);

    /**
     * Agrega una fuente de poder {@link Fuente} a la computadora en construcción.
     *
     * @param fuente la fuente a agregar.
     */
    void agregarFuente(Fuente fuente);

    /**
     * Agrega un gabinete {@link Gabinete} a la computadora en construcción.
     *
     * @param gab el gabinete a agregar.
     */
    void agregarGabinete(Gabinete gab);

    /**
     * Construye y devuelve la computadora completa {@link Compu} con todos
     * los componentes agregados.
     *
     * @return la computadora construida.
     */
    Compu build();
}
