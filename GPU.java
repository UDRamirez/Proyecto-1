public class GPU extends Pieza {
    private String tipomem;

    public GPU(String nombre, String marca, double precio, String tipomem) {
        super(nombre, marca, precio, "GPU");
        this.tipomem = tipomem;
    }

    public String getTipoMem(){
      return tipomem; 
    }
}
