import java.util.Arrays;
import java.util.List;

/**
 * Clase {@code Madre}.
 * <p>
 * Representa una placa madre (motherboard) de computadora.
 * Hereda de {@link Pieza} e incluye informacion sobre el chipset
 * y la compatibilidad con ciertos procesadores (AMD o Intel).
 * </p>
 */
public class Madre extends Pieza {

    /** Descripcion del chipset de la placa madre. */
    private String chips;

    /** Lista de procesadores compatibles (AMD e Intel). */
    private static final List<String> procesadores = Arrays.asList("AMD", "Intel");

    /**
     * Crea una nueva instancia de {@code Madre}.
     *
     * @param nombre nombre de la placa madre.
     * @param marca marca del fabricante.
     * @param precio precio de la placa madre.
     * @param chips descripcion del chipset de la placa madre.
     */
    public Madre(String nombre, String marca, double precio, String chips) {
        super(nombre, marca, precio, "Motherboard");
        this.chips = chips;
    }

    /**
     * Obtiene la descripcion completa del chipset.
     *
     * @return el chipset de la placa madre.
     */
    public String getChips() {
        return chips;
    }

    /**
     * Obtiene el tipo de procesador compatible basado en el chipset.
     * <p>
     * Analiza la descripcion del chipset y devuelve "AMD" o "Intel" si se encuentra
     * en la lista de procesadores compatibles. Si no se encuentra ninguno, devuelve un espacio.
     * </p>
     *
     * @return el tipo de procesador compatible ("AMD", "Intel") o un valor vacio si no existe.
     */
    public String getTipoChip() {
        if (chips == null || chips.isEmpty()) return "[Inexistente]";

        String[] palabras = chips.trim().split(" ");
        for (String palabra : palabras) {
            if (procesadores.contains(palabra)) {
                return palabra;
            }
        }

        return " ";
    }

    /**
     * Devuelve una representacion en texto de la placa madre,
     * incluyendo el chipset.
     *
     * @return una cadena con la informacion detallada de la placa madre.
     */
    @Override
    public String toString() {
        return super.toString() + " | Chipset: " + chips;
    }

}
