package DFS;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    public String color;
    int d; // tiempo de descubrimiento
    int f; // tiempo de finalización
    public List<Vertice> adyacentes; // lista de vértices adyacentes
    public int distancia;

    public Vertice() {
        this.color = "BLANCO"; // blanco inicialmente
        this.adyacentes = new ArrayList<>();
    }
}
