/**
 * Clase {@code Photoshop}.
 * <p>
 * Representa el programa Adobe Photoshop como un tipo de {@link Programa}.
 * Forma parte del software que puede instalarse en una computadora.
 * Esta clase puede usarse con el patron Decorator para agregar programas
 * a una PC sin modificar la estructura base del hardware.
 * </p>
 */
public class Photoshop extends Programa {

    /**
     * Crea una nueva instancia de {@code Photoshop} con nombre y precio predefinidos.
     * No recibe parametros, el nombre y precio estan definidos por defecto.
     */
    public Photoshop() {
        super("Adobe Photoshop 2025", 500.0);
    }
}
