import java.util.ArrayList;
import java.util.List;

public class PCDecorada implements Compunent {

    private Compunent compu;
    private Programa programa;
    private List<String> instalados;

    public PCDecorada(Compunent compu, Programa programa) {
        this.compu = compu;
        this.programa = programa;
        this.instalados = new ArrayList<>();

        if (compu instanceof PCDecorada) {
            this.instalados.addAll(((PCDecorada) compu).getProgramas());
        }

        if (!instalados.contains(programa.getNombre())) {
            this.instalados.add(programa.getNombre());
        } else {
            System.out.println("Advertencia: El programa '" + programa.getNombre() + "' ya está instalado y no se agregará nuevamente.");
        }
    }

    public List<String> getProgramas() {
        return instalados;
    }

    public boolean tienePrograma(String nombre) {
        return instalados.contains(nombre);
    }

    @Override
    public double getPrecio() {
        return compu.getPrecio() + (instalados.contains(programa.getNombre()) ? programa.getPrecio() : 0);
    }

    @Override
    public String getDescripcion() {
        String desc = compu.getDescripcion();

        if (instalados.contains(programa.getNombre())) {
            desc += "\nPrograma agregado: " + programa.getNombre();
        }

        return desc;
    }
}
