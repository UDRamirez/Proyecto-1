/**
 * Clase {@code RAM}.
 * <p>
 * Representa un módulo de memoria RAM de computadora.
 * Hereda de {@link Pieza} e incluye información sobre su capacidad en GB.
 * </p>
 */
public class RAM extends Pieza {

    /** Capacidad de la memoria RAM en gigabytes (GB). */
    private int memoria;

    /**
     * Crea una nueva instancia de {@code RAM}.
     *
     * @param nombre nombre del módulo RAM.
     * @param marca  marca del fabricante.
     * @param precio precio del módulo.
     * @param memoria capacidad de la memoria en GB.
     */
    public RAM(String nombre, String marca, double precio, int memoria) {
        super(nombre, marca, precio, "RAM");
        this.memoria = memoria;
    }

    /**
     * Obtiene la capacidad de la memoria RAM.
     *
     * @return la capacidad en GB.
     */
    public int getMemoria() {
        return memoria;
    }

    /**
     * Devuelve una representación en texto de la memoria RAM,
     * incluyendo su capacidad.
     *
     * @return una cadena con la información detallada de la RAM.
     */
    @Override
    public String toString() {
        return super.toString() + " | Capacidad: " + memoria + " GB";
    }
}
