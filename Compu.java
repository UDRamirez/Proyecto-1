import java.util.ArrayList;
import java.util.List;

/**
 * Clase {@code Compu} que implementa la interfaz {@link Compunent}.
 * <p>
 * Representa una computadora ensamblada con sus distintos componentes de hardware,
 * incluyendo CPU, GPU, placa madre, memorias RAM, discos duros, fuente de poder y gabinete.
 * Proporciona métodos para agregar componentes, obtener el precio total y generar
 * una descripción detallada del hardware instalado.
 * </p>
 */
public class Compu implements Compunent {

    /**
     * Procesador de la computadora.
     */
    private CPU cpu;

    /**
     * Tarjeta gráfica de la computadora.
     */
    private GPU gpu;

    /**
     * Placa madre de la computadora.
     */
    private Madre madre;

    /**
     * Lista de memorias RAM instaladas.
     */
    private List<RAM> rams = new ArrayList<>();

    /**
     * Lista de discos duros o SSDs instalados.
     */
    private List<Disco> discos = new ArrayList<>();

    /**
     * Gabinete de la computadora.
     */
    private Gabinete gab;

    /**
     * Fuente de poder de la computadora.
     */
    private Fuente fuente;

    private List<Programa> programas = new ArrayList<>();

    private List<String> advertencias = new ArrayList<>();


    /**
     * Constructor por defecto que inicializa una computadora vacía sin componentes.
     */
    public Compu() { }

    /**
     * Calcula el precio total de la computadora sumando el precio de todos los componentes.
     *
     * @return el precio total como valor {@code double}.
     */
    public double getPrecio() {
        double total = 0;
        if (cpu != null) total += cpu.getPrecio();
        if (gpu != null) total += gpu.getPrecio();
        if (madre != null) total += madre.getPrecio();
        if (fuente != null) total += fuente.getPrecio();
        if (gab != null) total += gab.getPrecio();
        for (RAM rar : rams) total += rar.getPrecio();
        for (Disco dis : discos) total += dis.getPrecio();
        return total;
    }

    /**
     * Asigna un procesador a la computadora.
     *
     * @param cpu el {@link CPU} que se agregará.
     */
    public void setCPU(CPU cpu) { 
        this.cpu = cpu; 
    }

    /**
     * Asigna una tarjeta gráfica a la computadora.
     *
     * @param gpu la {@link GPU} que se agregará.
     */
    public void setGPU(GPU gpu) { 
        this.gpu = gpu; 
    }

    /**
     * Asigna una placa madre a la computadora.
     *
     * @param madre la {@link Madre} que se agregará.
     */
    public void setMadre(Madre madre) { 
        this.madre = madre; 
    }

    /**
     * Agrega un módulo de memoria RAM a la computadora.
     *
     * @param ram la {@link RAM} que se agregará.
     */
    public void addRAM(RAM ram) { 
        rams.add(ram); 
    }

    /**
     * Agrega un disco duro o SSD a la computadora.
     *
     * @param disco el {@link Disco} que se agregará.
     */
    public void addDisco(Disco disco) { 
        discos.add(disco); 
    }

    /**
     * Asigna una fuente de poder a la computadora.
     *
     * @param fuente la {@link Fuente} que se agregará.
     */
    public void setFuente(Fuente fuente) { 
        this.fuente = fuente; 
    }

    /**
     * Asigna un gabinete a la computadora.
     *
     * @param gab el {@link Gabinete} que se agregará.
     */
    public void setGabinete(Gabinete gab) { 
        this.gab = gab; 
    }

    public void setProgramas(List<Programa> programas) {
    this.programas = programas;
    }

    public void setAdvertencias(List<String> advertencias) {
    this.advertencias = advertencias;
    }

  
    /**
     * Devuelve el procesador de la computadora.
     *
     * @return el {@link CPU} instalado.
     */
    public CPU getCPU() { 
        return cpu; 
    }

    /**
     * Devuelve la tarjeta gráfica de la computadora.
     *
     * @return la {@link GPU} instalada.
     */
    public GPU getGPU() { 
        return gpu; 
    }

    /**
     * Devuelve la lista de memorias RAM instaladas.
     *
     * @return lista de {@link RAM}.
     */
    public List<RAM> getRams() { 
        return rams; 
    }

    /**
     * Devuelve la placa madre de la computadora.
     *
     * @return la {@link Madre} instalada.
     */
    public Madre getMadre() { 
        return madre; 
    }

    /**
     * Devuelve la lista de discos duros o SSDs instalados.
     *
     * @return lista de {@link Disco}.
     */
    public List<Disco> getDiscos() { 
        return discos; 
    }

    /**
     * Devuelve la fuente de poder de la computadora.
     *
     * @return la {@link Fuente} instalada.
     */
    public Fuente getFuente() { 
        return fuente; 
    }

    /**
     * Devuelve el gabinete de la computadora.
     *
     * @return el {@link Gabinete} instalado.
     */
    public Gabinete getGabinete() { 
        return gab; 
    }

      public List<Programa> getProgramas() {
    return programas;
    }

    public List<String> getAdvertencias() {
    return advertencias;
    }

    /**
     * Genera una descripción completa del hardware de la computadora,
     * listando todos los componentes y sus precios.
     *
     * @return una cadena con la descripción detallada del hardware.
     */
    @Override
    public String getDescripcion() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== Hardware de la PC =====\n");
        sb.append("CPU: ").append(cpu != null ? cpu.getNombre() : "No seleccionado").append("\n");
        sb.append("GPU: ").append(gpu != null ? gpu.getNombre() : "No seleccionado").append("\n");
        sb.append("Motherboard: ").append(madre != null ? madre.getNombre() : "No seleccionada").append("\n");
        sb.append("Fuente: ").append(fuente != null ? fuente.getNombre() : "No seleccionada").append("\n");
        sb.append("Gabinete: ").append(gab != null ? gab.getNombre() : "No seleccionado").append("\n");

        sb.append("\n--- Memorias RAM ---\n");
        if (rams.isEmpty()) sb.append("Sin memorias\n");
        for (RAM r : rams) sb.append(r.getNombre()).append(" - $").append(r.getPrecio()).append("\n");

        sb.append("\n--- Discos duros ---\n");
        if (discos.isEmpty()) sb.append("Sin discos\n");
        for (Disco d : discos) sb.append(d.getNombre()).append(" - $").append(d.getPrecio()).append("\n");

        sb.append("\n--- SOFTWARE INSTALADO ---\n");
        if (programas.isEmpty()) {
            sb.append("Sin programas\n");
        } else {
            for (Programa p : programas)
                sb.append("  - ").append(p.getNombre()).append(" ($").append(p.getPrecio()).append(")\n");
        }

        sb.append("\nPrecio total: $").append(getPrecioTotal()).append("\n");
        return sb.toString();
    }

}
