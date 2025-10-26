/**
 * Interfaz {@code ContratoFabrica}.
 * <p>
 * Define el contrato para una fábrica de componentes de computadora,
 * permitiendo la creación de instancias de {@link Pieza} a partir de un modelo especificado.
 * </p>
 */
public interface ContratoFabrica {

    /**
     * Crea un componente de hardware de tipo {@link Pieza} según el modelo proporcionado.
     *
     * @param modelo el nombre o modelo del componente a crear.
     * @return una instancia de {@link Pieza} correspondiente al modelo.
     */
    Pieza crearComponente(String modelo);
    
  /**
     * Devuelve la lista de modelos disponibles de esta fábrica.
     *
     * @return lista de nombres de modelos.
     */
    List<String> getModelosDisponibles();
}
