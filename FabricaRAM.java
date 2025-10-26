/**
 * Clase {@code FabricaRAM}.
 * <p>
 * Implementa la interfaz {@link ContratoFabrica} y se encarga de crear
 * instancias de la clase {@link RAM} según el modelo especificado.
 * </p>
 *
 * <p>
 * Esta clase forma parte del patrón de diseño <b>Abstract Factory</b>, 
 * donde cada fábrica concreta crea un tipo específico de componente 
 * para ensamblar una computadora.
 * </p>
 */
public class FabricaRAM implements ContratoFabrica {

    /**
     * Crea una instancia de {@link RAM} en función del modelo indicado.
     * <p>
     * Si el modelo no coincide con ninguno de los casos definidos,
     * se muestra un mensaje en consola y se devuelve {@code null}.
     * </p>
     *
     * @param modelo el nombre del modelo de memoria RAM (por ejemplo: "Adata 8-GB", "Kingston 16-GB").
     * @return una instancia de {@link RAM} correspondiente al modelo, o {@code null} si no se encuentra.
     */
    @Override
    public Pieza crearComponente(String modelo) {
        switch (modelo) {
            case "Adata 8-GB":
                return new RAM("Adata 8-GB", "Adata", 500, 8);
            case "Adata 16-GB":
                return new RAM("Adata 16-GB", "Adata", 1000, 16);
            case "Adata 32-GB":
                return new RAM("Adata 32-GB", "Adata", 1500, 32);
            case "Kingston 8-GB":
                return new RAM("Kingston 8-GB", "Kingston", 550, 8);
            case "Kingston 16-GB":
                return new RAM("Kingston 16-GB", "Kingston", 1300, 16);
            case "Kingston 32-GB":
                return new RAM("Kingston 32-GB", "Kingston", 2000, 32);
            default:
                System.out.println("No se ha encontrado ese modelo: " + modelo);
                return null;
        }
    }

    public List<String> getModelos() {
    List<String> modelos = new ArrayList<>();
    modelos.add("Adata 8-GB");
    modelos.add("Adata 16-GB");
    modelos.add("Adata 32-GB");
    modelos.add("Kingston 8-GB");
    modelos.add("Kingston 16-GB");
    modelos.add("Kingston 32-GB");
    return modelos;
}
    
}
