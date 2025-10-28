import java.util.*;

/**
 * Interfaz {@code Sucursal}.
 * <p>
 * Define los metodos que una sucursal de computadoras debe implementar
 * para construir computadoras prediseñadas o personalizadas y distribuirlas.
 * </p>
 */
public interface Sucursal {

    /**
     * Construye una computadora economica prediseñada.
     *
     * @return una instancia de {@link Compunent} que representa la PC economica.
     */
    Compunent construirPcEco();

    /**
     * Construye una computadora premium prediseñada.
     *
     * @return una instancia de {@link Compunent} que representa la PC premium.
     */
    Compunent construirPcPrem();

    /**
     * Construye una computadora personalizada segun los componentes especificados.
     *
     * @param cpu      nombre del modelo de CPU.
     * @param gpu      nombre del modelo de GPU.
     * @param ram      nombre del modelo de RAM.
     * @param disco    nombre del modelo de disco.
     * @param madre    nombre del modelo de placa madre.
     * @param fuente   nombre del modelo de fuente de poder.
     * @param gabinete nombre del modelo de gabinete.
     * @param programa lista de programas a instalar.
     * @return una instancia de {@link Compunent} que representa la PC personalizada.
     */
    Compunent construirPcPerso(String cpu, String gpu, String ram, String disco,
                               String madre, String fuente, String gabinete, List<Programa> programa);

    /**
     * Distribuye la computadora construida a otra sucursal.
     *
     * @param pc       la computadora a distribuir.
     * @param sucursal nombre de la sucursal destino.
     */
    void distribuir(Compunent pc, String sucursal);
}
