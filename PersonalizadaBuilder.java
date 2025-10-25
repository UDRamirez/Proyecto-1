/**
 * Clase {@code PersonalizadaBuilder}.
 * <p>
 * Implementa la interfaz {@link ConstructorCompu} y permite construir
 * computadoras personalizadas paso a paso usando el patrón Builder.
 * </p>
 */
public class PersonalizadaBuilder implements ConstructorCompu {

    /** Computadora que se va a construir. */
    private Compu pc;
    
    private List<Programa> programas = new ArrayList<>();


    /**
     * Crea un nuevo constructor para construir una computadora personalizada.
     */
    public PersonalizadaBuilder() {
        this.pc = new Compu();
    }

    /**
     * Agrega una CPU a la computadora.
     *
     * @param cpu la CPU a agregar.
     */
    @Override
    public void agregarCPU(CPU cpu) {
        pc.setCPU(cpu);
    }

    /**
     * Agrega una GPU a la computadora.
     *
     * @param gpu la GPU a agregar.
     */
    @Override
    public void agregarGPU(GPU gpu) {
        pc.setGPU(gpu);
    }

    /**
     * Agrega una placa madre a la computadora.
     *
     * @param madre la placa madre a agregar.
     */
    @Override
    public void agregarMadre(Madre madre) {
        pc.setMadre(madre);
    }

    /**
     * Agrega una memoria RAM a la computadora.
     *
     * @param ram la memoria RAM a agregar.
     */
    @Override
    public void agregarRAM(RAM ram) {
        pc.addRAM(ram);
    }

    /**
     * Agrega un disco a la computadora.
     *
     * @param disco el disco a agregar.
     */
    @Override
    public void agregarDisco(Disco disco) {
        pc.addDisco(disco);
    }

    /**
     * Agrega una fuente de poder a la computadora.
     *
     * @param fuente la fuente a agregar.
     */
    @Override
    public void agregarFuente(Fuente fuente) {
        pc.setFuente(fuente);
    }

    /**
     * Agrega un gabinete a la computadora.
     *
     * @param gabinete el gabinete a agregar.
     */
    @Override
    public void agregarGabinete(Gabinete gabinete) {
        pc.setGabinete(gabinete);
    }

    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }

     private void verificarCompatibilidad(Compu pc) {
        List<String> advertencias = new ArrayList<>();

        if (pc.getCPU() != null && pc.getMadre() != null) {
            AdaptadorCPU aCPU = new AdaptadorCPU(pc.getCPU());
            AdaptadorMadre aMadre = new AdaptadorMadre(pc.getMadre());
            if (!aCPU.esCompatibleCon(aMadre)) {
                advertencias.add("⚠ CPU y Motherboard no son compatibles: "
                        + pc.getCPU().getNombre() + " vs " + pc.getMadre().getNombre());
            }
        }

        pc.setAdvertencias(advertencias);
    }

    /**
     * Devuelve la computadora completa construida.
     *
     * @return la instancia de {@link Compu} construida.
     */
    @Override
    public Compu build() {
        pc.setProgramas(programas);
        verificarCompatibilidad(pc);
        return pc;
    }
}
