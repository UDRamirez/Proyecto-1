/**
 * Clase {@code AdaptadorMadre} que implementa la interfaz {@link AdaptadorPieza}.
 * <p>
 * Esta clase actúa como un adaptador para una pieza de tipo {@link Madre},
 * permitiendo verificar su compatibilidad con otras piezas del sistema,
 * como un procesador ({@link AdaptadorCPU}).
 * </p>
 */
public class AdaptadorMadre implements AdaptadorPieza {

    /**
     * Instancia de la placa madre que representa la pieza adaptada.
     */
    private final Madre madre;

    /**
     * Constructor que inicializa el adaptador con una placa madre específica.
     *
     * @param madre la placa madre que se va a adaptar.
     */
    public AdaptadorMadre(Madre madre) {
        this.madre = madre;
    }

    /**
     * Verifica la compatibilidad de esta placa madre con otra pieza adaptada.
     * <p>
     * En este caso, comprueba si la placa madre es compatible con una CPU,
     * comparando el tipo de chip de la placa con la marca del procesador.
     * </p>
     *
     * @param otra otra pieza adaptada a verificar.
     * @return {@code true} si ambas piezas son compatibles, {@code false} en caso contrario.
     */
    @Override
    public boolean esCompatibleCon(AdaptadorPieza otra) {
        if (otra instanceof AdaptadorCPU) {
            AdaptadorCPU cpu = (AdaptadorCPU) otra;
            return madre.getTipoChip().equalsIgnoreCase(cpu.getCpu().getMarca());
        }
        return false;
    }

    /**
     * Obtiene el nombre o tipo de chip de la placa madre.
     *
     * @return una cadena con el tipo de chip de la placa madre.
     */
    @Override
    public String getNombre() {
        return madre.getTipoChip();
    }

    /**
     * Devuelve la instancia original de {@link Madre} asociada a este adaptador.
     *
     * @return el objeto {@link Madre} adaptado.
     */
    public Madre getMadre() {
        return madre;
    }

}
