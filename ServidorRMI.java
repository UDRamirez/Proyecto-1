import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("Registry RMI en puerto 1099");

            Map<String, SucursalRemota> sucursales = new HashMap<>();
            SucursalPrincipal principal = new SucursalPrincipal(sucursales);

            SucursalRemotaConcreta chihuahua = new SucursalRemotaConcreta("Sucursal Chihuahua", principal);
            SucursalRemotaConcreta juarez = new SucursalRemotaConcreta("Sucursal Juárez", principal);

            sucursales.put("Sucursal Chihuahua", chihuahua);
            sucursales.put("Sucursal Juárez", juarez);

            registry.rebind("SucursalChihuahua", chihuahua);
            registry.rebind("SucursalJuarez", juarez);

            System.out.println("Servidor RMI iniciado. Esperando clientes...");
        } catch (Exception e) {
            System.err.println(" Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
