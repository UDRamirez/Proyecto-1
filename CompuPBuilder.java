public class CompuPBuilder implements PCBuilder {
    private PC pc;

    public CompiPBuilder() {
        this.pc = new PC(); // usa el constructor vacío
    }

    @Override
    public void agregarCPU(CPU cpu) { pc.setCPU(cpu); }

    @Override
    public void agregarGPU(GPU gpu) { pc.setGPU(gpu); }

    @Override
    public void agregarMotherboard(Motherboard motherboard) { pc.setMotherboard(motherboard); }

    @Override
    public void agregarRAM(RAM ram) { pc.addRAM(ram); }

    @Override
    public void agregarAlmacenamiento(Almacenamiento almacenamiento) { pc.addAlmacenamiento(almacenamiento); }

    @Override
    public void agregarFuente(Fuente fuente) { pc.setFuente(fuente); }

    @Override
    public void agregarGabinete(Gabinete gabinete) { pc.setGabinete(gabinete); }

    @Override
    public PC build() {
        return pc;
    }
}
