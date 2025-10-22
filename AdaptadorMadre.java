public class AdaptadorMadre implements AdaptadorPieza{
    private final Madre madre;

    public AdaptadorMadre(Madre madre) {
        this.madre = madre;
    }

    @Override
    public boolean esCompatibleCon(AdaptadorPieza otra) {
        if (otra instanceof AdaptadorCPU) {
	    AdaptadorCPU cpu = (AdaptadorCPU) otra;
            return madre.getTipoChip().equalsIgnoreCase(cpu.getCpu().getMarca());
        }
        return false;
    }
    @Override
    public String getNombre() {
        return madre.getTipoChip();
    }

    public Madre getMadre() {
        return madre;
    }

}
