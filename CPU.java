/**
 * Clase {@code CPU} que extiende {@link Pieza}.
 * <p>
 * Representa un procesador (Unidad Central de Procesamiento) de una computadora.
 * Incluye información sobre su nombre, marca, precio y número de nucleos.
 * </p>
 *
 * <h2>Descripción:</h2>
 * Esta clase forma parte de los componentes de hardware que pueden agregarse
 * a una computadora. Permite definir la informacion basica de un procesador,
 * incluyendo su compatibilidad dentro del sistema.
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>{@code
 * CPU miCPU = new CPU("Ryzen 5 5600X", "AMD", 250.0, 6);
 * System.out.println(miCPU);
 * }</pre>
 *
 * @see Pieza
 * @version 1.0
 */
public class CPU extends Pieza {

    /**
     * Numero de nucleos del procesador.
     */
    private int nucleos;

    /**
     * Constructor que inicializa una nueva instancia de {@code CPU} con los datos especificados.
     *
     * @param nombre el nombre o modelo del procesador.
     * @param marca la marca del procesador (por ejemplo, "Intel" o "AMD").
     * @param precio el precio del procesador.
     * @param nucleos el numero de nucleos del procesador.
     */
    public CPU(String nombre, String marca, double precio, int nucleos) {
        super(nombre, marca, precio, "CPU");
        this.nucleos = nucleos;
    }

    /**
     * Devuelve el numero de nucleos del procesador.
     *
     * @return el numero de nucleos.
     */
    public int getNucleos() { 
        return nucleos;
    }

    /**
     * Devuelve una representacion en cadena del procesador, incluyendo
     * su informacion base y el numero de nucleos.
     *
     * @return una cadena con la descripcion del procesador.
     */
    @Override
    public String toString() {
        return super.toString() + " | Nucleos: " + nucleos;
    }
}
