package DFS;

import java.util.List;

public class Dfs {
private int tiempo = 0;

    public void dfs(List<Vertice> grafo) {
        //Inicializamos todos los vértices
        for (Vertice u : grafo) {
            u.color = "BLANCO";
        }
        tiempo = 0;
        // Visitamos cada vértice si aún no ha sido visitado
        for (Vertice u : grafo) {
            if (u.color.equals("BLANCO")) {
                dfsVisit(u);
            }
        }
    }
        private void dfsVisit(Vertice u) {
        u.color = "AMARILLO"; // en proceso
        tiempo++;
        u.d = tiempo; // tiempo de descubrimiento
        for (Vertice v : u.adyacentes) {
            if (v.color.equals("BLANCO")) {
                dfsVisit(v);
            }
        }
        u.color = "NEGRO"; // terminado
        tiempo++;
        u.f = tiempo; // tiempo de finalización
    }
}
