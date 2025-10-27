import java.util.List;
import java.util.Scanner;

/**
 * Clase principal de la aplicación RockBuster PC.
 * <p>
 * Permite al usuario seleccionar entre distintos tipos de computadoras
 * (económica, premium o personalizada), mostrando los componentes y precios.
 * En la opción personalizada, el usuario elige cada pieza con validación
 * de compatibilidad entre CPU y tarjeta madre.
 * </p>
 */
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
                    // Mostrar info de la Económica antes de confirmar
                    Compunent pcEcoPreview = director.construirPcEconomica();
                    System.out.println("\n=== Detalles PC Económica ===");
                    System.out.println(pcEcoPreview);

                    System.out.println("\n¿Desea ordenar esta PC? (s/n)");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        pcSeleccionada = pcEcoPreview;
                    }
                    break;

                case 2:
                    // Mostrar info de la Premium antes de confirmar
                    Compunent pcPremPreview = director.construirPcPremium();
                    System.out.println("\n=== Detalles PC Premium ===");
                    System.out.println(pcPremPreview);

                    System.out.println("\n¿Desea ordenar esta PC? (s/n)");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        pcSeleccionada = pcPremPreview;
                    }
                    break;

                case 3:
                    System.out.println("\n=== Construye tu PC Personalizada ===");
                    pcSeleccionada = new Compu();

                    // === CPU ===
                    ContratoFabrica fabCPU = FabricaMaestra.getFabrica("cpu");
                    List<String> modelosCPU = fabCPU.getModelos();
                    System.out.println("\n--- Seleccione su CPU ---");
                    for (int i = 0; i < modelosCPU.size(); i++) {
                        CPU temp = (CPU) fabCPU.crearComponente(modelosCPU.get(i));
                        System.out.println((i + 1) + ". " + temp.getNombre() + " - $" + temp.getPrecio());
                    }
                    int idxCPU = sc.nextInt() - 1;
                    sc.nextLine();
                    CPU cpu = (CPU) fabCPU.crearComponente(modelosCPU.get(idxCPU));

                    // === Motherboard ===
                    ContratoFabrica fabMadre = FabricaMaestra.getFabrica("madre");
                    List<String> modelosMadre = fabMadre.getModelos();
                    System.out.println("\n--- Seleccione su Placa Madre ---");
                    for (int i = 0; i < modelosMadre.size(); i++) {
                        Madre temp = (Madre) fabMadre.crearComponente(modelosMadre.get(i));
                        System.out.println((i + 1) + ". " + temp.getNombre() + " - $" + temp.getPrecio());
                    }
                    int idxMadre = sc.nextInt() - 1;
                    sc.nextLine();
                    Madre madre = (Madre) fabMadre.crearComponente(modelosMadre.get(idxMadre));

                    // Verificar compatibilidad
                    AdaptadorCPU adapCPU = new AdaptadorCPU(cpu);
                    AdaptadorMadre adapMadre = new AdaptadorMadre(madre);
                    if (!adapCPU.esCompatibleCon(adapMadre)) {
                        System.out.println("\n⚠ ¡Atención! CPU y Motherboard no son compatibles.");
                        System.out.println("¿Desea continuar de todos modos? (s/n)");
                        if (!sc.nextLine().equalsIgnoreCase("s")) {
                            System.out.println("No se añadieron CPU ni Motherboard.");
                            break;
                        }
                    }

                    pcSeleccionada.setCPU(cpu);
                    pcSeleccionada.setMadre(madre);

                    // === GPU ===
                    ContratoFabrica fabGPU = FabricaMaestra.getFabrica("gpu");
                    List<String> modelosGPU = fabGPU.getModelos();
                    System.out.println("\n--- Seleccione su Tarjeta Gráfica ---");
                    for (int i = 0; i < modelosGPU.size(); i++) {
                        GPU temp = (GPU) fabGPU.crearComponente(modelosGPU.get(i));
                        System.out.println((i + 1) + ". " + temp.getNombre() + " - $" + temp.getPrecio());
                    }
                    int idxGPU = sc.nextInt() - 1;
                    sc.nextLine();
                    pcSeleccionada.setGPU((GPU) fabGPU.crearComponente(modelosGPU.get(idxGPU)));

                    // === RAM ===
                    ContratoFabrica fabRAM = FabricaMaestra.getFabrica("ram");
                    List<String> modelosRAM = fabRAM.getModelos();
                    System.out.println("\n--- Seleccione su Memoria RAM ---");
                    for (int i = 0; i < modelosRAM.size(); i++) {
                        RAM temp = (RAM) fabRAM.crearComponente(modelosRAM.get(i));
                        System.out.println((i + 1) + ". " + temp.getNombre() + " - $" + temp.getPrecio());
                    }
                    int idxRAM = sc.nextInt() - 1;
                    sc.nextLine();
                    pcSeleccionada.addRAM((RAM) fabRAM.crearComponente(modelosRAM.get(idxRAM)));

                    // === Disco ===
                    ContratoFabrica fabDisco = FabricaMaestra.getFabrica("disco");
                    List<String> modelosDisco = fabDisco.getModelos();
                    System.out.println("\n--- Seleccione su Disco ---");
                    for (int i = 0; i < modelosDisco.size(); i++) {
                        Disco temp = (Disco) fabDisco.crearComponente(modelosDisco.get(i));
                        System.out.println((i + 1) + ". " + temp.getNombre() + " - $" + temp.getPrecio());
                    }
                    int idxDisco = sc.nextInt() - 1;
                    sc.nextLine();
                    pcSeleccionada.addDisco((Disco) fabDisco.crearComponente(modelosDisco.get(idxDisco)));

                    // === Fuente ===
                    ContratoFabrica fabFuente = FabricaMaestra.getFabrica("fuente");
                    List<String> modelosFuente = fabFuente.getModelos();
                    System.out.println("\n--- Seleccione su Fuente de Poder ---");
                    for (int i = 0; i < modelosFuente.size(); i++) {
                        Fuente temp = (Fuente) fabFuente.crearComponente(modelosFuente.get(i));
                        System.out.println((i + 1) + ". " + temp.getNombre() + " - $" + temp.getPrecio());
                    }
                    int idxFuente = sc.nextInt() - 1;
                    sc.nextLine();
                    pcSeleccionada.setFuente((Fuente) fabFuente.crearComponente(modelosFuente.get(idxFuente)));

                    // === Gabinete ===
                    ContratoFabrica fabGabinete = FabricaMaestra.getFabrica("gabinete");
                    List<String> modelosGabinete = fabGabinete.getModelos();
                    System.out.println("\n--- Seleccione su Gabinete ---");
                    for (int i = 0; i < modelosGabinete.size(); i++) {
                        Gabinete temp = (Gabinete) fabGabinete.crearComponente(modelosGabinete.get(i));
                        System.out.println((i + 1) + ". " + temp.getNombre() + " - $" + temp.getPrecio());
                    }
                    int idxGabinete = sc.nextInt() - 1;
                    sc.nextLine();
                    pcSeleccionada.setGabinete((Gabinete) fabGabinete.crearComponente(modelosGabinete.get(idxGabinete)));

                    break;

                case 0:
                    continuar = false;
                    System.out.println("\nGracias por usar RockBuster PC. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

            // === Si se eligió una PC ===
            if (pcSeleccionada != null) {
                Ticket ticket = new Ticket(pcSeleccionada, "Sucursal Central");

                boolean huboAdaptacion = (pcSeleccionada.getCPU() != null && pcSeleccionada.getCPU().getAdaptado())
                        || (pcSeleccionada.getMadre() != null && pcSeleccionada.getMadre().getAdaptado());

                System.out.println("\n===== TICKET DE COMPRA =====");
                System.out.println(ticket.getContenido());

                if (huboAdaptacion) {
                    System.out.println("⚠ Se realizaron adaptaciones en CPU o Motherboard por incompatibilidad.");
                }
            }
        }

        sc.close();
    }
}
