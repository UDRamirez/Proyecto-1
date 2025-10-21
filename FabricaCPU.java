public class FabricaCPU implements ContratoFabrica{

    @Override
    public Pieza crearComponente(String modelo){
	switch(modelo.toLowerCase().trim()){
	    case "core i3-13100":
                return new CPU("Core i3-13100", "Intel", 1500, 4);
            case "core i5-13600k":
                return new CPU("Core i5-13600K", "Intel", 3200, 6);
            case "core i7-13700k":
                return new CPU("Core i7-13700K", "Intel", 5800, 8);
            case "core i9-13900k":
                return new CPU("Core i9-13900K", "Intel", 9500, 16);
	default:
	    System.out.println("No se ha encontrado este modelo: " + modelo);
	    return null;

	}


    }




}
