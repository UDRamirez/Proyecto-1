public class FabricaMadre implements ContratoFabrica{


    public Pieza crearComponente(String modelo){
	switch(modelo.toLowerCase().trim()){
	case  "ROG Maximus Z790 Hero" :
		return new Madre("ROG Maximus Z790 Hero", "ASUS", 14000, "Chipset Intel Z790");
	case  "TUF Gaming B760-Plus":
		return new Madre("TUF Gaming B760-Plus", "ASUS", 3800, "Chipset Intel B760");
	case  "MEG Z790 Godlike":
		return new Madre("MEG Z790 Godlike", "MSI", 25000, "Chipset Intel Z790");
	case  "MAG B760 Tomahawk":
		return new Madre("MAG B760 Tomahawk", "MSI", 4200, "Chipset Intel B760");
	  
	default:
	    System.out.println("No se ha encontrado ese modelo:  " + modelo);
	    return null;
	}
	

    }
}
