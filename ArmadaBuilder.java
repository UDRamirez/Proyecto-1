public class ArmadaBuilder implements ConstructorCompu {

    //Esta clase se usa para las compus que ya estan armadas
    
    private Compu pc;

    public ArmadaBuilder() {
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
