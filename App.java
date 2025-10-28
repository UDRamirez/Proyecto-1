import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DirectorConstructor director = new DirectorConstructor();
        System.out.println("=== Bienvenido a RockBuster PC ===");

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSeleccione el tipo de computadora que desea:");
            System.out.println("1- PC Económica");
            System.out.println("2- PC Premium");
            System.out.println("3- PC Personalizada");
            System.out.println("0- Salir");

            int opcion = leerEntero(sc, "Ingrese una opción: ", 0, 3);
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
                        System.out.println("\n⚠ CPU y Motherboard no son compatibles.");
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

                    // === RAM (múltiples) ===
                    ContratoFabrica fabRAM = FabricaMaestra.getFabrica("ram");
                    List<String> modelosRAM = fabRAM.getModelos();
                    boolean agregarRAM = true;
                    while (agregarRAM) {
                        int idxRAM = seleccionarComponente(sc, "RAM", modelosRAM, fabRAM);
                        compuPersonal.addRAM((RAM) fabRAM.crearComponente(modelosRAM.get(idxRAM)));

                        System.out.println("¿Desea agregar otra RAM? (s/n)");
                        if (!sc.nextLine().equalsIgnoreCase("s")) {
                            agregarRAM = false;
                        }
                    }

                    // === Disco (múltiples) ===
                    ContratoFabrica fabDisco = FabricaMaestra.getFabrica("disco");
                    List<String> modelosDisco = fabDisco.getModelos();
                    boolean agregarDisco = true;
                    while (agregarDisco) {
                        int idxDisco = seleccionarComponente(sc, "Disco", modelosDisco, fabDisco);
                        compuPersonal.addDisco((Disco) fabDisco.crearComponente(modelosDisco.get(idxDisco)));

                        System.out.println("¿Desea agregar otro disco? (s/n)");
                        if (!sc.nextLine().equalsIgnoreCase("s")) {
                            agregarDisco = false;
                        }
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
                    String[] opciones = {"Windows", "Office", "Photoshop", "AutoCAD", "WSLTerminal"};
                    while (agregarProgramas) {
                        System.out.println("\n¿Desea agregar un programa? (s/n)");
                        if (!sc.nextLine().equalsIgnoreCase("s")) break;

                        System.out.println("Seleccione el programa a agregar:");
                        for (int i = 0; i < opciones.length; i++) {
                            System.out.println((i + 1) + ". " + opciones[i]);
                        }

                        int progIdx = leerEntero(sc, "Seleccione una opción: ", 1, opciones.length) - 1;
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
                    System.out.println("Opción no válida.");
            }

            if (pcSeleccionada != null) {
                System.out.println("\n¿Desea confirmar la compra de esta PC? (s/n)");
                if (sc.nextLine().equalsIgnoreCase("s")) {
                    Ticket ticket = new Ticket(pcSeleccionada, "Sucursal Central");

                    boolean huboAdaptacion = false;
                    if (pcSeleccionada instanceof Compu c) {
                        huboAdaptacion = (c.getCPU() != null && c.getCPU().getAdaptado())
                                || (c.getMadre() != null && c.getMadre().getAdaptado());
                    }

                    System.out.println("\n===== TICKET DE COMPRA =====");
                    System.out.println(ticket.getContenido());
                    if (huboAdaptacion) {
                        System.out.println("⚠ Se realizaron adaptaciones en CPU o Motherboard por incompatibilidad.");
                    }
                }
            }
        }

        sc.close();
    }

    // 🔹 Método auxiliar para seleccionar componentes con validación
    private static int seleccionarComponente(Scanner sc, String tipo, List<String> modelos, ContratoFabrica fab) {
        System.out.println("\n--- Seleccione su " + tipo + " ---");
        for (int i = 0; i < modelos.size(); i++) {
            Pieza temp = (Pieza) fab.crearComponente(modelos.get(i));
            System.out.println((i + 1) + ". " + temp.getNombre() + " - $" + temp.getPrecio());
        }
        return leerEntero(sc, "Ingrese el número de su elección: ", 1, modelos.size()) - 1;
    }

    // 🔹 Método seguro para leer enteros con validación
    private static int leerEntero(Scanner sc, String mensaje, int min, int max) {
        int numero;
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();
            try {
                numero = Integer.parseInt(entrada);
                if (numero >= min && numero <= max) {
                    return numero;
                } else {
                    System.out.println("⚠ El número debe estar entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Entrada inválida. Debe ingresar un número.");
            }
        }
    }
}

