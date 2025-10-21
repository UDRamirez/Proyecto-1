public abstract class Programa {
    protected String nombre;
    protected double precio;
    protected String programa;

    public Programa(String nombre, double precio, String programa) {
        this.nombre = nombre;
        this.precio = precio;
        this.programa = programa;
    }

    public String getNombre(){
      return nombre;
    }
  
    public double getPrecio(){
      return precio;
    }
  
    public String getPrograma(){
      return programa;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f", nombre, precio);
    }
}
