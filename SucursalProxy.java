/*
import java.rmi.RemoteException;

public class SucursalProxy implements SucursalRemota{

    private SucursalRemota stub;
    
    public SucursalProxy(Sucursal stub){
	this.stub = stub;

    }
    @Override
    public Compu construirPcEco() {
        try {
            return stub.construirPcEco();
        } catch (RemoteException e) {
            System.err.println("Error de conexion");
           
            return null;
        }
    }
    @Override
    public Compu construirPcPrem() {
        try {
   
            return stub.construirPcPrem();
        } catch (RemoteException e) {
             System.err.println("Error de conexion");
            return null;
        }
    }

    @Override
    public Compu construirPcPerso(String cpu, String gpu, String ram, String disco,
                                  String madre, String fuente, String gabinete) {
        try {
      
            return stub.construirPcPerso(cpu, gpu, ram, disco, madre, fuente, gabinete);
        } catch (RemoteException e) {
              System.err.println("Error de conexion");
            return null;
        }
    }
}
*/
