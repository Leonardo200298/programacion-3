package practico4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Busqueda {
    public void BFS(GrafoDirigido grafo) {
        Map<Integer, Auxiliar> resultado = new HashMap<>();
        Queue<Integer> fila = new LinkedList<>();
        Iterator<Integer> iterator = grafo.obtenerVertices();
        while (iterator.hasNext()) {
            Integer vertice = iterator.next();
            resultado.put(vertice, new Auxiliar("No valido", 0, 0));
        }

        for (Integer vertice : resultado.keySet()) {
            if (resultado.get(vertice).getColor().equals("No valido")) {
                BFSPrivado(grafo, vertice, fila, resultado);
            }
        }
    }

    private void BFSPrivado(GrafoDirigido grafo, Integer vertice, Queue<Integer> fila, Map<Integer, Aux> resultado) {
        resultado.get(vertice).setColor("visitado");
        fila.add(vertice);

        while (!fila.isEmpty()) {
            Integer actual = fila.poll();
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);

            while (adyacentes.hasNext()) {
                Integer adyacente = adyacentes.next();
                Auxiliar auxAdyacente = resultado.get(adyacente);

                if (auxAdyacente != null && auxAdyacente.getColor().equals("No valido")) {
                    auxAdyacente.setColor("visitado");
                    fila.add(adyacente);
                }
            }
        }
    }
}
