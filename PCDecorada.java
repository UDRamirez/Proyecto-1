import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Clase {@code PCDecorada}.
 * <p>
 * Implementa el patrón <b>Decorator</b> para añadir programas adicionales
 * a una computadora ya ensamblada sin modificar su estructura base.
 * Cada programa instalado aumenta el precio total y se agrega a la lista
 * de software de la computadora.
 * </p>
 */
public class PCDecorada implements Compunent, Serializable {

    /** Computadora base sobre la que se instala el programa. */
    public Compunent compu;

    /** Lista de programas instalados (incluye los anteriores del objeto decorado). */
    private List<Programa> instalados;

    /**
     * Crea una computadora decorada con un nuevo programa.
     *
     * @param compu     la computadora base o decorada previamente
     * @param programa  el programa que se desea instalar
     */
    public PCDecorada(Compunent compu, Programa programa) {
        this.compu = compu;
        this.instalados = new ArrayList<>();

        // Agregar los programas previos del componente base
        if (compu.getProgramas() != null) {
            this.instalados.addAll(compu.getProgramas());
        }

        // Instalar solo si no está repetido
        if (!tienePrograma(programa.getNombre())) {
            this.instalados.add(programa);
        } else {
            System.out.println("⚠ Advertencia: El programa '" + programa.getNombre() + "' ya está instalado y no se agregará nuevamente.");
        }
    }

    /** Obtiene la lista completa de programas instalados. */
    @Override
    public List<Programa> getProgramas() {
        return instalados;
    }

    /** Verifica si el programa ya está instalado. */
    public boolean tienePrograma(String nombre) {
        return instalados.stream().anyMatch(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    /** Calcula el precio total de la PC decorada (hardware + software). */
    @Override
    public double getPrecio() {
        double total = compu.getPrecio();
        for (Programa p : instalados) total += p.getPrecio();
        return total;
    }

    /** Devuelve la descripción detallada con los programas añadidos. */
    @Override
    public String getDescripcion() {
        StringBuilder sb = new StringBuilder(compu.getDescripcionBase());
        sb.append("\nProgramas instalados:");
        if (instalados.isEmpty()) {
            sb.append(" Sin programas");
        } else {
            for (Programa p : instalados) {
                sb.append("\n + ").append(p.getNombre());
            }
        }
        sb.append("\nPrecio total: $").append(getPrecio());
        return sb.toString();
    }

    /** Devuelve la descripción base del hardware sin incluir programas. */
    @Override
    public String getDescripcionBase() {
        return compu.getDescripcionBase();
    }
}
