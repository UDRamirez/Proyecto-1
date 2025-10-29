import java.io.Serializable;

/**
 * Clase abstracta {@code Programa}.
 * <p>
 * Representa un programa o software con un nombre y un precio.
 * Esta clase sirve como base para diferentes tipos de programas
 * que pueden ser instalados en una computadora.
 * </p>
 * <p>
 * Implementa {@link Serializable} para permitir su serializacion.
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
     * @param nombre nombre del programa.
     * @param precio precio del programa.
     */
    public Programa(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Obtiene el nombre del programa.
     *
     * @return nombre del programa.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio del programa.
     *
     * @return precio del programa.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Devuelve una representacion en texto del programa.
     *
     * @return cadena con nombre y precio del programa.
     */
    @Override
    public String toString() {
        return String.format("%s - $%.2f", nombre, precio);
    }
}

