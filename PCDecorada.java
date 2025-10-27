import java.util.ArrayList;
import java.util.List;

public class PCDecorada implements Compunent {

    private Compunent compu;
    private List<Programa> instalados;

    public PCDecorada(Compunent compu, Programa programa) {
        this.compu = compu;
        this.instalados = new ArrayList<>();

        if (compu.getProgramas() != null) {
            this.instalados.addAll(compu.getProgramas());
        }

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
            if (p.getNombre().equals(nombre)) return true;
        }
        return false;
    }

    @Override
    public double getPrecio() {
        double total = compu.getPrecio();
        for (Programa p : instalados) total += p.getPrecio();
        return total;
    }

    @Override
    public String getDescripcion() {
        StringBuilder sb = new StringBuilder(compu.getDescripcionBase());

        sb.append("\nProgramas instalados:");
        if (instalados.isEmpty()) sb.append(" Sin programas");
        else {
            for (Programa p : instalados) {
                sb.append("\n + ").append(p.getNombre());
            }
        }

        sb.append("\nPrecio total: $").append(getPrecio());
        return sb.toString();
    }

    @Override
    public String getDescripcionBase() {
        return compu.getDescripcionBase();
    }
}
