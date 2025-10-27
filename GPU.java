/**
 * Clase {@code GPU}.
 * <p>
 * Representa una tarjeta gráfica (GPU) para una computadora.
 * Hereda de {@link Pieza} e incluye información específica como el tipo de memoria de la GPU.
 * </p>
 */
public class GPU extends Pieza {

    /** Tipo de memoria de la GPU (por ejemplo, GDDR6). */
    private String tipomem;

    /**
     * Crea una nueva instancia de {@code GPU}.
     *
     * @param nombre nombre de la GPU.
     * @param marca marca del fabricante.
     * @param precio precio de la GPU.
     */
    public GPU(String nombre, String marca, double precio) {
        super(nombre, marca, precio, "GPU");
        this.tipomem = tipomem;
    }

    /**
     * Obtiene el tipo de memoria de la GPU.
     *
     * @return el tipo de memoria.
     */
    public String getTipoMem() {
        return tipomem;
    }

    /**
     * Devuelve una representación en texto de la GPU,
     * incluyendo su tipo de memoria.
     *
     * @return una cadena con la información detallada de la GPU.
     */
    @Override
    public String toString() {
        return super.toString() + " | Memoria GPU: " + tipomem;
    }
}
