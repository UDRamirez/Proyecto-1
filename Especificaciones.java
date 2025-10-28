import java.io.Serializable;
import java.util.List;

/**
 * Clase {@code Especificaciones} que implementa {@link Serializable}.
 * <p>
 * Representa la configuración completa de una computadora,
 * incluyendo CPU, GPU, RAM, disco, placa madre, fuente, gabinete
 * y una lista de programas instalados.
 * </p>
 */
public class Especificaciones implements Serializable {

    /** Nombre o modelo de la CPU seleccionada. */
    public String cpu;

    /** Nombre o modelo de la GPU seleccionada. */
    public String gpu;

    /** Nombre o modelo de la memoria RAM seleccionada. */
    public String ram;

    /** Nombre o modelo del disco seleccionado. */
    public String disco;

    /** Nombre o modelo de la placa madre seleccionada. */
    public String madre;

    /** Nombre o modelo de la fuente de poder seleccionada. */
    public String fuente;

    /** Nombre o modelo del gabinete seleccionado. */
    public String gabinete;

    /** Lista de programas instalados en la computadora. */
    public List<Programa> programas;

    /**
     * Constructor que inicializa una nueva instancia de {@code Especificaciones}
     * con todos los componentes y programas proporcionados.
     *
     * @param cpu CPU seleccionada.
     * @param gpu GPU seleccionada.
     * @param ram Memoria RAM seleccionada.
     * @param disco Disco seleccionado.
     * @param madre Placa madre seleccionada.
     * @param fuente Fuente de poder seleccionada.
     * @param gabinete Gabinete seleccionado.
     * @param programas Lista de programas instalados.
     */
    public Especificaciones(String cpu, String gpu, String ram, String disco,
                            String madre, String fuente, String gabinete, List<Programa> programas) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.disco = disco;
        this.madre = madre;
        this.fuente = fuente;
        this.gabinete = gabinete;
        this.programas = programas;
    }
}
