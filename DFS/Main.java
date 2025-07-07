package DFS;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear vértices
        Vertice v1 = new Vertice();
        Vertice v2 = new Vertice();
        Vertice v3 = new Vertice();
        Vertice v4 = new Vertice();

        // Definir aristas (adyacencias)
        v1.adyacentes.add(v2);
        v2.adyacentes.add(v3);
        v3.adyacentes.add(v4);
        v4.adyacentes.add(v1);

        // Crear grafo
        List<Vertice> grafo = new ArrayList<>();
        grafo.add(v1);
        grafo.add(v2);
        grafo.add(v3);
        grafo.add(v4);

        // Ejecutar DFS
        Dfs alg = new Dfs();
        alg.dfs(grafo);

        // Mostrar resultados
        for (Vertice v : grafo) {
            System.out.println("Vertice: " + v + " - d: " + v.d + " - f: " + v.f + " - color: " + v.color);
        }
    }
}
