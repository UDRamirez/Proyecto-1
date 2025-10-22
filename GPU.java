public class GPU extends Pieza {
    private String tipomem;

    public GPU(String nombre, String marca, double precio) {
        super(nombre, marca, precio, "GPU");
        this.tipomem = tipomem;
    }


    public String getTipoMem(){
      return tipomem; 
    }

    @Override
    public String toString() {
        return super.toString() + " | Memoria GPU: " + tipomem;
    }

}
