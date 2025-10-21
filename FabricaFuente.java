public class FabricaFuente implements ContratoFabrica{

    public Pieza crearComponente(String modelo){
	switch(modelo.toLowerCase().trim()){
	    
	case   "EVGA 800-W":
		return new Fuente("EVGA 800-W", "EVGA", 2200, 800);
	case   "EVGA 1000-W":
		return new Fuente("EVGA 1000-W", "EVGA", 3800, 1000);
	case   "EVGA 1500-W":
		return new Fuente("EVGA 1500-W", "EVGA", 9500, 1500);
	case  "Corsair 800-W":
		return new Fuente("Corsair 800-W", "Corsair", 2500, 800);
	case  "Corsair 1200-W":
		return new Fuente("Corsair 1200-W", "Corsair", 5500, 1200);
	case  "Corsair 1500-W":
		return new Fuente("Corsair 1500-W", "Corsair", 8000, 1500);
	case  "XPG 500-W":
		return new Fuente("XPG 500-W", "Kingston", 1000, 500);
	case  "XPG 700-W":
		return new Fuente("XPG 700-W", "Kingston", 1500, 700);
	case  "XPG 1000-W":
		return new Fuente("XPG 1000-W", "Kingston", 3000, 1000);
	default:
	    System.out.println("No se ha encontrado ese modelo:  " + modelo);
	    return null;
	}

    }
}
