public class PCDecorada implements Compunent{

  private Compunent compu; 
  private Programa programa;

   public PCDecorada(Compunent compu, Programa programa) {
        this.compu = compu;
        this.programa = programa;
    }

    @Override
    public double getPrecio() {
        return compu.getPrecio() + programa.getPrecio();
    }

    @Override
    public String getDescripcion() {
        return compu.getDescripcion() + "\nPrograma añadido: " + programa.getNombre();
    }
}




  

