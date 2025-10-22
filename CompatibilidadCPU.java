import java.util.*;
public class CompatibilidadCPU{

    
    public boolean esCompatible(CPU cpu, Madre placa){
	return cpu.getMarca().equalsIgnoreCase(placa.getTipoChip());

    }
    
    public List<Madre> getPiezasAlternativas(CPU cpu, List<Madre> placas){
	List<Madre> resultado = new ArrayList<>();

	for(Madre e: placas){
	    if(esCompatible(cpu, e)){
		resultado.add(e);
		    }
	}
	return resultado;
    }
   
    public List<CPU> getPiezasAlternativas(Madre madre, List<CPU> cpu){
	List<CPU> resultado = new ArrayList<>();

	for(CPU e: cpu){
	    if(esCompatible(e, madre)){
		resultado.add(e);
		    }
	}
	return resultado;
    }

}
