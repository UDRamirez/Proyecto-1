

public interface Sucursal{
    
    Compu construirPcEco();
    Compu construirPcPrem();
    Compu construirPcPerso(String cpu, String gpu, String ram, String disco,
    String madre, String fuente, String gabinete);
    void distribuir(Compu pc, String sucursal);
}

