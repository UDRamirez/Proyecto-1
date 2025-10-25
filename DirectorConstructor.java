/**
 * Clase {@code DirectorConstructor}.
 * <p>
 * Actúa como director en el patrón Builder para la construcción de computadoras.
 * Proporciona métodos predefinidos para construir PCs económicas, premium
 * o personalizadas utilizando un {@link ArmadaBuilder} y fábricas de componentes
 * a través de {@link FabricaMaestra}.
 * </p>
 */
public class DirectorConstructor {

    /**
     * Construye una computadora económica con componentes predefinidos.
     *
     * @return un objeto {@link Compu} con la configuración económica.
     */
    public Compu construirPcEconomica() {
        ArmadaBuilder builder = new ArmadaBuilder();

        ContratoFabrica fcpu = FabricaMaestra.getFabrica("cpu");
        ContratoFabrica fgpu = FabricaMaestra.getFabrica("gpu");
        ContratoFabrica fram = FabricaMaestra.getFabrica("ram");
        ContratoFabrica fmadre = FabricaMaestra.getFabrica("madre");
        ContratoFabrica fdisco = FabricaMaestra.getFabrica("disco");
        ContratoFabrica ffuente = FabricaMaestra.getFabrica("fuente");
        ContratoFabrica fgabinete = FabricaMaestra.getFabrica("gabinete");

        builder.agregarCPU((CPU) fcpu.crearComponente("core i3-13100"));
        builder.agregarGPU((GPU) fgpu.crearComponente("GTX 1660"));
        builder.agregarRAM((RAM) fram.crearComponente("Kingston 8-GB"));
        builder.agregarMadre((Madre) fmadre.crearComponente("TUF Gaming B760-Plus"));
        builder.agregarDisco((Disco) fdisco.crearComponente("Kingston 500-GB"));
        builder.agregarFuente((Fuente) ffuente.crearComponente("XPG 500-W"));
        builder.agregarGabinete((Gabinete) fgabinete.crearComponente("Lancer ATX"));

          Compu pcBase = builder.build();

    Compunent pcConWindows = new PCDecorada(pcBase, new Windows());
    Compunent pcFinal = new PCDecorada(pcConWindows, new Office());

    return pcFinal;
    }

    /**
     * Construye una computadora premium con componentes de alta gama predefinidos.
     *
     * @return un objeto {@link Compu} con la configuración premium.
     */
    public Compu construirPcPremium() {
        ArmadaBuilder builder = new ArmadaBuilder();

        ContratoFabrica fcpu = FabricaMaestra.getFabrica("cpu");
        ContratoFabrica fgpu = FabricaMaestra.getFabrica("gpu");
        ContratoFabrica fram = FabricaMaestra.getFabrica("ram");
        ContratoFabrica fmadre = FabricaMaestra.getFabrica("madre");
        ContratoFabrica fdisco = FabricaMaestra.getFabrica("disco");
        ContratoFabrica ffuente = FabricaMaestra.getFabrica("fuente");
        ContratoFabrica fgabinete = FabricaMaestra.getFabrica("gabinete");

        builder.agregarCPU((CPU) fcpu.crearComponente("Core i9-13900k"));
        builder.agregarGPU((GPU) fgpu.crearComponente("RTX 4090"));
        builder.agregarRAM((RAM) fram.crearComponente("Kingston 32-GB"));
        builder.agregarMadre((Madre) fmadre.crearComponente("MAG B760 Tomahawk"));
        builder.agregarDisco((Disco) fdisco.crearComponente("Kingston 4-TB"));
        builder.agregarFuente((Fuente) ffuente.crearComponente("XPG 1000-W"));
        builder.agregarGabinete((Gabinete) fgabinete.crearComponente("H6 Flow ATX"));

        return builder.build();
    }

    /**
     * Construye una computadora personalizada según los componentes especificados por el usuario.
     *
     * @param cpu nombre o modelo del procesador.
     * @param gpu nombre o modelo de la tarjeta gráfica.
     * @param ram nombre o modelo de la memoria RAM.
     * @param disco nombre o modelo del disco.
     * @param madre nombre o modelo de la placa madre.
     * @param fuente nombre o modelo de la fuente de poder.
     * @param gabinete nombre o modelo del gabinete.
     * @return un objeto {@link Compu} con la configuración personalizada.
     */
    public Compu construirPcPersonalizada(String cpu, String gpu, String ram, String disco,
                                          String madre, String fuente, String gabinete) {
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

        return builder.build();
    }

}
