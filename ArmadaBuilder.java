/**
 * Clase {@code ArmadaBuilder} que implementa la interfaz {@link ConstructorCompu}.
 * <p>
 * Este builder se utiliza para construir computadoras que ya están armadas,
 * agregando directamente los componentes a una instancia existente de {@link Compu}.
 * </p>
 */
public class ArmadaBuilder implements ConstructorCompu {

    // Esta clase se usa para las compus que ya están armadas

    /**
     * Instancia de la computadora que se está construyendo.
     */
    private Compu pc;

    /**
     * Constructor que inicializa un nuevo objeto {@link Compu} vacío
     * para comenzar el proceso de construcción.
     */
    public ArmadaBuilder() {
        this.pc = new Compu();
    }

    /**
     * Agrega un componente de tipo {@link CPU} a la computadora.
     *
     * @param cpu el procesador que se agregará.
     */
    @Override
    public void agregarCPU(CPU cpu) { 
        pc.setCPU(cpu); 
    }

    /**
     * Agrega un componente de tipo {@link GPU} a la computadora.
     *
     * @param gpu la tarjeta gráfica que se agregará.
     */
    @Override
    public void agregarGPU(GPU gpu) {
        pc.setGPU(gpu); 
    }

    /**
     * Agrega un componente de tipo {@link Madre} (placa madre) a la computadora.
     *
     * @param madre la placa madre que se agregará.
     */
    @Override
    public void agregarMadre(Madre madre) { 
        pc.setMadre(madre); 
    }

    /**
     * Agrega un módulo de memoria {@link RAM} a la computadora.
     *
     * @param ram la memoria RAM que se agregará.
     */
    @Override
    public void agregarRAM(RAM ram) {
        pc.addRAM(ram);
    }

    /**
     * Agrega un dispositivo de almacenamiento {@link Disco} a la computadora.
     *
     * @param disco el disco duro o SSD que se agregará.
     */
    @Override
    public void agregarDisco(Disco disco) { 
        pc.addDisco(disco);
    }

    /**
     * Agrega una fuente de poder {@link Fuente} a la computadora.
     *
     * @param fuente la fuente de poder que se agregará.
     */
    @Override
    public void agregarFuente(Fuente fuente) { 
        pc.setFuente(fuente); 
    }

    /**
     * Agrega un gabinete {@link Gabinete} a la computadora.
     *
     * @param gabinete el gabinete que se agregará.
     */
    @Override
    public void agregarGabinete(Gabinete gabinete) {
        pc.setGabinete(gabinete); 
    }

    /**
     * Devuelve la computadora completamente construida con todos los componentes agregados.
     *
     * @return el objeto {@link Compu} resultante.
     */
    @Override
    public Compu build() {
        return pc;
    }
}
