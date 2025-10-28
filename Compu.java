import java.util.ArrayList;
import java.util.List;
public class Compu implements Compunent {
    private CPU cpu;
    private Madre madre;
    private GPU gpu;
    private List<RAM> rams = new ArrayList<>();
    private List<Disco> discos = new ArrayList<>();
    private Fuente fuente;
    private Gabinete gabinete;
    private boolean huboIncompatibilidad = false;


    public boolean tuvoIncompatibilidad(){
	return this.huboIncompatibilidad;

    }

    public void setCPU(CPU cpu) { 
		this.cpu = cpu; 
	}
	
    public void setMadre(Madre madre) { 
		this.madre = madre;
	}
	
    public void setGPU(GPU gpu) {
		this.gpu = gpu; 
	}
	
    public void addRAM(RAM ram) { 
		this.rams.add(ram); 
	}
	
    public void addDisco(Disco disco) { 
		this.discos.add(disco);
	}
	
    public void setFuente(Fuente fuente) {
		this.fuente = fuente; 
	}
	
    public void setGabinete(Gabinete gabinete) { 
		this.gabinete = gabinete; 
	}

	
    public List<RAM> getRams() {
		return rams; 
	}
    public List<Disco> getDiscos() {
		return discos;
	}
    public CPU getCPU() { 
		return cpu; 
	}
	
    public Madre getMadre() { 
		return madre; 
	}
	
    public GPU getGPU() { 
		return gpu;
	}
	
    public Fuente getFuente() { 
		return fuente; 
	}
    public Gabinete getGabinete() { 
		return gabinete; 
	}


    public void setIncompatibilidad(boolean valor) {
        this.huboIncompatibilidad = valor;
    }

    public boolean getIncompatibilidad() {
        return this.huboIncompatibilidad;
    }

    @Override
    public double getPrecio() {
        double total = 0;
        if(cpu != null) total += cpu.getPrecio();
        if(madre != null) total += madre.getPrecio();
        if(gpu != null) total += gpu.getPrecio();
        for(RAM r : rams) total += r.getPrecio();
        for(Disco d : discos) total += d.getPrecio();
        if(fuente != null) total += fuente.getPrecio();
        if(gabinete != null) total += gabinete.getPrecio();
        return total;
    }

    @Override
    public String getDescripcion() {
        StringBuilder sb = new StringBuilder(getDescripcionBase());
        sb.append("\nPrecio total: $").append(getPrecio());
        return sb.toString();
    }

    @Override
    public String getDescripcionBase() {
        StringBuilder sb = new StringBuilder("Componentes de la PC:");
        if(cpu != null) sb.append("\nCPU: ").append(cpu.getNombre());
        if(madre != null) sb.append("\nMotherboard: ").append(madre.getNombre());
        if(gpu != null) sb.append("\nGPU: ").append(gpu.getNombre());
        if(!rams.isEmpty()) {
            sb.append("\nRAM:");
            for(RAM r : rams) sb.append(" ").append(r.getNombre());
        }
        if(!discos.isEmpty()) {
            sb.append("\nDiscos:");
            for(Disco d : discos) sb.append(" ").append(d.getNombre());
        }
        if(fuente != null) sb.append("\nFuente: ").append(fuente.getNombre());
        if(gabinete != null) sb.append("\nGabinete: ").append(gabinete.getNombre());
        return sb.toString();
    }

    @Override
    public List<Programa> getProgramas() {
        return new ArrayList<>();
    }
}
