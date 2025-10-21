public class Madre extends Pieza {
    private String chips; 

    public Madre(String nombre, String marca, double precio, String chips) {
        super(nombre, marca, precio, "Motherboard");
        this.chips = chips;
    }

    public String getChips(){
      return chips;
    }

      @Override
    public String toString() {
        return super.toString() + " | Chipset: " + chips;
    }
    
}
