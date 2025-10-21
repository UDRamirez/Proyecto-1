public class FabricaTarjeta implements ContratoFabrica{

    public Pieza crearComponente(String modelo){
	switch(modelo.toLowerCase().trim()){
	case  "GTX 1660":
		return new GPU("GTX 1660", "NVIDIA", 3500);
	case  "RTX 3060":
		return new GPU("RTX 3060", "NVIDIA", 6500);
	case  "RTX 4070":
		return new GPU("RTX 4070", "NVIDIA", 13000);
	case  "RTX 4080":
		return new GPU("RTX 4080", "NVIDIA", 25000);
	case  "RTX 4090":
		return new GPU("RTX 4090", "NVIDIA", 40000);

	default:
	    System.out.println("No se ha encontrado ese modelo:  " +  modelo);
	    return null;
	}
	

    }

}
