/**
 * Clase {@code Ticket} que representa el comprobante de compra de una computadora.
 * <p>
 * Genera un registro con información detallada sobre la computadora ensamblada,
 * incluyendo componentes, adaptaciones, precio total, fecha y sucursal.
 * </p>
 */
public class Ticket {
    private String idTicket;
    private String contenido;
    private String sucursal;
    private String fecha;
    private double total;

    /**
     * Crea un nuevo ticket para la compra de una computadora.
     *
     * @param compu     el componente (computadora o decorador) asociado a la compra
     * @param sucursal  la sucursal donde se realizó la compra
     */
    public Ticket(Compunent compu, String sucursal) {
        this.idTicket = generarId();
        this.sucursal = sucursal;
        this.fecha = java.time.LocalDateTime.now().toString();
        this.total = compu.getPrecio();
        this.contenido = generarContenido(compu);
    }

    /** Genera un ID único para el ticket. */
    private String generarId() {
        return "TKT-" + System.currentTimeMillis();
    }

    /**
     * Genera el texto completo del ticket con todos los detalles de la compra.
     */
    private String generarContenido(Compunent compu) {
        StringBuilder info = new StringBuilder();
        info.append("======================== TICKET DE COMPRA ========================\n\n");
        info.append("ID: ").append(idTicket).append("\n");
        info.append("Sucursal: ").append(sucursal).append("\n");
        info.append("Fecha: ").append(fecha).append("\n\n");
        info.append(compu.getDescripcion()).append("\n");

        // 🔹 Detectar incompatibilidad recorriendo decoradores hasta la base
        Compunent base = compu;
        while (base instanceof PCDecorada decorada) {
            base = decorada.compu;
        }

        if (base instanceof Compu c && c.tuvoIncompatibilidad()) {
            info.append("⚠ Se realizaron adaptaciones en CPU o Motherboard por incompatibilidad.\n");
        }

        info.append("==================================================================\n");
        return info.toString();
    }

    // Getters
    public String getContenido() { return contenido; }
    public String getIdTicket() { return idTicket; }
    public String getSucursal() { return sucursal; }
    public String getFecha() { return fecha; }
    public double getTotal() { return total; }

    @Override
    public String toString() { return contenido; }
}
