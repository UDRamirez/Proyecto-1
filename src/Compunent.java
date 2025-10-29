import java.util.List;

/**
 * Interfaz {@code Compunent}.
 * <p>
 * Define el contrato que deben implementar todas las clases que representen
 * una computadora o componente ensamblado completo.
 * Proporciona metodos para obtener el precio, la descripcion y la lista de programas
 * instalados, asi como la descripcion base del hardware.
 * </p>
 *
 * <h2>Implementaciones:</h2>
 * <ul>
 *   <li>{@link Compu}: representa una computadora ensamblada con todos sus componentes.</li>
 *   <li>{@link PCDecorada}: representa una computadora decorada con programas adicionales.</li>
 * </ul>
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>{@code
 * Compu pc = new Compu();
 * double precioTotal = pc.getPrecio();
 * String descripcion = pc.getDescripcion();
 * List<Programa> programas = pc.getProgramas();
 * }</pre>
 *
 * @see Compu
 * @see Programa
 */
public interface Compunent {

    /**
     * Obtiene el precio total del componente o computadora.
     *
     * @return el precio total.
     */
    double getPrecio();

    /**
     * Obtiene la descripcion completa de la computadora,
     * incluyendo componentes y programas instalados.
     *
     * @return la descripcion completa.
     */
    String getDescripcion();

    /**
     * Obtiene la lista de programas instalados en la computadora.
     *
     * @return lista de {@link Programa} instalados.
     */
    List<Programa> getProgramas();

    /**
     * Obtiene la descripcion base del hardware instalado,
     * sin incluir los programas instalados.
     *
     * @return la descripcion base de la computadora.
     */
    String getDescripcionBase();
}
