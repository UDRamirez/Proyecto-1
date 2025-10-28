import java.util.List;

/**
 * Interfaz {@code ContratoFabrica}.
 * <p>
 * Define el contrato para una fabrica de componentes de computadora,
 * permitiendo la creacion de instancias de {@link Pieza} a partir de un modelo especificado.
 * </p>
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>{@code
 * ContratoFabrica fabCPU = FabricaMaestra.getFabrica("cpu");
 * Pieza cpu = fabCPU.crearComponente("Ryzen 5");
 * List<String> modelos = fabCPU.getModelos();
 * }</pre>
 *
 * @see Pieza
 */
public interface ContratoFabrica {

    /**
     * Crea un componente de hardware de tipo {@link Pieza} segun el modelo proporcionado.
     *
     * @param modelo el nombre o modelo del componente a crear.
     * @return una instancia de {@link Pieza} correspondiente al modelo.
     */
    Pieza crearComponente(String modelo);

    /**
     * Devuelve la lista de modelos disponibles de esta fabrica.
     *
     * @return lista de nombres de modelos.
     */
    List<String> getModelos();
}
