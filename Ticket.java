/**
 * Clase {@code Ticket}.
 * <p>
 * Representa el comprobante de compra de una computadora.
 * Genera un registro con informacion detallada sobre la computadora ensamblada,
 * incluyendo componentes, adaptaciones, precio total, fecha y sucursal.
 * </p>
 */
public class Ticket {

    /** ID unico del ticket generado automaticamente. */
    private String idTicket;

    /** Contenido del ticket que describe la computadora y la compra. */
    private String contenido;

    /** Nombre de la sucursal donde se realizo la compra. */
    private String sucursal;

    /** Fecha y hora de la compra. */
    private String fecha;

    /** Precio total de la computadora incluyendo programas instalados. */
    private double total;

    /**
     * Constructor que crea un nuevo ticket para la compra de una computadora.
     *
     * @param compu    la computadora o decorador asociado a la compra
     * @param sucursal la sucursal donde se realizo la compra
     */
    public Ticket(Compunent compu, String sucursal) {
        this.idTicket = generarId();
        this.sucursal = sucursal;
        this.fecha = java.time.LocalDateTime.now().toString();
        this.total = compu.getPrecio();
        this.contenido = generarContenido(compu);
    }

    /**
     * Genera un ID unico basado en el tiempo actual en milisegundos.
     *
     * @return ID unico del ticket
     */
    private String generarId() {
        return "TKT-" + System.currentTimeMillis();
    }

    /**
     * Genera el texto completo del ticket con todos los detalles de la compra.
     * Incluye componentes, programas instalados, precio total y adaptaciones por incompatibilidad.
     *
     * @param compu la computadora comprada
     * @return cadena con la informacion completa del ticket
     */
    private String generarContenido(Compunent compu) {
        StringBuilder info = new StringBuilder();
        info.append("======================== TICKET DE COMPRA ========================\n\n");
        info.append("ID: ").append(idTicket).append("\n");
        info.append("Sucursal: ").append(sucursal).append("\n");
        info.append("Fecha: ").append(fecha).append("\n\n");
        info.append(compu.getDescripcion()).append("\n");

        // Detectar si hubo adaptaciones por incompatibilidad
        Compunent base = compu;
        while (base instanceof PCDecorada decorada) {
            base = decorada.compu;
        }

        if (base instanceof Compu c && c.tuvoIncompatibilidad()) {
            info.append("Se realizaron adaptaciones en CPU o Motherboard por incompatibilidad.\n");
        }

        info.append("==================================================================\n");
        return info.toString();
    }

    
    /** @return contenido completo del ticket */
    public String getContenido() {
        return contenido;
    }

    /** @return ID del ticket */
    public String getIdTicket() {
        return idTicket;
    }

    /** @return nombre de la sucursal */
    public String getSucursal() { 
        return sucursal; 
    }

    /** @return fecha y hora de la compra */
    public String getFecha() { 
        return fecha;
    }

    /** @return precio total de la computadora */
    public double getTotal() { 
        return total;
    }

    /** @return representacion en texto del ticket */
    @Override
    public String toString() { 
        return contenido;
    }
}
