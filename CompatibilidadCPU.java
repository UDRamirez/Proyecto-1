import java.util.*;
public class CompatibilidadCPU{

    
    public boolean esCompatible(CPU cpu, Madre placa){
	cpu.getMarca().toLowerCase().equals(placa.getTipoChip().toLowerCase()) ? return true : return false;

    }
    @Override
    public List<Madre> getPiezasAlternativas(CPU cpu, List<Madre> placas){
	List<Madre> resultado = new ArrayList<>();

	for(Madre e: placas){
	    if(esCompatible(cpu, e)){
		resultado.add(e)
		    }
	}
	return resultado;
    }
    @Override
    public List<CPU> getPiezasAlternativas(Madre madre, List<CPU> cpu){
	List<CPU> resultado = new ArrayList<>();

	for(CPU e: cpu){
	    if(esCompatible(madre, e)){
		resultado.add(e)
		    }
	}
	return resultado;
    }

}
