/**
 * Clase {@code FabricaGabinete}.
 * <p>
 * Implementa la interfaz {@link ContratoFabrica} y se encarga de crear instancias
 * de gabinetes ({@link Gabinete}) según el modelo especificado.
 * Soporta modelos de distintas marcas como NZXT y Yeiyian.
 * </p>
 */
public class FabricaGabinete implements ContratoFabrica {

    /**
     * Crea un componente de tipo {@link Gabinete} según el modelo proporcionado.
     * <p>
     * Si el modelo no coincide con ninguno de los disponibles, se muestra un mensaje
     * indicando que no se encontró el modelo y se devuelve {@code null}.
     * </p>
     *
     * @param modelo el nombre exacto del modelo de gabinete a crear.
     * @return una instancia de {@link Gabinete} correspondiente al modelo,
     *         o {@code null} si el modelo no se encuentra.
     */
    @Override
    public Pieza crearComponente(String modelo) {
        switch (modelo) {
            case "H6 Flow ATX":
                return new Gabinete("H6 Flow ATX", "NZXT", 2800);
            case "Lancer ATX":
                return new Gabinete("Lancer ATX", "Yeiyian", 1500);

            default:
                System.out.println("No se ha encontrado ese modelo:  " + modelo);
                return null;
        }
    }
}
