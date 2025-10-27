import java.util.ArrayList;
import java.util.List;

public class PCDecorada implements Compunent {

    private Compunent compu;
    private List<Programa> instalados;

    public PCDecorada(Compunent compu, Programa programa) {
        this.compu = compu;
        this.instalados = new ArrayList<>();

        // Si el componente ya es una PCDecorada, copia sus programas instalados
        if (compu instanceof PCDecorada) {
            this.instalados.addAll(((PCDecorada) compu).getProgramas());
        }

        // Evita duplicados
        if (!tienePrograma(programa.getNombre())) {
            this.instalados.add(programa);
        } else {
            System.out.println("Advertencia: El programa '" + programa.getNombre() + "' ya está instalado y no se agregará nuevamente.");
        }
    }

    public List<Programa> getProgramas() {
        return instalados;
    }

    public boolean tienePrograma(String nombre) {
        for (Programa p : instalados) {
            if (p.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double getPrecio() {
        double precioTotal = compu.getPrecio();
        for (Programa p : instalados) {
            precioTotal += p.getPrecio();
        }
        return precioTotal;
    }

    @Override
    public String getDescripcion() {
        StringBuilder desc = new StringBuilder(compu.getDescripcion());
        desc.append("\n\nProgramas instalados:");
        for (Programa p : instalados) {
            desc.append("\n + ").append(p.getNombre());
        }
        desc.append("\nPrecio total: $").append(getPrecio());
        return desc.toString();
    }
}
