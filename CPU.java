public class CPU extends Pieza {
    private int nucleos;

    public CPU(String nombre, String marca, double precio, int nucleos) {
        super(nombre, marca, precio, "CPU");
        this.nucleos = nucleos;
    }

    public int getNucleos() { return nucleos; }
}
