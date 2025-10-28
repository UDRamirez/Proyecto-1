import java.io.Serializable;

/**
 * Clase abstracta {@code Programa}.
 * <p>
 * Representa un programa o software con un nombre y un precio.
 * Esta clase sirve como base para diferentes tipos de programas
 * que pueden ser instalados o utilizados en una computadora.
 * </p>
 */
public abstract class Programa implements Serializable {

    /** Nombre del programa. */
    protected String nombre;

    /** Precio del programa. */
    protected double precio;

    /**
     * Constructor que inicializa los atributos principales del programa.
     *
     * @param nombre el nombre del programa.
     * @param precio el precio del programa.
     */
    public Programa(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    /** @return el nombre del programa. */
    public String getNombre() {
        return nombre;
    }

    /** @return el precio del programa. */
    public double getPrecio() {
        return precio;
    }

    /** @return representación formateada del programa. */
    @Override
    public String toString() {
        return String.format("%s - $%.2f", nombre, precio);
    }
}
