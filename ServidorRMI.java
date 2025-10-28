import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("Registro RMI en puerto 1099");

            Map<String, SucursalRemota> sucursales = new HashMap<>();
            SucursalPrincipal principal = new SucursalPrincipal(sucursales);

     
            SucursalRemotaConcreta chihuahua = new SucursalRemotaConcreta("Sucursal Chihuahua", principal);
            SucursalRemotaConcreta jalisco = new SucursalRemotaConcreta("Sucursal Jalisco", principal);
            SucursalRemotaConcreta yucatan = new SucursalRemotaConcreta("Sucursal Yucatan", principal);


            sucursales.put("Sucursal Chihuahua", chihuahua);
            sucursales.put("Sucursal Jalisco", jalisco);
            sucursales.put("Sucursal Yucatan", yucatan);

            registry.rebind("Sucursal Chihuahua", chihuahua);
            registry.rebind("Sucursal Jalisco", jalisco);
            registry.rebind("Sucursal Yucatan", yucatan);

            System.out.println("Servidor RMI iniciado. Sucursales disponibles:");
            System.out.println("- Sucursal Chihuahua");
            System.out.println("- Sucursal Jalisco"); 
            System.out.println("- Sucursal Yucatan");
            System.out.println("Esperando clientes...");
            
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
