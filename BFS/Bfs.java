package BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DFS.Vertice;

public class Bfs {
    
    // Método público que inicia la BFS y prepara los datos
    public void bfs(List<Vertice> grafo, Vertice s) {
        // Inicializar todos los vértices
        for (Vertice v : grafo) {
            v.color = "BLANCO";
            v.distancia = Integer.MAX_VALUE;
        }
        // Ejecutar la búsqueda desde el vértice s
        bfsVisit(s);
    }

    // Método privado que realiza la búsqueda BFS
    private void bfsVisit(Vertice s) {
        s.color = "VISITADO";
        s.distancia = 0;

        Queue<Vertice> cola = new LinkedList<>();
        cola.add(s);

        while (!cola.isEmpty()) {
            Vertice u = cola.poll();

            for (Vertice v : u.adyacentes) {
                if (v.color.equals("BLANCO")) {
                    v.color = "VISITADO";
                    v.distancia = u.distancia + 1;
                    cola.add(v);
                }
            }
        }
    }

}
