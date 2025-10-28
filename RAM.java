/**
 * Clase {@code RAM}.
 * <p>
 * Representa un modulo de memoria RAM de computadora.
 * Hereda de {@link Pieza} e incluye informacion sobre su capacidad en GB.
 * </p>
 * <p>
 * Permite obtener su capacidad y mostrar la informacion completa del modulo.
 * </p>
 */
public class RAM extends Pieza {

    /** Capacidad de la memoria RAM en gigabytes (GB). */
    private int memoria;

    /**
     * Crea una nueva instancia de {@code RAM}.
     *
     * @param nombre nombre del modulo RAM.
     * @param marca marca del fabricante.
     * @param precio precio del modulo.
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
     * Devuelve una representacion en texto de la memoria RAM,
     * incluyendo su capacidad.
     *
     * @return cadena con la informacion detallada del modulo RAM.
     */
    @Override
    public String toString() {
        return super.toString() + " | Capacidad: " + memoria + " GB";
    }
}
