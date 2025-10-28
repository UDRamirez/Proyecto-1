import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Clase {@code Cliente} que se conecta a una sucursal remota mediante RMI.
 * <p>
 * Esta clase actua como cliente para solicitar computadoras pre-armadas
 * desde una sucursal remota utilizando un proxy {@link SucursalProxy}.
 * </p>
 *
 * <h2>Funcionamiento:</h2>
 * <ol>
 *   <li>Se obtiene el registro RMI en el host y puerto especificados.</li>
 *   <li>Se busca la sucursal remota por su nombre en el registro.</li>
 *   <li>Se crea un proxy que permite interactuar con la sucursal de forma local.</li>
 *   <li>Se solicita la computadora deseada (por ejemplo, "eco").</li>
 * </ol>
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>{@code
 * Cliente.main(new String[]{});
 * }</pre>
 *
 * @see SucursalRemota
 * @see SucursalProxy
 */
public class Cliente {
    
    /**
     * Metodo principal que inicia el cliente RMI y realiza una peticion de PC.
     *
     * @param args argumentos de linea de comando (no se utilizan en este ejemplo).
     */
    public static void main(String[] args) {
        try {
            // Obtener el registro RMI del host local en el puerto 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Buscar la sucursal remota en el registro y crear el proxy
            SucursalRemota chihuahuaRemoto = (SucursalRemota) registry.lookup("SucursalChihuahua");
            SucursalRemota chihuahua = new SucursalProxy(chihuahuaRemoto);

            System.out.println("Cliente conectado correctamente.\n");

            // Realizar la petición de una computadora "eco"
            chihuahua.pedirPc("eco");   

            System.out.println("\nPeticion de PCs enviada correctamente.");

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
