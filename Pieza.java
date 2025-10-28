import java.io.Serializable;

/**
 * Clase abstracta {@code Pieza}.
 * <p>
 * Representa un componente de hardware generico para una computadora.
 * Todas las piezas concretas como CPU, GPU, RAM, Disco, Fuente, Madre o Gabinete
 * heredan de esta clase.
 * Implementa {@link Serializable} para permitir su serializacion.
 * </p>
 */
public abstract class Pieza implements Serializable {

    /** Nombre del componente. */
    String nombre;

    /** Marca del fabricante. */
    String marca;

    /** Precio del componente. */
    double precio;

    /** Tipo de componente (CPU, GPU, RAM, etc.). */
    String tipo;

    /** Indica si el componente ha sido adaptado o modificado. */
    boolean adaptado;

    /**
     * Crea una nueva instancia de {@code Pieza}.
     *
     * @param nombre nombre del componente.
     * @param marca marca del fabricante.
     * @param precio precio del componente.
     * @param tipo tipo de componente.
     */
    public Pieza(String nombre, String marca, double precio, String tipo) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.tipo = tipo;
        this.adaptado = false;
    }

    /** Devuelve el nombre del componente. */
    public String getNombre() {
        return nombre;
    }

    /** Devuelve la marca del componente. */
    public String getMarca() {
        return marca;
    }

    /** Devuelve el precio del componente. */
    public double getPrecio() {
        return precio;
    }

    /** Devuelve el tipo del componente. */
    public String getTipo() {
        return tipo;
    }

    /** Indica si el componente ha sido adaptado. */
    public boolean getAdaptado() {
        return adaptado;
    }

    /** Establece si el componente ha sido adaptado. */
    public void setAdaptado(boolean adaptado) {
        this.adaptado = adaptado;
    }

    /**
     * Devuelve una representacion en texto del componente,
     * incluyendo tipo, nombre, marca y precio.
     *
     * @return cadena con la informacion del componente.
     */
    @Override
    public String toString() {
        return tipo + ": " + nombre + " | Marca: " + marca + " | Precio: $" + precio;
    }
}
