/**
 * Clase {@code FabricaMaestra}.
 * <p>
 * Esta clase actua como una fabrica central (o fabrica abstracta) que devuelve
 * la fabrica concreta correspondiente segun el tipo de componente solicitado.
 * </p>
 *
 * <p>
 * Implementa el patron de diseño <b>Abstract Factory</b>, centralizando la creacion
 * de las distintas fabricas de componentes de PC, como CPU, RAM, GPU, fuente, disco,
 * tarjeta madre y gabinete.
 * </p>
 */
public class FabricaMaestra {

    /**
     * Devuelve la fabrica concreta correspondiente al tipo de componente solicitado.
     * <p>
     * Si el tipo indicado no coincide con ninguna fabrica conocida, se devuelve {@code null}.
     * </p>
     *
     * @param fabrica el nombre del tipo de fabrica deseada (por ejemplo: "cpu", "ram", "gpu", etc.).
     * @return una instancia de la fabrica correspondiente que implementa {@link ContratoFabrica},
     *         o {@code null} si no se encuentra una coincidencia.
     */
    public static ContratoFabrica getFabrica(String fabrica) {
        switch (fabrica.toLowerCase()) {
            case "cpu": return new FabricaCPU();
            case "ram": return new FabricaRAM();
            case "gpu": return new FabricaTarjeta();
            case "fuente": return new FabricaFuente();
            case "disco": return new FabricaDisco();
            case "madre": return new FabricaMadre();
            case "gabinete": return new FabricaGabinete();
            default: return null;
        }
    }

}
