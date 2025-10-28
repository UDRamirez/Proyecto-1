public class Ticket {
    private String idTicket;
    private String contenido;
    private String sucursal;
    private String fecha;
    private double total;
    private boolean huboAdaptacion;

    // 🔹 Acepta cualquier Compunent (Compu o PCDecorada) y si hubo adaptación
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
        String info = "======================== TICKET DE COMPRA ========================\n\n";
        info += "ID: " + idTicket + "\n";
        info += "Sucursal: " + sucursal + "\n";
        info += "Fecha: " + fecha + "\n\n";
        info += compu.getDescripcion() + "\n";
        if (huboAdaptacion) {
            info += "\n⚠ Se realizaron adaptaciones en CPU o Motherboard por incompatibilidad.\n";
        }
        info += "==================================================================\n";
        return info;
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
