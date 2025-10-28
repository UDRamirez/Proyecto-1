import java.util.ArrayList;
import java.util.List;
/**
 * Clase {@code FabricaFuente}.
 * <p>
 * Implementa la interfaz {@link ContratoFabrica} y se encarga de crear instancias
 * de fuentes de poder ({@link Fuente}) según el modelo especificado.
 * Soporta modelos de las marcas EVGA, Corsair y XPG.
 * </p>
 */
public class FabricaFuente implements ContratoFabrica {

    /**
     * Crea un componente de tipo {@link Fuente} según el modelo proporcionado.
     * <p>
     * Si el modelo no coincide con ninguno de los disponibles, se muestra un mensaje
     * indicando que no se encontró el modelo y se devuelve {@code null}.
     * </p>
     *
     * @param modelo el nombre exacto del modelo de fuente a crear.
     * @return una instancia de {@link Fuente} correspondiente al modelo,
     *         o {@code null} si el modelo no se encuentra.
     */
    @Override
    public Pieza crearComponente(String modelo) {
        switch (modelo) {

            case "EVGA 800-W":
                return new Fuente("EVGA 800-W", "EVGA", 2200, 800);
            case "EVGA 1000-W":
                return new Fuente("EVGA 1000-W", "EVGA", 3800, 1000);
            case "EVGA 1500-W":
                return new Fuente("EVGA 1500-W", "EVGA", 9500, 1500);
            case "Corsair 800-W":
                return new Fuente("Corsair 800-W", "Corsair", 2500, 800);
            case "Corsair 1200-W":
                return new Fuente("Corsair 1200-W", "Corsair", 5500, 1200);
            case "Corsair 1500-W":
                return new Fuente("Corsair 1500-W", "Corsair", 8000, 1500);
            case "XPG 500-W":
                return new Fuente("XPG 500-W", "Kingston", 1000, 500);
            case "XPG 700-W":
                return new Fuente("XPG 700-W", "Kingston", 1500, 700);
            case "XPG 1000-W":
                return new Fuente("XPG 1000-W", "Kingston", 3000, 1000);

            default:
                System.out.println("No se ha encontrado ese modelo:  " + modelo);
                return null;
        }
    }

    
    /**
     * Devuelve una lista con todos los modelos de fuentes de poder disponibles en la fábrica.
     *
     * @return lista de nombres de modelos de fuentes EVGA, Corsair y XPG.
     */
    @Override
    public List<String> getModelos() {
        List<String> modelos = new ArrayList<>();

        // EVGA
        modelos.add("EVGA 800-W");
        modelos.add("EVGA 1000-W");
        modelos.add("EVGA 1500-W");

        // Corsair
        modelos.add("Corsair 800-W");
        modelos.add("Corsair 1200-W");
        modelos.add("Corsair 1500-W");

        // XPG
        modelos.add("XPG 500-W");
        modelos.add("XPG 700-W");
        modelos.add("XPG 1000-W");

        return modelos;
    }
}
