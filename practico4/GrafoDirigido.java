package practico4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {
	private Map<Integer,List<Arco<T>>> adyacentes;
	
	public GrafoDirigido(){
		this.adyacentes = new HashMap<>();
	}
	

	@Override
	public void agregarVertice(int verticeId) {
		if (!this.contieneVertice(verticeId)) {
			this.adyacentes.put(verticeId,new LinkedList<Arco<T>>());
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
		//el vertice uno siempre sera la key del hashmap
		if (!this.contieneVertice(verticeId1)) {
			this.adyacentes.get(verticeId1).add(new Arco<T>(verticeId1, verticeId2, etiqueta));
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (this.contieneVertice(verticeId1)) {
			List<Arco<T>> arcos = this.adyacentes.get(verticeId1);
			//me queda O(a a la 2)
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

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
