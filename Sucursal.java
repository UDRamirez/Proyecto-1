import java.util.ArrayList;
import java.util.List;

public abstract class Sucursal {
    protected String nombre;
    protected String ubicacion;
    protected List<Ticket> tickets;

    public Sucursal(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tickets = new ArrayList<>();
    }

    public void agregarTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return new ArrayList<>(tickets);
    }

    public void mostrarTickets() {
        System.out.println("\nTICKETS - " + nombre.toUpperCase());
        if (tickets.isEmpty()) {
            System.out.println("No hay tickets registrados");
        } else {
            for (int i = 0; i < tickets.size(); i++) {
                System.out.println(tickets.get(i).getContenido());
                System.out.println("----------------------------------------");
            }
        }
    }

    public String getNombre() { 
        return nombre; 
    }

    public String getUbicacion() {
        return ubicacion; 
    }

    @Override
    public String toString() {
        return nombre + " - " + ubicacion;
    }
}