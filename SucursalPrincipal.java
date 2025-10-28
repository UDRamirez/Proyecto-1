import java.util.*;
import java.rmi.RemoteException;

/**
 * Clase {@code SucursalPrincipal}.
 * <p>
 * Representa la sucursal principal de la red de sucursales. 
 * Se encarga de construir computadoras economicas, premium o personalizadas 
 * y de distribuirlas a las sucursales remotas.
 * </p>
 */
public class SucursalPrincipal implements Sucursal {

    /** Director que se encarga de construir computadoras segun los distintos tipos. */
    private DirectorConstructor constructor;

    /** Mapa con las sucursales remotas registradas y su nombre como clave. */
    private Map<String, SucursalRemota> sucursalesRemotas;

    /**
     * Crea una nueva sucursal principal.
     *
     * @param sucursales mapa inicial de sucursales remotas.
     */
    public SucursalPrincipal(Map<String, SucursalRemota> sucursales) {
        this.constructor = new DirectorConstructor();
        this.sucursalesRemotas = sucursales;
    }

    /**
     * Registra una nueva sucursal remota en el sistema.
     *
     * @param nombre nombre de la sucursal.
     * @param puntoDistribucion instancia de {@link SucursalRemota}.
     */
    public void registrarSucursal(String nombre, SucursalRemota puntoDistribucion) {
        sucursalesRemotas.put(nombre, puntoDistribucion);
    }

    /**
     * Construye una computadora economica prediseñada.
     *
     * @return computadora economica construida.
     */
    @Override
    public Compunent construirPcEco() {
        return constructor.construirPcEconomica();
    }

    /**
     * Construye una computadora premium prediseñada.
     *
     * @return computadora premium construida.
     */
    @Override
    public Compunent construirPcPrem() {
        return constructor.construirPcPremium();
    }

    /**
     * Construye una computadora personalizada segun las especificaciones dadas.
     *
     * @param cpu      modelo de CPU.
     * @param gpu      modelo de GPU.
     * @param ram      modelo de RAM.
     * @param disco    modelo de disco.
     * @param madre    modelo de placa madre.
     * @param fuente   modelo de fuente de poder.
     * @param gabinete modelo de gabinete.
     * @param programas lista de programas a instalar.
     * @return computadora personalizada construida.
     */
    @Override
    public Compunent construirPcPerso(String cpu, String gpu, String ram, String disco,
                                      String madre, String fuente, String gabinete, List<Programa> programas) {
        return constructor.construirPcPersonalizada(cpu, gpu, ram, disco, madre, fuente, gabinete, programas);
    }

    /**
     * Distribuye una computadora a una sucursal remota.
     *
     * @param pc computadora a distribuir.
     * @param sucursal nombre de la sucursal destino.
     */
    @Override
    public void distribuir(Compunent pc, String sucursal) {
        try {
            SucursalRemota destino = sucursalesRemotas.get(sucursal);
            if (destino != null) {
                destino.recibirPc(pc);
                System.out.println("Distribuida a " + sucursal);
            } else {
                System.out.println("No existe esa sucursal remota: " + sucursal);
            }
        } catch (RemoteException e) {
            System.err.println("Error distribuyendo a " + sucursal + ": " + e.getMessage());
        }
    }

    /**
     * Fabrica una computadora segun el tipo especificado ("eco" o "prem").
     *
     * @param tipoPc tipo de computadora.
     * @return computadora construida o null si el tipo es invalido.
     */
    public Compunent fabricarPc(String tipoPc) {
        switch (tipoPc.toLowerCase()) {
            case "eco": return construirPcEco();
            case "prem": return construirPcPrem();
            default: return null;
        }
    }

    /**
     * Fabrica una computadora segun el tipo y las especificaciones dadas.
     *
     * @param tipoPc tipo de computadora ("eco", "prem" o "perso").
     * @param specs  objeto {@link Especificaciones} con los componentes y programas.
     * @return computadora construida o null si el tipo es invalido.
     */
    public Compunent fabricarPc(String tipoPc, Especificaciones specs) {
        switch (tipoPc.toLowerCase()) {
            case "eco": return construirPcEco();
            case "prem": return construirPcPrem();
            case "perso":
                return construirPcPerso(
                    specs.cpu, specs.gpu, specs.ram, specs.disco,
                    specs.madre, specs.fuente, specs.gabinete, specs.programas
                );
            default: return null;
        }
    }

    /**
     * Devuelve los nombres de las sucursales remotas registradas.
     *
     * @return lista de nombres de sucursales.
     */
    public List<String> getPuntosDistribucion() {
        return new ArrayList<>(sucursalesRemotas.keySet());
    }
}
