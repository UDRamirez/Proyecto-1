import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Pieza> componentes;

    public Inventario() {
        this.componentes = new ArrayList<>();
    }

    public void agregarComponente(Pieza componente) {
        componentes.add(componente);
    }

    public List<Pieza> getComponentes() {
        return new ArrayList<>(componentes);
    }

    public List<CPU> getCPUs() {
        List<CPU> cpus = new ArrayList<>();
        for (Pieza componente : componentes) {
            if (componente instanceof CPU) {
                cpus.add((CPU) componente);
            }
        }
        return cpus;
    }

    public List<GPU> getGPUs() {
        List<GPU> gpus = new ArrayList<>();
        for (Pieza componente : componentes) {
            if (componente instanceof GPU) {
                gpus.add((GPU) componente);
            }
        }
        return gpus;
    }

    public List<Madre> getMothers() {
        List<Madre> mothers = new ArrayList<>();
        for (Pieza componente : componentes) {
            if (componente instanceof Madre) {
                mothers.add((Madre) componente);
            }
        }
        return mothers;
    }

    public List<RAM> getRAMs() {
        List<RAM> rams = new ArrayList<>();
        for (Pieza componente : componentes) {
            if (componente instanceof RAM) {
                rams.add((RAM) componente);
            }
        }
        return rams;
    }

    public void mostrarComponentes() {
        System.out.println("\nINVENTARIO (" + componentes.size() + " componentes):");
        for (Pieza componente : componentes) {
            System.out.println(" - " + componente.getNombre() + " | $" + componente.getPrecio());
        }
    }
}