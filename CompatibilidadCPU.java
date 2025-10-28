import java.util.*;

/**
 * Clase {@code CompatibilidadCPU}.
 * <p>
 * Proporciona métodos para verificar la compatibilidad entre piezas de hardware
 * utilizando el patrón Adaptador. También permite obtener una lista de piezas
 * compatibles a partir de una pieza de referencia.
 * </p>
 *
 * <h2>Funcionamiento:</h2>
 * <ul>
 *   <li>{@link #esCompatible(AdaptadorPieza, AdaptadorPieza)}: Comprueba si dos piezas adaptadas son compatibles.</li>
 *   <li>{@link #getPiezasAlternativas(AdaptadorPieza, List)}: Filtra una lista de piezas candidatas, devolviendo solo las compatibles con la pieza de referencia.</li>
 * </ul>
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>{@code
 * AdaptadorCPU cpu = new AdaptadorCPU(new CPU("Ryzen 5 5600X", "AMD", 250.0, 6));
 * AdaptadorMadre madre = new AdaptadorMadre(new Madre("Asus B550", "AMD", 150.0, "AMD"));
 * CompatibilidadCPU compat = new CompatibilidadCPU();
 * boolean compatible = compat.esCompatible(cpu, madre);
 * }</pre>
 *
 * @see AdaptadorPieza
 * @version 1.0
 */
public class CompatibilidadCPU {

    /**
     * Verifica si dos piezas adaptadas son compatibles entre sí.
     *
     * @param a la primera pieza adaptada.
     * @param b la segunda pieza adaptada.
     * @return {@code true} si las piezas son compatibles, {@code false} en caso contrario.
     */
    public boolean esCompatible(AdaptadorPieza a, AdaptadorPieza b) {
        return a.esCompatibleCon(b);
    }

    /**
     * Devuelve una lista de piezas compatibles con una pieza de referencia.
     * <p>
     * Este método evalúa una lista de posibles alternativas y filtra aquellas
     * que son compatibles con la pieza de referencia proporcionada.
     * </p>
     *
     * @param <T> el tipo genérico que extiende {@link AdaptadorPieza}.
     * @param referencia la pieza base con la que se evaluará la compatibilidad.
     * @param alternativas la lista de piezas candidatas.
     * @return una lista de piezas compatibles con la pieza de referencia.
     */
    public <T extends AdaptadorPieza> List<T> getPiezasAlternativas(AdaptadorPieza referencia, List<T> alternativas) {
        List<T> compatibles = new ArrayList<>();
        for (T pieza : alternativas) {
            if (esCompatible(referencia, pieza)) {
                compatibles.add(pieza);
            }
        }
        return compatibles;
    }
}
