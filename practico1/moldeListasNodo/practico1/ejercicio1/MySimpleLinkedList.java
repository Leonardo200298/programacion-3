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
		//int contador = 0;
		Node<T> temp = this.first;
		//Node<T> temp = new Node<>(this.first.getInfo(), this.first.getNext());
		if (temp == null || index > this.size()) {
			return null;
		}
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		return temp.getInfo();
	}
	
	public int size() {
		return this.tamanio;
	}
	public int indexOf(T elemento){
		Node<T> auxPrimeraPos = this.first;
		int indice = 0;
		for (int i = 0; i < size(); i++) {
			if (auxPrimeraPos.getInfo() == elemento) {
				indice++;
				auxPrimeraPos = auxPrimeraPos.getNext();
			}
		}
		return indice;
	}
	@Override
	public String toString() {
		Node<T> temp = this.first;
		String auxToString = "";
		if (this.isEmpty()) {
			return null;
		}
		while (temp != null) {
			auxToString += temp.getInfo();

			if (temp.getNext() != null) {
				auxToString += ", ";
			}

			temp = temp.getNext();
		}
		return auxToString;
	}
	
}