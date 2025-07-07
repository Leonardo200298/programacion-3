package recorridos;

import grafo.Grafo;
import java.util.*;

public class BFS {

    private Map<Integer, String> estado;
    private Map<Integer, Integer> distancia;

    public BFS() {
        this.estado = new HashMap<>();
        this.distancia = new HashMap<>();
    }

    public void ejecutarBFS(Grafo<?> grafo) {
        // Inicializar todos como NO_VISITADO
        for (Iterator<Integer> it = grafo.obtenerVertices(); it.hasNext();) {
            Integer v = it.next();
            estado.put(v, "NO_VISITADO");
        }

        for (Integer v : estado.keySet()) {
            if (estado.get(v).equals("NO_VISITADO")) {
                bfsDesdeVertice(grafo, v);
            }
        }
    }

    private void bfsDesdeVertice(Grafo<?> grafo, Integer s) {
        Queue<Integer> cola = new LinkedList<>();
        estado.put(s, "VISITADO");
        distancia.put(s, 0);
        cola.add(s);

        while (!cola.isEmpty()) {
            Integer actual = cola.poll();
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);

            while (adyacentes.hasNext()) {
                Integer vecino = adyacentes.next();
                if (estado.get(vecino).equals("NO_VISITADO")) {
                    estado.put(vecino, "VISITADO");
                    distancia.put(vecino, distancia.get(actual) + 1);
                    cola.add(vecino);
                }
            }
        }
    }

    public void imprimirResultados() {
        for (Integer v : estado.keySet()) {
            System.out.println("Vértice " + v +
                " | estado=" + estado.get(v) +
                " | distancia=" + distancia.getOrDefault(v, -1));
        }
    }
}
