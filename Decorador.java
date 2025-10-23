public abstract class Decorador implements Compunent {
    protected Compunent compuBase;
    protected Programa programa;

    public Decorador(Compunent compuBase, Programa programa) {
        this.compuBase = compuBase;
        this.programa = programa;
    }

    @Override
    public double getPrecio() {
        return compuBase.getPrecio() + programa.getPrecio();
    }

    @Override
    public String getDescripcion() {
        return compuBase.getDescripcion() + "\n+ " + programa.getNombre();
    }
}
