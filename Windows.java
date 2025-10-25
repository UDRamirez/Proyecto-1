/**
 * Clase {@code Windows}.
 * <p>
 * Representa el sistema operativo Windows como un tipo de {@link Programa}.
 * </p>
 */
public class Windows extends Programa {

    /**
     * Crea una nueva instancia de {@code Windows}.
     *
     * @param version versión del sistema operativo (por ejemplo, "10").
     * @param precio  precio del sistema operativo.
     */
    public Windows(String version, double precio) {
        super("Windows 10", 500.0);
    }
}
