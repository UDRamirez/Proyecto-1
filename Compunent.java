import java.util.List;
/**
 * Interfaz {@code Compunent}.
 * <p>
 * Define el contrato que deben implementar todas las clases que representan
 * computadoras o sistemas ensamblados. Proporciona métodos para obtener
 * el precio total y una descripción detallada del hardware.
 * </p>
 */
public interface Compunent {

    /**
     * Devuelve el precio total del componente o sistema.
     *
     * @return el precio como valor {@code double}.
     */
    double getPrecio();

    /**
     * Devuelve una descripción completa del componente o sistema,
     * incluyendo información de los componentes internos.
     *
     * @return una cadena con la descripción del hardware.
     */
    String getDescripcion();

    List<Programa> getProgramas();
}
