public class Ticket {
    private String idTicket;
    private String contenido;
    private String sucursal;
    private String fecha;
    private double total;

    public Ticket(Compunent compu, String sucursal) {
        this.idTicket = "TKT-" + System.currentTimeMillis();
        this.sucursal = sucursal;
        this.fecha = java.time.LocalDateTime.now().toString();
        this.total = compu.getPrecio();
        this.contenido = generarContenido(compu);
    }

    private String generarContenido(Compunent compu) {
        String info = "======================== TICKET DE COMPRA ========================\n\n";
        info += "ID: " + idTicket + "\n";
        info += "Sucursal: " + sucursal + "\n";
        info += "Fecha: " + fecha + "\n\n";
        info += compu.getDescripcion() + "\n";

        // 🔹 Detectar incompatibilidad
        Compunent base = compu;
        while(base instanceof PCDecorada decorada) {
            base = decorada.compu;
        }
        if(base instanceof Compu c && c.tuvoIncompatibilidad()) {
            info += "⚠ Se realizaron adaptaciones en CPU o Motherboard por incompatibilidad.\n";
        }

        info += "==================================================================\n";
        return info;
    }

    public String getContenido() { return contenido; }
    public String getIdTicket() { return idTicket; }
    public String getSucursal() { return sucursal; }
    public String getFecha() { return fecha; }
    public double getTotal() { return total; }

    @Override
    public String toString() { return contenido; }
}
