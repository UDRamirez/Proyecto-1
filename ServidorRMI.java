import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase {@code ServidorRMI}.
 * <p>
 * Implementa el servidor RMI que registra las sucursales remotas
 * para que los clientes puedan conectarse y acceder a los servicios
 * de cada sucursal.
 * </p>
 * <p>
 * Crea el registro RMI en el puerto 1099, inicializa la sucursal
 * principal y las sucursales remotas, y las registra en el
 * registry para que sean accesibles por los clientes.
 * </p>
 */
public class ServidorRMI {

    /**
     * Metodo principal que inicia el servidor RMI.
     * <p>
     * Se encarga de crear el registry, inicializar las sucursales
     * y registrar cada sucursal remota en el registry.
     * </p>
     *
     * @param args argumentos de la linea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        try {
            // Crear el registro RMI en el puerto 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("Registro RMI en puerto 1099");

            // Crear mapa de sucursales
            Map<String, SucursalRemota> sucursales = new HashMap<>();

            // Inicializar sucursal principal
            SucursalPrincipal principal = new SucursalPrincipal(sucursales);

            // Crear sucursales remotas
            SucursalRemotaConcreta chihuahua = new SucursalRemotaConcreta("Sucursal Chihuahua", principal);
            SucursalRemotaConcreta jalisco = new SucursalRemotaConcreta("Sucursal Jalisco", principal);
            SucursalRemotaConcreta yucatan = new SucursalRemotaConcreta("Sucursal Yucatan", principal);

            // Agregar sucursales al mapa
            sucursales.put("Sucursal Chihuahua", chihuahua);
            sucursales.put("Sucursal Jalisco", jalisco);
            sucursales.put("Sucursal Yucatan", yucatan);

            // Registrar sucursales en el registry
            registry.rebind("Sucursal Chihuahua", chihuahua);
            registry.rebind("Sucursal Jalisco", jalisco);
            registry.rebind("Sucursal Yucatan", yucatan);

            // Mostrar informacion
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
