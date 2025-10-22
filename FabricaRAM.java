public class FabricaRAM implements ContratoFabrica{

    public Pieza crearComponente(String modelo){
	switch(modelo){
	case  "Adata 8-GB" :
		return new RAM("Adata 8-GB", "Adata", 500, 8);
	case  "Adata 16-GB":
		return new RAM("Adata 16-GB", "Adata", 1000, 16);
	case  "Adata 32-GB":
		return new RAM("Adata 32-GB", "Adata", 1500, 32);
	case  "Kingston 8-GB":
		return new RAM("Kingston 8-GB", "Kingston", 550, 8);
	case  "Kingston 16-GB":
		return new RAM("Kingston 16-GB", "Kingston", 1300, 16);
	case  "Kingston 32-GB":
		return new RAM("Kingston 32-GB", "Kingston", 2000, 32);
	default:
	    System.out.println("No se ha encontrado ese modelo:  " +  modelo);
	    return null;
	}
	

    }




}
