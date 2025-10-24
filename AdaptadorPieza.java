/**
 * Interfaz {@code AdaptadorPieza}.
 * <p>
 * Define el contrato que deben seguir todas las clases adaptadoras de piezas de hardware.
 * Los adaptadores permiten verificar la compatibilidad entre diferentes componentes
 * y obtener información básica sobre ellos (como su nombre o tipo).
 * </p>
 */
public interface AdaptadorPieza {

    /**
     * Verifica si esta pieza es compatible con otra pieza adaptada.
     *
     * @param otra la otra pieza adaptada con la que se desea comprobar la compatibilidad.
     * @return {@code true} si ambas piezas son compatibles, {@code false} en caso contrario.
     */
    boolean esCompatibleCon(AdaptadorPieza otra);

    /**
     * Obtiene el nombre o identificador principal de la pieza adaptada.
     *
     * @return una cadena con el nombre de la pieza.
     */
    String getNombre();
}
