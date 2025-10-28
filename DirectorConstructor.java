import java.util.List;

public class DirectorConstructor {

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

        // Construir la PC base
        Compunent pc = builder.build();

        // Agregar programas antes de generar precio/descripcion
        pc = new PCDecorada(pc, new Windows());
        pc = new PCDecorada(pc, new Office());

        return pc;
    }

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

        // Agregar todos los programas de alta gama
        pc = new PCDecorada(pc, new Windows());
        pc = new PCDecorada(pc, new Office());
        pc = new PCDecorada(pc, new Photoshop());
        pc = new PCDecorada(pc, new AutoCAD());
        pc = new PCDecorada(pc, new WSLTerminal());

        return pc;
    }

    // Para PC personalizada: recibir la lista de programas y agregarlos aquí
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
