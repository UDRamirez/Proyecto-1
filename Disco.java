public class Disco extends Componente {
  
    private String tipodisco; 
    private String capacidad;

    public Almacenamiento(String nombre, String marca, double precio, String tipodisco, String capacidad) {
        super(nombre, marca, precio, "Disco");
        this.tipodisco = tipodisco;
        this.capacidad = capacidad;
    }

    public String getTipoDisco() { return tipodisco; }
    public String getCapacidad() { return capacidad; }
}
