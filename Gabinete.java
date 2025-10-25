/**
 * Clase {@code Gabinete}.
 * <p>
 * Representa un gabinete para computadora.
 * Hereda de {@link Pieza} y no añade atributos adicionales,
 * pero permite diferenciarlo como un tipo específico de componente.
 * </p>
 */
public class Gabinete extends Pieza {

    /**
     * Crea una nueva instancia de {@code Gabinete}.
     *
     * @param nombre nombre del gabinete.
     * @param marca marca del fabricante.
     * @param precio precio del gabinete.
     */
    public Gabinete(String nombre, String marca, double precio) {
        super(nombre, marca, precio, "Gabinete");
    }

    /**
     * Devuelve una representación en texto del gabinete.
     *
     * @return una cadena con la información detallada del gabinete.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
