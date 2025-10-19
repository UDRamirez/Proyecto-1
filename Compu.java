public class Compu{
  
  public CPU cpu;
  public GPU gpu;
  public Madre madre;
  public List<RAM> rams = new ArrayList<>();
  public List<Disco> discos = new ArrayList<>();
  public Gabinete gab;
  public Fuente fuente;
  public double precioTotal;
  //falta software

    public PC() {
      
    }
  
    public double total() {
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
     memorias.add(ram);
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
  
    public Madre getMadre() { 
      return madre;
    }
  
    public List<RAM> getDisco() { 
      return memorias; 
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

  //Metodo mpara mostrar toda la info

 
  
}
