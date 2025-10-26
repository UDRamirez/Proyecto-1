import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        DirectorConstructor director = new DirectorConstructor();

        // === PC Económica ===
        Compunent pcEconomica = director.construirPcEconomica();
        System.out.println("=== PC Económica ===");
        System.out.println(pcEconomica.getDescripcion());

        // === PC Gamer Premium ===
        Compunent pcGamer = director.construirPcPremium();
        System.out.println("\n=== PC Gamer ===");
        System.out.println(pcGamer.getDescripcion());

        // === PC Personalizada ===
        List<Programa> programasPersonalizados = new ArrayList<>();
        programasPersonalizados.add(new Windows());
        programasPersonalizados.add(new Office());
        programasPersonalizados.add(new Photoshop());

        Compunent pcPersonalizada = director.construirPcPersonalizada(
            "Core i7-13700K",
            "RTX 4070",
            "Kingston 16-GB",
            "Kingston 2-TB",
            "MAG B760 Tomahawk",
            "XPG 700-W",
            "H6 Flow ATX",
            programasPersonalizados
        );

        System.out.println("\n=== PC Personalizada ===");
        System.out.println(pcPersonalizada.getDescripcion());

        // === Comparación de PC Gamer y Personalizada ===
        System.out.println("\n=== Comparación de PCs ===");
        System.out.println("Precio PC Gamer: $" + pcGamer.getPrecio());
        System.out.println("Precio PC Personalizada: $" + pcPersonalizada.getPrecio());
    }
}
