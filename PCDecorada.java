/**
 * Clase {@code PCDecorada}.
 * <p>
 * Implementa la interfaz {@link Compunent} y representa una computadora
 * a la que se le añade un programa adicional usando el patrón Decorator.
 * </p>
 */
public class PCDecorada implements Compunent {

    /** Componente base de la computadora. */
    private Compunent compu;

    /** Programa que se añade a la computadora. */
    private Programa programa;

    /**
     * Crea una nueva instancia de {@code PCDecorada}.
     *
     * @param compu    el componente base de la computadora.
     * @param programa el programa que se añadirá a la computadora.
     */
    public PCDecorada(Compunent compu, Programa programa) {
        this.compu = compu;
        this.programa = programa;
    }

    /**
     * Obtiene el precio total de la computadora decorada,
     * sumando el precio del componente base y del programa añadido.
     *
     * @return el precio total.
     */
    @Override
    public double getPrecio() {
        return compu.getPrecio() + programa.getPrecio();
    }

    /**
     * Obtiene la descripción completa de la computadora decorada,
     * incluyendo el componente base y el programa añadido.
     *
     * @return la descripción detallada de la computadora decorada.
     */
    @Override
    public String getDescripcion() {
        return compu.getDescripcion() + "\nPrograma añadido: " + programa.getNombre();
    }
}
