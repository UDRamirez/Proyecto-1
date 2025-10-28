import java.util.ArrayList;
import java.util.List;

public class Compu implements Compunent {

    private CPU cpu;
    private GPU gpu;
    private Madre madre;
    private List<RAM> rams = new ArrayList<>();
    private List<Disco> discos = new ArrayList<>();
    private Gabinete gabinete;
    private Fuente fuente;
    private List<Programa> programas = new ArrayList<>();

    public Compu() {}

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

    public void setCPU(CPU cpu) { this.cpu = cpu; }
    public void setGPU(GPU gpu) { this.gpu = gpu; }
    public void setMadre(Madre madre) { this.madre = madre; }
    public void addRAM(RAM ram) { rams.add(ram); }
    public void addDisco(Disco disco) { discos.add(disco); }
    public void setFuente(Fuente fuente) { this.fuente = fuente; }
    public void setGabinete(Gabinete gabinete) { this.gabinete = gabinete; }
    public void addPrograma(Programa programa) { this.programas.add(programa); }

    public CPU getCPU() { return cpu; }
    public GPU getGPU() { return gpu; }
    public Madre getMadre() { return madre; }
    public List<RAM> getRams() { return rams; }
    public List<Disco> getDiscos() { return discos; }
    public Fuente getFuente() { return fuente; }
    public Gabinete getGabinete() { return gabinete; }
    @Override
    public List<Programa> getProgramas() { return programas; }

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
        return sb.toString();
    }

    @Override
    public String getDescripcionBase() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== Detalles esta PC =====\n");

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
