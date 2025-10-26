public class Ticket {
    private String idTicket;
    private String contenido;
    private String sucursal;
    private String fecha;
    private double total;

    public Ticket(Compu compu, String sucursal) {
        this.idTicket = generarId();
        this.sucursal = sucursal;
        this.fecha = java.time.LocalDateTime.now().toString();
        this.total = compu.total();
        this.contenido = generarContenido(compu);
    }

    private String generarId() {
        return "TKT-" + System.currentTimeMillis();
    }

    private String generarContenido(Compu compu) {
        String info = "======================== TICKET DE COMPRA ========================\n\n";
        info += "ID: " + idTicket + "\n";
        info += "Sucursal: " + sucursal + "\n";
        info += "Fecha: " + fecha + "\n\n";
        info += compu.toString() + "\n";
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