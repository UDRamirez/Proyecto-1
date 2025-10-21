public class Fuente extends Pieza {
    private int potencia; 

    public Fuente(String nombre, String marca, double precio, int potencia) {
        super(nombre, marca, precio, "Fuente");
        this.potencia = potencia;
    }

    public int getPotencia(){ 
      return potencia;
    }
}
