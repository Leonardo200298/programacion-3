package practico1.ejercicio1;

public class DoubleLinkedList<T> {
    private Node<T> first;
    private int tamanio;

    public DoubleLinkedList() {
        this.first = null;
        this.tamanio = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info, null);
        tmp.setNext(this.first);
        if (this.first != null) {
            this.first.setPrev(tmp);

        }
        this.first = tmp;
        this.tamanio++;
    }

    public T extractFront() {
        if (this.first == null) {
            return null;
        }
        T aux = this.first.getInfo();
        if (this.first.getNext() == null) {
            this.first = null;
        }
        Node<T> temp = this.first.getNext();
        if (temp != null) {
            temp.setPrev(null);
            temp.setNext(null);
            this.first = temp;   
        }
        this.tamanio--;
        return aux;
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
}
