import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DirectorConstructor director = new DirectorConstructor();
        System.out.println("=== ¡Bienvenido a la plataforma de MonosChinosMX! ===");
        System.out.println("===Por favor, consulta nuestras Pc's pre-hechas o haz la tuya propia===");

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSeleccione el tipo de computadora que desea:");
            System.out.println("1- PC Económica");
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
                    if (preguntarSN(sc, "\n¿Deseas ordenar esta PC? (s/n)")) {
                        pcSeleccionada = pcEcoPreview;
                    }
                }

                case 2 -> {
                    Compunent pcPremPreview = director.construirPcPremium();
                    System.out.println(pcPremPreview.getDescripcion());
                    if (preguntarSN(sc, "\n¿Deseas ordenar esta PC? (s/n)")) {
                        pcSeleccionada = pcPremPreview;
                    }
                }

                case 3 -> {
                    System.out.println("\n=== ¡Construyamos tu propia PC! ===");
                    Compu compuPersonal = new Compu();
                    List<Programa> programasPersonal = new ArrayList<>();
                    boolean huboIncompatibilidad = false;

                    //CPU
                    ContratoFabrica fabCPU = FabricaMaestra.getFabrica("cpu");
                    List<String> modelosCPU = fabCPU.getModelos();
                    int idxCPU = seleccionarComponente(sc, "CPU", modelosCPU, fabCPU);
                    CPU cpu = (CPU) fabCPU.crearComponente(modelosCPU.get(idxCPU));

                    //Motherboard
                    ContratoFabrica fabMadre = FabricaMaestra.getFabrica("madre");
                    List<String> modelosMadre = fabMadre.getModelos();
                    int idxMadre = seleccionarComponente(sc, "Motherboard", modelosMadre, fabMadre);
                    Madre madre = (Madre) fabMadre.crearComponente(modelosMadre.get(idxMadre));

                    // Compatibilidad
                    AdaptadorCPU adapCPU = new AdaptadorCPU(cpu);
                    AdaptadorMadre adapMadre = new AdaptadorMadre(madre);
                    if (!adapCPU.esCompatibleCon(adapMadre)) {
                        System.out.println("\n⚠ CPU y Motherboard no son compatibles.");
                        if (!preguntarSN(sc, "¿Desea continuar de todos modos? (s/n)")) {
                            System.out.println("No se añadieron CPU ni Motherboard.");
                        } else {
                            // marcar que hubo adaptación
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

                    //GPU
                    ContratoFabrica fabGPU = FabricaMaestra.getFabrica("gpu");
                    List<String> modelosGPU = fabGPU.getModelos();
                    int idxGPU = seleccionarComponente(sc, "GPU", modelosGPU, fabGPU);
                    compuPersonal.setGPU((GPU) fabGPU.crearComponente(modelosGPU.get(idxGPU)));

                    // RAMs
                    ContratoFabrica fabRAM = FabricaMaestra.getFabrica("ram");
                    List<String> modelosRAM = fabRAM.getModelos();
                    boolean agregarMasRAM = true;

                    while (agregarMasRAM) {
                        int idxRAM = seleccionarComponente(sc, "RAM", modelosRAM, fabRAM);
                        RAM nuevaRAM = (RAM) fabRAM.crearComponente(modelosRAM.get(idxRAM));
                        compuPersonal.addRAM(nuevaRAM);
                        System.out.println("RAM agregada: " + nuevaRAM.getNombre());
                        agregarMasRAM = preguntarSN(sc, "¿Desea agregar otra memoria RAM? (s/n)");
                    }

                    //Disco
                    ContratoFabrica fabDisco = FabricaMaestra.getFabrica("disco");
                    List<String> modelosDisco = fabDisco.getModelos();
                    boolean agregarMasDisco = true;

                    while (agregarMasDisco) {
                        int idxDisco = seleccionarComponente(sc, "Disco", modelosDisco, fabDisco);
                        Disco nuevoDisco = (Disco) fabDisco.crearComponente(modelosDisco.get(idxDisco));
                        compuPersonal.addDisco(nuevoDisco);
                        System.out.println("Disco agregado: " + nuevoDisco.getNombre());
                        agregarMasDisco = preguntarSN(sc, "¿Desea agregar otro disco? (s/n)");
                    }

                    //Fuente
                    ContratoFabrica fabFuente = FabricaMaestra.getFabrica("fuente");
                    List<String> modelosFuente = fabFuente.getModelos();
                    int idxFuente = seleccionarComponente(sc, "Fuente", modelosFuente, fabFuente);
                    compuPersonal.setFuente((Fuente) fabFuente.crearComponente(modelosFuente.get(idxFuente)));

                    //Gabinete
                    ContratoFabrica fabGabinete = FabricaMaestra.getFabrica("gabinete");
                    List<String> modelosGabinete = fabGabinete.getModelos();
                    int idxGabinete = seleccionarComponente(sc, "Gabinete", modelosGabinete, fabGabinete);
                    compuPersonal.setGabinete((Gabinete) fabGabinete.crearComponente(modelosGabinete.get(idxGabinete)));

                    //Programas
                    boolean agregarProgramas = true;
                    while (agregarProgramas) {
                        if (!preguntarSN(sc, "\n¿Desea agregar un programa? (s/n)")) break;

                        System.out.println("Seleccione el programa a agregar:");
                        String[] opciones = {"Windows", "Office", "Photoshop", "AutoCAD", "WSLTerminal"};
                        for (int i = 0; i < opciones.length; i++) {
                            System.out.println((i + 1) + ". " + opciones[i]);
                        }

                        if (!sc.hasNextInt()) {
                            System.out.println("Debe ingresar un número.");
                            sc.nextLine();
                            continue;
                        }
                        int progIdx = sc.nextInt() - 1;
                        sc.nextLine();

                        if (progIdx < 0 || progIdx >= opciones.length) {
                            System.out.println("Opción inválida, no se añadió programa.");
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

                    // Decorando la compu
                    Compunent pcFinal = compuPersonal;
                    for (Programa p : programasPersonal) {
                        pcFinal = new PCDecorada(pcFinal, p);
                    }

                    pcSeleccionada = pcFinal;

                    System.out.println("\n=== Detalles PC Personalizada ===");
                    System.out.println(pcSeleccionada.getDescripcion());

                
                    compuPersonal.setIncompatibilidad(huboIncompatibilidad);
                }

                case 0 -> {
                    continuar = false;
                    System.out.println("\nGracias por visitarnos, ¡Hasta pronto!");
                }

                default -> System.out.println("Opción no válida.");
            }

            if (pcSeleccionada != null) {
                if (preguntarSN(sc, "\n¿Deseas confirmar la compra de esta PC? (s/n)")) {
                    Ticket ticket = new Ticket(pcSeleccionada, "Sucursal Central");

                    // Revisar si hubo incompatibilidad
                    boolean huboAdaptacion = false;
                    Compunent base = pcSeleccionada;
                    while (base instanceof PCDecorada decorada) {
                        base = decorada.compu; // accedemos al compu base
                    }

                    if (base instanceof Compu c) {
                        huboAdaptacion = c.getIncompatibilidad();
                    }

                    System.out.println(ticket.getContenido());
                    
                }
            }
        }

        sc.close();
    }

    // Metodo para desplegar todos los tipos de un componente que hay
    private static int seleccionarComponente(Scanner sc, String tipo, List<String> modelos, ContratoFabrica fab) {
        int idx = -1;
        while (true) {
            System.out.println("\n--- Seleccione su " + tipo + " ---");
            for (int i = 0; i < modelos.size(); i++) {
                Pieza temp = (Pieza) fab.crearComponente(modelos.get(i));
                System.out.println((i + 1) + ". " + temp.getNombre() + " - $" + temp.getPrecio());
            }
            System.out.print("Ingrese el número de su elección: ");
            if (!sc.hasNextInt()) {
                System.out.println("Debe ingresar un número.");
                sc.nextLine();
                continue;
            }
            idx = sc.nextInt() - 1;
            sc.nextLine();
            if (idx >= 0 && idx < modelos.size()) break;
            System.out.println("Opción inválida, intente de nuevo.");
        }
        return idx;
    }

    //Método para respuestas SN porque si pasabas numero no salia xddd
    private static boolean preguntarSN(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje + " ");
            String respuesta = sc.nextLine().trim().toLowerCase();
            if (respuesta.equals("s")) return true;
            if (respuesta.equals("n")) return false;
            System.out.println("Eso no es una opción. Por favor, ingrese 's' o 'n'.");
        }
    }
}
