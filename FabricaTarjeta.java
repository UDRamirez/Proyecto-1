import java.util.ArrayList;
import java.util.List;
/**
 * Clase {@code FabricaTarjeta}.
 * <p>
 * Implementa la interfaz {@link ContratoFabrica} y se encarga de crear
 * instancias de tarjetas gráficas ({@link GPU}) según el modelo especificado.
 * </p>
 *
 * <p>
 * Forma parte del patrón de diseño <b>Abstract Factory</b>, donde cada
 * fábrica concreta produce un tipo específico de componente de hardware.
 * </p>
 */
public class FabricaTarjeta implements ContratoFabrica {

    /**
     * Crea una instancia de {@link GPU} en función del modelo indicado.
     * <p>
     * Si el modelo no coincide con ninguno de los casos definidos, se muestra
     * un mensaje en consola y se devuelve {@code null}.
     * </p>
     *
     * @param modelo el nombre del modelo de tarjeta gráfica (por ejemplo: "GTX 1660", "RTX 4090").
     * @return una instancia de {@link GPU} correspondiente al modelo, o {@code null} si no se encuentra.
     */
    @Override
    public Pieza crearComponente(String modelo) {
        switch (modelo) {
            case "GTX 1660":
                return new GPU("GTX 1660", "NVIDIA", 3500);
            case "RTX 3060":
                return new GPU("RTX 3060", "NVIDIA", 6500);
            case "RTX 4070":
                return new GPU("RTX 4070", "NVIDIA", 13000);
            case "RTX 4080":
                return new GPU("RTX 4080", "NVIDIA", 25000);
            case "RTX 4090":
                return new GPU("RTX 4090", "NVIDIA", 40000);

            default:
                System.out.println("No se ha encontrado ese modelo: " + modelo);
                return null;
        }
    }

    public List<String> getModelos() {
    List<String> modelos = new ArrayList<>();
    modelos.add("GTX 1660");
    modelos.add("RTX 3060");
    modelos.add("RTX 4070");
    modelos.add("RTX 4080");
    modelos.add("RTX 4090");
    return modelos;
}
}
