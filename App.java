import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DirectorConstructor director = new DirectorConstructor();
        System.out.println("=== Bienvenido a RockBuster PC ===");

        Map<String, SucursalRemota> sucursalesMap = new HashMap<>();
        SucursalPrincipal principal = new SucursalPrincipal(sucursalesMap);
        System.out.println("Sucursal principal CDMX inicializada.");

        // Conexión a sucursales remotas
        String[] nombresRemotas = {"Sucursal Chihuahua", "Sucursal Jalisco", "Sucursal Yucatan"};
        for (String nombre : nombresRemotas) {
            try {
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);
                SucursalRemota stub = (SucursalRemota) registry.lookup(nombre);
                SucursalProxy proxy = new SucursalProxy(stub);
                principal.registrarSucursal(nombre, proxy); 
                System.out.println("Conexion RMI establecida con " + nombre);
            } catch (Exception e) {
                System.err.println("No se pudo conectar a " + nombre + ": " + e.getMessage());
                System.out.println("La sucursal se omitira de la distribución remota.");
            }
        }
        
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSeleccione el tipo de computadora que desea:");
            System.out.println("1- PC Económica");
            System.out.println("2- PC Premium");
            System.out.println("3- PC Personalizada");
            System.out.println("0- Salir");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            Compunent pcSeleccionada = null;

            switch (opcion) {
                case 1:
                    Compunent pcEcoPreview = director.construirPcEconomica();
                    System.out.println("\n=== Detalles PC Económica ===");
                    System.out.println(pcEcoPreview.getDescripcion());
                    System.out.println("\n¿Desea ordenar esta PC? (s/n)");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        pcSeleccionada = pcEcoPreview;
                    }
                    break;

                case 2:
                    Compunent pcPremPreview = director.construirPcPremium();
                    System.out.println("\n=== Detalles PC Premium ===");
                    System.out.println(pcPremPreview.getDescripcion());
                    System.out.println("\n¿Desea ordenar esta PC? (s/n)");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        pcSeleccionada = pcPremPreview;
                    }
                    break;

                case 3:
                    System.out.println("\n=== Construye tu PC Personalizada ===");
                    Compu compuPersonal = new Compu();
                    List<Programa> programasPersonal = new ArrayList<>();

                    // === CPU ===
                    ContratoFabrica fabCPU = FabricaMaestra.getFabrica("cpu");
                    List<String> modelosCPU = fabCPU.getModelos();
                    int idxCPU = seleccionarComponente(sc, "CPU", modelosCPU, fabCPU);

                    CPU cpu = (CPU) fabCPU.crearComponente(modelosCPU.get(idxCPU));

                    // === Motherboard ===
                    ContratoFabrica fabMadre = FabricaMaestra.getFabrica("madre");
                    List<String> modelosMadre = fabMadre.getModelos();
                    int idxMadre = seleccionarComponente(sc, "Motherboard", modelosMadre, fabMadre);

                    Madre madre = (Madre) fabMadre.crearComponente(modelosMadre.get(idxMadre));

                    // Compatibilidad CPU-Madre
                    AdaptadorCPU adapCPU = new AdaptadorCPU(cpu);
                    AdaptadorMadre adapMadre = new AdaptadorMadre(madre);
                    if (!adapCPU.esCompatibleCon(adapMadre)) {
                        System.out.println("\nCPU y Motherboard no son compatibles.");
                        System.out.println("¿Desea continuar de todos modos? (s/n)");
                        if (!sc.nextLine().equalsIgnoreCase("s")) {
                            System.out.println("No se añadieron CPU ni Motherboard.");
                            break;
                        }
                    }

                    compuPersonal.setCPU(cpu);
                    compuPersonal.setMadre(madre);

                    // === GPU ===
                    ContratoFabrica fabGPU = FabricaMaestra.getFabrica("gpu");
                    List<String> modelosGPU = fabGPU.getModelos();
                    int idxGPU = seleccionarComponente(sc, "GPU", modelosGPU, fabGPU);
                    compuPersonal.setGPU((GPU) fabGPU.crearComponente(modelosGPU.get(idxGPU)));

                    // === RAM ===
                    ContratoFabrica fabRAM = FabricaMaestra.getFabrica("ram");
                    List<String> modelosRAM = fabRAM.getModelos();
                    boolean agregarMasRAM = true;
                    while (agregarMasRAM) {
                        int idxRAM = seleccionarComponente(sc, "RAM", modelosRAM, fabRAM);
                        RAM nuevaRAM = (RAM) fabRAM.crearComponente(modelosRAM.get(idxRAM));
                        compuPersonal.addRAM(nuevaRAM);
                        System.out.println("RAM agregada: " + nuevaRAM.getNombre());
                        System.out.println("¿Desea agregar otra memoria RAM? (s/n)");
                        agregarMasRAM = sc.nextLine().equalsIgnoreCase("s");
                    }

                   
                    // === Disco ===
                    ContratoFabrica fabDisco = FabricaMaestra.getFabrica("disco");
                    List<String> modelosDisco = fabDisco.getModelos();
                    boolean agregarMasDisco = true;
                    while (agregarMasDisco) {
                        int idxDisco = seleccionarComponente(sc, "Disco", modelosDisco, fabDisco);
                        Disco nuevoDisco = (Disco) fabDisco.crearComponente(modelosDisco.get(idxDisco));
                        compuPersonal.addDisco(nuevoDisco);
                        System.out.println("Disco agregado: " + nuevoDisco.getNombre());
                        System.out.println("¿Desea agregar otro disco? (s/n)");
                        agregarMasDisco = sc.nextLine().equalsIgnoreCase("s");
                    }

                    // === Fuente ===
                    ContratoFabrica fabFuente = FabricaMaestra.getFabrica("fuente");
                    List<String> modelosFuente = fabFuente.getModelos();
                    int idxFuente = seleccionarComponente(sc, "Fuente", modelosFuente, fabFuente);
                    compuPersonal.setFuente((Fuente) fabFuente.crearComponente(modelosFuente.get(idxFuente)));

                    // === Gabinete ===
                    ContratoFabrica fabGabinete = FabricaMaestra.getFabrica("gabinete");
                    List<String> modelosGabinete = fabGabinete.getModelos();
                    int idxGabinete = seleccionarComponente(sc, "Gabinete", modelosGabinete, fabGabinete);
                    compuPersonal.setGabinete((Gabinete) fabGabinete.crearComponente(modelosGabinete.get(idxGabinete)));

                    // === Programas personalizados ===
                    boolean agregarProgramas = true;
                    while (agregarProgramas) {
                        System.out.println("\n¿Desea agregar un programa? (s/n)");
                        if (!sc.nextLine().equalsIgnoreCase("s")) break;

                        System.out.println("Seleccione el programa a agregar:");
                        String[] opciones = {"Windows", "Office", "Photoshop", "AutoCAD", "WSLTerminal"};
                        for (int i = 0; i < opciones.length; i++) {
                            System.out.println((i + 1) + ". " + opciones[i]);
                        }
                        int progIdx = sc.nextInt() - 1;
                        sc.nextLine();

                        if (progIdx < 0 || progIdx >= opciones.length) {
                            System.out.println("Opción invalida, no se añadio programa.");
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

                    pcSeleccionada = director.construirPcPersonalizada(
                            cpu.getNombre(), 
                            compuPersonal.getGPU().getNombre(),
                            compuPersonal.getRams().get(0).getNombre(),
                            compuPersonal.getDiscos().get(0).getNombre(),
                            madre.getNombre(),
                            compuPersonal.getFuente().getNombre(),
                            compuPersonal.getGabinete().getNombre(),
                            programasPersonal
                    );

                    System.out.println("\n=== Detalles PC Personalizada ===");
                    System.out.println(pcSeleccionada.getDescripcion());
                    break;

                case 0:
                    continuar = false;
                    System.out.println("\nGracias por usar RockBuster PC. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opcion no válida.");
            }

            if (pcSeleccionada != null) {
                System.out.println("\n¿Desea confirmar la compra de esta PC? (s/n)");
                if (sc.nextLine().equalsIgnoreCase("s")) {
                    // 🔹 NUEVA SECCIÓN: Selección de sucursal destino
                    String nombreSucursal = "Sucursal CDMX";
                    SucursalRemota sucursalDestino = null;
                    
                    System.out.println("\n=== Selección de sucursal destino ===");
                    System.out.println("1. Sucursal Principal CDMX (local)");
                    System.out.println("2. Sucursal Chihuahua");
                    System.out.println("3. Sucursal Jalisco"); 
                    System.out.println("4. Sucursal Yucatan");
                    System.out.print("Seleccione la sucursal destino (1-4): ");
                    
                    int opcionSucursal = sc.nextInt();
                    sc.nextLine();
                    
                    switch (opcionSucursal) {
                        case 1:
                            // Sucursal principal - no necesita proxy
                            nombreSucursal = "Sucursal CDMX";
                            break;
                        case 2:
                            sucursalDestino = sucursalesMap.get("Sucursal Chihuahua");
                            nombreSucursal = "Sucursal Chihuahua";
                            break;
                        case 3:
                            sucursalDestino = sucursalesMap.get("Sucursal Jalisco");
                            nombreSucursal = "Sucursal Jalisco";
                            break;
                        case 4:
                            sucursalDestino = sucursalesMap.get("Sucursal Yucatan");
                            nombreSucursal = "Sucursal Yucatan";
                            break;
                        default:
                            System.out.println("Opcion invalida se usara la sucursal principal.");
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
                        System.out.println("PC procesada en " + nombreSucursal);
                    }

                    Ticket ticket = new Ticket(pcSeleccionada, nombreSucursal);

                    boolean huboAdaptacion = false;
                    if (pcSeleccionada instanceof Compu) {
                        Compu c = (Compu) pcSeleccionada;
                        huboAdaptacion = (c.getCPU() != null && c.getCPU().getAdaptado())
                                || (c.getMadre() != null && c.getMadre().getAdaptado());
                    }

                    System.out.println("\n===== TICKET DE COMPRA =====");
                    System.out.println(ticket.getContenido());
                    if (huboAdaptacion) {
                        System.out.println("Se realizaron adaptaciones en CPU o Motherboard por incompatibilidad.");
                    }
                    if (!envioExitoso && sucursalDestino != null) {
                        System.out.println("La PC se proceso localmente debido a problemas de conexion.");
                    }
                }
            }
        }

        sc.close();
    }

    // Método auxiliar para seleccionar componentes con validación
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
}
