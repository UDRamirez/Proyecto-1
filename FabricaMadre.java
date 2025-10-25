/**
 * Clase {@code FabricaMadre}.
 * <p>
 * Implementa la interfaz {@link ContratoFabrica} y se encarga de crear instancias
 * de placas madre ({@link Madre}) según el modelo especificado.
 * Soporta modelos de distintas marcas como ASUS y MSI, con diversos chipsets Intel.
 * </p>
 */
public class FabricaMadre implements ContratoFabrica {

    /**
     * Crea un componente de tipo {@link Madre} según el modelo proporcionado.
     * <p>
     * Si el modelo no coincide con ninguno de los disponibles, se muestra un mensaje
     * indicando que no se encontró el modelo y se devuelve {@code null}.
     * </p>
     *
     * @param modelo el nombre exacto del modelo de placa madre a crear.
     * @return una instancia de {@link Madre} correspondiente al modelo,
     *         o {@code null} si el modelo no se encuentra.
     */
    @Override
    public Pieza crearComponente(String modelo) {
        switch (modelo) {
            case "ROG Maximus Z790 Hero":
                return new Madre("ROG Maximus Z790 Hero", "ASUS", 14000, "Chipset Intel Z790");
            case "TUF Gaming B760-Plus":
                return new Madre("TUF Gaming B760-Plus", "ASUS", 3800, "Chipset Intel B760");
            case "MEG Z790 Godlike":
                return new Madre("MEG Z790 Godlike", "MSI", 25000, "Chipset Intel Z790");
            case "MAG B760 Tomahawk":
                return new Madre("MAG B760 Tomahawk", "MSI", 4200, "Chipset Intel B760");

            default:
                System.out.println("No se ha encontrado ese modelo:  " + modelo);
                return null;
        }
    }
}
