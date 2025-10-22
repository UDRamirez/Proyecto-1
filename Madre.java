public class Madre extends Pieza {
    private String chips; 
    private static final List<String> procesadores = Arrays.asList("AMD", "Intel");

    public Madre(String nombre, String marca, double precio, String chips) {
        super(nombre, marca, precio, "Motherboard");
        this.chips = chips;
    }

    public String getChips(){
      return chips;
    }

    public String getTipoChip(){
	if (chips.toLowerCase() == null) return false;

        String[] palabras = texto.trim().split(" ");
        for (String palabra : palabras) {
            if (procesadores.contains(palabra)) {
                return palabra;
            }
        }

        return " "; 

    }


      @Override
    public String toString() {
        return super.toString() + " | Chipset: " + chips;
    }
    

}
