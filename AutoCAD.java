/**
 * Clase {@code AutoCAD} que extiende {@link Programa}.
 * <p>
 * Representa una versión específica del software de diseño asistido por computadora AutoCAD.
 * Cada instancia incluye la versión del programa y su precio base.
 * </p>
 *
 * <h2>Descripción:</h2>
 * Esta clase forma parte del conjunto de decoradores de software que pueden añadirse
 * a una computadora ensamblada. Permite incorporar el programa AutoCAD como parte
 * del paquete de software de una PC.
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>{@code
 * Programa autocad = new AutoCAD();
 * pc = new PCDecorada(pc, autocad);
 * }</pre>
 *
 * @see Programa
 * @version 1.0
 */
public class AutoCAD extends Programa {

    /**
     * Constructor que crea una instancia de {@code AutoCAD} con valores predeterminados.
     * <p>
     * Establece el nombre del programa como "AutoCAD 2024" y su precio base en 250.0.
     * </p>
     */
    public AutoCAD() {
        super("AutoCAD 2024", 250.0);
    }
}

