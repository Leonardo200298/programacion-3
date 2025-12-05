import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.Set;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {
	private Map<Integer, List<Arco<T>>> adyacentes;

	public GrafoDirigido() {
		this.adyacentes = new HashMap<>();

	}

	@Override
	public void agregarVertice(int verticeId) {
		if (!this.contieneVertice(verticeId)) {
			this.adyacentes.put(verticeId, new LinkedList<Arco<T>>());
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		this.adyacentes.remove(verticeId);
		for (Integer vertice : this.adyacentes.keySet()) {
			List<Arco<T>> arcos = this.adyacentes.get(vertice);
			for (Arco<T> arco : arcos) {
				if (arco.getVerticeDestino() == verticeId) {
					arcos.remove(arco);
				}
			}
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		// el vertice uno siempre sera la key del hashmap
		if (!this.contieneVertice(verticeId1)) {
			this.adyacentes.get(verticeId1).add(new Arco<T>(verticeId1, verticeId2, etiqueta));
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (this.contieneVertice(verticeId1)) {
			List<Arco<T>> arcos = this.adyacentes.get(verticeId1);
			// me queda O(a a la 2)
			arcos.remove(this.obtenerArco(verticeId1, verticeId2));
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.adyacentes.containsKey(verticeId);

	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if (this.contieneVertice(verticeId1)) {
			List<Arco<T>> arcos = this.adyacentes.get(verticeId1);
			for (Arco<T> arco : arcos) {
				if (arco.getVerticeDestino() == verticeId1) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if (this.contieneVertice(verticeId1)) {
			for (Arco<T> arco : this.adyacentes.get(verticeId1)) {
				if (arco.getVerticeDestino() == verticeId1) {
					return arco;
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return this.adyacentes.size();
	}

	@Override
	public int cantidadArcos() {
		int cantArcos = 0;
		for (List<Arco<T>> arco : this.adyacentes.values()) {
			cantArcos += arco.size();
		}
		return cantArcos;
	}

	public Set<Integer> getVertices() {
		return this.adyacentes.keySet();
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		Set<Integer> vertices = this.adyacentes.keySet();
		return vertices.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		List<Arco<T>> listaArcos = adyacentes.get(verticeId);

		if (listaArcos == null)
			return new ArrayList<Integer>().iterator();

		List<Integer> adyacentes = new ArrayList<>();
		for (Arco<T> arco : listaArcos) {
			adyacentes.add(arco.getVerticeDestino());
		}

		return adyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		for (List<Arco<T>> arcoList : this.adyacentes.values()) {
			arcos.addAll(arcoList);
		}
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {

		return new ArrayList<>(this.adyacentes.get(verticeId)).iterator();
	}

	@Override
	public Map<Integer, Auxiliar> DFS() {
		Map<Integer, Auxiliar> resultado = new HashMap<>();

		Iterator<Integer> it = this.obtenerVertices();

		// Inicializar colores y tiempos
		while (it.hasNext()) {
			Integer v = it.next();
			resultado.put(v, new Auxiliar("blanco", -1, -1));
		}

		int tiempo = 0;
		for (Integer v : resultado.keySet()) {
			if (resultado.get(v).getColor().equals("blanco")) {
				tiempo = DFSVisit(v, tiempo, resultado);
			}
		}

		return resultado;
	}

	private int DFSVisit(Integer origen, int tiempo, Map<Integer, Auxiliar> resultado) {
		Auxiliar aux = resultado.get(origen);
		aux.setColor("amarillo");
		tiempo++;
		aux.setTI(tiempo);

		Iterator<Integer> camino = this.obtenerAdyacentes(origen);
		while (camino.hasNext()) {
			Integer w = camino.next();
			Auxiliar auxW = resultado.get(w);
			if (auxW.getColor().equals("blanco")) {
				tiempo = DFSVisit(w, tiempo, resultado);
			}
		}

		aux.setColor("negro");
		tiempo++;
		aux.setTF(tiempo);

		return tiempo;
	}

}