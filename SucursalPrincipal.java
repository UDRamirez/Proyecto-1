import java.util.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.Serializable;

public class SucursalPrincipal  implements Sucursal{
    private DirectorConstructor constructor;
    private Map<String, SucursalRemota> sucursalesRemotas;
   
    
    public SucursalPrincipal(Map<String, SucursalRemota> sucursales) {
        this.constructor = new DirectorConstructor();
        this.sucursalesRemotas = sucursales;
  
    }
    

    public void registrarSucursal(String nombre, SucursalRemota puntoDistribucion) {
        sucursalesRemotas.put(nombre, puntoDistribucion);
      
      
    }
    
    
    @Override
    public Compunent construirPcEco() {
     
        Compunent pc = constructor.construirPcEconomica();
        return pc;
    }
    
    @Override
    public Compunent construirPcPrem() {
   
        Compunent pc = constructor.construirPcPremium();
	return pc;
    }
    
    @Override
    public Compunent construirPcPerso(String cpu, String gpu, String ram, String disco,
				      String madre, String fuente, String gabinete, List<Programa> programas) {
      
        Compunent pc = constructor.construirPcPersonalizada(cpu, gpu, ram, disco, madre, fuente, gabinete, programas);
      
        return pc;
    }
    @Override
    public void distribuir( Compunent pc, String sucursal) {
      try {
            SucursalRemota destino = sucursalesRemotas.get(sucursal);
            if (destino != null) {
                destino.recibirPc(pc);
                System.out.println("Distribuida "  + " a " + sucursal);
            } else {
                System.out.println("No existe esa sucursal remota: " + sucursal);
            }
        } catch (RemoteException e) {
            System.err.println("Error distribuyendo a " + sucursal + ": " + e.getMessage());
        }
    }
    
  public Compunent fabricarPc(String tipoPc) {
        switch (tipoPc.toLowerCase()) {
	case "eco": return construirPcEco();
	case "prem": return construirPcPrem();
	default: return null;
        }
    }
  public Compunent fabricarPc(String tipoPc, Especificaciones specs) {
        switch (tipoPc.toLowerCase()) {
            case "eco": return construirPcEco();
            case "prem": return construirPcPrem();
            case "perso":
                return construirPcPerso(
                    specs.cpu, specs.gpu, specs.ram, specs.disco,
                    specs.madre, specs.fuente, specs.gabinete, specs.programas
                );
            default: return null;
        }
    }
    public List<String> getPuntosDistribucion() {
        return new ArrayList<>(sucursalesRemotas.keySet());
    }
    

   
}
