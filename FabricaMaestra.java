public static class FabricaMaestra{
    
    public static ContratoFabrica getFabrica(String fabrica){
	switch(fabrica.toLowerCase()){
	case "cpu": return new FabricaCPU();
	case "ram": return new FabricaRAM();
	case "gpu": return new FabricaTarjeta();
	case "fuente": return new FabricaFuente();
	case "disco": return new FabricaDisco();
	case "madre": return new FabricaMadre();
	case "gabinete": return new FabricaGabinete();
	default: return null;
	    

	}

    }

}
