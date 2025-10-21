public class Disco extends Componente {
  
    private String tipodisco; // hdd-ssd
    private String capacidad;

    public Disco(String nombre, String marca, double precio, String tipodisco, String capacidad) {
        super(nombre, marca, precio, "Disco");
        this.tipodisco = tipodisco;
        this.capacidad = capacidad;
    }

    public String getTipoDisco() {
      return tipodisco;
    }
  
    public String getCapacidad() { 
      return capacidad;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: " + tipodisco + " | Capacidad: " + capacidad + " GB";
    }
}
