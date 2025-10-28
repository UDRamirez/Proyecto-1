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

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            Compunent pcSeleccionada = null;

            switch (opcion) {
                case 1:
                    Compunent pcEcoPreview = director.construirPcEconomica();
                    System.out.println("\n=== Detalles PC Económica ===");
                    System.out.println(pcEcoPreview.getDescripcion());
                    if (confirmar(sc, "¿Desea ordenar esta PC? (s/n)")) {
                        pcSeleccionada = pcEcoPreview;
                    }
                    break;

                case 2:
                    Compunent pcPremPreview = director.construirPcPremium();
                    System.out.println("\n=== Detalles PC Premium ===");
                    System.out.println(pcPremPreview.getDescripcion());
                    if (confirmar(sc, "¿Desea ordenar esta PC? (s/n)")) {
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
                        if (!confirmar(sc, "¿Desea continuar de todos modos? (s/n)")) {
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
                        agregarMasRAM = confirmar(sc, "¿Desea agregar otra memoria RAM? (s/n)");
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
                        agregarMasDisco = confirmar(sc, "¿Desea agregar otro disco? (s/n)");
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
                    while (confirmar(sc, "¿Desea agregar un programa? (s/n)")) {
                        System.out.println("Seleccione el programa a agregar:");
                        String[] opciones = {"Windows", "Office", "Photoshop", "AutoCAD", "WSLTerminal"};
                        for (int i = 0; i < opciones.length; i++) {
                            System.out.println((i + 1) + ". " + opciones[i]);
                        }

                        int progIdx = seleccionarNumero(sc, "Ingrese una opción:", 1, opciones.length) - 1;

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
                            System.out.println("Programa agregado: " + prog.getNombre());
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
                if (confirmar(sc, "\n¿Desea confirmar la compra de esta PC? (s/n)")) {
                    Ticket ticket = new Ticket(pcSeleccionada, "Sucursal Central");

                    boolean huboAdaptacion = false;
                    Compunent base = pcSeleccionada;
                    while (base instanceof PCDecorada decorada) {
                        base = decorada.getProgramas().isEmpty() ? base : ((PCDecorada) base).compu;
                    }

                    if (base instanceof Compu c) {
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

    // 🔹 Método auxiliar para confirmar S/N con validación
    private static boolean confirmar(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje + " ");
            String respuesta = sc.nextLine().trim().toLowerCase();
            if (respuesta.equals("s")) return true;
            if (respuesta.equals("n")) return false;
            System.out.println("⚠ Eso no es una opción válida. Intente nuevamente (s/n).");
        }
    }

    // 🔹 Método auxiliar para validar selección numérica segura
    private static int seleccionarNumero(Scanner sc, String mensaje, int min, int max) {
        int num;
        while (true) {
            System.out.print(mensaje + " ");
            try {
                num = Integer.parseInt(sc.nextLine());
                if (num >= min && num <= max) return num;
                System.out.println("⚠ Número fuera de rango (" + min + "-" + max + "). Intente de nuevo.");
            } catch (NumberFormatException e) {
                System.out.println("⚠ Entrada inválida. Ingrese un número.");
            }
        }
    }

    // 🔹 Método auxiliar para seleccionar componentes con validación
    private static int seleccionarComponente(Scanner sc, String tipo, List<String> modelos, ContratoFabrica fab) {
        int idx = -1;
        while (true) {
            System.out.println("\n--- Seleccione su " + tipo + " ---");
            for (int i = 0; i < modelos.size(); i++) {
                Pieza temp = (Pieza) fab.crearComponente(modelos.get(i));
                System.out.println((i + 1) + ". " + temp.getNombre() + " - $" + temp.getPrecio());
            }
            idx = seleccionarNumero(sc, "Ingrese el número de su elección:", 1, modelos.size()) - 1;
            return idx;
        }
    }
}
