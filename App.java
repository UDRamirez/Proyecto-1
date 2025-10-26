import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirectorConstructor director = new DirectorConstructor();

        System.out.println("=== Bienvenido a la plataforma de MonosChinos MX ===");
        System.out.println("=== ¡Consulta alguna de nuestras computadoras o personaliza la tuya propia! ===");
         System.out.println("");
        
        

        boolean salir = false;
        Compunent pcSeleccionada = null;

        while (!salir) {
            System.out.println("\nSelecciona el tipo de computadora:");
            System.out.println("1- PC Económica");
            System.out.println("2- PC Premium");
            System.out.println("3- PC Personalizada");
            System.out.println("4- Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("\n=== Información de la PC Económica ===");
                    Compunent pcEco = director.construirPcEconomica();
                    System.out.println(pcEco.getDescripcion() + "\nTotal: $" + pcEco.getPrecio());

                    System.out.println("\n¿Deseas ordenar esta PC? (s/n)");
                    if (scanner.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("¡Tu computadora se ensamblará!");
                        pcSeleccionada = pcEco;
                        salir = true;
                    }
                    break;

                case 2:
                    System.out.println("\n=== Información de la PC Premium ===");
                    Compunent pcPrem = director.construirPcPremium();
                    System.out.println(pcPrem.getDescripcion() + "\nTotal: $" + pcPrem.getPrecio());

                    System.out.println("\n¿Deseas ordenar esta PC? (s/n)");
                    if (scanner.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("¡Tu computadora se ensamblará!");
                        pcSeleccionada = pcPrem;
                        salir = true;
                    }
                    break;

                case 3:
                    System.out.println("\n===¡Personalicemos tu PC! ===");

                    String cpu = elegirComponente("cpu", scanner);
                    String gpu = elegirComponente("gpu", scanner);
                    String ram = elegirComponente("ram", scanner);
                    String disco = elegirComponente("disco", scanner);
                    String madre = elegirComponente("madre", scanner);
                    String fuente = elegirComponente("fuente", scanner);
                    String gabinete = elegirComponente("gabinete", scanner);

                    System.out.println("\nSelecciona los programas que deseas agregar:");
                    List<Programa> programas = seleccionarProgramas(scanner);

                    pcSeleccionada = director.construirPcPersonalizada(
                        cpu, gpu, ram, disco, madre, fuente, gabinete, programas
                    );
                    salir = true;
                    break;

                case 4:
                    salir = true;
                    System.out.println("Gracias por visitar MonosChinos MX. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida, intenta nuevamente.");
            }
        }

        if (pcSeleccionada != null) {
            System.out.println("\n=== Pedido Confirmado ===");
            System.out.println(pcSeleccionada.getDescripcion());
            System.out.println("Precio Total: $" + pcSeleccionada.getPrecio());
        }

        scanner.close();
    }

    public static String elegirComponente(String tipo, Scanner scanner) {
        ContratoFabrica fabrica = FabricaMaestra.getFabrica(tipo);
        List<String> opciones = fabrica.getModelosDisponibles();

        System.out.println("Selecciona tu " + tipo + ":");
        for (int i = 0; i < opciones.size(); i++) {
            Pieza pieza = fabrica.crearComponente(opciones.get(i));
            System.out.println((i + 1) + "- " + opciones.get(i) + " - $" + (pieza != null ? pieza.getPrecio() : "N/A"));
        }

        int eleccion;
        do {
            System.out.print("Ingresa el número de tu elección: ");
            eleccion = scanner.nextInt();
        } while (eleccion < 1 || eleccion > opciones.size());
        scanner.nextLine(); // limpiar buffer

        return opciones.get(eleccion - 1);
    }

    public static List<Programa> seleccionarProgramas(Scanner scanner) {
        List<Programa> programasDisponibles = Arrays.asList(
            new Windows(),
            new Office(),
            new Photoshop(),
            new WSLTerminal(),
            new AutoCAD()
        );

        List<Programa> seleccionados = new ArrayList<>();
        boolean agregar = true;

        while (agregar) {
            System.out.println("\nProgramas disponibles:");
            for (int i = 0; i < programasDisponibles.size(); i++) {
                Programa p = programasDisponibles.get(i);
                System.out.println((i + 1) + "- " + p.getNombre() + " - $" + p.getPrecio());
            }
            System.out.println((programasDisponibles.size() + 1) + "- Terminar selección");

            System.out.print("Selecciona un programa para preinstalar en tu PC: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            if (opcion == programasDisponibles.size() + 1) {
                agregar = false;
            } else if (opcion >= 1 && opcion <= programasDisponibles.size()) {
                Programa elegido = programasDisponibles.get(opcion - 1);
                if (!seleccionados.contains(elegido)) {
                    seleccionados.add(elegido);
                    System.out.println(elegido.getNombre() + " agregado.");
                } else {
                    System.out.println("El programa ya fue agregado.");
                }
            } else {
                System.out.println("Opción inválida, intenta de nuevo.");
            }
        }

        return seleccionados;
    }
}
