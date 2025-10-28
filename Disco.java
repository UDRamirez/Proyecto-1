
/**
 * Clase {@code Disco}.
 * <p>
 * Representa un componente de almacenamiento dentro de una computadora.
 * Hereda de {@link Pieza} e incluye información específica como el tipo de disco
 * (HDD o SSD) y su capacidad en gigabytes (GB).
 * </p>
 */
public class Disco extends Pieza {
  
    /** Tipo de disco, puede ser HDD o SSD. */
    private String tipodisco;
    
    /** Capacidad de almacenamiento del disco en gigabytes (GB). */
    private int capacidad;

    /**
     * Crea una nueva instancia de {@code Disco}.
     *
     * @param nombre nombre del disco.
     * @param marca marca del fabricante.
     * @param precio precio del disco.
     * @param tipodisco tipo de disco (por ejemplo, "HDD" o "SSD").
     * @param capacidad capacidad del disco en gigabytes (GB).
     */
>>>>>>> origin/cambios
    public Disco(String nombre, String marca, double precio, String tipodisco, int capacidad) {
        super(nombre, marca, precio, "Disco");
        this.tipodisco = tipodisco;
        this.capacidad = capacidad;
    }

    /**
     * Obtiene el tipo de disco.
     *
     * @return una cadena con el tipo de disco (HDD o SSD).
     */
    public String getTipoDisco() {

        return tipodisco;

    }

    /**
     * Obtiene la capacidad del disco.
     *
     * @return la capacidad en gigabytes (GB).
     */
    public int getCapacidad() { 
        return capacidad;
    }

    /**
     * Devuelve una representación en texto del disco, incluyendo
     * su tipo y capacidad.
     *
     * @return una cadena con la información detallada del disco.
     */
    @Override
    public String toString() {
        return super.toString() + " | Tipo: " + tipodisco + " | Capacidad: " + capacidad + " GB";
    }
}
