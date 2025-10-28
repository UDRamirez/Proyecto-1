import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Clase {@code Compu} que implementa la interfaz {@link Compunent} y {@link Serializable}.
 * <p>
 * Representa una computadora ensamblada con sus distintos componentes de hardware,
 * incluyendo CPU, GPU, placa madre, memorias RAM, discos duros, fuente de poder y gabinete.
 * Proporciona metodos para agregar componentes, verificar compatibilidad,
 * obtener el precio total y generar una descripcion detallada del hardware instalado.
 * </p>
 *
 * <h2>Funcionamiento:</h2>
 * <ul>
 *   <li>Permite agregar y obtener cada componente individualmente.</li>
 *   <li>Calcula el precio total sumando todos los componentes y programas instalados.</li>
 *   <li>Genera descripciones base y completas, incluyendo programas y posibles incompatibilidades.</li>
 * </ul>
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>{@code
 * Compu miPC = new Compu();
 * miPC.setCPU(new CPU("Ryzen 5 5600X", "AMD", 250.0, 6));
 * miPC.setGPU(new GPU("RTX 3060", "Nvidia", 400.0));
 * System.out.println(miPC.getDescripcion());
 * }</pre>
 *
 * @see Compunent
 * @see Serializable
 * @version 1.0
 */
public class Compu implements Compunent, Serializable {

    private CPU cpu;
    private GPU gpu;
    private Madre madre;
    private List<RAM> rams = new ArrayList<>();
    private List<Disco> discos = new ArrayList<>();
    private Gabinete gabinete;
    private Fuente fuente;
    private List<Programa> programas = new ArrayList<>();

    /**
     * Indica si hubo incompatibilidad entre componentes durante el ensamblaje.
     */
    private boolean huboIncompatibilidad = false;

    /**
     * Constructor vacio para inicializar una instancia de {@code Compu}.
     */
    public Compu() {}

    /**
     * Devuelve true si se detectaron incompatibilidades en los componentes.
     *
     * @return {@code true} si hubo incompatibilidades, {@code false} en caso contrario.
     */
    public boolean tuvoIncompatibilidad() {
        return this.huboIncompatibilidad;
    }

    /**
     * Establece el estado de incompatibilidad de los componentes.
     *
     * @param valor {@code true} si hubo incompatibilidad, {@code false} en caso contrario.
     */
    public void setIncompatibilidad(boolean valor) {
        this.huboIncompatibilidad = valor;
    }

    /**
     * Obtiene el estado de incompatibilidad de los componentes.
     *
     * @return {@code true} si hubo incompatibilidad, {@code false} en caso contrario.
     */
    public boolean getIncompatibilidad() {
        return this.huboIncompatibilidad;
    }

    // Setters para los componentes
    public void setCPU(CPU cpu) { 
        this.cpu = cpu; 
    }
    
    public void setGPU(GPU gpu) { 
        this.gpu = gpu; 
    }
    
    public void setMadre(Madre madre) { 
        this.madre = madre; 
    }
    
    public void addRAM(RAM ram) {
        rams.add(ram); 
    }
    
    public void addDisco(Disco disco) { 
        discos.add(disco); 
    }
    
    public void setFuente(Fuente fuente) {
        this.fuente = fuente; 
    }
    
    public void setGabinete(Gabinete gabinete) { 
        this.gabinete = gabinete;
    }
    
    public void addPrograma(Programa programa) {
        this.programas.add(programa); 
    }

    // Getters para los componentes
    public CPU getCPU() {
        return cpu; 
    }
    
    public GPU getGPU() {
        return gpu; 
    }
    
    public Madre getMadre() { 
        return madre;
    }
    
    public List<RAM> getRams() {
        return rams;
    }
    
    public List<Disco> getDiscos() { 
        return discos; 
    }
    
    public Fuente getFuente() { 
        return fuente;
    }
    
    public Gabinete getGabinete() { 
        return gabinete; 
    }
    
    @Override
    public List<Programa> getProgramas() { return programas; }

    /**
     * Calcula el precio total de la computadora sumando todos los componentes
     * y los programas instalados.
     *
     * @return el precio total de la computadora.
     */
    @Override
    public double getPrecio() {
        double total = 0;
        if (cpu != null) total += cpu.getPrecio();
        if (gpu != null) total += gpu.getPrecio();
        if (madre != null) total += madre.getPrecio();
        if (fuente != null) total += fuente.getPrecio();
        if (gabinete != null) total += gabinete.getPrecio();
        for (RAM r : rams) total += r.getPrecio();
        for (Disco d : discos) total += d.getPrecio();
        for (Programa p : programas) total += p.getPrecio();
        return total;
    }

    /**
     * Genera una descripcion completa de la computadora, incluyendo componentes,
     * programas instalados, precio total y advertencia de incompatibilidades si existen.
     *
     * @return una cadena con la descripcion completa de la computadora.
     */
    @Override
    public String getDescripcion() {
        StringBuilder sb = new StringBuilder(getDescripcionBase());

        sb.append("\nProgramas instalados:");
        if (programas.isEmpty()) {
            sb.append(" Sin programas");
        } else {
            for (Programa p : programas) {
                sb.append("\n + ").append(p.getNombre());
            }
        }

        sb.append("\nPrecio total: $").append(getPrecio());

        if (huboIncompatibilidad) {
            sb.append("\n Se detectaron incompatibilidades en algunos componentes.");
        }

        return sb.toString();
    }

    /**
     * Genera una descripcion detallada del hardware instalado en la computadora,
     * incluyendo adaptaciones si los componentes fueron adaptados para compatibilidad.
     *
     * @return una cadena con la descripcion base de los componentes.
     */
    @Override
    public String getDescripcionBase() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== Detalles de tu nueva PC =====\n");

        sb.append("CPU: ").append(cpu != null ? cpu.getNombre() : "No seleccionado");
        if (cpu != null && cpu.getAdaptado()) sb.append(" [ADAPTADO]");
        sb.append("\n");

        sb.append("GPU: ").append(gpu != null ? gpu.getNombre() : "No seleccionado");
        if (gpu != null && gpu.getAdaptado()) sb.append(" [ADAPTADO]");
        sb.append("\n");

        sb.append("Motherboard: ").append(madre != null ? madre.getNombre() : "No seleccionada");
        if (madre != null && madre.getAdaptado()) sb.append(" [ADAPTADO]");
        sb.append("\n");

        sb.append("Fuente: ").append(fuente != null ? fuente.getNombre() : "No seleccionada");
        if (fuente != null && fuente.getAdaptado()) sb.append(" [ADAPTADO]");
        sb.append("\n");

        sb.append("Gabinete: ").append(gabinete != null ? gabinete.getNombre() : "No seleccionado");
        if (gabinete != null && gabinete.getAdaptado()) sb.append(" [ADAPTADO]");
        sb.append("\n");

        sb.append("\n--- Memorias RAM ---\n");
        if (rams.isEmpty()) sb.append("Sin memorias\n");
        else {
            for (RAM r : rams) {
                sb.append(r.getNombre());
                if (r.getAdaptado()) sb.append(" [ADAPTADO]");
                sb.append(" - $").append(r.getPrecio()).append("\n");
            }
        }

        sb.append("\n--- Discos duros ---\n");
        if (discos.isEmpty()) sb.append("Sin discos\n");
        else {
            for (Disco d : discos) {
                sb.append(d.getNombre());
                if (d.getAdaptado()) sb.append(" [ADAPTADO]");
                sb.append(" - $").append(d.getPrecio()).append("\n");
            }
        }

        return sb.toString();
    }
}
