import java.util.ArrayList;
import java.util.List;

public class Compu implements Compunent {
    private CPU cpu;
    private Madre madre;
    private GPU gpu;
    private Fuente fuente;
    private Gabinete gabinete;
    private List<RAM> rams;
    private List<Disco> discos;
    private boolean tuvoIncompatibilidad = false;

    public Compu() {
        rams = new ArrayList<>();
        discos = new ArrayList<>();
    }

    public void setCPU(CPU cpu) { this.cpu = cpu; }
    public CPU getCPU() { return cpu; }

    public void setMadre(Madre madre) { this.madre = madre; }
    public Madre getMadre() { return madre; }

    public void setGPU(GPU gpu) { this.gpu = gpu; }
    public GPU getGPU() { return gpu; }

    public void setFuente(Fuente fuente) { this.fuente = fuente; }
    public Fuente getFuente() { return fuente; }

    public void setGabinete(Gabinete gabinete) { this.gabinete = gabinete; }
    public Gabinete getGabinete() { return gabinete; }

    public void addRAM(RAM ram) { rams.add(ram); }
    public List<RAM> getRams() { return rams; }

    public void addDisco(Disco disco) { discos.add(disco); }
    public List<Disco> getDiscos() { return discos; }

    public void setIncompatibilidad(boolean valor) { tuvoIncompatibilidad = valor; }
    public boolean tuvoIncompatibilidad() { return tuvoIncompatibilidad; }

    @Override
    public double getPrecio() {
        double total = 0;
        if(cpu != null) total += cpu.getPrecio();
        if(madre != null) total += madre.getPrecio();
        if(gpu != null) total += gpu.getPrecio();
        if(fuente != null) total += fuente.getPrecio();
        if(gabinete != null) total += gabinete.getPrecio();
        for(RAM r : rams) total += r.getPrecio();
        for(Disco d : discos) total += d.getPrecio();
        return total;
    }

    @Override
    public String getDescripcion() {
        StringBuilder sb = new StringBuilder(getDescripcionBase());
        sb.append("\nPrecio total: $").append(getPrecio());
        return sb.toString();
    }

    @Override
    public String getDescripcionBase() {
        StringBuilder sb = new StringBuilder("=== Componentes de la PC ===");
        if(cpu != null) sb.append("\nCPU: ").append(cpu.getNombre());
        if(madre != null) sb.append("\nMotherboard: ").append(madre.getNombre());
        if(gpu != null) sb.append("\nGPU: ").append(gpu.getNombre());
        if(!rams.isEmpty()) {
            sb.append("\nRAM:");
            for(RAM r : rams) sb.append(" ").append(r.getNombre());
        }
        if(!discos.isEmpty()) {
            sb.append("\nDiscos:");
            for(Disco d : discos) sb.append(" ").append(d.getNombre());
        }
        if(fuente != null) sb.append("\nFuente: ").append(fuente.getNombre());
        if(gabinete != null) sb.append("\nGabinete: ").append(gabinete.getNombre());
        return sb.toString();
    }

    @Override
    public List<Programa> getProgramas() {
        return new ArrayList<>();
    }
}
