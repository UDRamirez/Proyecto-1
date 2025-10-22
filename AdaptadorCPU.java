public class AdaptadorCPU implements AdaptadorPieza{

    private final CPU cpu;

    public AdaptadorCPU(CPU cpu) {
        this.cpu = cpu;
    }

    @Override
    public boolean esCompatibleCon(AdaptadorPieza otra) {
        if (otra instanceof AdaptadorMadre) {
	     AdaptadorMadre madre = (AdaptadorMadre) otra;
            return cpu.getMarca().equalsIgnoreCase(madre.getMadre().getTipoChip());
        }
        return false;
    }
    @Override
    public String getNombre() {
        return cpu.getMarca();
    }

    public CPU getCpu() {
        return cpu;
    }
    



}
