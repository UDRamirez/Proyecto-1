import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
 
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            SucursalRemota chihuahua = (SucursalRemota) registry.lookup("SucursalChihuahua");
            SucursalRemota jalisco = (SucursalRemota) registry.lookup("SucursalJalisco");

            System.out.println("Cliente conectado correctamente.\n");

            chihuahua.pedirPc("eco");   
            chihuahua.pedirPc("prem"); 

           

            System.out.println("\nPetición de PCs enviada correctamente.");

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
