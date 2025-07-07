package recorridos;

import grafo.Grafo;
import java.util.*;

public class DFS {

    private Map<Integer, String> color;
    private Map<Integer, Integer> tiempoDescubrimiento;
    private Map<Integer, Integer> tiempoFinalizacion;
    private int tiempo;

    public DFS() {
        this.color = new HashMap<>();
        this.tiempoDescubrimiento = new HashMap<>();
        this.tiempoFinalizacion = new HashMap<>();
        this.tiempo = 0;
    }

    public void ejecutarDFS(Grafo<?> grafo) {
        for (Iterator<Integer> it = grafo.obtenerVertices(); it.hasNext();) {
            Integer v = it.next();
            color.put(v, "BLANCO");
        }

        for (Integer v : color.keySet()) {
            if (color.get(v).equals("BLANCO")) {
                dfsVisit(grafo, v);
            }
        }
    }

    private void dfsVisit(Grafo<?> grafo, Integer u) {
        color.put(u, "AMARILLO");
        tiempo++;
        tiempoDescubrimiento.put(u, tiempo);

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(u);
        while (adyacentes.hasNext()) {
            Integer v = adyacentes.next();
            if (color.get(v).equals("BLANCO")) {
                dfsVisit(grafo, v);
            }
        }

        color.put(u, "NEGRO");
        tiempo++;
        tiempoFinalizacion.put(u, tiempo);
    }

    public void imprimirResultados() {
        for (Integer v : color.keySet()) {
            System.out.println("Vértice " + v +
                " | d=" + tiempoDescubrimiento.get(v) +
                " | f=" + tiempoFinalizacion.get(v) +
                " | color=" + color.get(v));
        }
    }
}
