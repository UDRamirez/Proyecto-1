import java.rmi.RemoteException;

public class SucursalProxy implements SucursalRemota {
    private SucursalRemota stub;

    public SucursalProxy(SucursalRemota stub) {
        this.stub = stub;
    }

    @Override
    public void recibirPc(Compunent pc) throws RemoteException {
        stub.recibirPc(pc);
    }

    @Override
    public void pedirPc(String tipoPc) throws RemoteException {
        stub.pedirPc(tipoPc);
    }

    @Override
    public void pedirPcPersonalizada(Especificaciones specs) throws RemoteException {
        stub.pedirPcPersonalizada(specs);
    }
    @Override
    public String getNombre()  throws RemoteException{
	return stub.getNombre();
    }
}
