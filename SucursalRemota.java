
import java.rmi.Remote;
import java.rmi.RemoteException;
interface SucursalRemota extends Remote{
   
    void recibirPc(Compunent compu) throws RemoteException;
    void pedirPc(String tipoPc) throws RemoteException; 
    void pedirPcPersonalizada(Especificaciones specs) throws RemoteException;
    public String getNombre() throws RemoteException;

}
