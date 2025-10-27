import java.io.Serializable;

public class Especificaciones implements Serializable {
    public String cpu, gpu, ram, disco, madre, fuente, gabinete;

    public Especificaciones(String cpu, String gpu, String ram, String disco,
                              String madre, String fuente, String gabinete) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.disco = disco;
        this.madre = madre;
        this.fuente = fuente;
        this.gabinete = gabinete;
    }
}
