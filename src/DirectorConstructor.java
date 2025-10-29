import java.util.List;

/**
 * Clase {@code DirectorConstructor}.
 * <p>
 * Esta clase actua como director en el patron Builder, encargandose de la construccion
 * de diferentes tipos de computadoras preconfiguradas o personalizadas.
 * Utiliza {@link ArmadaBuilder} y {@link ContratoFabrica} para armar los componentes.
 * </p>
 */
public class DirectorConstructor {

    /**
     * Construye una computadora economica preconfigurada.
     * <p>
     * Agrega componentes basicos y algunos programas preinstalados.
     * </p>
     *
     * @return un objeto {@link Compunent} representando la PC economica.
     */
    public Compunent construirPcEconomica() {
        ArmadaBuilder builder = new ArmadaBuilder();

        ContratoFabrica fcpu = FabricaMaestra.getFabrica("cpu");
        ContratoFabrica fgpu = FabricaMaestra.getFabrica("gpu");
        ContratoFabrica fram = FabricaMaestra.getFabrica("ram");
        ContratoFabrica fmadre = FabricaMaestra.getFabrica("madre");
        ContratoFabrica fdisco = FabricaMaestra.getFabrica("disco");
        ContratoFabrica ffuente = FabricaMaestra.getFabrica("fuente");
        ContratoFabrica fgabinete = FabricaMaestra.getFabrica("gabinete");

        builder.agregarCPU((CPU) fcpu.crearComponente("Core i3-13100"));
        builder.agregarGPU((GPU) fgpu.crearComponente("GTX 1660"));
        builder.agregarRAM((RAM) fram.crearComponente("Kingston 8-GB"));
        builder.agregarMadre((Madre) fmadre.crearComponente("TUF Gaming B760-Plus"));
        builder.agregarDisco((Disco) fdisco.crearComponente("Kingston 500-GB"));
        builder.agregarFuente((Fuente) ffuente.crearComponente("XPG 500-W"));
        builder.agregarGabinete((Gabinete) fgabinete.crearComponente("Lancer ATX"));

        Compunent pc = builder.build();

        pc = new PCDecorada(pc, new Windows());
        pc = new PCDecorada(pc, new Office());

        return pc;
    }

    /**
     * Construye una computadora premium preconfigurada.
     * <p>
     * Agrega componentes de gama alta y todos los programas disponibles.
     * </p>
     *
     * @return un objeto {@link Compunent} representando la PC premium.
     */
    public Compunent construirPcPremium() {
        ArmadaBuilder builder = new ArmadaBuilder();

        ContratoFabrica fcpu = FabricaMaestra.getFabrica("cpu");
        ContratoFabrica fgpu = FabricaMaestra.getFabrica("gpu");
        ContratoFabrica fram = FabricaMaestra.getFabrica("ram");
        ContratoFabrica fmadre = FabricaMaestra.getFabrica("madre");
        ContratoFabrica fdisco = FabricaMaestra.getFabrica("disco");
        ContratoFabrica ffuente = FabricaMaestra.getFabrica("fuente");
        ContratoFabrica fgabinete = FabricaMaestra.getFabrica("gabinete");

        builder.agregarCPU((CPU) fcpu.crearComponente("Core i9-13900K"));
        builder.agregarGPU((GPU) fgpu.crearComponente("RTX 4090"));
        builder.agregarRAM((RAM) fram.crearComponente("Kingston 32-GB"));
        builder.agregarMadre((Madre) fmadre.crearComponente("MAG B760 Tomahawk"));
        builder.agregarDisco((Disco) fdisco.crearComponente("Kingston 4-TB"));
        builder.agregarFuente((Fuente) ffuente.crearComponente("XPG 1000-W"));
        builder.agregarGabinete((Gabinete) fgabinete.crearComponente("H6 Flow ATX"));

        Compunent pc = builder.build();

        pc = new PCDecorada(pc, new Windows());
        pc = new PCDecorada(pc, new Office());
        pc = new PCDecorada(pc, new Photoshop());
        pc = new PCDecorada(pc, new AutoCAD());
        pc = new PCDecorada(pc, new WSLTerminal());

        return pc;
    }

    /**
     * Construye una computadora personalizada.
     * <p>
     * Permite especificar cada componente y agregar una lista de programas,
     * evitando duplicados en la instalacion.
     * </p>
     *
     * @param cpu modelo de CPU a usar.
     * @param gpu modelo de GPU a usar.
     * @param ram modelo de RAM a usar.
     * @param disco modelo de disco a usar.
     * @param madre modelo de placa madre a usar.
     * @param fuente modelo de fuente de poder a usar.
     * @param gabinete modelo de gabinete a usar.
     * @param programas lista de programas a instalar.
     * @return un objeto {@link Compunent} representando la PC personalizada.
     */
    public Compunent construirPcPersonalizada(
            String cpu, String gpu, String ram, String disco, String madre,
            String fuente, String gabinete, List<Programa> programas) {

        ArmadaBuilder builder = new ArmadaBuilder();

        ContratoFabrica fcpu = FabricaMaestra.getFabrica("cpu");
        ContratoFabrica fgpu = FabricaMaestra.getFabrica("gpu");
        ContratoFabrica fram = FabricaMaestra.getFabrica("ram");
        ContratoFabrica fmadre = FabricaMaestra.getFabrica("madre");
        ContratoFabrica fdisco = FabricaMaestra.getFabrica("disco");
        ContratoFabrica ffuente = FabricaMaestra.getFabrica("fuente");
        ContratoFabrica fgabinete = FabricaMaestra.getFabrica("gabinete");

        builder.agregarCPU((CPU) fcpu.crearComponente(cpu));
        builder.agregarGPU((GPU) fgpu.crearComponente(gpu));
        builder.agregarRAM((RAM) fram.crearComponente(ram));
        builder.agregarMadre((Madre) fmadre.crearComponente(madre));
        builder.agregarDisco((Disco) fdisco.crearComponente(disco));
        builder.agregarFuente((Fuente) ffuente.crearComponente(fuente));
        builder.agregarGabinete((Gabinete) fgabinete.crearComponente(gabinete));

        Compunent pc = builder.build();

        // Agregar programas personalizados, evitando duplicados
        if (programas != null && !programas.isEmpty()) {
            for (Programa prog : programas) {
                boolean existe = pc.getProgramas().stream()
                        .anyMatch(p -> p.getNombre().equalsIgnoreCase(prog.getNombre()));
                if (!existe) {
                    pc = new PCDecorada(pc, prog);
                }
            }
        }

        return pc;
    }
}
