public class CompuABuilder implements ConstructorCompu {
    private Compu pc;

    public CompuABuilder() {
        this.pc = new Compu(); 
    }

    @Override
    public void agregarCPU(CPU cpu){ 
        pc.setCPU(cpu); 
    }

    @Override
    public void agregarGPU(GPU gpu){
        pc.setGPU(gpu); 
    }

    @Override
    public void agregarMadre(Madre madre){ 
        pc.setMadre(madre); 
    }

    @Override
    public void agregarRAM(RAM ram){
        pc.addRAM(ram);
    }

    @Override
    public void agregarDisco(Disco disco){ 
        pc.addDisco(disco);
    }

    @Override
    public void agregarFuente(Fuente fuente){ 
        pc.setFuente(fuente); 
    }

    @Override
    public void agregarGabinete(Gabinete gabinete){
        pc.setGabinete(gabinete); 
    }

    @Override
    public Compu build() {
        return pc;
    }
}
