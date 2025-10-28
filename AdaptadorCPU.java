/**
 * Clase {@code AdaptadorCPU} que implementa la interfaz {@code AdaptadorPieza}.
 * <p>
 * Esta clase actua como un adaptador para un objeto de tipo {@link CPU},
 * permitiendo verificar su compatibilidad con otras piezas del sistema,
 * en particular con una placa madre ({@link AdaptadorMadre}).
 * </p>
 */
public class AdaptadorCPU implements AdaptadorPieza {

    /**
     * Instancia del objeto {@link CPU} que representa la pieza adaptada.
     */
    private final CPU cpu;

    /**
     * Constructor que inicializa el adaptador con una CPU especifica.
     *
     * @param cpu la CPU que se va a adaptar.
     */
    public AdaptadorCPU(CPU cpu) {
        this.cpu = cpu;
    }

    /**
     * Verifica la compatibilidad de esta CPU con otra pieza adaptada.
     * <p>
     * En este caso, se comprueba si la CPU es compatible con una placa madre,
     * comparando la marca de la CPU con el tipo de chip de la placa madre.
     * </p>
     *
     * @param otra la otra pieza adaptada que se desea verificar.
     * @return {@code true} si ambas piezas son compatibles, {@code false} en caso contrario.
     */
    @Override
    public boolean esCompatibleCon(AdaptadorPieza otra) {
        if (otra instanceof AdaptadorMadre) {
            AdaptadorMadre madre = (AdaptadorMadre) otra;
            return cpu.getMarca().equalsIgnoreCase(madre.getMadre().getTipoChip());
        }
        return false;
    }

    /**
     * Obtiene el nombre o marca de la CPU.
     *
     * @return una cadena con el nombre de la CPU.
     */
    @Override
    public String getNombre() {
        return cpu.getMarca();
    }

    /**
     * Devuelve la instancia original de {@link CPU} asociada a este adaptador.
     *
     * @return el objeto {@link CPU} adaptado.
     */
    public CPU getCpu() {
        return cpu;
    }
}
