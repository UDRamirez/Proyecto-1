import java.rmi.RemoteException;

/**
 * Clase {@code SucursalProxy}.
 * <p>
 * Implementa la interfaz {@link SucursalRemota} y actua como un proxy para
 * delegar las llamadas a un objeto remoto real (stub).
 * Permite que los clientes interactuen con la sucursal remota
 * sin conocer su implementacion interna.
 * </p>
 */
public class SucursalProxy implements SucursalRemota {

    /** Referencia al objeto remoto real que implementa {@link SucursalRemota}. */
    private SucursalRemota stub;

    /**
     * Crea un proxy para la sucursal remota.
     *
     * @param stub instancia remota a la que se delegaran las llamadas.
     */
    public SucursalProxy(SucursalRemota stub) {
        this.stub = stub;
    }

    /**
     * Delegar la recepcion de una computadora a la sucursal remota.
     *
     * @param pc computadora recibida.
     * @throws RemoteException si ocurre un error de comunicacion remota.
     */
    @Override
    public void recibirPc(Compunent pc) throws RemoteException {
        stub.recibirPc(pc);
    }

    /**
     * Delegar la solicitud de una computadora prediseñada.
     *
     * @param tipoPc tipo de computadora solicitada.
     * @throws RemoteException si ocurre un error de comunicacion remota.
     */
    @Override
    public void pedirPc(String tipoPc) throws RemoteException {
        stub.pedirPc(tipoPc);
    }

    /**
     * Delegar la solicitud de una computadora personalizada con especificaciones.
     *
     * @param specs especificaciones de la computadora personalizada.
     * @throws RemoteException si ocurre un error de comunicacion remota.
     */
    @Override
    public void pedirPcPersonalizada(Especificaciones specs) throws RemoteException {
        stub.pedirPcPersonalizada(specs);
    }

    /**
     * Obtiene el nombre de la sucursal remota.
     *
     * @return nombre de la sucursal.
     * @throws RemoteException si ocurre un error de comunicacion remota.
     */
    @Override
    public String getNombre() throws RemoteException {
        return stub.getNombre();
    }
}
