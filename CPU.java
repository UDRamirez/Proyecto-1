/**
 * Clase {@code CPU} que extiende {@link Pieza}.
 * <p>
 * Representa un procesador (unidad central de procesamiento) de una computadora.
 * Incluye información sobre su nombre, marca, precio y número de núcleos.
 * </p>
 */
public class CPU extends Pieza {

    /**
     * Número de núcleos del procesador.
     */
    private int nucleos;

    /**
     * Constructor que inicializa una nueva instancia de {@code CPU} con los datos especificados.
     *
     * @param nombre el nombre o modelo del procesador.
     * @param marca la marca del procesador (por ejemplo, "Intel" o "AMD").
     * @param precio el precio del procesador.
     * @param nucleos el número de núcleos del procesador.
     */
    public CPU(String nombre, String marca, double precio, int nucleos) {
        super(nombre, marca, precio, "CPU");
        this.nucleos = nucleos;
    }

    /**
     * Devuelve el número de núcleos del procesador.
     *
     * @return el número de núcleos.
     */
    public int getNucleos() { 
        return nucleos;
    }

    /**
     * Devuelve una representación en cadena del procesador, incluyendo
     * su información base y el número de núcleos.
     *
     * @return una cadena con la descripción del procesador.
     */
    @Override
    public String toString() {
        return super.toString() + " | Núcleos: " + nucleos;
    }
}
