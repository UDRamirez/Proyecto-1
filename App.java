import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

/**
 * Clase principal {@code App} del sistema MonosChinosMX.
 * <p>
 * Esta clase ejecuta el flujo principal del programa, permitiendo al usuario:
 * <ul>
 *   <li>Visualizar computadoras preconstruidas o personalizar una PC.</li>
 *   <li>Seleccionar piezas y programas.</li>
 *   <li>Verificar compatibilidad entre componentes.</li>
 *   <li>Simular la compra y envio de la PC mediante RMI.</li>
 * </ul>
 * </p>
 */
public class App {

    /**
     * Metodo principal del programa. Controla el flujo de seleccion y creacion de PCs,
     * gestionando tanto PCs predisenadas como personalizadas.
     *
     * @param args argumentos de linea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DirectorConstructor director = new DirectorConstructor();
        System.out.println("=== Bienvenido a la plataforma de MonosChinosMX ===");
        System.out.println("=== Por favor, consulte nuestras PCs pre-hechas o haga la suya propia ===");

        // Inicializacion del sistema de Proxy/RMI
        Map<String, SucursalRemota> sucursalesMap = new HashMap<>();
        SucursalPrincipal principal = new SucursalPrincipal(sucursalesMap);
        System.out.println("Sucursal principal CDMX inicializada.");

        // Conexion a sucursales remotas
        String[] nombresRemotas = {"Sucursal Chihuahua", "Sucursal Jalisco", "Sucursal Yucatan"};
        for (String nombre : nombresRemotas) {
            try {
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);
                SucursalRemota stub = (SucursalRemota) registry.lookup(nombre);
                SucursalProxy proxy = new SucursalProxy(stub);
                principal.registrarSucursal(nombre, proxy);
                sucursalesMap.put(nombre, proxy);
                System.out.println("Conexion RMI establecida con " + nombre);
            } catch (Exception e) {
                System.err.println("No se pudo conectar a " + nombre + ": " + e.getMessage());
                System.out.println("La sucursal se omitira de la distribucion remota.");
            }
        }

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSeleccione el tipo de computadora que desea:");
            System.out.println("1- PC Economica");
            System.out.println("2- PC Premium");
            System.out.println("3- PC Personalizada");
            System.out.println("0- Salir");

            int opcion = sc.nextInt();
            sc.nextLine();
            Compunent pcSeleccionada = null;

            switch (opcion) {
                case 1 -> {
                    Compunent pcEcoPreview = director.construirPcEconomica();
                    System.out.println(pcEcoPreview.getDescripcion());
                    if (preguntarSN(sc, "\nDesea ordenar esta PC? (s/n)")) {
                        pcSeleccionada = pcEcoPreview;
                    }
                }

                case 2 -> {
                    Compunent pcPremPreview = director.construirPcPremium();
                    System.out.println(pcPremPreview.getDescripcion());
                    if (preguntarSN(sc, "\nDesea ordenar esta PC? (s/n)")) {
                        pcSeleccionada = pcPremPreview;
                    }
                }

                case 3 -> {
                    System.out.println("\n=== Construyamos tu propia PC ===");
                    Compu compuPersonal = new Compu();
                    List<Programa> programasPersonal = new ArrayList<>();
                    boolean huboIncompatibilidad = false;

                    // CPU
                    ContratoFabrica fabCPU = FabricaMaestra.getFabrica("cpu");
                    List<String> modelosCPU = fabCPU.getModelos();
                    int idxCPU = seleccionarComponente(sc, "CPU", modelosCPU, fabCPU);
                    CPU cpu = (CPU) fabCPU.crearComponente(modelosCPU.get(idxCPU));

                    // Motherboard
                    ContratoFabrica fabMadre = FabricaMaestra.getFabrica("madre");
                    List<String> modelosMadre = fabMadre.getModelos();
                    int idxMadre = seleccionarComponente(sc, "Motherboard", modelosMadre, fabMadre);
                    Madre madre = (Madre) fabMadre.crearComponente(modelosMadre.get(idxMadre));

                    // Compatibilidad
                    AdaptadorCPU adapCPU = new AdaptadorCPU(cpu);
                    AdaptadorMadre adapMadre = new AdaptadorMadre(madre);
                    if (!adapCPU.esCompatibleCon(adapMadre)) {
                        System.out.println("\nCPU y Motherboard no son compatibles.");
                        if (!preguntarSN(sc, "Desea continuar de todos modos? (s/n)")) {
                            System.out.println("No se anadieron CPU ni Motherboard.");
                        } else {
                            cpu.setAdaptado(true);
                            madre.setAdaptado(true);
                            huboIncompatibilidad = true;
                            compuPersonal.setCPU(cpu);
                            compuPersonal.setMadre(madre);
                        }
                    } else {
                        compuPersonal.setCPU(cpu);
                        compuPersonal.setMadre(madre);
                    }

                    // GPU
                    ContratoFabrica fabGPU = FabricaMaestra.getFabrica("gpu");
                    List<String> modelosGPU = fabGPU.getModelos();
                    int idxGPU = seleccionarComponente(sc, "GPU", modelosGPU, fabGPU);
                    compuPersonal.setGPU((GPU) fabGPU.crearComponente(modelosGPU.get(idxGPU)));

                    // RAM
                    ContratoFabrica fabRAM = FabricaMaestra.getFabrica("ram");
                    List<String> modelosRAM = fabRAM.getModelos();
                    boolean agregarMasRAM = true;

                    while (agregarMasRAM) {
                        int idxRAM = seleccionarComponente(sc, "RAM", modelosRAM, fabRAM);
                        RAM nuevaRAM = (RAM) fabRAM.crearComponente(modelosRAM.get(idxRAM));
                        compuPersonal.addRAM(nuevaRAM);
                        System.out.println("RAM agregada: " + nuevaRAM.getNombre());
                        agregarMasRAM = preguntarSN(sc, "Desea agregar otra memoria RAM? (s/n)");
                    }

                    // Discos
                    ContratoFabrica fabDisco = FabricaMaestra.getFabrica("disco");
                    List<String> modelosDisco = fabDisco.getModelos();
                    boolean agregarMasDisco = true;

                    while (agregarMasDisco) {
                        int idxDisco = seleccionarComponente(sc, "Disco", modelosDisco, fabDisco);
                        Disco nuevoDisco = (Disco) fabDisco.crearComponente(modelosDisco.get(idxDisco));
                        compuPersonal.addDisco(nuevoDisco);
                        System.out.println("Disco agregado: " + nuevoDisco.getNombre());
                        agregarMasDisco = preguntarSN(sc, "Desea agregar otro disco? (s/n)");
                    }

                    // Fuente
                    ContratoFabrica fabFuente = FabricaMaestra.getFabrica("fuente");
                    List<String> modelosFuente = fabFuente.getModelos();
                    int idxFuente = seleccionarComponente(sc, "Fuente", modelosFuente, fabFuente);
                    compuPersonal.setFuente((Fuente) fabFuente.crearComponente(modelosFuente.get(idxFuente)));

                    // Gabinete
                    ContratoFabrica fabGabinete = FabricaMaestra.getFabrica("gabinete");
                    List<String> modelosGabinete = fabGabinete.getModelos();
                    int idxGabinete = seleccionarComponente(sc, "Gabinete", modelosGabinete, fabGabinete);
                    compuPersonal.setGabinete((Gabinete) fabGabinete.crearComponente(modelosGabinete.get(idxGabinete)));

                    // Programas
                    boolean agregarProgramas = true;
                    while (agregarProgramas) {
                        if (!preguntarSN(sc, "\nDesea agregar un programa? (s/n)")) break;

                        System.out.println("Seleccione el programa a agregar:");
                        String[] opciones = {"Windows", "Office", "Photoshop", "AutoCAD", "WSLTerminal"};
                        for (int i = 0; i < opciones.length; i++) {
                            System.out.println((i + 1) + ". " + opciones[i]);
                        }

                        if (!sc.hasNextInt()) {
                            System.out.println("Debe ingresar un numero.");
                            sc.nextLine();
                            continue;
                        }
                        int progIdx = sc.nextInt() - 1;
                        sc.nextLine();

                        if (progIdx < 0 || progIdx >= opciones.length) {
                            System.out.println("Opcion invalida, no se anadio programa.");
                            continue;
                        }

                        Programa prog = switch (opciones[progIdx]) {
                            case "Windows" -> new Windows();
                            case "Office" -> new Office();
                            case "Photoshop" -> new Photoshop();
                            case "AutoCAD" -> new AutoCAD();
                            case "WSLTerminal" -> new WSLTerminal();
                            default -> null;
                        };

                        boolean existe = programasPersonal.stream()
                                .anyMatch(p -> p.getNombre().equalsIgnoreCase(prog.getNombre()));
                        if (!existe) {
                            programasPersonal.add(prog);
                        } else {
                            System.out.println("El programa ya fue agregado, se ignora duplicado.");
                        }
                    }

                    // Decorador
                    Compunent pcFinal = compuPersonal;
                    for (Programa p : programasPersonal) {
                        pcFinal = new PCDecorada(pcFinal, p);
                    }

                    compuPersonal.setIncompatibilidad(huboIncompatibilidad);
                    pcSeleccionada = pcFinal;

                    System.out.println("\n=== Detalles PC Personalizada ===");
                    System.out.println(pcSeleccionada.getDescripcion());
                }

                case 0 -> {
                    continuar = false;
                    System.out.println("\nGracias por visitarnos, hasta pronto!");
                }

                default -> System.out.println("Opcion no valida.");
            }

            if (pcSeleccionada != null) {
                if (preguntarSN(sc, "\nDesea confirmar la compra de esta PC? (s/n)")) {

                    // Seleccion de sucursal destino
                    String nombreSucursal = "Sucursal CDMX";
                    SucursalRemota sucursalDestino = null;

                    System.out.println("\n=== Seleccion de sucursal destino ===");
                    System.out.println("1. Sucursal Principal CDMX (local)");
                    System.out.println("2. Sucursal Chihuahua");
                    System.out.println("3. Sucursal Jalisco");
                    System.out.println("4. Sucursal Yucatan");
                    System.out.print("Seleccione la sucursal destino (1-4): ");

                    int opcionSucursal = sc.nextInt();
                    sc.nextLine();

                    switch (opcionSucursal) {
                        case 1 -> nombreSucursal = "Sucursal CDMX";
                        case 2 -> sucursalDestino = sucursalesMap.get("Sucursal Chihuahua");
                        case 3 -> sucursalDestino = sucursalesMap.get("Sucursal Jalisco");
                        case 4 -> sucursalDestino = sucursalesMap.get("Sucursal Yucatan");
                        default -> System.out.println("Opcion invalida, se usara la sucursal principal.");
                    }

                    boolean envioExitoso = false;
                    if (sucursalDestino != null) {
                        try {
                            sucursalDestino.recibirPc(pcSeleccionada);
                            envioExitoso = true;
                            System.out.println("PC enviada exitosamente a " + nombreSucursal);
                        } catch (RemoteException e) {
                            System.err.println("Error al enviar la PC a " + nombreSucursal + ": " + e.getMessage());
                            System.out.println("Se usara la sucursal principal localmente.");
                            nombreSucursal = "Sucursal CDMX";
                        }
                    } else {
                        envioExitoso = true;
                        System.out.println("PC procesada localmente en " + nombreSucursal);
                    }

                    Ticket ticket = new Ticket(pcSeleccionada, nombreSucursal);
                    System.out.println(ticket.getContenido());
                }
            }
        }

        sc.close();
    }

    // Metodo auxiliar para seleccionar componentes con validacion
    private static int seleccionarComponente(Scanner sc, String tipo, List<String> modelos, ContratoFabrica fab) {
        int idx = -1;
        while (true) {
            System.out.println("\n--- Seleccione su " + tipo + " ---");
            for (int i = 0; i < modelos.size(); i++) {
                Pieza temp = (Pieza) fab.crearComponente(modelos.get(i));
                System.out.println((i + 1) + ". " + temp.getNombre() + " - $" + temp.getPrecio());
            }
            System.out.print("Ingrese el numero de su eleccion: ");
            if (!sc.hasNextInt()) {
                System.out.println("Debe ingresar un numero.");
                sc.nextLine();
                continue;
            }
            idx = sc.nextInt() - 1;
            sc.nextLine();
            if (idx >= 0 && idx < modelos.size()) break;
            System.out.println("Opcion invalida, intente de nuevo.");
        }
        return idx;
    }

    // Metodo para preguntar si/no con validacion
    private static boolean preguntarSN(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje + " ");
            String respuesta = sc.nextLine().trim().toLowerCase();
            if (respuesta.equals("s")) return true;
            if (respuesta.equals("n")) return false;
            System.out.println("Eso no es una opcion. Por favor, ingrese 's' o 'n'.");
        }
    }
}
