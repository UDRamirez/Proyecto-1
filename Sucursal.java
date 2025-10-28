import java.util.*;

public interface Sucursal{
    
    Compunent construirPcEco();
    Compunent construirPcPrem();
    Compunent construirPcPerso(String cpu, String gpu, String ram, String disco,
			       String madre, String fuente, String gabinete, List<Programa> programa);
    void distribuir(Compunent pc, String sucursal);
}

