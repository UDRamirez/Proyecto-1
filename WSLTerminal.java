/**
 * Clase {@code WSLTerminal}.
 * <p>
 * Representa el programa WSL Terminal (Linux) como un tipo de {@link Programa}.
 * Permite simular la instalacion de una terminal Linux en la computadora.
 * </p>
 */
public class WSLTerminal extends Programa {

    /**
     * Constructor que crea una nueva instancia de {@code WSLTerminal}.
     * Inicializa el nombre del programa y su precio.
     */
    public WSLTerminal() {
        super("WSL Terminal: Linux", 500.0);
    }

    /**
     * @return representacion en texto del programa con nombre y precio.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
