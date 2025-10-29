import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaz {@code SucursalRemota}.
 * <p>
 * Define los metodos que una sucursal remota debe implementar
 * para poder recibir y solicitar computadoras a traves de RMI.
 * Extiende {@link Remote} para soportar llamadas remotas.
 * </p>
 */
public interface SucursalRemota extends Remote {

    /**
     * Permite que la sucursal reciba una computadora enviada desde la sucursal principal.
     *
     * @param compu computadora recibida.
     * @throws RemoteException si ocurre un error de comunicacion remota.
     */
    void recibirPc(Compunent compu) throws RemoteException;

    /**
     * Permite solicitar una computadora prediseñada desde la sucursal remota.
     *
     * @param tipoPc tipo de computadora solicitada (por ejemplo, "eco" o "prem").
     * @throws RemoteException si ocurre un error de comunicacion remota.
     */
    void pedirPc(String tipoPc) throws RemoteException;

    /**
     * Permite solicitar una computadora personalizada con especificaciones detalladas.
     *
     * @param specs objeto {@link Especificaciones} que contiene los componentes y programas deseados.
     * @throws RemoteException si ocurre un error de comunicacion remota.
     */
    void pedirPcPersonalizada(Especificaciones specs) throws RemoteException;

    /**
     * Obtiene el nombre de la sucursal remota.
     *
     * @return nombre de la sucursal.
     * @throws RemoteException si ocurre un error de comunicacion remota.
     */
    String getNombre() throws RemoteException;
}
