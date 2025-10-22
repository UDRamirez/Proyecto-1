import java.util.*;
public class CompatibilidadCPU {

    
       public boolean esCompatible(AdaptadorPieza a, AdaptadorPieza b) {
        return a.esCompatibleCon(b);
    }

  
    public <T extends AdaptadorPieza> List<T> getPiezasAlternativas(AdaptadorPieza referencia, List<T> alternativas) {
        List<T> compatibles = new ArrayList<>();
        for (T pieza : alternativas) {
            if (esCompatible(referencia, pieza)) {
                compatibles.add(pieza);
            }
        }
        return compatibles;
    }
}
