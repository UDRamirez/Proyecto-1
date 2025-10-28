public class Ticket {
    private String idTicket;
    private String contenido;
    private String sucursal;
    private String fecha;
    private double total;
    private boolean huboAdaptacion;

    public Ticket(Compunent compu, String sucursal, boolean huboAdaptacion) {
        this.idTicket = generarId();
        this.sucursal = sucursal;
        this.fecha = java.time.LocalDateTime.now().toString();
        this.total = compu.getPrecio();
        this.huboAdaptacion = huboAdaptacion;
        this.contenido = generarContenido(compu);
    }

    private String generarId() {
        return "TKT-" + System.currentTimeMillis();
    }

    private String generarContenido(Compunent compu) {
        StringBuilder info = new StringBuilder();
        info.append("======================== TICKET DE COMPRA ========================\n\n");
        info.append("ID: ").append(idTicket).append("\n");
        info.append("Sucursal: ").append(sucursal).append("\n");
        info.append("Fecha: ").append(fecha).append("\n\n");
        info.append(compu.getDescripcion()).append("\n");

        if (huboAdaptacion) {
            info.append("⚠ Se realizaron adaptaciones en CPU o Motherboard por incompatibilidad.\n");
        }

        info.append("==================================================================\n");
        return info.toString();
    }

    public String getContenido() {
        return contenido;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public String getSucursal() {
        return sucursal;
    }

    public String getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return contenido;
    }
}
