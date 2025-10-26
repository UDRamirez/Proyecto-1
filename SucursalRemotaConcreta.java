import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;

public class SucursalRemotaConcreta extends UnicastRemoteObject implements SucursalRemota {
    private String nombre;
    private List<Compu> inventario;
    private SucursalPrincipal principal;

    public SucursalRemotaConcreta(String nombre, SucursalPrincipal principal) throws RemoteException {
        super();
        this.nombre = nombre;
        this.principal = principal;
        this.inventario = new ArrayList<>();
    }

    @Override
    public void recibirPc(Compu pc) throws RemoteException {
        inventario.add(pc);
        System.out.println(nombre + " recibió " + pc);
    }

    @Override
    public void pedirPc(String tipoPc) throws RemoteException {
        Compu pc = principal.fabricarPc(tipoPc);
        principal.distribuir(pc, nombre);
    }
}
