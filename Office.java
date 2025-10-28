/**
 * Clase {@code Office}.
 * <p>
 * Representa el programa Microsoft Office como un tipo de {@link Programa}.
 * </p>
 */
public class Office extends Programa {

    /**
     * Crea una nueva instancia de {@code Office}.
     *
     * @param version versión del programa (por ejemplo, "2024").
     * @param precio  precio del programa.
     */
    public Office() {
        super("Microsoft Office 2024 ", 500.0);
    }
}
