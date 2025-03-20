package practico1.ejercicio1;
public class MySimpleLinkedList<T> {
	
	private Node<T> first;
	private int tamanio;

	public MySimpleLinkedList() {
		this.first = null;
		this.tamanio = 0;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.tamanio++;
	}
	
	public T extractFront() {	
		if (this.first == null) {
			return null;
		}
		T temp = this.first.getInfo();
		this.first = first.getNext();
		this.tamanio--;
		return temp;
	}

	public boolean isEmpty() {
	
		return this.first == null;
	}
	
	public T get(int index) {
		int contador = 0;
		Node<T> temp = this.first;
		//Node<T> temp = new Node<>(this.first.getInfo(), this.first.getNext());
		if (this.first == null || index > this.size()) {
			return null;
			
		}

		/* 
		otra solucion
		 * 		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
			return temp.getInfo();
		 */
		while (index != contador && temp != null) {
			contador++;
			temp = first.getNext();
		}
		return temp.getInfo();
	}
	
	public int size() {
		return this.tamanio;
	}
	
	@Override
	public String toString() {
		String auxToString = "";
		for (int i = 0; i < this.size(); i++) {
			auxToString = this.first.toString();
		}
		return auxToString;
	}
	
}