import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;

public class SucursalRemotaConcreta extends UnicastRemoteObject implements SucursalRemota {
    private String nombre;
    private List<Compunent> inventario;
    private SucursalPrincipal principal;

    public SucursalRemotaConcreta(String nombre, SucursalPrincipal principal) throws RemoteException {
        super();
        this.nombre = nombre;
        this.principal = principal;
        this.inventario = new ArrayList<>();
    }

    @Override
    public void recibirPc(Compunent pc) throws RemoteException {
        inventario.add(pc);
        System.out.println(nombre + " recibió " + pc);
    }

    @Override
    public void pedirPc(String tipoPc) throws RemoteException {
        Compunent pc = principal.fabricarPc(tipoPc);
        principal.distribuir(pc, nombre);
    }
    @Override
    public void pedirPcPersonalizada(Especificaciones specs) throws RemoteException {
        Compunent pc = principal.fabricarPc("perso", specs);
        principal.distribuir(pc, nombre);
    }

    public List<Compunent> getInventario() {
        return inventario;
    }
    @Override
    public String getNombre() throws RemoteException{
	return nombre;
    }
}
