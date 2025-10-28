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

    /**
     * Nombre del programa.
     */
    protected String nombre;

    /**
     * Precio del programa.
     */
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

    /**
     * Devuelve el nombre del programa.
     *
     * @return una cadena con el nombre del programa.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el precio del programa.
     *
     * @return el precio del programa como valor {@code double}.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Devuelve una representación en cadena del programa,
     * incluyendo su nombre y precio formateado.
     *
     * @return una cadena con la información del programa.
     */
    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f", nombre, precio);
    }
}
