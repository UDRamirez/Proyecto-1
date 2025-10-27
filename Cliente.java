import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
 
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            SucursalRemota chihuahuaRemoto = (SucursalRemota) registry.lookup("SucursalChihuahua");
	    SucursalRemota chihuahua = new SucursalProxy(chihuahuaRemoto);
            System.out.println("Cliente conectado correctamente.\n");

            chihuahua.pedirPc("eco");   
        

           

            System.out.println("\nPetición de PCs enviada correctamente.");

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
