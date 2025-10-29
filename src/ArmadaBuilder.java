/**
 * Clase {@code ArmadaBuilder} que implementa la interfaz {@link ConstructorCompu}.
 * <p>
 * Esta clase concreta del patron <b>Builder</b> se encarga de construir objetos
 * del tipo {@link Compu} paso a paso, agregando sus distintos componentes de hardware.
 * <br><br>
 * Se utiliza principalmente para crear computadoras ya armadas o predefinidas
 * dentro del sistema, encapsulando el proceso de construccion y evitando que el
 * codigo cliente deba preocuparse por los detalles internos de la creacion.
 * </p>
 *
 * <h2>Patron de diseno aplicado:</h2>
 * <ul>
 *   <li><b>Builder</b>: Permite construir objetos complejos (como una PC)
 *       mediante pasos controlados, separando la construccion de su representacion.</li>
 * </ul>
 *
 * @version 1.0
 */
public class ArmadaBuilder implements ConstructorCompu {

    /**
     * Instancia de la computadora que se esta construyendo.
     */
    private Compu pc;

    /**
     * Constructor que inicializa un nuevo objeto {@link Compu} vacio,
     * listo para comenzar el proceso de construccion.
     */
    public ArmadaBuilder() {
        this.pc = new Compu();
    }

    /**
     * Agrega un componente de tipo {@link CPU} a la computadora.
     *
     * @param cpu el procesador que se agregara.
     */
    @Override
    public void agregarCPU(CPU cpu) {
        pc.setCPU(cpu);
    }

    /**
     * Agrega un componente de tipo {@link GPU} (tarjeta grafica) a la computadora.
     *
     * @param gpu la tarjeta grafica que se agregara.
     */
    @Override
    public void agregarGPU(GPU gpu) {
        pc.setGPU(gpu);
    }

    /**
     * Agrega una placa madre ({@link Madre}) a la computadora.
     *
     * @param madre la placa madre que se agregara.
     */
    @Override
    public void agregarMadre(Madre madre) {
        pc.setMadre(madre);
    }

    /**
     * Agrega un modulo de memoria RAM ({@link RAM}) a la computadora.
     *
     * @param ram la memoria RAM que se agregara.
     */
    @Override
    public void agregarRAM(RAM ram) {
        pc.addRAM(ram);
    }

    /**
     * Agrega un dispositivo de almacenamiento ({@link Disco}) a la computadora.
     *
     * @param disco el disco duro o SSD que se agregara.
     */
    @Override
    public void agregarDisco(Disco disco) {
        pc.addDisco(disco);
    }

    /**
     * Agrega una fuente de poder ({@link Fuente}) a la computadora.
     *
     * @param fuente la fuente de poder que se agregara.
     */
    @Override
    public void agregarFuente(Fuente fuente) {
        pc.setFuente(fuente);
    }

    /**
     * Agrega un gabinete ({@link Gabinete}) a la computadora.
     *
     * @param gabinete el gabinete que se agregara.
     */
    @Override
    public void agregarGabinete(Gabinete gabinete) {
        pc.setGabinete(gabinete);
    }

    /**
     * Devuelve la computadora completamente construida con todos los
     * componentes agregados durante el proceso de construccion.
     *
     * @return el objeto {@link Compu} resultante.
     */
    @Override
    public Compu build() {
        return pc;
    }
}
