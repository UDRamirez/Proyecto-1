public class DirectorConstructor{
    
   
    
    public Compu construirPcEconomica(){
	 ArmadaBuilder builder = new ArmadaBuilder();

	 ContratoFabrica fcpu = FabricaMaestra.getFabrica("cpu");
	 ContratoFabrica fgpu = FabricaMaestra.getFabrica("gpu");
	 ContratoFabrica fram= FabricaMaestra.getFabrica("ram");
	 ContratoFabrica fmadre= FabricaMaestra.getFabrica("madre");
	 ContratoFabrica fdisco= FabricaMaestra.getFabrica("disco");
	 ContratoFabrica ffuente= FabricaMaestra.getFabrica("fuente");
	 ContratoFabrica fgabinete= FabricaMaestra.getFabrica("gabinete");

	 builder.agregarCPU((CPU) fcpu.crearComponente("core i3-13100"));
	 builder.agregarGPU((GPU) fgpu.crearComponente("GTX 1660"));
	 builder.agregarRAM((RAM) fram.crearComponente("Kingston 8-GB"));
	 builder.agregarMadre((Madre) fmadre.crearComponente("TUF Gaming B760-Plus"));
	 builder.agregarDisco((Disco) fdisco.crearComponente("Kingston 500-GB"));
	 builder.agregarFuente((Fuente) ffuente.crearComponente("XPG 500-W"));
	 builder.agregarGabinete((Gabinete) fgabinete.crearComponente("Lancer ATX"));

        return builder.build();
    }
     public Compu construirPcPremium(){
	 ArmadaBuilder builder = new ArmadaBuilder();

	 ContratoFabrica fcpu= FabricaMaestra.getFabrica("cpu");
	 ContratoFabrica fgpu= FabricaMaestra.getFabrica("gpu");
	 ContratoFabrica fram= FabricaMaestra.getFabrica("ram");
	 ContratoFabrica fmadre= FabricaMaestra.getFabrica("madre");
	 ContratoFabrica fdisco= FabricaMaestra.getFabrica("disco");
	 ContratoFabrica ffuente= FabricaMaestra.getFabrica("fuente");
	 ContratoFabrica fgabinete= FabricaMaestra.getFabrica("gabinete");

	 builder.agregarCPU((CPU) fcpu.crearComponente("Core i9-13900k"));
	 builder.agregarGPU((GPU) fgpu.crearComponente("RTX 4090"));
	 builder.agregarRAM((RAM) fram.crearComponente("Kingston 32-GB"));
	 builder.agregarMadre((Madre) fmadre.crearComponente("MAG B760 Tomahawk"));
	 builder.agregarDisco((Disco) fdisco.crearComponente("Kingston 4-TB"));
	 builder.agregarFuente((Fuente) ffuente.crearComponente("XPG 1000-W"));
	 builder.agregarGabinete((Gabinete) fgabinete.crearComponente("H6 Flow ATX"));

        return builder.build();
    }
     public Compu construirPcPersonalizada(String cpu, String gpu, String ram, String disco,
                                           String madre, String fuente, String gabinete){
	 ArmadaBuilder builder = new ArmadaBuilder();
	 ContratoFabrica fcpu= FabricaMaestra.getFabrica("cpu");
	 ContratoFabrica fgpu= FabricaMaestra.getFabrica("gpu");
	 ContratoFabrica fram= FabricaMaestra.getFabrica("ram");
	 ContratoFabrica fmadre= FabricaMaestra.getFabrica("madre");
	 ContratoFabrica fdisco= FabricaMaestra.getFabrica("disco");
	 ContratoFabrica ffuente= FabricaMaestra.getFabrica("fuente");
	 ContratoFabrica fgabinete= FabricaMaestra.getFabrica("gabinete");

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
