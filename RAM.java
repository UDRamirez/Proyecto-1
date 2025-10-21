public class RAM extends Pieza {
    private int memoria;

    public RAM(String nombre, String marca, double precio, int memoria) {
        super(nombre, marca, precio, "RAM");
        this.memoria = memoria;
    }

    public int getMemoria(){ 
      return memoria; 
    }
}
