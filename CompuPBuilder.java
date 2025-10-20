public class CompuPBuilder implements ConstructorCompu {
    private PC pc;

    public CompuPBuilder() {
        this.pc = new PC(); 
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
    public PC build() {
        return pc;
    }
}
