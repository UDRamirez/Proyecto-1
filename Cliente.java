import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            SucursalRemota chihuahua = (SucursalRemota) registry.lookup("SucursalChihuahua");
            SucursalRemota juarez = (SucursalRemota) registry.lookup("SucursalJuarez");

            chihuahua.pedirPc("eco");   
            chihuahua.pedirPc("prem"); 
            juarez.pedirPc("perso");    

            System.out.println("Cliente conectado correctamente");
        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
