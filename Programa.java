public abstract class Programa {
    protected String nombre;
    protected double precio;

    public Programa(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre(){
      return nombre;
    }
  
    public double getPrecio(){
      return precio;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f", nombre, precio);
    }
}
