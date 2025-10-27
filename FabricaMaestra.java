/**
 * Clase {@code FabricaMaestra}.
 * <p>
 * Esta clase actúa como una fábrica central (o fábrica abstracta) que devuelve
 * la fábrica concreta correspondiente según el tipo de componente solicitado.
 * </p>
 *
 * <p>
 * Implementa el patrón de diseño <b>Abstract Factory</b>, centralizando la creación
 * de las distintas fábricas de componentes de PC, como CPU, RAM, GPU, fuente, disco,
 * tarjeta madre y gabinete.
 * </p>
 */
public class FabricaMaestra {

    /**
     * Devuelve la fábrica concreta correspondiente al tipo de componente solicitado.
     * <p>
     * Si el tipo indicado no coincide con ninguna fábrica conocida, se devuelve {@code null}.
     * </p>
     *
     * @param fabrica el nombre del tipo de fábrica deseada (por ejemplo: "cpu", "ram", "gpu", etc.).
     * @return una instancia de la fábrica correspondiente que implementa {@link ContratoFabrica},
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
