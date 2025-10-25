/**
 * Clase {@code WSLTerminal}.
 * <p>
 * Representa el programa WSL Terminal (Linux) como un tipo de {@link Programa}.
 * </p>
 */
public class WSLTerminal extends Programa {

    /**
     * Crea una nueva instancia de {@code WSLTerminal}.
     *
     * @param dist   distribución de Linux (por ejemplo, "Ubuntu").
     * @param precio precio del programa.
     */
    public WSLTerminal(String dist, double precio) {
        super("WSL Terminal: Linux", 500.0);
    }
}
