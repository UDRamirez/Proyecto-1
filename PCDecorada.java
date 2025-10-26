public class PCDecorada implements Compunent {

    private Compunent compu;
    private Programa programa;
    private List<String> instalados;

    public PCDecorada(Compunent compu, Programa programa) {
        this.compu = compu;
        this.instalados = new ArrayList<>();

        if (compu instanceof PCDecorada) {
            this.instalados.addAll(((PCDecorada) compu).getProgramasInstalados());
        }

        if (!instalados.contains(programa.getNombre())) {
            this.programa = programa;
            this.instalados.add(programa.getNombre());
        } else {
            this.programa = null;
            System.out.println("El programa " + programa.getNombre() + " ya está instalado.");
        }
    }

    public List<String> getProgramasInstalados() {
        return instalados;
    }

    @Override
    public double getPrecio() {
        if (programa != null) {
            return compu.getPrecio() + programa.getPrecio();
        }
        return compu.getPrecio();
    }

    @Override
    public String getDescripcion() {
        String desc = compu.getDescripcion();
        if (programa != null) {
            desc += "\nPrograma agregado: " + programa.getNombre();
        }
        return desc;
    }
}
