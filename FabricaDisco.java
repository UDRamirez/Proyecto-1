import java.util.ArrayList;
import java.util.List;
/**
 * Clase {@code FabricaDisco}.
 * <p>
 * Implementa la interfaz {@link ContratoFabrica} y se encarga de crear instancias
 * de discos duros ({@link Disco}), tanto HDD como SSD, según el modelo especificado.
 * </p>
 */
public class FabricaDisco implements ContratoFabrica {

    /**
     * Crea un componente de tipo {@link Disco} según el modelo proporcionado.
     * <p>
     * La fábrica reconoce distintos modelos de discos HDD y SSD de marcas como
     * Western Digital, Seagate y Kingston. Si el modelo no coincide con ninguno,
     * se mostrará un mensaje indicando que no se encontró y se devolverá {@code null}.
     * </p>
     *
     * @param modelo el nombre exacto del modelo del disco a crear.
     * @return una instancia de {@link Disco} correspondiente al modelo,
     *         o {@code null} si el modelo no se encuentra.
     */
    @Override
    public Pieza crearComponente(String modelo) {
        switch (modelo) {
            // HDD
            case "Western Digital Blue 500-GB":
                return new Disco("Western Digital Blue 500-GB", "Western Digital Blue", 450, "HDD", 500);
            case "Western Digital Blue 1-TB":
                return new Disco("Western Digital Blue 1-TB", "Western Digital Blue", 600, "HDD", 1024);
            case "Seagate Barracuda 1-TB":
                return new Disco("Seagate Barracuda 1-TB", "Seagate Barracuda", 550, "HDD", 1024);
            case "Seagate Barracuda 2-TB":
                return new Disco("Seagate Barracuda 2-TB", "Seagate Barracuda", 800, "HDD", 2048);

            // SSD
            case "Kingston 500-GB":
                return new Disco("Kingston 500-GB", "Kingston", 500, "SSD", 500);
            case "Kingston 1-TB":
                return new Disco("Kingston 1-TB", "Kingston", 800, "SSD", 1024);
            case "Kingston 2-TB":
                return new Disco("Kingston 2-TB", "Kingston", 1600, "SSD", 2048);
            case "Kingston 4-TB":
                return new Disco("Kingston 4-TB", "Kingston", 3200, "SSD", 8096);

            default:
                System.out.println("No se ha encontrado ese modelo:  " + modelo);
                return null;
        }
    }

     /**
     * Devuelve una lista con todos los modelos de discos disponibles en la fábrica.
     *
     * @return lista de nombres de modelos de discos HDD y SSD.
     */
    @Override
    public List<String> getModelos() {
        List<String> modelos = new ArrayList<>();

        // HDD
        modelos.add("Western Digital Blue 500-GB");
        modelos.add("Western Digital Blue 1-TB");
        modelos.add("Seagate Barracuda 1-TB");
        modelos.add("Seagate Barracuda 2-TB");

        // SSD
        modelos.add("Kingston 500-GB");
        modelos.add("Kingston 1-TB");
        modelos.add("Kingston 2-TB");
        modelos.add("Kingston 4-TB");

        return modelos;
    }
}
}
