public interface ConstructorCompu{
  
    void agregarCPU(CPU cpu);
  
    void agregarGPU(GPU gpu);
  
    void agregarMadre(Madre madre);
  
    void agregarRAM(RAM ram);
  
    void agregarDisco(Disco disco);
  
    void agregarFuente(Fuente fuente);
  
    void agregarGabinete(Gabinete gab);

    void agregarPrograma(Programa programa);

    Compu build();
}
