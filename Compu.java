import java.util.ArrayList;
import java.util.List;

public class Compu implements Compunent{
  
  private CPU cpu;
  private GPU gpu;
  private Madre madre;
  private List<RAM> rams = new ArrayList<>();
  private List<Disco> discos = new ArrayList<>();
  private Gabinete gab;
  private Fuente fuente;

    public Compu() {
      
    }
  
    public double getPrecio() {
        double total = 0;
        if (cpu != null) total += cpu.getPrecio();
        if (gpu != null) total += gpu.getPrecio();
        if (madre != null) total += madre.getPrecio();
        if (fuente != null) total += fuente.getPrecio();
        if (gabinete != null) total += gab.getPrecio();
        for (RAM rar : rams) total += rar.getPrecio();
        for (Disco dis : discos) total += dis.getPrecio();
        return total;
    }

   public void setCPU(CPU cpu) {
     this.cpu = cpu; 
   }
  
   public void setGPU(GPU gpu) { 
     this.gpu = gpu; 
   }
  
   public void setMadre(Madre madre) { 
     this.madre = madre; 
   }
  
   public void addRAM(RAM ram) {
     rams.add(ram);
   }
  
   public void addDisco(Disco disco) { 
   discos.add(disco);
   }
  
   public void setFuente(Fuente fuente) { 
     this.fuente = fuente;
   }
  
   public void setGabinete(Gabinete gabinete) {
     this.gabinete = gabinete;
   }


   public CPU getCPU() { 
     return cpu; 
   }
  
    public GPU getGPU() { 
      return gpu;
    }

    public List<RAM> getRams(){
      return rams;
    }
  
    public Madre getMadre() { 
      return madre;
    }
  
    public List<Disco> getDiscos() { 
      return discos;
    }
  
    public Fuente getFuente() { 
      return fuente; 
    }
  
    public Gabinete getGabinete() { 
      return gab; 
    }


    @Override
    public String getDescripcion() {
         StringBuilder sb = new StringBuilder();
        sb.append("===== Hardware de la PC =====\n");
        sb.append("CPU: ").append(cpu != null ? cpu.getNombre() : "No seleccionado").append("\n");
        sb.append("GPU: ").append(gpu != null ? gpu.getNombre() : "No seleccionado").append("\n");
        sb.append("Motherboard: ").append(madre != null ? madre.getNombre() : "No seleccionada").append("\n");
        sb.append("Fuente: ").append(fuente != null ? fuente.getNombre() : "No seleccionada").append("\n");
        sb.append("Gabinete: ").append(gab != null ? gab.getNombre() : "No seleccionado").append("\n");

        sb.append("\n--- Memorias RAM ---\n");
        if (rams.isEmpty()) sb.append("Sin memorias\n");
        for (RAM r : rams) sb.append(r.getNombre()).append(" - $").append(r.getPrecio()).append("\n");

        sb.append("\n--- Discos duros ---\n");
        if (discos.isEmpty()) sb.append("Sin discos\n");
        for (Disco d : discos) sb.append(d.getNombre()).append(" - $").append(d.getPrecio()).append("\n");

        return sb.toString();
    }

 
  
}
