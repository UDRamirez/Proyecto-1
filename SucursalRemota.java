import java.rmi.Remote;
import java.rmi.RemoteException;
interface SucursalRemota extends Remote{
   
    void recibirPc(Compu compu) throws RemoteException;
    void pedirPc(String tipoPc) throws RemoteException; 



}
