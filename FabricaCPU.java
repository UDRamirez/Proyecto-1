import java.util.ArrayList;
import java.util.List;

/**
 * Clase {@code FabricaCPU}.
 * <p>
 * Implementa la interfaz {@link ContratoFabrica} y se encarga de crear instancias
 * de procesadores {@link CPU} específicos según el modelo solicitado.
 * Esta clase forma parte del patrón <b>Abstract Factory</b>, permitiendo
 * la creación de CPUs de distintas marcas (Intel o AMD) sin acoplar el código
 * a las clases concretas.
 * </p>
 */
public class FabricaCPU implements ContratoFabrica {

    /**
     * Crea un componente de tipo {@link CPU} según el modelo especificado.
     * <p>
     * Si el modelo no coincide con ninguno de los disponibles, se mostrará
     * un mensaje indicando que no se encontró el modelo y se devolverá {@code null}.
     * </p>
     *
     * @param modelo el nombre del modelo de CPU que se desea crear.
     * @return una instancia de {@link CPU} correspondiente al modelo,
     *         o {@code null} si no se encuentra el modelo.
     */
    @Override
    public Pieza crearComponente(String modelo) {
        switch (modelo.toLowerCase()) {
            //Intel
            case "core i3-13100":
                return new CPU("Core i3-13100", "Intel", 1500, 4);
            case "core i5-13600k":
                return new CPU("Core i5-13600K", "Intel", 3200, 6);
            case "core i7-13700k":
                return new CPU("Core i7-13700K", "Intel", 5800, 8);
            case "core i9-13900k":
                return new CPU("Core i9-13900K", "Intel", 9500, 16);

            //AMD
            case "ryzen 5 5600g":
                return new CPU("Ryzen 5 5600G", "AMD", 1500, 4);
            case "ryzen 5 7600x":
                return new CPU("Ryzen 5 7600X", "AMD", 3000, 6);
            case "ryzen 7 7700x":
                return new CPU("Ryzen 7 7700X", "AMD", 6000, 8);
            case "ryzen 9 7950x3d":
                return new CPU("Ryzen 9 7950X3D", "AMD", 9000, 16);

            default:
                System.out.println(" No se ha encontrado este modelo de CPU");
                return null;
        }
    }

    /**
     * Retorna la lista de modelos de CPU disponibles en esta fábrica.
     *
     * @return una lista con los nombres de los modelos de CPU.
     */
    @Override
    public List<String> getModelos() {
        List<String> modelos = new ArrayList<>();
        // Intel
        modelos.add("Core i3-13100");
        modelos.add("Core i5-13600K");
        modelos.add("Core i7-13700K");
        modelos.add("Core i9-13900K");
        // AMD
        modelos.add("Ryzen 5 5600G");
        modelos.add("Ryzen 5 7600X");
        modelos.add("Ryzen 7 7700X");
        modelos.add("Ryzen 9 7950X3D");
        return modelos;
    }
}
