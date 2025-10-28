import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;

/**
 * Clase {@code SucursalRemotaConcreta}.
 * <p>
 * Implementa la interfaz {@link SucursalRemota} y representa
 * una sucursal remota concreta que puede recibir y solicitar
 * computadoras a traves de RMI.
 * </p>
 */
public class SucursalRemotaConcreta extends UnicastRemoteObject implements SucursalRemota {

    /** Nombre de la sucursal remota. */
    private String nombre;

    /** Inventario de computadoras disponibles en la sucursal. */
    private List<Compunent> inventario;

    /** Referencia a la sucursal principal para solicitar computadoras. */
    private SucursalPrincipal principal;

    /**
     * Constructor que inicializa la sucursal remota.
     *
     * @param nombre nombre de la sucursal.
     * @param principal referencia a la sucursal principal.
     * @throws RemoteException si ocurre un error al exportar el objeto RMI.
     */
    public SucursalRemotaConcreta(String nombre, SucursalPrincipal principal) throws RemoteException {
        super();
        this.nombre = nombre;
        this.principal = principal;
        this.inventario = new ArrayList<>();
    }

    /**
     * Recibe una computadora enviada desde la sucursal principal
     * y la agrega al inventario.
     *
     * @param pc computadora recibida.
     * @throws RemoteException si ocurre un error de comunicacion remota.
     */
    @Override
    public void recibirPc(Compunent pc) throws RemoteException {
        inventario.add(pc);
        System.out.println(nombre + " recibio " + pc);
    }

    /**
     * Solicita una computadora prediseñada a la sucursal principal
     * y la recibe mediante distribucion.
     *
     * @param tipoPc tipo de computadora solicitada (por ejemplo, "eco" o "prem").
     * @throws RemoteException si ocurre un error de comunicacion remota.
     */
    @Override
    public void pedirPc(String tipoPc) throws RemoteException {
        Compunent pc = principal.fabricarPc(tipoPc);
        principal.distribuir(pc, nombre);
    }

    /**
     * Solicita una computadora personalizada a la sucursal principal
     * utilizando las especificaciones detalladas.
     *
     * @param specs especificaciones de la computadora deseada.
     * @throws RemoteException si ocurre un error de comunicacion remota.
     */
    @Override
    public void pedirPcPersonalizada(Especificaciones specs) throws RemoteException {
        Compunent pc = principal.fabricarPc("perso", specs);
        principal.distribuir(pc, nombre);
    }

    /**
     * Obtiene el inventario de computadoras de la sucursal.
     *
     * @return lista de computadoras disponibles.
     */
    public List<Compunent> getInventario() {
        return inventario;
    }

    /**
     * Obtiene el nombre de la sucursal remota.
     *
     * @return nombre de la sucursal.
     * @throws RemoteException si ocurre un error de comunicacion remota.
     */
    @Override
    public String getNombre() throws RemoteException {
        return nombre;
    }
}
