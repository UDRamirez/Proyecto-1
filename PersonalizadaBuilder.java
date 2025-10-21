public class PersonalizadaBuilder implements ConstructorCompu {

    //Esta clase se usa para las compus que ya estan armadas
    
    private Compu pc;
     private List<Programa> programas;

    public PersonalizadaBuilder() {
        this.pc = new Compu();
        this.programas = new ArrayList<>();
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
    public void agregarPrograma(Programa programa) {
        programas.add(programa);
    }

    @Override
    public Compu build() {
        pc.setProgramas(programas);
        return pc;
    }
}
