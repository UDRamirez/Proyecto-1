/**
 * Clase abstracta {@code Pieza}.
 * <p>
 * Representa un componente genérico de computadora.
 * Contiene atributos básicos como nombre, marca, precio y tipo.
 * </p>
 */
public abstract class Pieza {

    /** Nombre de la pieza. */
    String nombre;

    /** Marca del fabricante de la pieza. */
    String marca;

    /** Precio de la pieza. */
    double precio;

    /** Tipo de la pieza (CPU, GPU, RAM, etc.). */
    String tipo;

    /**
     * Crea una nueva instancia de {@code Pieza}.
     *
     * @param nombre nombre de la pieza.
     * @param marca  marca del fabricante.
     * @param precio precio de la pieza.
     * @param tipo   tipo de la pieza.
     */
    public Pieza(String nombre, String marca, double precio, String tipo) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.tipo = tipo;
    }

    /**
     * Obtiene el nombre de la pieza.
     *
     * @return el nombre de la pieza.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la marca de la pieza.
     *
     * @return la marca del fabricante.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Obtiene el precio de la pieza.
     *
     * @return el precio.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Obtiene el tipo de la pieza.
     *
     * @return el tipo (CPU, GPU, RAM, etc.).
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Devuelve una representación en texto de la pieza.
     *
     * @return una cadena con el tipo, nombre, marca y precio.
     */
    @Override
    public String toString() {
        return tipo + ": " + nombre + " | Marca: " + marca + " | Precio: $" + precio;
    }
}
