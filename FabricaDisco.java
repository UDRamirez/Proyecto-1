public class FabricaDisco implements ContratoFabrica{

     public Pieza crearComponente(String modelo){
	switch(modelo){
	    //HDD
	case  "Western Digital Blue 500-GB":
		return new Disco("Western Digital Blue 500-GB", "Western Digital Blue", 450, "HDD", 500);
	case  "Western Digital Blue 1-TB":
		return new Disco("Western Digital Blue 1-TB", "Western Digital Blue", 600, "HDD", 1024);
	case  "Seagate Barracuda 1-TB":
		return new Disco("Seagate Barracuda 1-TB", "Seagate Barracuda", 550, "HDD", 1024);
	case  "Seagate Barracuda 2-TB":
		return new Disco("Seagate Barracuda 2-TB", "Seagate Barracuda", 800, "HDD", 2048);

	    // SSD
	case  "Kingston 500-GB":
		return new Disco("Kingston 500-GB", "Kingston", 500, "SSD", 500);
	case  "Kingston 1-TB":
		return new Disco("Kingston 1-TB", "Kingston", 800, "SSD", 1024);
	case  "Kingston 2-TB":
		return new Disco("Kingston 2-TB", "Kingston", 1600, "SSD", 2048);
	case  "Kingston 4-TB":
		return new Disco("Kingston 4-TB", "Kingston", 3200, "SSD", 8096);
	default:
	    System.out.println("No se ha encontrado ese modelo (Disco):  " +  modelo);
	    return null;
	}
    
     }

}
