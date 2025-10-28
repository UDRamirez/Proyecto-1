/**
 * Clase {@code AutoCAD} que extiende {@link Programa}.
 * <p>
 * Representa una versión específica del software de diseño asistido por computadora AutoCAD.
 * Cada instancia incluye la versión del programa y su precio.
 * </p>
 */
public class AutoCAD extends Programa {

    /**
     * Constructor que crea una instancia de {@code AutoCAD} con la versión y precio especificados.
     *
     * @param version la versión del software AutoCAD (por ejemplo, "2024").
     * @param precio el precio del programa.
     */

    public AutoCAD() {
        super("AutoCAD 2024 ", 250.0);

    }

}
