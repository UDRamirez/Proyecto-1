import java.util.List;
import java.util.Scanner;

/**
 * Clase principal de la aplicación RockBusterPC.
 * <p>
 * Permite al usuario seleccionar entre distintos tipos de computadoras:
 * económica, gamer o personalizada. En el caso de la computadora personalizada,
 * el usuario elige cada componente paso a paso.
 * </p>
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DirectorConstructor director = new DirectorConstructor();

        System.out.println("=====================================");
        System.out.println("   Bienvenido a RockBusterPC 💻");
        System.out.println("=====================================\n");

        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ver información de PC Económica");
            System.out.println("2. Ver información de PC Gamer");
            System.out.println("3. Ordenar PC Económica");
            System.out.println("4. Ordenar PC Gamer");
            System.out.println("5. Construir PC Personalizada");
            System.out.println("6. Salir");
            System.out.print("Ingrese su elección: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    Compu econInfo = director.construirPcEconomica();
                    System.out.println("\n=== Información de PC Económica ===");
                    System.out.println(econInfo.getDescripcion());
                    System.out.println("Precio total: $" + econInfo.getPrecio());
                    break;

                case 2:
                    Compu gamerInfo = director.construirPcPremium();
                    System.out.println("\n=== Información de PC Gamer ===");
                    System.out.println(gamerInfo.getDescripcion());
                    System.out.println("Precio total: $" + gamerInfo.getPrecio());
                    break;

                case 3:
                    confirmarCompra(director.construirPcEconomica(), sc, "Económica");
                    break;

                case 4:
                    confirmarCompra(director.construirPcPremium(), sc, "Gamer");
                    break;

                case 5:
                    Compu personalizada = construirPcPersonalizadaInteractiva(sc, director);
                    confirmarCompra(personalizada, sc, "Personalizada");
                    break;

                case 6:
                    salir = true;
                    System.out.println("\nGracias por visitar RockBusterPC. ¡Vuelva pronto!");
                    break;

                default:
                    System.out.println("❌ Opción no válida, intente nuevamente.\n");
            }
        }

        sc.close();
    }

    /**
     * Pide confirmación de compra y muestra el resumen final.
     */
    private static void confirmarCompra(Compunent compu, Scanner sc, String tipo) {
        System.out.println("\n=== Resumen de PC " + tipo + " ===");
        System.out.println(compu.getDescripcion());
        System.out.println("Precio total: $" + compu.getPrecio());
        System.out.print("\n¿Desea confirmar su pedido? (s/n): ");
        String conf = sc.nextLine();

        if (conf.equalsIgnoreCase("s")) {
            System.out.println("\n✅ ¡Pedido confirmado! Su PC " + tipo + " ha sido ensamblada con éxito.");
        } else {
            System.out.println("\n❌ Pedido cancelado.");
        }
        System.out.println();
    }

    /**
     * Permite construir una PC personalizada paso a paso.
     */
    private static Compu construirPcPersonalizadaInteractiva(Scanner sc, DirectorConstructor director) {
        System.out.println("\n=== Construcción de PC Personalizada ===");

        System.out.println("\nSeleccione su CPU:");
        String cpu = elegirComponente(sc, "cpu");

        System.out.println("\nSeleccione su GPU:");
        String gpu = elegirComponente(sc, "gpu");

        System.out.println("\nSeleccione su RAM:");
        String ram = elegirComponente(sc, "ram");

        System.out.println("\nSeleccione su Disco:");
        String disco = elegirComponente(sc, "disco");

        System.out.println("\nSeleccione su Tarjeta Madre:");
        String madre = elegirComponente(sc, "madre");

        System.out.println("\nSeleccione su Fuente de poder:");
        String fuente = elegirComponente(sc, "fuente");

        System.out.println("\nSeleccione su Gabinete:");
        String gabinete = elegirComponente(sc, "gabinete");

        System.out.println("\nConstruyendo su PC personalizada...");
        Compu pc = director.construirPcPersonalizada(cpu, gpu, ram, disco, madre, fuente, gabinete);

        System.out.println("\n✅ PC personalizada creada con éxito.");
        return pc;
    }

    /**
     * Muestra los componentes disponibles según el tipo y devuelve el seleccionado.
     */
    private static String elegirComponente(Scanner sc, String tipo) {
        ContratoFabrica fabrica = FabricaMaestra.getFabrica(tipo);
        List<String> disponibles = fabrica.getModelosDisponibles();

        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println((i + 1) + ". " + disponibles.get(i));
        }

        int opcion;
        do {
            System.out.print("Ingrese el número de su elección: ");
            opcion = sc.nextInt();
            sc.nextLine();
        } while (opcion < 1 || opcion > disponibles.size());

        return disponibles.get(opcion - 1);
    }
}
