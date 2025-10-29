/**
 * Clase {@code Fuente}.
 * <p>
 * Representa una fuente de poder para una computadora.
 * Hereda de {@link Pieza} e incluye informacion especifica como la potencia en vatios (W).
 * </p>
 */
public class Fuente extends Pieza {

    /** Potencia de la fuente en vatios (W). */
    private int potencia;

    /**
     * Crea una nueva instancia de {@code Fuente}.
     *
     * @param nombre nombre de la fuente.
     * @param marca marca del fabricante.
     * @param precio precio de la fuente.
     * @param potencia potencia de la fuente en vatios (W).
     */
    public Fuente(String nombre, String marca, double precio, int potencia) {
        super(nombre, marca, precio, "Fuente");
        this.potencia = potencia;
    }

    /**
     * Obtiene la potencia de la fuente.
     *
     * @return la potencia en vatios (W).
     */
    public int getPotencia() {
        return potencia;
    }

    /**
     * Devuelve una representacion en texto de la fuente,
     * incluyendo su potencia.
     *
     * @return una cadena con la informaci0n detallada de la fuente.
     */
    @Override
    public String toString() {
        return super.toString() + " | Potencia: " + potencia + " W";
    }
}
