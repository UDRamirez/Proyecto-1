public class FabricaGabinete implements ContratoFabrica{

    public Pieza crearComponente(String modelo){
	switch(modelo.toLowerCase().trim()){
	case  "H6 Flow ATX":
		return new Gabinete("H6 Flow ATX", "NZXT", 2800);
	case "Lancer ATX":
		return new Gabinete("Lancer ATX", "Yeiyian", 1500);
	   

	default:
	    System.out.println("No se ha encontrado ese modelo:  " + modelo);
	    return null;
	}
	

    }


}
