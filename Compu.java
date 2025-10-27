import java.util.ArrayList;
import java.util.List;

public class Compu {

    private CPU cpu;
    private GPU gpu;
    private Madre madre;
    private List<RAM> rams = new ArrayList<>();
    private List<Disco> discos = new ArrayList<>();
    private Gabinete gab;
    private Fuente fuente;
    private double precioTotal;
    private List<Programa> programas = new ArrayList<>();

    public Compu() {

    }

    public double total() {
        double total = 0;
        if (cpu != null)
            total += cpu.getPrecio();
        if (gpu != null)
            total += gpu.getPrecio();
        if (madre != null)
            total += madre.getPrecio();
        if (fuente != null)
            total += fuente.getPrecio();
        if (gabinete != null)
            total += gab.getPrecio();
        for (RAM rar : rams)
            total += rar.getPrecio();
        for (Disco dis : discos)
            total += dis.getPrecio();
        for (Programa p : programas)
            total += p.getPrecio();
        return total;
    }

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
        memorias.add(ram);
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

    public CPU getCPU() {
        return cpu;
    }

    public GPU getGPU() {
        return gpu;
    }

    public Madre getMadre() {
        return madre;
    }

    public List<RAM> getDisco() {
        return memorias;
    }

    public List<Disco> getDiscos() {
        return discos;
    }

    public Fuente getFuente() {
        return fuente;
    }

    public Gabinete getGabinete() {
        return gab;
    }

    public List<Programa> getProgramas() {
        return programas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== Detalles de tu nueva PC =====\n");

        sb.append("CPU: ").append(cpu != null ? cpu.getNombre() : "No seleccionado");
        if (cpu != null && cpu.getAdaptado())
            sb.append(" [ADAPTADO]");
        sb.append("\n");

        sb.append("GPU: ").append(gpu != null ? gpu.getNombre() : "No seleccionado");
        if (gpu != null && gpu.getAdaptado())
            sb.append(" [ADAPTADO]");
        sb.append("\n");

        sb.append("Motherboard: ").append(madre != null ? madre.getNombre() : "No seleccionada");
        if (madre != null && madre.getAdaptado())
            sb.append(" [ADAPTADO]");
        sb.append("\n");

        sb.append("Fuente: ").append(fuente != null ? fuente.getNombre() : "No seleccionada");
        if (fuente != null && fuente.getAdaptado())
            sb.append(" [ADAPTADO]");
        sb.append("\n");

        sb.append("Gabinete: ").append(gab != null ? gab.getNombre() : "No seleccionado");
        if (gab != null && gab.getAdaptado())
            sb.append(" [ADAPTADO]");
        sb.append("\n");

        sb.append("\n--- Memorias RAM ---\n");
        if (rams.isEmpty()) {
            sb.append("Sin memorias\n");
        } else {
            for (RAM r : rams) {
                sb.append(r.getNombre());
                if (r.getAdaptado())
                    sb.append(" [ADAPTADO]");
                sb.append(" - $").append(r.getPrecio()).append("\n");
            }
        }

        sb.append("\n--- Discos duros ---\n");
        if (discos.isEmpty()) {
            sb.append("Sin discos\n");
        } else {
            for (Disco d : discos) {
                sb.append(d.getNombre());
                if (d.getAdaptado())
                    sb.append(" [ADAPTADO]");
                sb.append(" - $").append(d.getPrecio()).append("\n");
            }
        }

        sb.append("\n--- Programas instalados ---\n");
        if (programas.isEmpty()) {
            sb.append("Sin programas\n");
        } else {
            for (Programa p : programas) {
                sb.append(p.getNombre()).append(" - $").append(p.getPrecio()).append("\n");
            }
        }

        sb.append("\nTOTAL: $").append(total()).append("\n");

        return sb.toString();
    }

}
}
